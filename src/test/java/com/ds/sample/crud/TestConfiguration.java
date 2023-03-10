package com.ds.sample.crud;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.ds.sample.UserInterface;

/**
 * Configuration for spring-using tests. 
 */
@SpringBootConfiguration
@EnableAutoConfiguration
public class TestConfiguration {

    @Bean
    public UserInterface createUserInterface() {
        return new UserService();
    }

    @Bean
    public UserDataStorage createDataStorage() {
        return new UserDataStorage();
    }
}
