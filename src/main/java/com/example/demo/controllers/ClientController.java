package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ClientRequestDto;
import com.example.demo.dto.ClientResponseDto;
import com.example.demo.service.ClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("clients")
@Api(description="API pour les opérations CRUD sur les clients.")
public class ClientController {

	
	private ClientService clientService;
	
	public ClientController(ClientService clientService)
	{
		this.clientService=clientService;
	}
	
	@GetMapping("")
	@ApiOperation(value = "Récupère tout les clients ")
	public ResponseEntity< List<ClientResponseDto>> getClient() {
		//return clientService.findAll();
		return new ResponseEntity<>(clientService.findAll(),HttpStatus.OK);// return status code 200 for ok 
		
	}
	
	@PostMapping("")
	@ApiOperation(value = "Ajouter un nouveau client")
	public ResponseEntity<ClientResponseDto> save(@Valid @RequestBody() ClientRequestDto clientrequestdto)
	{
		//return clientService.save(clientrequestdto);
		
		return new ResponseEntity<>(clientService.save(clientrequestdto),HttpStatus.CREATED);//return 201 status code for created object in database 
		
	}
	
    @GetMapping("/id/{id}")
	@ApiOperation(value = "Récupère un client by id ")
	public ResponseEntity<ClientResponseDto> findById(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(clientService.findById(id));//return 200 status code
	}
    
    @GetMapping("/nom/{nom}")
	@ApiOperation(value = "Récupère client by nom")
	public ResponseEntity< ClientResponseDto> findByNom(@PathVariable() String nom) {
		return ResponseEntity.ok(clientService.findByNom(nom));//return 200 status code 
	}
    
    @DeleteMapping("/id/{id}")
	@ApiOperation(value = "Supprimer un client by id ")
	public ResponseEntity<?> delete(@PathVariable() Integer id) {
		clientService.delete(id);
		return ResponseEntity.noContent().build();//return 204 status code for no content 
	}
    
    @PutMapping("/id/{id}")
	@ApiOperation(value = "Modifier un client by id ")
	public ResponseEntity<ClientResponseDto> update(@Valid @RequestBody() ClientRequestDto clientRequestDto,@PathVariable() Integer id) {
		ClientResponseDto clientResponseDto= clientService.update(clientRequestDto, id);
		
		return ResponseEntity.accepted().body(clientResponseDto);//for put request , return 202 for status code
	}

}
