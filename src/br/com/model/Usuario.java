package br.com.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.util.Status;
import br.com.util.Tipo;

@Entity
@SequenceGenerator(name="usuario_id", sequenceName="usuario_seq")
@Inheritance(strategy=InheritanceType.JOINED)
public class Usuario implements AbstractEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id; 
	
	@NotEmpty(message="O campo deve ser preenchido")
	private String login;
	@NotEmpty(message="O campo deve ser preenchido")
	private String senha;
	private String email;
	private String nome;

	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	@Embedded
	private Endereco endereco;

	public Usuario(Long id) {
		this.id = id;
	}
	
	public Usuario() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public boolean hasValidId(){
		return getId() != null && getId() != 0;
	}

	@Override
	public String toString() {
		return nome;
	}
	

}
