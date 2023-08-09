package com.springSecurity.products.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springSecurity.products.models.entities.Product;
import com.springSecurity.products.service.ProductService;

import jakarta.validation.Valid;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping(path = "/product/create")
	public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product){
		productService.createProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
	
	@GetMapping(path = "/products")
	public ResponseEntity<Iterable<Product>> getAllProducts(){
		Iterable<Product> products = productService.getAllProducts();
		return ResponseEntity.ok().body(products);
	}
	
	@GetMapping(path = "/product/{id}")
	public ResponseEntity<Product> getById(@PathVariable Long id){
		Optional<Product> productOptional = productService.getProcuctById(id);
		if(!productOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok().body(productOptional.get());
	}
	
}
