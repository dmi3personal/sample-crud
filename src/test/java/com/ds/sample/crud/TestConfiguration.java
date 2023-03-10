package com.ds.sample.crud;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.ds.sample.UserInterface;
import com.ds.sample.crud.inmemory.UserDataStorage;

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
    public UserStorage createDataStorage() {
        return new UserDataStorage();
    }
}
