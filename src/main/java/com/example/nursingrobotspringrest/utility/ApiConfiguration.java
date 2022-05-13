package com.example.nursingrobotspringrest.utility;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "python.client.config")
@Configuration
public class ApiConfiguration {
   private String api;
   private String port;

   @Bean
    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }
    @Bean
    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Bean
    public void show(){
        System.out.println("print show output");
    }
}
