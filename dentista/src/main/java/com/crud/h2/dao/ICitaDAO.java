package com.crud.h2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.h2.dto.Cita;


public interface ICitaDAO extends JpaRepository<Cita, Long>{

}
