package com.crud.h2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.h2.dto.Dentista;


public interface IDentistaDAO extends JpaRepository<Dentista, Long>{

}
