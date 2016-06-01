package br.com.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="delivery")
@PrimaryKeyJoinColumn(name="pedido_id")
public class Delivery extends Pedido {
	
	
	private Double trocoPara;
	
	@ManyToOne
	@JoinColumn(name="fk_cliente")
	private Cliente cliente;
		
	public Delivery(Usuario cliente) {
		this.cliente = (Cliente) cliente;
	}
	
	public Delivery() {}

	public Double getTrocoPara() {
		return trocoPara;
	}

	public void setTrocoPara(Double trocoPara) {
		this.trocoPara = trocoPara;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Cliente: %s\n Id - Pedido: %s\n Troco para: %s", getCliente(), getId(), getTrocoPara());
	}
}
