package com.eazybytes.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class InMemoryUsers {

    //** First Approach Using DefaultPasswordEncoder//**
    /*@Bean
    public InMemoryUserDetailsManager userDetailService(){

        UserDetails admin=
                User.withDefaultPasswordEncoder().
                        username("admin").password("12345").authorities("admin").build();
        UserDetails user=
                User.withDefaultPasswordEncoder().username("user").password("123456").authorities("read").build();

        return new InMemoryUserDetailsManager(admin,user);
    }*/

    //** Second Approach Using No DefaultPasswordEncoder//**
   /* @Bean
    public UserDetailsService userDetailService(){

        UserDetails admin=
                User.withUsername("admin")
                        .password("12345").authorities("admin").build();
        UserDetails user=
                User.withUsername("user").password("123456").authorities("read").build();

        return new InMemoryUserDetailsManager(admin,user);
    }*/

    // Using Bydefault JdbcUserDetails Implementation provided by Spring Team
    @Bean
    public UserDetailsService userSeviceDeails(DataSource dataSource){

        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
   public  PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
