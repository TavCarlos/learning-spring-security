package com.springSecurity.products.respositories;

import org.springframework.data.repository.CrudRepository;

import com.springSecurity.products.models.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long>  {

}
