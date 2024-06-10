package com.lacomer.api.incidencias.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lacomer.api.incidencias.models.entity.Cliente;
import com.lacomer.api.incidencias.models.entity.Ticket;
import com.lacomer.api.incidencias.models.services.ITicketService;

import org.springframework.data.domain.Sort;

//@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class TicketRestController {

	
	@Autowired
	private ITicketService ticketService;

	@GetMapping("/tickets")
	public Set<Ticket> index() {
		return ticketService.findAll();
	}
	
	
	@GetMapping("/tickets/page/{page}")
	public Page<Ticket> index(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 100);
		return ticketService.findAll(pageable);
	}

	
	
	@GetMapping("/tickets/{id}")
    public ResponseEntity<?> show(@PathVariable String id) {
        
        Set<Ticket> tickets = new HashSet<>();
        Map<String, Object> response = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            tickets = ticketService.findByGroupedId(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if (tickets.isEmpty()) {
            response.put("mensaje", "El ticket ID: ".concat(id).concat(" no existe en la base de datos!"));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        
        String ticketsJson = "";
        try {
            ticketsJson = mapper.writeValueAsString(tickets);
        } catch (Exception e) {
            response.put("mensaje", "Error al convertir el ticket a JSON");
            response.put("error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return new ResponseEntity<String>(ticketsJson, HttpStatus.OK);
    }

 
	
	}
	



	
