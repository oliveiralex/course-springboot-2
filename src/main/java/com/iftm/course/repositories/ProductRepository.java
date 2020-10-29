package com.iftm.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iftm.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
