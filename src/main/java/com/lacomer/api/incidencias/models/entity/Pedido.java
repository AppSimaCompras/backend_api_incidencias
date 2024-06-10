package com.lacomer.api.incidencias.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="pedido")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="PEDI_ID")
    private Long pedi_id;

    @Column(name="SUCC_ID")
    private String sucursal;

    @Column(name="PEDI_STAT")
    private String status;

    @JsonIgnoreProperties(value={"pedido", "hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIE_ID")
    private Cliente cliente;

    @JsonIgnoreProperties({"pedido"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PedidoDeta> detalles;



	public Long getPedi_id() {
		return pedi_id;
	}



	public void setPedi_id(Long pedi_id) {
		this.pedi_id = pedi_id;
	}



	public String getSucursal() {
		return sucursal;
	}



	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}

	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	

	public List<PedidoDeta> getDetalles() {
		return detalles;
	}



	public void setDetalles(List<PedidoDeta> detalles) {
		this.detalles = detalles;
	}




	private static final long serialVersionUID = 1L;
}
