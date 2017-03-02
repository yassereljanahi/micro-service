package com.microservice.product.service;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;

import com.microservice.product.dao.ProductDAO;
import com.microservice.product.entity.Product;

@Path("products")
public class ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Product> getAllProducts(){
		
		return productDAO.findAll();
	
	}
	
	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getProductById(@PathParam("id") Long id){
		
		Product product = productDAO.findOne(id);
		
		if(product != null){
			
			return Response.ok(product)
					.build();
			
		}else{
			
			return Response.status(Response.Status.NOT_FOUND)
					.entity("Product not found")
					.build();
			
		}
	
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces(MediaType.TEXT_PLAIN)
	public Response insertProduct(Product product){
		
		Product newProduct = productDAO.save(product);
		
		return Response.created(URI.create("http://localhost:8080/service/products/"+newProduct.getId())) //Code 201
				.entity("New product has been created")
				.build();
		
	}
	
	@PUT
	@Path("{id}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateProduct(@PathParam("id") Long id, Product product){
		
		if(id!=product.getId())
			product.setId(id);
		
		
		//Check if product exists
		if(productDAO.exists(id)){
			
			//Update the product
			productDAO.save(product);
			
			return Response.ok() //Code 200
					.entity("Product has been updated")
					.build();
		
		}else{
			
			//Product not found on the server
			//Create it
			return insertProduct(product);
			
			/*
			 * Product not found
			 * It depends on the implementation of the web service
			 * 
			 * return Response.status(Response.Status.NOT_FOUND) //Code 404
					.entity("Product not found")
					.build();
			*/
			
		}
			
	}
	
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteAllProducts(){
		
		productDAO.deleteAll();
		
		return Response.ok() //Code 200
				.entity("All products have been removed")
				.build();
		
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteProductById(@PathParam("id") Long id){
		
		//Check if product exists
		if(productDAO.exists(id)){
		
			productDAO.delete(id);
			return Response.ok() //Code 200
					.entity("Product has been removed")
					.build();
			
		}else{
			
			return Response.status(Response.Status.NOT_FOUND) //Code 404
					.entity("Product not found")
					.build();
			
		}
		
	}
	
}
