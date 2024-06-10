package com.lacomer.api.incidencias.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="articulo")
public class Articulo implements Serializable{

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ART_EAN")
    private Long codigoBarras;

    @Column(name="ART_COD")
    private Integer codigo;

    @Column(name="ART_DES")
    private String descripcion;
	
    

	public Long getCodigoBarras() {
		return codigoBarras;
	}



	public void setCodigoBarras(Long codigoBarras) {
		this.codigoBarras = codigoBarras;
	}



	public Integer getCodigo() {
		return codigo;
	}



	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	private static final long serialVersionUID = 1L;
}
