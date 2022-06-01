package com.Eseurveys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Eseurveys.model.entity.Constat;
import java.util.List;
import java.lang.String;
import java.util.Date;
import com.Eseurveys.model.entity.Chargeur;

@Repository
public interface ConstatRepository extends JpaRepository<Constat, Long> {
	List<Constat> findByVoyageId(Long id);
	List<Constat> findByChargeurId(Long id);
	List<Constat> findByInspecteurChargementId(Long id);
	List<Constat> findByInspecteurDechargementId(Long id);
	List<Constat> findByEtat(String etat);
	
	//inspecteurChargement and date chargement range
	List<Constat> findByInspecteurChargementIdAndDateChargementBetween(Long id , Date dateDeb , Date dateFin);
	
	//inspecteurDechargement and chargement Range
	List<Constat> findByInspecteurDechargementIdAndDateChargementBetween(Long id , Date dateDeb , Date dateFin);
	
	//date chargement in range
	List<Constat> findByDateChargementBetween(Date dateDeb , Date dateFin);
	
	//date dechargement in range
    List<Constat> findByDateDechargementBetween(Date dateDeb , Date dateFin);
    
    //chargeur and etat 
    List<Constat> findByChargeurIdAndEtat(Long id, String etat);
    
    List<Constat> findByPhase(String phase);
    
    List<Constat> findByChargeurIdAndPhase(Long id , String phase);
}
