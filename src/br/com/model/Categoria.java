package br.com.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.com.util.Status;



@Entity 
@SequenceGenerator(name="categoria_id", sequenceName="categoria_seq", allocationSize=1)
public class Categoria implements AbstractEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="categoria_id")
	private Long id;
	
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public Categoria(Long id) {
		this.id = id;
	}
	
	public Categoria() {}

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
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return String.format("Nome: %s\n", getNome());
	}
	
	public boolean hasValidId(){
		return getId() != null && getId() != 0;
	}

}
