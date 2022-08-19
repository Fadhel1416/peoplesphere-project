package com.example.demo.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitRequestDto {
	
	private String libelle;
	
	
	private String ref;
	
	private float prix;
	
	private float quantite_stock;
	


	public ProduitRequestDto(String libelle, String ref, float prix, float quantite_stock) {
		super();
		this.libelle = libelle;
		this.ref = ref;
		this.prix = prix;
		this.quantite_stock = quantite_stock;
	}



	public float getPrix() {
		return prix;
	}



	public void setPrix(float prix) {
		this.prix = prix;
	}



	public float getQuantite_stock() {
		return quantite_stock;
	}



	public void setQuantite_stock(float quantite_stock) {
		this.quantite_stock = quantite_stock;
	}



	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}
	
	
	
	

}
