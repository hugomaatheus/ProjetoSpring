package br.com.model;

import javax.persistence.Embeddable;

import org.hibernate.validator.constraints.NotEmpty;

@Embeddable
public class Endereco {
	
	@NotEmpty(message="O campo deve ser preenchido")
	private String rua;
	
	@NotEmpty(message="O campo deve ser preenchido")
	private String bairro;
	
	@NotEmpty(message="O campo deve ser preenchido")
	private String numero;
	
	@NotEmpty(message="O campo deve ser preenchido")
	private String complemento;
	
	@NotEmpty(message="O campo deve ser preenchido")
	private String telefone;
	
	@NotEmpty(message="O campo deve ser preenchido")
	private String cep;
	
	public Endereco(String rua, String bairro, String numero, String complemento, String telefone, String cep) {
		super();
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.complemento = complemento;
		this.telefone = telefone;
		this.cep = cep;
	}
	
	public Endereco() {}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Rua: %s\n"
				+ "Número: %s\n"
				+ "Bairro: %s\n", getRua(), getNumero(), getBairro());
	}
	
}
