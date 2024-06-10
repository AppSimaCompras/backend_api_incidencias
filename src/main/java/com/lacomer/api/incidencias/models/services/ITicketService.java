package com.lacomer.api.incidencias.models.services;

import java.util.List;


import java.util.Set;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lacomer.api.incidencias.models.entity.Ticket;

public interface ITicketService {

	 Set<Ticket> findAll();
	 
	 public Page<Ticket> findAll(Pageable pageable);
		
	 //public Ticket findById(String id);


	//List<Ticket> findByGroupedId(String id);
	
	Set<Ticket> findByGroupedId(String id);

}
