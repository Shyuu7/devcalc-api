package com.devcalc.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("DevCalc API")
                        .version("1.0.0")
                        .description("API REST para operações matemáticas básicas")
                        .contact(new Contact()
                                .name("DevCalc Team")
                                .url("https://github.com/Shyuu7/devcalc-api")));
    }
}