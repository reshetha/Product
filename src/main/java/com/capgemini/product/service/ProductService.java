package com.capgemini.product.service;

import com.capgemini.product.entity.Product;
import com.capgemini.product.service.exception.ProductNotFoundException;

public interface ProductService {
	
	public Product addproduct(Product product);
	public Product updateproduct(Product product);
	
	public Product findProductById(int productId)throws ProductNotFoundException;
	void deleteProduct(Product product);
	
	

}
