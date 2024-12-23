package com.example.demo.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.google.gson.GsonBuilder;
 
@Configuration
public class GsonConfig {
    @Bean
    public GsonBuilder gsonBuilder() {
        var builder = new GsonBuilder();

        builder.registerTypeAdapter(LocalDate.class, new LocalDateTimeDeserializer());

        return builder;
    }
}
