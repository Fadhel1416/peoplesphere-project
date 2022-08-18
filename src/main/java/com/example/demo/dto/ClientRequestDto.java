package com.example.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDto {
	
	//@NotNull(message="le nom est obligatoire !!")
	@NotBlank
	@Size(min=5,message="ce champ doit avoir ou moins 5 caractere !!")
	@Size(max=20,message="ce champ doit avoir ou plus 20 caractere !!")
	private String nom;
	
	//@NotNull(message="le prenom est obligatoire !!")
	@NotBlank
	@Size(min=5,max=20,message="la nombre de caractere doit etre compris entre 5 et 20 !!")
	private String prenom;
	
	@NotNull
	@Pattern(regexp="^(\\+216|33)([ \\-_/]*)(\\d[ \\-_/]*){8}$",message="format invalid")
	private String tel;
	
	
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
	
	

}
