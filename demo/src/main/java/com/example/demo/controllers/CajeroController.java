package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cajero")
public class CajeroController {

    @GetMapping("/status")
    public String getCajeroStatus() {
        return "Cajero is operational";
    }

    // Add more methods for other endpoints as needed

}
