package com.lacomer.api.incidencias.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lacomer.api.incidencias.models.entity.ArtiInven;
import com.lacomer.api.incidencias.models.services.IArtiInvenService;

@RestController
@RequestMapping("/api")
public class ArtiInvenRestController {

    @Autowired
    private IArtiInvenService artiInvenService;

    @GetMapping("/inventories")
    public List<ArtiInven> getAllInventories() {
        return artiInvenService.findAll();
    }

    @GetMapping("/inventories/sucursal/{sucursalId}")
    public List<ArtiInven> getInventoriesBySucursal(@PathVariable Long sucursalId) {
        return artiInvenService.findBySucursalId(sucursalId);
    }

    @GetMapping("/inventories/articulo/{articuloId}")
    public List<ArtiInven> getInventoriesByArticulo(@PathVariable Long articuloId) {
        return artiInvenService.findByArticuloId(articuloId);
    }
    
    @GetMapping("/inventories/page/{page}")
	public Page<ArtiInven> index(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 100);
		return artiInvenService.findAll(pageable);
	}
}
