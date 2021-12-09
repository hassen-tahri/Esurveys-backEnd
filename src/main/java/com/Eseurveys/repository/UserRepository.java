package com.Eseurveys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Eseurveys.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
