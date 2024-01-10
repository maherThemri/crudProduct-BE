package com.entretien.test1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entretien.test1.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
