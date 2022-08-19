package com.example.demo.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="produits")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitEntity implements Serializable{
	
	
	
	private static final long serialVersionUID=-725040896547L;
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false)
	private String libelle;
	
	@Column(nullable=false)
	private String ref;
	
	@Column(nullable=false)
    private float prix;
	
	@Column(nullable=false)
     private float quantite_stock;
	
	
	@OneToMany(mappedBy = "produit",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<LigneFactureEntity> ligneFactures;


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


	public List<LigneFactureEntity> getLigneFactures() {
		return ligneFactures;
	}


	public void setLigneFactures(List<LigneFactureEntity> ligneFactures) {
		this.ligneFactures = ligneFactures;
	}
	
	
	
	

}
