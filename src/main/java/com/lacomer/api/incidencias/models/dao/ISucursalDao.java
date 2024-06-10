package com.lacomer.api.incidencias.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lacomer.api.incidencias.models.entity.Sucursal;



public interface ISucursalDao extends JpaRepository<Sucursal, Long>{

}
