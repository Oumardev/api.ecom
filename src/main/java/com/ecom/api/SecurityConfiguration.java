package com.ecom.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager UserDetailServices(){
        UserDetails user_admin = User.builder()
        .username("Oumar")
        .password("dev_api")
        .roles("ADMIN")
        .build();

        UserDetails user_default = User.builder()
        .username("user_api")
        .password("UDH348X83D")
        .roles("USER")
        .build();

        return new InMemoryUserDetailsManager(user_admin,user_default);
    }

}