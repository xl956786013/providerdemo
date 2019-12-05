package com.xuling.providerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProviderdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderdemoApplication.class, args);
    }

}
