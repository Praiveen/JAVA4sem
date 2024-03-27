package com.example.prak11;

import org.springframework.boot.actuate.health.Health;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyActuatorEndpoints {

    @GetMapping("/actuator/health")
    public Health health() {
        // Возвращаем Health с состоянием "UP" для демонстрации успешного состояния приложения
        return Health.up().build();
    }
}

