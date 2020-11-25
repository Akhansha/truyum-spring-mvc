package com.cognizant.truyum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.*")
public class TruyumSpringMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(TruyumSpringMvcApplication.class, args);
    }

}
