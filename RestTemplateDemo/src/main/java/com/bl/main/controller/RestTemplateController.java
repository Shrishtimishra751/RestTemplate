package com.bl.main.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bl.main.model.Product;

@RestController
@RequestMapping(value = "/home")
public class RestTemplateController {
	@Autowired
	private RestTemplate resttemplate;

	public String getProductList() {
		System.err.println("000000000000");
		HttpHeaders header = new HttpHeaders();
		System.err.println("11111111111");
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		System.err.println("222222222222");
		HttpEntity<String> entity = new HttpEntity<String>(header);
		System.err.println("33333333333333");
		return resttemplate.exchange("http://localhost:8080/products", HttpMethod.GET, entity, String.class).getBody();
	}
@PostMapping("/post")
	   public String createProduct(@RequestBody Product products) {
	System.out.println(products.toString());
	try {
	      HttpHeaders header = new HttpHeaders();
	      header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Product> entity = new HttpEntity<Product>(products,header);
	      
	      System.out.println("***************************************"+entity);
	      return resttemplate.exchange("http://localhost:8080/post", HttpMethod.POST, entity, String.class).getBody();
	   }
	catch(Exception e) {
		e.getMessage();
		return null;
	}
	}
	
	@GetMapping("/get")
	public String getmsg() {
		return "hii";
	}
	
//	@PutMapping("/put")
//	public String updateProduct(@PathVariable("id") String id, @RequestBody Product products) {
//	      HttpHeaders headers = new HttpHeaders();
//	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//	      HttpEntity<Product> entity = new HttpEntity<Product>(products,headers);
//	      
//	      return resttemplate.exchange("http://localhost:8080/products/"+id, HttpMethod.PUT, entity, String.class).getBody();
//	   }
}