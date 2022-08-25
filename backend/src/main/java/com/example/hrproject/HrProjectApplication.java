package com.example.hrproject;

import com.example.hrproject.Entities.Collaborateur;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Slf4j
public class HrProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrProjectApplication.class, args);
        log.info("Im in main");
    }
}
