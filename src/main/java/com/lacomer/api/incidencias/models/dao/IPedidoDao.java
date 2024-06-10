package com.lacomer.api.incidencias.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lacomer.api.incidencias.models.entity.Pedido;

import java.util.Optional;

public interface IPedidoDao extends JpaRepository<Pedido, Long> {

	/*
    @Query("SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = :id")
    Optional<Pedido> findByIdWithCliente(@Param("id") Long id);
    */


	@Query("SELECT p FROM Pedido p JOIN FETCH p.cliente JOIN FETCH p.detalles WHERE p.pedi_id = :pediId")
    Optional<Pedido> findByPediIdWithClienteAndDetalles(@Param("pediId") Long pediId);
	
	
//Nuevo

}
    
