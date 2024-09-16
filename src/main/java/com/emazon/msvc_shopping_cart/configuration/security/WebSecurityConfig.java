package com.emazon.msvc_shopping_cart.configuration.security;

import com.emazon.msvc_shopping_cart.configuration.security.jwt.JwtValidatorFilter;
import com.emazon.msvc_shopping_cart.domain.spi.ITokenServicePort;
import com.emazon.msvc_shopping_cart.domain.util.Constants;
import com.emazon.msvc_shopping_cart.domain.util.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    private final ITokenServicePort tokenPort;


    public WebSecurityConfig(ITokenServicePort tokenPort) {
        this.tokenPort = tokenPort;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.
                csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(http -> {
                    http.requestMatchers(HttpMethod.POST, Constants.API_SHOPPING_CART_PATH).hasRole(UserRole.CLIENT.getRoleName());
                    http.anyRequest().denyAll();
                })
                .addFilterBefore(new JwtValidatorFilter(tokenPort), UsernamePasswordAuthenticationFilter.class)
                .httpBasic(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable);


        return httpSecurity.build();
    }

}