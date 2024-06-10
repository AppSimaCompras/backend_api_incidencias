package com.lacomer.api.incidencias;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@SpringBootApplication
public class SpringBootBackendApirestApplication{

	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootBackendApirestApplication.class, args);
		
		System.out.println("Hola Mundo");
	}
	
	
	@Bean
    public CommandLineRunner commandLineRunner(RequestMappingHandlerMapping handlerMapping) {
        return args -> {
            handlerMapping.getHandlerMethods().forEach((requestMappingInfo, handlerMethod) -> {
                System.out.println(requestMappingInfo + " " + handlerMethod);
            });
        };
    }
    
	}
			
