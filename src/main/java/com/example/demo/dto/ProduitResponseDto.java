
package com.example.demo.dto;

import java.math.BigDecimal;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitResponseDto {
	
	private Integer id;
	private String libelle;
	
	private String ref;
	
	private BigDecimal prix;
	
	private double quantite_stock;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public double getQuantite_stock() {
		return quantite_stock;
	}

	public void setQuantite_stock(double quantite_stock) {
		this.quantite_stock = quantite_stock;
	}


	
	
	
	

}
