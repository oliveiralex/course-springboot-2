package com.iftm.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iftm.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
