package app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActuatorController {

    @GetMapping
    public String hello() {
        return "Hello Actuator!";
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
