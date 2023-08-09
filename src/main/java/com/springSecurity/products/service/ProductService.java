package com.springSecurity.products.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springSecurity.products.models.entities.Product;
import com.springSecurity.products.respositories.ProductRepository;

@Service
public class ProductService{

	@Autowired
	ProductRepository repository;
	
	public Product createProduct(Product product) {
		repository.save(product);
		return product;
	}
	
	public Iterable<Product> getAllProducts(){
		return repository.findAll();
	}
	
	public Optional<Product> getProcuctById(Long id) {
		return repository.findById(id);
	}
	
}
