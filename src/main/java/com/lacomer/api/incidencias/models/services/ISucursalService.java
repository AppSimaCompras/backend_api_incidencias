package com.lacomer.api.incidencias.models.services;

import java.util.List;

import com.lacomer.api.incidencias.models.entity.Cliente;
import com.lacomer.api.incidencias.models.entity.Sucursal;



public interface ISucursalService {

	public List<Sucursal> findAll();
	
	public Sucursal findById(Long id);
}
