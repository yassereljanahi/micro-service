package com.microservice.product.service;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.annotation.security.RunAs;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.microservice.product.entity.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTests {

	@Test
	public void test(){}
	
	/*
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	private URL baseUrl;
	
	
	@Before
	public void setBaseUrl() throws MalformedURLException{
		baseUrl = new URL("http://localhost:"+port+"/service/products/");
	}
	
	@Test
	public void testGetAllProducts() {
		
		ResponseEntity<List> response = restTemplate.getForEntity(baseUrl.toString(),
				List.class);
		
		assertTrue(response.getStatusCode().equals(HttpStatus.OK));
		
	}
	
	@Test
	public void testGetProductById() {
		
		int id=10;
		
		ResponseEntity<Product> response = restTemplate.getForEntity(baseUrl.toString()+id,
				Product.class);
		
		assertTrue(response.getStatusCode().equals(HttpStatus.OK));
		
	}
	
	@Test
	public void testGetNotExistingProductProductById() {
		
		int id=1;
		
		ResponseEntity<String> response = restTemplate.getForEntity(baseUrl.toString()+id,
				String.class);
		
		assertTrue(response.getStatusCode().equals(HttpStatus.NOT_FOUND));
		
	}

	@Test
	public void testPostProduct() {
		
		Product product = new Product();
		product.setName("Lait");
		product.setDescription("Lait");
		product.setPrice(3.5f);
		
		ResponseEntity<String> response = restTemplate.postForEntity(baseUrl.toString(), product, String.class);
		
		assertTrue(response.getStatusCode().equals(HttpStatus.CREATED));
		
	}
	
	@Test
	public void testUpdateProductById() {
		
		long id=9;
		
		Product product = new Product();
		product.setId(id);
		product.setName("pain");
		product.setDescription("pain");
		product.setPrice(2.5f);
		
		//Update the product
		restTemplate.put(baseUrl.toString()+id, product);
		
		//Check the product if it's updated
		ResponseEntity<Product> response = restTemplate.getForEntity(baseUrl.toString()+id,
				Product.class);
		
		assertTrue(response.getStatusCode().equals(HttpStatus.OK));
		assertTrue(response.getBody().equals(product));
		
	}
	
	@Test
	public void testDeleteProductById() {
		
		long id=5;
		
		//Delete product
		ResponseEntity<String> response = restTemplate.exchange(baseUrl.toString()+id, HttpMethod.DELETE, null, String.class);
		
		assertTrue(response.getStatusCode().equals(HttpStatus.OK));
	}
	
	@Test
	public void testDeleteNonExistingProductById() {
		
		long id=100;
		
		//Delete product
		ResponseEntity<String> response = restTemplate.exchange(baseUrl.toString()+id, HttpMethod.DELETE, null, String.class);
		
		assertTrue(response.getStatusCode().equals(HttpStatus.NOT_FOUND));
	}
	*/
	
}
