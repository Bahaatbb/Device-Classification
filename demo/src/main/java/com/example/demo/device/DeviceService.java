package com.example.demo.device;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;


    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<Device> getDevices() {
        return deviceRepository.findAll();
    }

    public Device getDevice(Long id) {
        return deviceRepository.findById(id).orElse(null);
    }

    public Device createDevice(Device device) {
        return deviceRepository.save(device);
    }

    public void updateDevice(Device device) {
        deviceRepository.save(device);
    }


    @Transactional
    public Device predictDevicePrice(Device device) throws JsonProcessingException {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Device> entity = new HttpEntity<>(device, headers);
            ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8000/predict", entity, String.class);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(response.getBody());
            Integer prediction = jsonNode.get("prediction").asInt();

            device.setPriceRange(prediction);

            return deviceRepository.save(device);
        } catch (HttpClientErrorException e) {

            System.out.println("HTTP client error occurred while predicting device price");
            throw new RuntimeException("HTTP client error occurred while predicting device price", e);
        } catch (ResourceAccessException e) {

            System.out.println("Resource access exception occurred while predicting device price");
            throw new RuntimeException("Resource access exception occurred while predicting device price", e);
        }
    }
}
