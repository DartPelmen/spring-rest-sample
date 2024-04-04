package edu.festu.ivankuznetsov.eventsapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import edu.festu.ivankuznetsov.eventsapp.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final UserService userService;

    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
        throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public static BCryptPasswordEncoder passwordEncoder(){ return new BCryptPasswordEncoder();}

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.
                cors(CorsConfigurer::disable).
                csrf(CsrfConfigurer::disable).
                formLogin(Customizer.withDefaults()).
                authorizeHttpRequests(requestCustomizer->
                    requestCustomizer
                        // requestMatchers(HttpMethod.GET,"/getByUser").hasRole("USER").
                        // requestMatchers("/user").hasRole("ADMIN").
                        // requestMatchers(HttpMethod.POST, "/register").permitAll().

                     //   requestMatchers(HttpMethod.POST).hasRole("ADMIN").
                        // requestMatchers(HttpMethod.DELETE).authenticated().
                        // requestMatchers(HttpMethod.PUT).authenticated().
                        // requestMatchers(HttpMethod.GET,"/**","/login**","/logout**").
                        // permitAll()
                        .anyRequest().permitAll()
                                    
                ).httpBasic(Customizer.withDefaults()).build();
    }
}
