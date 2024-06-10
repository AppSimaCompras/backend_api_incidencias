package com.lacomer.api.incidencias.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lacomer.api.incidencias.models.entity.Pedido;



public interface IPedidoService {

	public List<Pedido> findAll();
	
	public Page<Pedido> findAll(Pageable pageable);
	
	public Pedido findById(Long id);
	
    Optional<Pedido> findByPediIdWithClienteAndDetalles(Long pediId);
   
//Nuevo
   
   
}
