package com.crud.h2.dto;


import java.sql.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Pacient  {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
	private Long id;
	private String nom_cognoms;
	private String dni;
	private Date naixament;

	@OneToMany
	@JsonIgnore
	@JoinColumn(name="pacient")
	private List<Cita> cites;
	
	public Pacient() {}
	public Pacient(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public List<Cita> getCites() {
		return cites;
	}
	public String getDni() {
		return dni;
	}
	public Long getId() {
		return id;
	}
	public Date getNaixament() {
		return naixament;
	}
	public String getNom_cognoms() {
		return nom_cognoms;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public void setCites(List<Cita> cites) {
		this.cites = cites;
	}

}
