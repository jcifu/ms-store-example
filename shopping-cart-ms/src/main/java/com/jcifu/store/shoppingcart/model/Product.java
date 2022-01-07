package com.jcifu.store.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Product {
    
	@Id
	private Integer productCode;
   
	private String productName;
   
	private String brand;
   
	private Integer quantity;
   
	private Integer price;
	
	private String description;

    private Integer categoryId;

	// private Cart cart;
    
}
