package com.siifo.siifo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.siifo.siifo.config.WebMvcConfig;



// @SpringBootApplication(staticResources = { "classpath:/public" })
@SpringBootApplication
public class Application {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfig();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}



