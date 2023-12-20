package com.shd0w.study.StarWarsApi.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI myOpenAPI() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Server URL in Development environment");

        Contact contact = new Contact();
        contact.setEmail("rios.john26@gmail.com");
        contact.setName("shd0w");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Star Wars API")
                .version("1.0")
                .contact(contact)
                .description("This API consumes the SWAPI (Star Wars API). Study purposes only")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(server));
    }
}
