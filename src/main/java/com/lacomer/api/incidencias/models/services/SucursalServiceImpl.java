package com.lacomer.api.incidencias.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lacomer.api.incidencias.models.dao.ISucursalDao;
import com.lacomer.api.incidencias.models.entity.Sucursal;

@Service
public class SucursalServiceImpl implements ISucursalService{

	
	@Autowired
	private ISucursalDao sucursalDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Sucursal> findAll() {
		return (List<Sucursal>) sucursalDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Sucursal findById(Long id) {
		return sucursalDao.findById(id).orElse(null);
	}
	
}
