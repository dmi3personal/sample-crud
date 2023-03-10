package com.ds.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application that starts the REST service.
 */
@SpringBootApplication
public class Application {

    /**
     * Starting point for the application.
     * @param args Arguments used to start the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
