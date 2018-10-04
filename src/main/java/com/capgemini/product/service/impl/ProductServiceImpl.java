package com.capgemini.product.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.product.entity.Product;
import com.capgemini.product.repository.ProductRepository;
import com.capgemini.product.service.ProductService;
import com.capgemini.product.service.exception.ProductNotFoundException;



	
	@Service
	public class ProductServiceImpl implements ProductService {

		@Autowired
		private ProductRepository productRepository;

		@Override
		public Product addproduct(Product product) {
			return productRepository.save(product);
		}

		@Override
		public Product updateproduct(Product product) {
			return productRepository.save(product);
		}

		@Override
		public Product findProductById(int productId) throws ProductNotFoundException {
			Optional<Product> optionalProduct = productRepository.findById(productId);
			if(optionalProduct.isPresent())
				return optionalProduct.get();
			throw new ProductNotFoundException("Product does not exists");
		}

		@Override
		public void deleteProduct(Product product) {
			productRepository.delete(product);
		}

	}
		
		
		
	

	


