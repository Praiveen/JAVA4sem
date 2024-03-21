package com.example.prak10;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public Junior junProgrammer () {
        return new Junior();
    }

    @Bean
    public Middle midProgrammer () {
        return new Middle();
    }

    @Bean
    public Senior senProgrammer () {
        return new Senior();
    }

    @Bean("junior")
    public Programming startProgrammingJun() {
        Programming programming = new Programming();
        programming.setType(junProgrammer());
        return programming;
    }

    @Bean("middle")
    public Programming startProgrammingMid() {
        Programming programming = new Programming();
        programming.setType(midProgrammer());
        return programming;
    }

    @Bean("senior")
    public Programming startProgrammingSen() {
        Programming programming = new Programming();
        programming.setType(senProgrammer());
        return programming;
    }
}
