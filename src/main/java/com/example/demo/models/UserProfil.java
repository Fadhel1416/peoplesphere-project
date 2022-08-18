package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="profiles")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProfil implements Serializable{
	
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String avatar;
	
	private String tel;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private UserEntity user;

}
