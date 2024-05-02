package net.employee.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HealthCheck {

    @RequestMapping("/health")
    public String healthCheck(){
        return "Checking Health";
    }
}
