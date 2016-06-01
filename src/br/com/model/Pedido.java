package br.com.model;

import java.util.Collection;
import java.util.Date;

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
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="pedido_itemCardapio", joinColumns=@JoinColumn(name="pedido_id"),
	inverseJoinColumns=@JoinColumn(name="itemCardapio_id"))
	private Collection<ItemPedido> itens;
	

	public Pedido(Long id) {
		this.id = id;
		
	}
	
	public Pedido(){
		
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

	public Collection<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Collection<ItemPedido> itens) {
		this.itens = itens;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s", getId());
	}
	public boolean hasValidId(){
		return getId() != null && getId() != 0;
	}
	
}
