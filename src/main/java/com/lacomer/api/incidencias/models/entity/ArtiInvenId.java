package com.lacomer.api.incidencias.models.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ArtiInvenId implements Serializable {

    @Column(name = "SUCC_ID")
    private Long sucursalId;

    @Column(name = "ART_EAN")
    private Long articuloId;

	public Long getSucursalId() {
		return sucursalId;
	}

	public void setSucursalId(Long sucursalId) {
		this.sucursalId = sucursalId;
	}

	public Long getArticuloId() {
		return articuloId;
	}

	public void setArticuloId(Long articuloId) {
		this.articuloId = articuloId;
	}

    
}

