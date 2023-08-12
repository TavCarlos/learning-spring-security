package com.springSecurity.products.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.springSecurity.products.models.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserDetails findByUserName(String userName);
}
