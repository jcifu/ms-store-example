package com.jcifu.store.shoppingcart.controller;

import java.util.List;

import com.jcifu.store.shoppingcart.model.Cart;
import com.jcifu.store.shoppingcart.model.Product;
import com.jcifu.store.shoppingcart.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
    
    @Autowired
    private CartService shoppingService;

    //get cart
    @GetMapping(value = "/cart/{cartId}")
    public Cart getCart(@PathVariable Integer cartId){
        Cart actualCart =  shoppingService.findCartById(cartId);
        return actualCart;
    }

    //add item
    @PutMapping(value = "/cart/addItem/{productCode}")
    public void addCartItem(@PathVariable Integer productCode, Cart cart/*, Item item*/, Product product, Integer quantity){
        
        Cart actualCart = shoppingService.findCartById(cart.getCartId());
        
        List<Product> itemList= actualCart.getProducts();
        
        itemList.forEach( cartItem ->{
            
            cartItem.setProductCode(product.getProductCode());
            cartItem.setProductName(product.getProductName());
            cartItem.setPrice(product.getPrice());
            cartItem.setQuantity(quantity);
        
        });
        
        shoppingService.saveCart(actualCart);
    }

    //delete item
    @DeleteMapping(value = "/cart/delete/{productCode}")
    public void deleteCartItem(@PathVariable Integer productCode, Cart cart){
        
        Cart actualCart = shoppingService.findCartById(cart.getCartId());
        shoppingService.deleteItem(actualCart, productCode);
    }

    

    

}
