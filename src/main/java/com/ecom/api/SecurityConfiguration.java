package com.ecom.api;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable();

        http
        .authorizeHttpRequests((authz) -> authz
            .antMatchers("/register").permitAll()
            .antMatchers("/lignecommande").hasRole("ADMIN")
            .antMatchers("/user").hasRole("ADMIN")
        ).httpBasic(withDefaults());
        
        return http.build();
    }

}