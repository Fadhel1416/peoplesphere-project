package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.ProduitEntity;

@Repository
public interface ProduitDao extends JpaRepository<ProduitEntity, Integer> {
	
	
	ProduitEntity findByLibelle(String lib);
	
	ProduitEntity findByRef(String Ref);

}
