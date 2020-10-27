package com.iftm.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iftm.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
