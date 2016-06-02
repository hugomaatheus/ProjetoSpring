package br.com.model;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import br.com.util.Status;

@Entity
@SequenceGenerator(name="cardapio_id", sequenceName="cardapio_seq", allocationSize=1 )
public class Cardapio implements AbstractEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cardapio_id")
	private Long id;
	
	private String nome;

	private Double preco;
	
	@ManyToOne
	private Categoria categoria;

	@Enumerated(EnumType.STRING)
	private Status status;
	
	public Cardapio(Long id) {
		this.id = id;
	}
	
	public Cardapio() {
		
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return String.format("Nome: %s\n"
				+ "Pre�o: R$%f\n"
				+ "Categoria: %s\n", getNome(), getPreco(), getCategoria());
	}

	public boolean hasValidId(){
		return getId() != null && getId() != 0;
	}
}