package com.stark.registry.ServiceRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistryApplication.class, args);
        System.out.println("Microservices Service Registry\n" +
                "A service registry is a database used to keep track of the available instances" +
                " of each microservice in an application. The service registry needs to be " +
                "updated each time a new service comes online and whenever a service is taken " +
                "offline or becomes unavailable.");
    }

}
