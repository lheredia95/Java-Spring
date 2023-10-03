package com.trabajando.springboot.app;

import com.trabajando.springboot.app.auth.handler.LoginSuccesHandler;
import com.trabajando.springboot.app.models.service.JpaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class SpringSecurityConfig {

    @Autowired
    private LoginSuccesHandler succesHandler;

    @Autowired
    private JpaUserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public void userDetailsService(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/", "/css/**", "/js/**", "/images/**", "/listar").permitAll()
                        .anyRequest().authenticated()
                ).formLogin(form -> form
                        .successHandler(succesHandler)
                        .loginPage("/login")
                        .permitAll()
                )
                .logout(form -> form
                        .logoutUrl("/logout")
                        .permitAll())
                .exceptionHandling(form -> form
                        .accessDeniedPage("/error_403"));
        return http.build();
    }
}
