package com.cognizant.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

@Controller
public class CartController {

	@Autowired
    CartService cartService;

    private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);
    
    @GetMapping("/add-to-cart")
    public String addToCart(@RequestParam long menuItemId, ModelMap model) {
        LOGGER.info("Start - addToCart ");
        cartService.addCartItem(1, menuItemId);
        model.addAttribute("addCartStatus", true);
        
        LOGGER.info("End - addToCart");
        return "redirect:/show-menu-list-customer";
    }
    
    @GetMapping(value = "/show-cart")
    public String showCart(@RequestParam(required = false) long userId, ModelMap model) {
        
        LOGGER.info("Start - ShowCart");
        System.out.println("user id is " + userId);
        if(userId != 0) {
            try {
                List<MenuItem> cartItems = cartService.getAllCartItems(userId);
                System.out.println(cartItems);
                model.addAttribute("cartItems", cartItems);
                model.addAttribute("userId", userId);
                LOGGER.info("End - ShowCart");
                return "cart";
            } catch (CartEmptyException e) {
                // TODO Auto-generated catch block

                LOGGER.info("End - ShowCart");
                return "cart-empty";
                
            }
        }else {
            return "cart";
        }
    }
    
    
    @GetMapping(value = "/remove-cart")
    public String removeCart(@RequestParam long userId, @RequestParam long menuItemId, ModelMap model) {
    	LOGGER.info("Start - removeCart");
        cartService.removeCartItem(userId, menuItemId);

        List<MenuItem> cartItems;
        try {
            cartItems = cartService.getAllCartItems(userId);
            model.addAttribute("cartItems", cartItems);
            model.addAttribute("userId", userId);
        } catch (CartEmptyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        LOGGER.info("End - removeCart");
        return "redirect:/cart";
    }
}
