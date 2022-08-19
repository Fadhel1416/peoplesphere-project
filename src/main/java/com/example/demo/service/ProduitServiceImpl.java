package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ClientDao;
import com.example.demo.dao.ProduitDao;
import com.example.demo.dto.ClientResponseDto;
import com.example.demo.dto.ProduitRequestDto;
import com.example.demo.dto.ProduitResponseDto;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.models.ClientEntity;
import com.example.demo.models.ProduitEntity;

@Service
public class ProduitServiceImpl implements ProduitService {
	
	private ProduitDao produitDao;
	private ModelMapper modelMapper;
	
	
	public ProduitServiceImpl(ProduitDao produitDao, ModelMapper modelMapper) {
		super();
		this.produitDao = produitDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public ProduitResponseDto save(ProduitRequestDto produitRequestDto) {
		// TODO Auto-generated method stub
      ProduitEntity produitEntity=modelMapper.map(produitRequestDto,ProduitEntity.class);
      ProduitEntity produitSaved=produitDao.save(produitEntity);
      
      return modelMapper.map(produitSaved,ProduitResponseDto.class);
	
	}

	@Override
	public ProduitResponseDto findById(Integer id) {
		// TODO Auto-generated method stub
		ProduitEntity produitEntity=produitDao.findById(id).orElseThrow(()->new EntityNotFoundException("produit n\'existe pas "));
		
		return modelMapper.map(produitEntity,ProduitResponseDto.class);
	}

	@Override
	public ProduitResponseDto findByRef(String ref) {
		// TODO Auto-generated method stub
	ProduitEntity produitEntity=produitDao.findByRef(ref);
	
	if(produitEntity==null)
	{
		throw new EntityNotFoundException("produit n\'existe pas ");
	}
		
		return modelMapper.map(produitEntity,ProduitResponseDto.class);
	}

	@Override
	public ProduitResponseDto findByLibelle(String libelle) {
		// TODO Auto-generated method stub
		ProduitEntity produitEntity=produitDao.findByLibelle(libelle);
		
		if(produitEntity==null)
		{
			throw new EntityNotFoundException("produit n\'existe pas ");
		}
			
			return modelMapper.map(produitEntity,ProduitResponseDto.class);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		produitDao.deleteById(id);
	}

	@Override
	public ProduitResponseDto update(ProduitRequestDto produitRequestDto, Integer id) {
		// TODO Auto-generated method stub
		Optional<ProduitEntity>produitEntityOptional =produitDao.findById(id);
		
		if(produitEntityOptional.isPresent())
		{
			ProduitEntity produitEntity=modelMapper.map(produitRequestDto, ProduitEntity.class);
			produitEntity.setId(id);
			ProduitEntity updated=produitDao.save(produitEntity);
			return modelMapper.map(updated, ProduitResponseDto.class);
		}
		else {
			throw new EntityNotFoundException("produit not found");
		}
		
	}

	@Override
	public List<ProduitResponseDto> findAll() {
		// TODO Auto-generated method stub
		return produitDao.findAll()
				.stream().map(el->modelMapper.map(el, ProduitResponseDto.class))
				.collect(Collectors.toList());	
		
	}

}
