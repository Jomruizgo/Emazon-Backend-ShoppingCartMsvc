package com.emazon.msvc_shopping_cart.configuration;


import com.emazon.msvc_shopping_cart.adapters.driven.jwt.JavaJwtAdapter;
import com.emazon.msvc_shopping_cart.domain.spi.ITokenServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {


    @Bean
    public ITokenServicePort tokenPort() {
        return new JavaJwtAdapter();
    }

}
