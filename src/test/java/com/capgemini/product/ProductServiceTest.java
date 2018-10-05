package com.capgemini.product;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.product.entity.Product;
import com.capgemini.product.repository.ProductRepository;
import com.capgemini.product.service.impl.ProductServiceImpl;

public class ProductServiceTest {
private MockMvc mockMvc;
	
	@Mock
	public ProductRepository productRepository;
	
	@InjectMocks
	public ProductServiceImpl productServiceImpl;
	
	@Before
	public void setUP() {
	MockitoAnnotations.initMocks(this);
	mockMvc = MockMvcBuilders.standaloneSetup(productServiceImpl).build();
	}
	
	@Test
	public void testAddProduct() {
		Product product = new Product(123, "vaseline","10");
		when(productRepository.save(product)).thenReturn(product);
		Product addProduct = productServiceImpl.addproduct(product);
		assertEquals(123, addProduct.getProductId());
	}
	
	@Test
	public void testUpdateProduct() {
		Product product = new Product(123, "ponds", "10");
		when(productRepository.save(product)).thenReturn(product);
		Product addProduct = productServiceImpl.addproduct(product);
		assertEquals(123, addProduct.getProductId());
	}

     @Test
	public void testdeleteproduct() {
		Product product = new Product(123, "ponds", "10");
		productServiceImpl.deleteProduct(product);

	}
	
}

