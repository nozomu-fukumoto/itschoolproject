package com.sample.itschoolpg.itschoolproject.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
  
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.formLogin(login -> login
          .loginProcessingUrl("/login")
          .loginPage("/login")
          .defaultSuccessUrl("/", true)
          .failureUrl("/login?error")
          .permitAll()
    ).authorizeHttpRequests(authz -> authz
          .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
          .permitAll()
          .anyRequest().authenticated()
    );
    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
