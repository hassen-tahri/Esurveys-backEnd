package com.Eseurveys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Eseurveys.model.entity.TypeRemorque;

@Repository
public interface TypeRemorqueRepository extends JpaRepository<TypeRemorque, Long> {

}
