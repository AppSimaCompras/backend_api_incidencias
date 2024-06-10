package com.lacomer.api.incidencias.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lacomer.api.incidencias.models.dao.IArticuloDao;
import com.lacomer.api.incidencias.models.entity.Articulo;


@Service
public class ArticuloServiceImpl implements IArticuloService{
	
	
	@Autowired
	private IArticuloDao articuloDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Articulo> findAll() {
		return (List<Articulo>) articuloDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Articulo> findAll(Pageable pageable) {
		return articuloDao.findAll(pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Articulo findById(Long id) {
		return articuloDao.findById(id).orElse(null);
	}


}
