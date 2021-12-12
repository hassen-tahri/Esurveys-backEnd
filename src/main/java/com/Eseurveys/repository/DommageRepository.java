package com.Eseurveys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Eseurveys.model.entity.Dommage;

@Repository
public interface DommageRepository extends JpaRepository<Dommage, Long> {

}
