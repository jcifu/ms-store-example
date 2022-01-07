package com.jcifu.store.shoppingcart.service;

import java.util.List;

import com.jcifu.store.shoppingcart.model.Cart;
import com.jcifu.store.shoppingcart.model.Product;
import com.jcifu.store.shoppingcart.repository.CartRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{
    
    @Autowired
    private CartRepo shoppingCart;


    @Override
    public Cart findCartById(Integer cartId) {

        if(shoppingCart.existsById(cartId)){
            Cart cart = shoppingCart.getById(cartId);
            return cart;
        }else {
            Cart cart = new Cart();
            cart.setCartId(cartId);
            return cart;
        }
        
    } 

    @Override
    public void addItem(Cart cart, Product product, Integer quantity) {
        
        Cart userCart = shoppingCart.getById(cart.getCartId());

        userCart.getProducts().forEach(
            cartItem -> {
            userCart.setProductCode(product.getProductCode());
            userCart.setProductCode(product.getProductCode());
            userCart.setProductName(product.getProductName());
            userCart.setQuantity(quantity);
            userCart.setPrice(product.getPrice());
            userCart.setTotalSale(product.getPrice() * quantity);
            }
        );

        shoppingCart.save(userCart);    
    }

    @Override
    public void deleteItem(Cart cart, Integer productCode) {
        
        Cart userCart = shoppingCart.getById(cart.getCartId());
        
        List<Product> items = userCart.getProducts();

        if (productCode != null && shoppingCart.existsById(cart.getCartId())) {

            // to delete
        }
    }

    @Override
    public Cart saveCart(Cart cart) {
        Cart userCart = shoppingCart.save(cart);
        return userCart;
    }
}
