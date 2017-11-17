package com.project.Auth.models;

import java.util.Date;
import java.util.List;


import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;
import com.project.Auth.models.User;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@ManyToMany(mappedBy = "roles")
	private List<User> users;

	public Role() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
