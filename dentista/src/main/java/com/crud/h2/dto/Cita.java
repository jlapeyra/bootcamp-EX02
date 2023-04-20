package com.crud.h2.dto;


import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Cita  {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
	private Long id;
	private Timestamp inici;
	private Timestamp fi;
	
	@ManyToOne
	@JoinColumn(name = "pacient")
	private Pacient pacient;

	@ManyToOne
	@JoinColumn(name = "dentista")
	private Dentista dentista;
	
	public Cita() {}
	public Cita(Long id) {
		this.id = id;
	}

	public Timestamp getFi() {
		return fi;
	}
	public Long getId() {
		return id;
	}
	public Timestamp getInici() {
		return inici;
	}
	public Dentista getDentista() {
		return dentista;
	}
	public Pacient getPacient() {
		return pacient;
	}

	public void setPacient(Pacient pacient) {
		this.pacient = pacient;
	}
	public void setDentista(Dentista dentista) {
		this.dentista = dentista;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
