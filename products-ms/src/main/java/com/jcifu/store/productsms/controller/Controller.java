package com.jcifu.store.productsms.controller;

import java.util.List;
import java.util.Optional;

import com.jcifu.store.productsms.model.Products;
import com.jcifu.store.productsms.service.ProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    @Autowired
    private ProductsService productService;

    @GetMapping("/products")
    public List<Products> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/products/{productCode}")
    public Optional<Products> getProduct(@PathVariable Integer productCode){
        
        return productService.getProduct(productCode);
    }

    @PostMapping(value = "/products/save", consumes = "application/json")
    public Products saveProduct(@RequestBody Products product){
        return productService.saveProduct(product);
    }

    @PutMapping(value = "products/{productCode}", consumes = "application/json")
    public Optional<Products> updateProduct(@RequestBody Products products, @PathVariable Integer productCode) {   
        return productService.updateProduct(products, productCode);
    }  

    @DeleteMapping("products/{productCode}")
    public HttpEntity<String> deleteProduct(@PathVariable Integer productCode){
        String result = productService.deleteProduct(productCode);
        return new HttpEntity<String>(result);
    }
}
