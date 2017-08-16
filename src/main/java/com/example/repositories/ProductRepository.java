package com.example.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.entities.Product;

@Repository
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Serializable> {

}
