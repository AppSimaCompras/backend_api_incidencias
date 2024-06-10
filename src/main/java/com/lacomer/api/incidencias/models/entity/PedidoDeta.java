package com.lacomer.api.incidencias.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="pedido_deta")
public class PedidoDeta implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ART_EAN")
    private Long codigoBarras;
    //@Column(name="PEDI_ID")
    //private Long detalles_id;

    //@Column(name="ART_EAN")
    //private String art_ean;

    @Column(name="PEDI_CANT")
    private Integer cantidad;

    @JsonIgnoreProperties(value={"detalles", "hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PEDI_ID", insertable = false, updatable = false)
    private Pedido pedido;

    // Getters y Setters


		public Integer getCantidad() {
			return cantidad;
		}


		public Long getCodigoBarras() {
			return codigoBarras;
		}


		public void setCodigoBarras(Long codigoBarras) {
			this.codigoBarras = codigoBarras;
		}


		public void setCantidad(Integer cantidad) {
			this.cantidad = cantidad;
		}


		public Pedido getPedido() {
			return pedido;
		}



		public void setPedido(Pedido pedido) {
			this.pedido = pedido;
		}



		private static final long serialVersionUID = 1L;
}
