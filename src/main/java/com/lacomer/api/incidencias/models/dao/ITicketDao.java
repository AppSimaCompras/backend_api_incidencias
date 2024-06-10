package com.lacomer.api.incidencias.models.dao;


import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lacomer.api.incidencias.models.entity.Ticket;

import org.springframework.data.domain.Pageable;




public interface ITicketDao extends JpaRepository<Ticket, String> {

	@Query("SELECT t FROM Ticket t WHERE t.pedi_ticket = :id")
    Set<Ticket> findByGroupedId(@Param("id") String id);
	

	@Query("SELECT DISTINCT t FROM Ticket t")
    List<Ticket> findAllDistinct();
	
}

