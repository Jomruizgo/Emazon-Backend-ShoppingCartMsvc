package com.emazon.msvc_shopping_cart.adapters.driving.controller;

import com.emazon.msvc_shopping_cart.domain.util.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Constants.API_SHOPPING_CART_PATH)
public class ShoppingCartController {

    @PostMapping("")
    public ResponseEntity<String> sell(){
        String regard = "Hello client user from sopping cart microservice.";
        return new ResponseEntity<>(regard, HttpStatus.OK);
    }
}
