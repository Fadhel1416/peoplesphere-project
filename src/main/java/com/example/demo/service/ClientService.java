package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ClientRequestDto;
import com.example.demo.dto.ClientResponseDto;

public interface ClientService {
	
	
	ClientResponseDto save(ClientRequestDto ClientRequestDto);
	
	ClientResponseDto findById(Integer id);
	
	ClientResponseDto findByNom(String nom);
	
    void delete(Integer id);
    
    ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id);
    
    List<ClientResponseDto> findAll();
    
}
