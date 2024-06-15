package com.agan.layerdao_hibernate.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withUsername("admin")
                .password(encoder().encode("admin"))
                .roles("ADMIN", "WRITE", "DELETE")
                .build();

        UserDetails user = User.withUsername("user")
                .password(encoder().encode("user"))
                .roles("USER", "READ")
                .build();

        UserDetails hakan = User.withUsername("hakan")
                .password(encoder().encode("hakan"))
                .roles("ADMIN", "USER", "WRITE", "READ")
                .build();

        return new InMemoryUserDetailsManager(admin, user, hakan);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("security/welcome").permitAll()
                        .requestMatchers("security/by-city").hasAuthority("ROLE_ADMIN")
                        .requestMatchers("security/by-age").hasAuthority("ROLE_USER")
                        .requestMatchers("security-test/welcome").permitAll()
                        .requestMatchers("security-test/read").hasAuthority("ROLE_USER")
                        .requestMatchers("security-test/write").hasAnyAuthority("ROLE_ADMIN", "ROLE_WRITE")
                        .requestMatchers("security-test/modify").hasAnyAuthority("ROLE_WRITE", "ROLE_DELETE")
                        .requestMatchers("security-test/user").hasAnyAuthority("ROLE_ADMIN", "ROLE_READ")
                )
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(encoder());

        return provider;
    }

}
