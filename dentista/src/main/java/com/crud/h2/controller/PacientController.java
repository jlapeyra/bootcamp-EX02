package com.crud.h2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.h2.dao.*;
import com.crud.h2.dto.*;

@RestController
@RequestMapping("/pacient")
public class PacientController {
	
	@Autowired
	IPacientDAO pacientDAO;
	@Autowired
	ICitaDAO citaDAO;

	/*
	 * Llança una excepció si el pacient no existeix
	 * Això és una versió simplificada però en un projecte acabat hauria de comprobar que 
	 * l'usuari en qüestió s'ha autenticat correctament.
	 */
	void auth(Long id) throws AuthException {
		if (!pacientDAO.existsById(id)) {
			throw new AuthException("El pacient amb id "+id+" no existeix");
		}
	}

	/*
	 * Es crea un usuari pacient
	 */
	@PostMapping("")
	public Pacient nouUsuari(@RequestBody Pacient usuari) {
		return pacientDAO.save(usuari);
	}

	/*
	 * El pacient consulta el seu usuari
	 */
	@GetMapping("/{id}")
	public Pacient veureUsuari(@PathVariable(name="id") Long id) throws AuthException {
		auth(id);
		return pacientDAO.findById(id).get();
	}

	/*
	 * El pacient edita el seu usuari
	 */
	@PutMapping("/{id}")
	public Pacient editaUsuari(@PathVariable(name="id") Long id, @RequestBody Pacient usuari) throws AuthException {
		auth(id);
		usuari.setId(id);
		usuari.setCites(pacientDAO.findById(id).get().getCites());
		return pacientDAO.save(usuari);
	}

	/*
	 * El pacient crea una cita seva
	 */
	@PostMapping("/{id}/cita")
	public Cita creaCita(@PathVariable(name="id") Long id, @RequestBody Cita cita) throws AuthException  {
		auth(id);
		cita.setId(null);
		cita.setPacient(new Pacient(id));
		return citaDAO.save(cita);
	}

	/*
	 * El pacient actualitza una cita seva
	 */
	@PutMapping("/{id}/cita")
	public Cita editaCita(@PathVariable(name="id") Long id, @RequestBody Cita cita) throws AuthException  {
		auth(id);
		if (citaDAO.findById(cita.getId()).get().getPacient().getId() != id) {
			throw new AuthException("El pacient "+id+" no pot editar la cita "+ cita.getId() +" perquè pertany a un altre pacient.");
		}
		cita.setPacient(new Pacient(id));
		return citaDAO.save(cita);
	}

	/*
	 * El pacient elimina una cita seva
	 */
	@DeleteMapping("/{id}/cita")
	public void eliminaCita(@PathVariable(name="id") long id, @RequestParam long idCita) throws AuthException  {
		auth(id);
		if (citaDAO.findById(idCita).get().getPacient().getId() != id) {
			throw new AuthException("El pacient "+id+" no pot editar la cita "+ idCita +" perquè pertany a un altre pacient.");
		}
		citaDAO.deleteById(idCita);
	}

	/*
	 * El pacient consulta les seves cites
	 */
	@GetMapping("/{id}/cites")
	public List<Cita> cites(@PathVariable(name="id") Long id) throws AuthException  {
		auth(id);
		return pacientDAO.findById(id).get().getCites();
	}
	
	
	
}
