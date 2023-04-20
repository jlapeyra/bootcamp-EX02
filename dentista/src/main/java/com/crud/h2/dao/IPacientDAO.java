package com.crud.h2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.h2.dto.Pacient;


public interface IPacientDAO extends JpaRepository<Pacient, Long>{

}
