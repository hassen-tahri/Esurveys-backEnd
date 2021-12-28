package com.Eseurveys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Eseurveys.model.entity.Bateau;

@Repository
public interface BateauRepository extends JpaRepository<Bateau, Long> {

}
