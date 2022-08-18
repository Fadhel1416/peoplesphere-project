package com.example.demo.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable{
	
	@Id
	private Integer userId;
	@Column(nullable=false)
	private String username;
	@Column(nullable=false)
	private String password;
	
	@ManyToMany
	@JoinTable(name="user_roles",joinColumns = @JoinColumn(name="userId"),inverseJoinColumns = @JoinColumn(name="roleId"))
	private List<RoleEntity> roles;
	
	@OneToOne(mappedBy = "user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private UserProfil profile;

	
	
}
