# Device-Classification
A Device classification model with a FastApi and Spring boot
<hr/>

## Prerequisites
- For the Spring Boot project Java 17 and Spring boot 3.3.2 are recommended, add the database configuration in the `application.properties`

- For the FastApi service python 3.11 and above is required and then install the requirments using ```pip install -r requirements.txt```

- For training the model you need to install sklearn and matplotlib additionally

## Project Overview
  This is a project that demonstrates a simple RESTful API for device management using Spring Boot and a machine learning model for predicting device prices using Python and FastAPI.

## Project Configuration
 - The Spring Boot application is configured in the application.properties file.
 - The Python application is configured in the main.py file.
 - The machine learning model is trained in the model.ipynb file and saved as model.joblib and normalization_params.joblib.

## Running the Project
1. Train the machine learning model by running the model.ipynb file. This will automatically save the model.joblib and normalization_params.joblib files.

2. Install the required dependencies for the Spring Boot application using Maven: mvn clean install

3. Install the required dependencies for the Python application using pip: pip install fastapi pydantic joblib numpy pandas scikit-learn

4. Run the Python application using: uvicorn main:app --host 0.0.0.0 --port 8000

5. Run the Spring Boot application using Maven: mvn spring-boot:run

### API Endpoints
#### Spring Boot API
- GET /api/device: Retrieve a list of all devices

- GET /api/device/{id}: Retrieve details of a specific device by ID

- POST /api/device: Add a new device

- POST /api/predict/{id}: Predict the price of a device and save the result in the device entity

#### Python API
- POST /predict: Make a prediction using the trained model. The request body should contain the following fields:
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

### Model Training
The machine learning model is trained using the model.ipynb file, which contains the following steps:
1. Data loading and preprocessing
2. Feature engineering
3. Model selection and training
4. Model evaluation

The trained model is saved as model.joblib and the normalization parameters are saved as normalization_params.joblib. These files are used by the Python application to make predictions.