package br.com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="itempedido")
@SequenceGenerator(name="itemPedido_id", sequenceName="itemPedido_seq", allocationSize=1)
public class ItemPedido implements AbstractEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	private int qtd;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_pedido")
	private Pedido pedido;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_cardapio")
	private Cardapio cardapio;
	
	public ItemPedido(Cardapio cardapio) {
		this.cardapio = cardapio;
	}
	
	public ItemPedido() {}

	public Cardapio getCardapio() {
		return cardapio;
	}

	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s\n %s\n", getId(), getCardapio());
	}
	
	public boolean hasValidId(){
		return getId() != null && getId() != 0;
	}

}
