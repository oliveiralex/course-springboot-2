package com.iftm.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iftm.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
