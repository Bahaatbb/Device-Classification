package com.example.demo.device;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path ="api")
public class DeviceController {

    private final DeviceService deviceService;


    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/device")
    public List<Device> getDevices() {
        return deviceService.getDevices();
    }

    @GetMapping("/device/{id}")
    public ResponseEntity<Device> getDevice(@PathVariable Long id) {
        Device device = deviceService.getDevice(id);
        if (device != null) {
            return ResponseEntity.ok(device);
        } else {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Device not found with id: " + id);
        }
    }

    @PostMapping("/device")
    public Device createDevice(@Valid @RequestBody Device device) {
        return  deviceService.createDevice(device);
    }

    @PostMapping("predict/{id}")
    public ResponseEntity<Device> predictDevicePrice(@PathVariable Long id) throws JsonProcessingException {
        Device device = deviceService.getDevice(id);
        if (device == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Device not found with id: " + id);
        }

        if (device.getPriceRange() != null) {
            return ResponseEntity.ok(device);
        }

        return ResponseEntity.ok(deviceService.predictDevicePrice(device));
    }
    
}
