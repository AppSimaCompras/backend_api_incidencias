package com.lacomer.api.incidencias.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lacomer.api.incidencias.models.entity.Cliente;
import com.lacomer.api.incidencias.models.entity.Sucursal;
import com.lacomer.api.incidencias.models.services.ISucursalService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class SucursalRestController {

	
	@Autowired
	private ISucursalService sucursalService;
	
	@GetMapping("/stores")
	public List<Sucursal> index() {
		return sucursalService.findAll();
	}
	
	@GetMapping("/stores/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Sucursal sucursal = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			sucursal = sucursalService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(sucursal == null) {
			response.put("mensaje", "La tienda ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Sucursal>(sucursal, HttpStatus.OK);
	}
}
