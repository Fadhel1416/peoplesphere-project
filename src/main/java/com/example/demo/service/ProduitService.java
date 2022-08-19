package com.example.demo.service;

import java.util.List;


import com.example.demo.dto.ProduitRequestDto;
import com.example.demo.dto.ProduitResponseDto;

public interface ProduitService {
	
	
	ProduitResponseDto save(ProduitRequestDto produitRequestDto);
	
	ProduitResponseDto findById(Integer id);
	
	ProduitResponseDto findByRef(String ref);
	
	ProduitResponseDto findByLibelle(String libelle);
	
    void delete(Integer id);
    
    ProduitResponseDto update(ProduitRequestDto produitRequestDto, Integer id);
    
    List<ProduitResponseDto> findAll();
    
}
