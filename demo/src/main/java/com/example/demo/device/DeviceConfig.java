package com.example.demo.device;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeviceConfig {

    @Bean
    CommandLineRunner commandLineRunner(DeviceRepository deviceRepository) {
        return args -> {
            Device device1 = new Device(
                    1021, // batteryPower
                    true, // blue
                    0.5, // clockSpeed
                    true, // dualSim
                    1, // fc
                    true, // fourG
                    53, // intMemory
                    0.7, // mDep
                    136, // mobileWt
                    3, // nCores
                    6, // pc
                    905, // pxHeight
                    1988, // pxWidth
                    2631, // ram
                    17, // scH
                    3, // scW
                    7, // talkTime
                    true, // threeG
                    true, // touchScreen
                    false // wifi
            );
            deviceRepository.save(device1);
        };
    }
}
