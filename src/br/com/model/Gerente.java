package br.com.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name="usuario_id")
public class Gerente extends Usuario {

	public Gerente(Long id) {
		super(id);
	}
	
	public Gerente() {
		super();
	}

	@Override
	public String toString() {
		return "Gerente [getId()=" + getId() + ", getLogin()=" + getLogin() + ", getSenha()="
				+ getSenha() + ", getEmail()=" + getEmail() + ", getNome()=" + getNome() + ", getStatus()="
				+ getStatus() + ", getTipo()=" + getTipo() + ", getEndereco()=" + getEndereco() + "]";
	}
	
}
