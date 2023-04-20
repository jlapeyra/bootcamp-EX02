package com.crud.h2.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Dentista  {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
	private Long id;
	private String nom_cognoms;
	private String dni;
	private String num_colegiat;

	@OneToMany
	@JsonIgnore
	@JoinColumn(name="dentista")
	public List<Cita> cites;

	@JsonIgnore
	public List<Cita> getCites() {
		return cites;
	}
	public Long getId() {
		return id;
	}
	public String getNom_cognoms() {
		return nom_cognoms;
	}
	public String getDni() {
		return dni;
	}
	public String getNum_colegiat() {
		return num_colegiat;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public void setCites(List<Cita> cites) {
		this.cites = cites;
	}


}
