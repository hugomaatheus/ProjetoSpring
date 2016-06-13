package br.com.model;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;



@Entity
@PrimaryKeyJoinColumn(name="pedido_id")
public class Tradicional extends Pedido {
	
	@ManyToOne
	private Usuario vendedor;
	
	@ManyToOne
	private Mesa mesa;
	
	public Tradicional(Mesa mesa, Funcionario vendedor) {
		this.mesa = mesa;
		this.vendedor = vendedor;
	}
	
	public Tradicional() {}
	
	public Tradicional(Usuario usuario) {
		this.vendedor = usuario;
	}

	public Usuario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Mesa: %d %d %d", getMesa().getNumero(), getMesa().getId(), getId());
	}

}
