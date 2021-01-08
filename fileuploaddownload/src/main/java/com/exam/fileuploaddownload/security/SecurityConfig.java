package com.exam.fileuploaddownload.security;

import static com.exam.fileuploaddownload.security.ApplicationUserRole.ADMIN;
import static com.exam.fileuploaddownload.security.ApplicationUserRole.USER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.builder()
                .username("user1")
                .password(passwordEncoder.encode("password"))
                .roles(ApplicationUserRole.USER.name())
                .build();

        UserDetails user2 = User.builder()
                .username("user2")
                .password(passwordEncoder.encode("password"))
                .roles(ADMIN.name())
                .build();

        UserDetails user3 = User.builder()
                .username("user3")
                .password(passwordEncoder.encode("password"))
                .roles(ADMIN.name())
                .build();
        UserDetails user4 = User.builder()
                .username("user4")
                .password(passwordEncoder.encode("password"))
                .roles(ApplicationUserRole.USER.name())
                .build();

        return new InMemoryUserDetailsManager(
                user1,
                user2,
                user3,
                user4
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/upload").hasRole(ADMIN.name())
                .antMatchers("/download").hasAnyRole(ADMIN.name())
                .antMatchers("/files/*").hasAnyRole(ADMIN.name(), USER.name())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();

    }
}