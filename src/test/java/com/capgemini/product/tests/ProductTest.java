package com.capgemini.product.tests;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.product.controller.ProductController;
import com.capgemini.product.entity.Product;
import com.capgemini.product.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {
	
	@Mock
	private ProductService productService;
	
	@InjectMocks
	private ProductController productController;
	
	private MockMvc mockMvc;
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
	}
		
	@Test
	public void testAddProductWhichAddsProductObject() throws Exception {
		
		Product product = new Product(123, "vaseline", "10");
		
		when(productService.addproduct(Mockito.isA(Product.class))).thenReturn(product);
		
		mockMvc.perform(post("/product").
				               contentType(MediaType.APPLICATION_JSON_UTF8)
				               .content("{\"productId\": 123, \"productName\": \"vaseline\",\"productPrice\":\"10\"}")
				               .accept(MediaType.APPLICATION_JSON))
		                     .andExpect(status().isOk())
		                     .andExpect(jsonPath("$.productId").exists())
		                     .andExpect(jsonPath("$.productName").exists())
		                     .andExpect(jsonPath("$.productPrice").exists())
		                    
		                     
		                      .andExpect(jsonPath("$.productId").value("123"))
		                     .andExpect(jsonPath("$.productName").value("vaseline"))
		                     .andExpect(jsonPath("$.productPrice").value("10"))
		                     
		                     
		                     .andDo(print());		              
	}
			
			
			
}
