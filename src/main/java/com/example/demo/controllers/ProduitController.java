package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProduitRequestDto;
import com.example.demo.dto.ProduitResponseDto;
import com.example.demo.service.ProduitService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("produits")
@Api(description="API pour les opérations CRUD sur les produits.")
public class ProduitController {

	private ProduitService produitService;

	public ProduitController(ProduitService produitService) {
		//super();
		this.produitService = produitService;
	}
	
	@GetMapping("")
	@ApiOperation(value="Recupérer tout les produits")
	public ResponseEntity<List<ProduitResponseDto>> findAll() {
		//return produitService.findAll();
		
		//return all product in array list
		return new ResponseEntity<>(produitService.findAll(),HttpStatus.OK);
	}
	
    
	@PostMapping("")
	@ApiOperation(value="Ajouter un nouveau produit")
	public ResponseEntity<ProduitResponseDto> save(@RequestBody() ProduitRequestDto produitRequestDto) {
		
		return new ResponseEntity<>(produitService.save(produitRequestDto),HttpStatus.CREATED);
	}
    
	@GetMapping("/id/{id}")
	@ApiOperation(value="recuperer un  produit par id")
	public  ResponseEntity< ProduitResponseDto> findById(@PathVariable() Integer id) {
		
		return ResponseEntity.ok(produitService.findById(id));
	}
	
	@GetMapping("/ref/{ref}")
	@ApiOperation(value="recuperer un  produit par reference")
	public ResponseEntity<ProduitResponseDto> findByRef(@PathVariable() String ref) {
		return ResponseEntity.ok(produitService.findByRef(ref));
	}
   
	@GetMapping("/libelle/{libelle}")
	@ApiOperation(value="recuperer un  produit par libelle")
	public ResponseEntity<ProduitResponseDto> findByLibelle(@PathVariable() String libelle) {
		return ResponseEntity.ok(produitService.findByLibelle(libelle));
	}

	@DeleteMapping("/id/{id}")
	@ApiOperation(value = "Supprimer un produit by id ")
	public  ResponseEntity<?> delete(Integer id) {
		produitService.delete(id);
		
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/id/{id}")
	@ApiOperation(value = "Modifier un produit by id ")
	public ResponseEntity<ProduitResponseDto> update(@RequestBody() ProduitRequestDto produitRequestDto, Integer id) {
		return new ResponseEntity<>(produitService.update(produitRequestDto, id),HttpStatus.ACCEPTED);
	}

	
	
	
	
}
