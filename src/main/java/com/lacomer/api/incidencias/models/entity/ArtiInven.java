package com.lacomer.api.incidencias.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "arti_inven")
@JsonIgnoreProperties({"sucursal", "articulo"})
public class ArtiInven implements Serializable {

    @EmbeddedId
    private ArtiInvenId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("sucursalId")
    @JoinColumn(name = "SUCC_ID", insertable = false, updatable = false)
    private Sucursal sucursal;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("articuloId")
    @JoinColumn(name = "ART_EAN", insertable = false, updatable = false)
    private Articulo articulo;

    @Column(name = "INVE_CANT")
    private Integer cantidad;

	public ArtiInvenId getId() {
		return id;
	}

	public void setId(ArtiInvenId id) {
		this.id = id;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
    
    
}
