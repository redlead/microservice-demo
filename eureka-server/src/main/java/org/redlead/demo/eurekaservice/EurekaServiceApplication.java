package org.redlead.demo.eurekaservice;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@EnableAdminServer
public class EurekaServiceApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(EurekaServiceApplication.class, args);
    }
}