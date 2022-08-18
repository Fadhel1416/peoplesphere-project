package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ClientDao;
import com.example.demo.dto.ClientRequestDto;
import com.example.demo.dto.ClientResponseDto;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.models.ClientEntity;

@Service
public class ClientServiceImpl implements ClientService {

	
	private ClientDao clientDao;
	private ModelMapper modelMapper;
	
	public ClientServiceImpl(ClientDao clientDao, ModelMapper modelMapper) {
		//super();
		this.clientDao = clientDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public ClientResponseDto save(ClientRequestDto ClientRequestDto) {
		// TODO Auto-generated method stub
		ClientEntity clientEntity=modelMapper.map(ClientRequestDto,ClientEntity.class);
		ClientEntity saved=clientDao.save(clientEntity);
		
		return modelMapper.map(saved, ClientResponseDto.class);
	}

	@Override
	public ClientResponseDto findById(Integer id) {
		// TODO Auto-generated method stub
		ClientEntity clientEntity=clientDao.findById(id).orElseThrow(()->new EntityNotFoundException("client not found "));
		return modelMapper.map(clientEntity, ClientResponseDto.class);
	}

	@Override
	
	
	public ClientResponseDto findByNom(String nom) {
		
          ClientEntity clientEntity=clientDao.findByNom(nom);
          
		return modelMapper.map(clientEntity,ClientResponseDto.class);
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		clientDao.deleteById(id);
		//you can remove entity by this instructions........
		/*
		ClientEntity clientEntity=clientDao.findById(id).get();
		clientDao.delete(clientEntity);*/
		
	}

	@Override
	public ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id) {
		// TODO Auto-generated method stub
		Optional<ClientEntity> clientEntityOptional =clientDao.findById(id);
		if(clientEntityOptional.isPresent())
		{
			ClientEntity clientEntity=modelMapper.map(clientRequestDto, ClientEntity.class);
			clientEntity.setId(id);
			ClientEntity updated=clientDao.save(clientEntity);
			return modelMapper.map(updated, ClientResponseDto.class);
		}
		else {
			throw new EntityNotFoundException("client not found");
		}
	}

	@Override
	public List<ClientResponseDto> findAll() {
		// TODO Auto-generated method stub
		return clientDao.findAll()
				.stream().map(el->modelMapper.map(el, ClientResponseDto.class))
				.collect(Collectors.toList());
	}

}
