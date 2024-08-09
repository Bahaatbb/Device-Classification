from fastapi import FastAPI, HTTPException
from pydantic import BaseModel, validator
import joblib
import numpy as np
from starlette.responses import JSONResponse
import json
import pandas as pd

app = FastAPI()

model = joblib.load('model.joblib')
normalization_params = joblib.load('normalization_params.joblib')
columns_to_normalize, means, stds = normalization_params

class RequestBody(BaseModel):
    battery_power: int
    blue: bool
    clock_speed: float
    dual_sim: bool
    fc: float
    four_g: bool
    int_memory: float
    m_dep: float
    mobile_wt: float
    n_cores: int
    pc: float
    px_height: int
    px_width: int
    ram: float
    sc_h: float
    sc_w: float
    talk_time: int
    three_g: bool
    touch_screen: bool
    wifi: bool

    @validator('battery_power', 'n_cores', 'px_height', 'px_width', 'talk_time')
    def validate_non_negative_int_fields(cls, v):
        if not isinstance(v, int):
            raise ValueError('Must be an integer')
        if v < 0:
            raise ValueError('Must be a non-negative integer')
        return v

    @validator('clock_speed', 'fc', 'int_memory', 'm_dep', 'mobile_wt', 'pc', 'ram', 'sc_h', 'sc_w')
    def validate_non_negative_float_fields(cls, v):
        if not isinstance(v, (int, float)):
            raise ValueError('Must be a float or integer')
        if v < 0:
            raise ValueError('Must be a non-negative float')
        return v

    @validator('blue', 'dual_sim', 'four_g', 'three_g', 'touch_screen', 'wifi')
    def validate_bool_fields(cls, v):
        if not isinstance(v, bool):
            raise ValueError('Must be a boolean')
        return v


@app.post("/predict", response_model=dict)
async def predict(data: RequestBody):
    try:
        input_data = pd.DataFrame({
            "battery_power": data.battery_power,
            "blue": data.blue,
            "clock_speed": data.clock_speed,
            "dual_sim": data.dual_sim,
            "fc": data.fc,
            "four_g": data.four_g,
            "int_memory": data.int_memory,
            "m_dep": data.m_dep,
            "mobile_wt": data.mobile_wt,
            "n_cores": data.n_cores,
            "pc": data.pc,
            "px_height": data.px_height,
            "px_width": data.px_width,
            "ram": data.ram,
            "sc_h": data.sc_h,
            "sc_w": data.sc_w,
            "talk_time": data.talk_time,
            "three_g": data.three_g,
            "touch_screen": data.touch_screen,
            "wifi": data.wifi
        }, index=[0])

        input_data[columns_to_normalize] = input_data[columns_to_normalize].apply(lambda x: (x - means[x.name]) / stds[x.name])   
        prediction = model.predict(input_data)

        return {"prediction": str(prediction[0])}

    except ValueError as e:
        raise HTTPException(status_code=400, detail=str(e))

    except Exception as e:
        print(e)
        raise HTTPException(status_code=500, detail="Internal Server Error")

@app.exception_handler(HTTPException)
async def http_exception_handler(request, exc):
    return JSONResponse({"error": exc.detail}, status_code=exc.status_code)


if __name__ == "__main__":
    import uvicorn
    uvicorn.run(app, host="0.0.0.0", port=8000)