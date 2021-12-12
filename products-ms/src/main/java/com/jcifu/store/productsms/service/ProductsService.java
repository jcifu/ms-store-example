package com.jcifu.store.productsms.service;

import java.util.List;
import java.util.Optional;

import com.jcifu.store.productsms.model.Products;

public interface ProductsService {
    
    List<Products> getProducts();
    
    Optional<Products> getProduct(Integer productCode);
    
    Optional<Products> updateProduct(Products products, Integer productCode);

    Products saveProduct(Products products);

    String deleteProduct(Integer productCode);
}
