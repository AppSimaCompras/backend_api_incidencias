package com.lacomer.api.incidencias.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lacomer.api.incidencias.models.entity.Pedido;
import com.lacomer.api.incidencias.models.services.IPedidoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class PedidoRestController {

    @Autowired
    private IPedidoService pedidoService;

    @GetMapping("/orders")
    public List<Pedido> index() {
        return pedidoService.findAll();
    }

    
    @GetMapping("/orders/page/{page}")
    public Page<Pedido> index(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 100);
        return pedidoService.findAll(pageable);
    }
    
    
    
    @GetMapping("/orders/{pediId}")
    public ResponseEntity<?> showByPediId(@PathVariable Long pediId) {
        Map<String, Object> response = new HashMap<>();
        Optional<Pedido> pedidoOptional;

        try {
            pedidoOptional = pedidoService.findByPediIdWithClienteAndDetalles(pediId);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (!pedidoOptional.isPresent()) {
            response.put("mensaje", "El pedido ID: ".concat(pediId.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        Pedido pedido = pedidoOptional.get();


        return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
    }

    
}
