package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LigneFactureKey implements Serializable{
	
	private static final long serialVersionUID=20201458795545L;
	
	
	@Column(name="facture_id")
	private Integer factureId;
	
	@Column(name="produit_id")
	private Integer produitId;

}
