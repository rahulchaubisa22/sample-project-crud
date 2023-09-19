package com.sample.registration.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@EnableSwagger2
@ComponentScan({ "com.sample.*"})
@EnableAspectJAutoProxy
@EnableMongoRepositories(basePackages = "com.sample.registration.repository")
public class SampleProjectCrud {
    public static void main(String[] args) {
        SpringApplication.run(SampleProjectCrud.class, args);
    }
}
