package com.lacomer.api.incidencias.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RestController;

import com.lacomer.api.incidencias.models.entity.Articulo;
import com.lacomer.api.incidencias.models.services.IArticuloService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ArticuloRestController {
	
	@Autowired
	private IArticuloService articuloService;

	@GetMapping("/articles")
	public List<Articulo> index() {
		return articuloService.findAll();
	}
	
	@GetMapping("/articles/page/{page}")
    public Page<Articulo> index(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 100);
        return articuloService.findAll(pageable);
    }
	
	@GetMapping("/articles/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Articulo articulo = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			articulo = articuloService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(articulo == null) {
			response.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Articulo>(articulo, HttpStatus.OK);
	}
}
