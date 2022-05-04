package com.Eseurveys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Eseurveys.model.entity.DommageItem;
import java.util.List;

@Repository
public interface DommageItemRepository extends JpaRepository<DommageItem, Long> {
	List<DommageItem> findByConstatId(Long id);
	List<DommageItem> findByConstatIdAndPhase(Long id , String phase);
}
