package com.jcifu.store.shoppingcart.service;

import com.jcifu.store.shoppingcart.model.Cart;
import com.jcifu.store.shoppingcart.model.Product;

public interface CartService {
    
    Cart findCartById(Integer cartId);

    void addItem(Cart cart, Product product, Integer quantity);

    void deleteItem(Cart cart, Integer productCode);

    Cart saveCart(Cart cart);
}
