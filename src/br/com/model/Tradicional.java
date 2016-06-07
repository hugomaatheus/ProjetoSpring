package br.com.model;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;



@Entity
@PrimaryKeyJoinColumn(name="pedido_id")
public class Tradicional extends Pedido {
	
	@ManyToOne
	private Funcionario vendedor;
	
	@ManyToOne
	private Mesa mesa;
	
	public Tradicional(Mesa mesa, Funcionario vendedor) {
		this.mesa = mesa;
		this.vendedor = vendedor;
	}
	
	public Tradicional() {}
	
	public Tradicional(Funcionario funcionario) {
		this.vendedor = funcionario;
	}

	public Funcionario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Funcionario vendedor) {
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
