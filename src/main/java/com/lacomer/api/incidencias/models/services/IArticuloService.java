package com.lacomer.api.incidencias.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lacomer.api.incidencias.models.entity.Articulo;


public interface IArticuloService {

	public List<Articulo> findAll();
	
	public Page<Articulo> findAll(Pageable pageable);
	
	public Articulo findById(Long id);
}
