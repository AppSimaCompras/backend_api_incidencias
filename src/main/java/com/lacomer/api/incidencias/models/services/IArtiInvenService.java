package com.lacomer.api.incidencias.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lacomer.api.incidencias.models.entity.ArtiInven;


public interface IArtiInvenService {

	public List<ArtiInven> findAll();

	List<ArtiInven> findByArticuloId(Long articuloId);

	List<ArtiInven> findBySucursalId(Long sucursalId);
	
	public Page<ArtiInven> findAll(Pageable pageable);
}
