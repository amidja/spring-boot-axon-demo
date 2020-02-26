package com.example.eventsourcing.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apiDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.eventsourcing"))
                .paths(PathSelectors.any())                
                .build()
                .genericModelSubstitutes(Optional.class)
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo(){                
        return new ApiInfoBuilder()
                .title("Event Sourcing using Axon and Spring Boot")
                .description("Event Sourcing using Axon and Spring Boot")
                .version("0.1.0-DRAFT")
                .build();
    }
}

