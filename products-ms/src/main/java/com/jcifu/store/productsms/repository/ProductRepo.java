package com.jcifu.store.productsms.repository;

import com.jcifu.store.productsms.model.Products;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Products, Integer> {
    
}