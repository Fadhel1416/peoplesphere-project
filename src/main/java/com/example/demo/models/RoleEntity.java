package com.example.demo.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity implements Serializable{
	
	@Id
	private Integer roleId;
	@Column(nullable=false)
	private String name;

	@ManyToMany
	@JoinTable(name="user_roles",joinColumns = @JoinColumn(name="roleId"),inverseJoinColumns = @JoinColumn(name="userId"))
	private List<UserEntity> users;
}
