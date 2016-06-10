package br.com.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.util.Status;
import br.com.util.TipoPedido;



@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Pedido implements AbstractEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private Double total;
	
	@OneToMany(mappedBy="pedido", fetch=FetchType.EAGER) 
	private List<ItemPedido> itens = new ArrayList<ItemPedido>();
	
	@Enumerated(EnumType.STRING)
	private TipoPedido tipo;

	public Pedido(Long id) {
		this.id = id;
	}
	
	public Pedido(){
		
	}
	
	public TipoPedido getTipo() {
		return tipo;
	}

	public void setTipo(TipoPedido tipo) {
		this.tipo = tipo;
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
	
	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
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
