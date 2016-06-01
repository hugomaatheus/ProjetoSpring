package br.com.model;



import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="usuario_id")
public class Cliente extends Usuario {
	
	
	public Cliente(Long id) {
		super(id);
	}
	
	public Cliente() {
		
	}

	@Override
	public String toString() {
		return "getId()=" + getId() + ", getLogin()=" + getLogin() + ", getSenha()="
				+ getSenha() + ", getEmail()=" + getEmail() + ", getNome()=" + getNome() + ", getStatus()="
				+ getStatus() + ", getTipo()=" + getTipo() + ", getEndereco()=" + getEndereco() + "]";
	}
	
}
