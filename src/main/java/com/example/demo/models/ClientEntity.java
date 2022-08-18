package com.example.demo.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Class representing a client.")
public class ClientEntity implements Serializable {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable=false)
	private String nom;
	@Column(nullable=false)
	private String prenom;
	@Column(name="client_tel")
	private String tel;
	
	@OneToMany(mappedBy = "client",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<FactureEntity> factures;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<FactureEntity> getFactures() {
		return factures;
	}

	public void setFactures(List<FactureEntity> factures) {
		this.factures = factures;
	}
	
	
	

	
	
}
