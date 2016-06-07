package br.com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="itempedido")
@SequenceGenerator(name="itemPedido_id", sequenceName="itemPedido_seq", allocationSize=1)
public class ItemPedido implements AbstractEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	private Integer quantidade;
	
	@Transient
	private Tradicional tradicional;
	
	@ManyToOne
	@JoinColumn(name="fk_pedido")
	private Pedido pedido;
	
	@ManyToOne
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

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public Tradicional getTradicional() {
		return tradicional;
	}

	public void setTradicional(Tradicional tradicional) {
		this.tradicional = tradicional;
	}

	@Override
	public String toString() {
		return "ItemPedido [id=" + id + ", quantidade=" + quantidade + ", pedido=" + pedido + ", cardapio=" + cardapio + "]";
	}

	public boolean hasValidId(){
		return getId() != null && getId() != 0;
	}

}
