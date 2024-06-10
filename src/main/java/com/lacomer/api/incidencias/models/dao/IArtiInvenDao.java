package com.lacomer.api.incidencias.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lacomer.api.incidencias.models.entity.ArtiInven;
import com.lacomer.api.incidencias.models.entity.ArtiInvenId;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IArtiInvenDao extends JpaRepository<ArtiInven, ArtiInvenId> {
    List<ArtiInven> findByIdSucursalId(Long sucursalId);
    List<ArtiInven> findByIdArticuloId(Long articuloId);
}




