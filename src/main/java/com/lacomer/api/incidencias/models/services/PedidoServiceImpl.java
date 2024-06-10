package com.lacomer.api.incidencias.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lacomer.api.incidencias.models.dao.IPedidoDao;
import com.lacomer.api.incidencias.models.entity.Pedido;


@Service
public class PedidoServiceImpl implements IPedidoService{

	

	@Autowired
    private IPedidoDao pedidoDao;

    
	@Override
	@Transactional(readOnly = true)
	public List<Pedido> findAll() {
		return (List<Pedido>)pedidoDao.findAll();
	}
	

    @Override
	@Transactional(readOnly = true)
	public Page<Pedido> findAll(Pageable pageable) {
		return pedidoDao.findAll(pageable);
	}
    
	
	@Override
	@Transactional(readOnly = true)
	public Pedido findById(Long id) {
		return pedidoDao.findById(id).orElse(null);
	}


	    @Override
	    public Optional<Pedido> findByPediIdWithClienteAndDetalles(Long pediId) {
	        return pedidoDao.findByPediIdWithClienteAndDetalles(pediId);
	    }

	  
	 //Nuevo
	 
	
    }

	
