package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

@Service
public class CartService {

    private CartDao cartDao;

    public List<MenuItem> getAllCartItems(final long userId) throws CartEmptyException {
        return cartDao.getAllCartItems(userId);
    }

    @Autowired
    public void setCartDao(final CartDao cartDao) {
        this.cartDao = cartDao;
    }

    public void addCartItem(final long userId, final long menuItemId) {
        cartDao.addCartItem(userId, menuItemId);
    }

    public void removeCartItem(final long userId, final long menuItemId) {
        cartDao.removeCartItem(userId, menuItemId);
    }
}
