package br.com.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import br.com.util.Status;



@Entity
@SequenceGenerator(name="mesa_id", sequenceName="mesa_seq", allocationSize=1)
public class Mesa implements AbstractEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="mesa_id")
	private Long id;
	
	private Integer numero;
	
	private int capacidade;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@OneToMany
	@JoinTable(name="mesa_PedTradicional", joinColumns=@JoinColumn(name="mesa_id"),
	inverseJoinColumns=@JoinColumn(name="pedido_id", referencedColumnName="pedido_id"))
	private List<Tradicional> tradicionais;
	
	@OneToMany
	@JoinTable(name="mesa_Reserva",joinColumns=@JoinColumn(name="mesa_id"),
	inverseJoinColumns=@JoinColumn(name="reserva_id"))
	private List<Reserva> reservas;
	
	public Mesa(Long id) {
		this.id = id;
	}
	
	public Mesa() {}

	public Mesa(int numero) {
		this.numero = numero;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public List<Tradicional> getTradicionais() {
		return tradicionais;
	}

	public void setTradicionais(List<Tradicional> tradicionais) {
		this.tradicionais = tradicionais;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	@Override
	public String toString() {
		return String.format("%d", getId());
	}
	
	public boolean hasValidId(){
		return getId() != null && getId() != 0;
	}
	
}
