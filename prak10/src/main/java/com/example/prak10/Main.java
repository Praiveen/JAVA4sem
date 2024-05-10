package com.example.prak10;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class Main {
    public static void main(String... args) {
        SpringApplication.run(Main.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        Programming programming = context.getBean("juniorr", Programming.class);
        programming.DoProgramming();

        programming = context.getBean("middlee", Programming.class);
        programming.DoProgramming();

        programming = context.getBean("seniorr", Programming.class);
        programming.DoProgramming();
    }
}
