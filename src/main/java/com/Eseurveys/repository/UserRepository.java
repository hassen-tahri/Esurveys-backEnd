package com.Eseurveys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Eseurveys.model.entity.User;
import java.lang.String;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByPseudo(String pseudo);

}
