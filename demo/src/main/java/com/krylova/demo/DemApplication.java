package com.krylova.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DemApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemApplication.class, args);
    }

}
