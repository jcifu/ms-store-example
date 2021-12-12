package com.jcifu.store.productsms.service;

import java.util.List;
import java.util.Optional;

import com.jcifu.store.productsms.model.Products;
import com.jcifu.store.productsms.repository.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Products> getProducts() {
        List<Products> productList = productRepo.findAll();
        return productList;
    }

    @Override
    public Optional<Products> getProduct(Integer productCode) {
        Optional<Products> productOptional = productRepo.findById(productCode);
        return productOptional;
    }

    @Override
    public Optional<Products> updateProduct(Products products, Integer productCode) {

        Optional<Products> productsOptional = productRepo.findById(productCode);
        Products product = productsOptional.get();
        
        if(productsOptional.isPresent()){
            product.setProductCode(product.getProductCode());
            product.setProductName(product.getProductName());
            product.setBrand(product.getBrand());
            product.setQuantity(product.getQuantity());
            product.setPrice(product.getPrice());
            product.setDescription(product.getDescription());
            
            productRepo.save(product);
        }
        
        return productsOptional;
    }

    @Override
    public Products saveProduct(Products products) {
        return productRepo.save(products);
    }

    @Override
    public String deleteProduct(Integer productCode) {

        if (productCode != null) {

            if (productRepo.existsById(productCode)) {
                productRepo.deleteById(productCode);
                return ("Producto " + productCode + " eliminado");
            } else {
                
                return "Código de producto no existe. Ingrese código nuevamente.";
            }
        }
        return "Código de producto incorrecto. Ingrese código nuevamente";
    }
}
