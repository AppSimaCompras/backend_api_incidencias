package com.lacomer.api.incidencias.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sucursal")
public class Sucursal {

	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUCC_ID")
    private Long sucursal_id;

    @Column(name = "SUCC_DES")
    private String nombre;
    
    
    public Long getSucursal_id() {
		return sucursal_id;
	}


	public void setSucursal_id(Long sucursal_id) {
		this.sucursal_id = sucursal_id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	private static final long serialVersionUID = 1L;
}
