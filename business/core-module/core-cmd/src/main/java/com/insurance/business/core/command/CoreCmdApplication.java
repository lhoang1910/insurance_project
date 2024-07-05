package com.insurance.business.core.command;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.insurance.business.core.domain", "com.insurance.business.core.command"})
public class CoreCmdApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreCmdApplication.class, args);
    }

}
