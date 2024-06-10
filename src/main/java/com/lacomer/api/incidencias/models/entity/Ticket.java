package com.lacomer.api.incidencias.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ticket_temp")
public class Ticket {

	
	 @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private String pedi_ticket;
	

	    @Column(name="SUCC_ID")
	    private String sucursal;
	    
	    @Column(name="ART_EAN")
	    private String codigo_barras;

	    @Column(name="CANTIDAD")
	    private String cantidad;
	    
	    @Column(name="P_UNITARIO")
	    private String pago_unitario;
	    
	    @Column(name="TOTAL")
	    private String total;
	    
	    
	    


		public String getPedi_ticket() {
			return pedi_ticket;
		}




		public void setPedi_ticket(String pedi_ticket) {
			this.pedi_ticket = pedi_ticket;
		}




		public String getSucursal() {
			return sucursal;
		}




		public void setSucursal(String sucursal) {
			this.sucursal = sucursal;
		}




		public String getCodigo_barras() {
			return codigo_barras;
		}




		public void setCodigo_barras(String codigo_barras) {
			this.codigo_barras = codigo_barras;
		}




		public String getCantidad() {
			return cantidad;
		}




		public void setCantidad(String cantidad) {
			this.cantidad = cantidad;
		}




		public String getPago_unitario() {
			return pago_unitario;
		}




		public void setPago_unitario(String pago_unitario) {
			this.pago_unitario = pago_unitario;
		}




		public String getTotal() {
			return total;
		}




		public void setTotal(String total) {
			this.total = total;
		}




		private static final long serialVersionUID = 1L;
}
