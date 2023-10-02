package com.trabajando.springboot.app;

import com.trabajando.springboot.app.auth.handler.LoginSuccesHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
public class SpringSecurityConfig {

    @Autowired
    private LoginSuccesHandler succesHandler;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

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

    /* autenticacion JDBC*/
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder)
                .usersByUsernameQuery("select username,password, enabled " +
                        "from users " +
                        "where username=?")
                .authoritiesByUsernameQuery("select u.username,a.authority " +
                        "from authorities a " +
                        "inner join users u " +
                        "on (a.user_id = u.id) " +
                        "where u.username=?");
    }
}
