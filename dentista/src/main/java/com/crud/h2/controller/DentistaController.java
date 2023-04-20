package com.crud.h2.controller;

import java.util.List;

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
@RequestMapping("/dentista")
public class DentistaController {
	
	@Autowired
	IDentistaDAO dentistaDAO;
	@Autowired
	ICitaDAO citaDAO;

	/*
	 * Llança una excepció si el dentista no existeix
	 * Això és una versió simplificada però en un projecte acabat hauria de comprobar que 
	 * l'usuari en qüestió s'ha autenticat correctament.
	 */
	void auth(Long id) throws AuthException {
		if (!dentistaDAO.existsById(id)) {
			throw new AuthException("El dentista amb id "+id+" no existeix");
		}
	}

	/*
	 * Es crea un usuari dentista
	 */
	@PostMapping("")
	public Dentista nouUsuari(@RequestBody Dentista usuari) {
		return dentistaDAO.save(usuari);
	}

	/*
	 * El dentista consulta el seu usuari
	 */
	@GetMapping("/{id}")
	public Dentista veureUsuari(@PathVariable(name="id") Long id) throws AuthException {
		auth(id);
		return dentistaDAO.findById(id).get();
	}

	/*
	 * El dentista edita el seu usuari
	 */
	@PutMapping("/{id}")
	public Dentista editaUsuari(@PathVariable(name="id") Long id, @RequestBody Dentista usuari) throws AuthException {
		auth(id);
		usuari.setId(id);
		usuari.setCites(dentistaDAO.findById(id).get().getCites());
		return dentistaDAO.save(usuari);
	}

	/*
	 * El dentista crea una cita 
	 */
	@PostMapping("/{id}/cita")
	public Cita creaCita(@PathVariable(name="id") Long id, @RequestBody Cita cita) throws AuthException  {
		auth(id);
		cita.setId(null);
		return citaDAO.save(cita);
	}

	/*
	 * El dentista crea una cita 
	 */
	@PutMapping("/{id}/cita")
	public Cita editaCita(@PathVariable(name="id") Long id, @RequestBody Cita cita) throws AuthException  {
		auth(id);
		return citaDAO.save(cita);
	}

	/*
	 * El dentista elimina una cita 
	 * (si cita.id existeix a la BD s'actualitza, si no es crea)
	 */
	@DeleteMapping("/{id}/cita")
	public void eliminaCita(@PathVariable(name="id") Long id, @RequestParam Long idCita) throws AuthException  {
		auth(id);
		citaDAO.deleteById(idCita);
	}

	/*
	 * El dentista consulta les seves cites
	 */
	@GetMapping("/{id}/cites")
	public List<Cita> cites(@PathVariable(name="id") Long id) throws AuthException  {
		auth(id);
		return dentistaDAO.findById(id).get().getCites();
	}

	/*
	 * El dentista consulta totes les cites
	 */
	@GetMapping("/{id}/citesTotes")
	public List<Cita> citesTotes(@PathVariable(name="id") Long id) throws AuthException  {
		auth(id);
		return citaDAO.findAll();
	}


	
	
}
