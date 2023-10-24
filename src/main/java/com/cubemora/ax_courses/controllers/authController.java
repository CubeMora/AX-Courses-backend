package com.cubemora.ax_courses.controllers;

import java.security.Principal;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/auth")
public class authController {
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping(path = "/getName")
    public String getUsername(Principal principal) {
        return principal.getName();
    }

    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginData) {
       
        
        ResponseEntity<String> response = restTemplate.postForEntity(
                "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyBCqDQvKkIZQkont-FbD_HJAFoH8j6T4ik",
                loginData,
                String.class);
            

        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);

        
    }
}
