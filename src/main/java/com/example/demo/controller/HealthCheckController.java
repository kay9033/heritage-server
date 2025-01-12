package com.example.demo.controller;

import com.example.demo.entity.HealthCheck;
import com.example.demo.repository.HealthCheckRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hc")
public class HealthCheckController {

    private final HealthCheckRepository healthCheckRepository;

    public HealthCheckController(HealthCheckRepository healthCheckRepository) {
        this.healthCheckRepository = healthCheckRepository;
    }

    @GetMapping
    public List<HealthCheck> getHealthCheckMessages() {
        return healthCheckRepository.findAll();
    }
}
