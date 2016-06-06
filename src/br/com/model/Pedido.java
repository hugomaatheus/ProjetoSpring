package br.com.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.util.Status;



@Entity
@SequenceGenerator(name="pedido_id", sequenceName="pedido_seq")
@Inheritance(strategy=InheritanceType.JOINED)
public class Pedido implements AbstractEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private Double total;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="pedido_itemCardapio", joinColumns=@JoinColumn(name="pedido_id"),
	inverseJoinColumns=@JoinColumn(name="itemCardapio_id"))
	private List<ItemPedido> itens;
	

	public Pedido(Long id) {
		this.id = id;
		
	}
	
	public Pedido(){
		
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}
	
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", data=" + data + ", status=" + status + ", total=" + total + ", itens=" + itens
				+ "]";
	}

	public boolean hasValidId(){
		return getId() != null && getId() != 0;
	}

}
