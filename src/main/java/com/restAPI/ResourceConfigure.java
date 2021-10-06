package com.restAPI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResourceConfigure {
    @Bean
    public UserService getUserService(){
        return new UserService();
    }
}
