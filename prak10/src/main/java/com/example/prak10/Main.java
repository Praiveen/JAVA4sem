package com.example.prak10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class Main {
    public static void main(String... args) {
        SpringApplication.run(Main.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        Programming programming = context.getBean("junior", Programming.class);
        programming.DoProgramming();
        programming = context.getBean("middle", Programming.class);
        programming.DoProgramming();
        programming = context.getBean("senior", Programming.class);
        programming.DoProgramming();

        ((ConfigurableApplicationContext) context).close();
    }
}
