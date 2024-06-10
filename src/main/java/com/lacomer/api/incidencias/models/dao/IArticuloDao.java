package com.lacomer.api.incidencias.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lacomer.api.incidencias.models.entity.Articulo;

public interface IArticuloDao extends JpaRepository<Articulo, Long>{

}
