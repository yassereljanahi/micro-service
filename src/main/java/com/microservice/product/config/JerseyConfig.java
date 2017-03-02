package com.microservice.product.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("service")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig(){
		packages("com.microservice.product.service");
	}
	
}
