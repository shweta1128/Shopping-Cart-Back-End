package com.techelevator.controller;

import com.techelevator.Services.CartServices;
import com.techelevator.model.Cart;
import com.techelevator.model.CartItem;
import com.techelevator.model.User;
import org.springframework.data.relational.core.sql.In;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;


@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping(path = "/cart")
public class CartController {

    public CartServices cartServices;


    public CartController(CartServices cartServices){
        this.cartServices= cartServices;
    }

    @RequestMapping( method = RequestMethod.GET )
    public Cart getAllItemsInCart(Principal principal) {
        return cartServices.getAllItemsOfCart(principal);
    }
}



