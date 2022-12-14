package com.example.exemplespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ExemplespringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExemplespringApplication.class, args);
    }

}
