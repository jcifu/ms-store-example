package com.jcifu.store.shoppingcart.repository;

import com.jcifu.store.shoppingcart.model.Cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {
    
}
