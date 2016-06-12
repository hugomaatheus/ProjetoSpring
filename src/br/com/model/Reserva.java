package br.com.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.util.Status;



@Entity
@SequenceGenerator(name="reserva_id", sequenceName="reserva_seq")
@Table(name="reserva")
public class Reserva implements AbstractEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
//	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private String dataInicial;

	//	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="dd/MM/yyyy hh:mm")
	private String dataFinal;

	private int num_pessoa;
	
	private String nome_Responsavel;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne
	@JoinColumn(name="fk_funcionario")
	private Funcionario funcionario;
	
	@ManyToOne
	private Mesa mesa;

	public Reserva(Long id) {
		this.id = id;
	}
	
	public Reserva() {}
	
	public String getDataInicial() {
		return dataInicial;
	}
	public String getDataFinal() {
		return dataFinal;
	}
	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}
	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNum_pessoa() {
		return num_pessoa;
	}
	public void setNum_pessoa(int num_pessoa) {
		this.num_pessoa = num_pessoa;
	}
	public String getNome_Responsavel() {
		return nome_Responsavel;
	}
	public void setNome_Responsavel(String nome_Responsavel) {
		this.nome_Responsavel = nome_Responsavel;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	
	@Override
	public String toString() {
		return "Reserva [id=" + id + ", dataInicial=" + dataInicial + ", dataFinal=" + dataFinal + ", num_pessoa="
				+ num_pessoa + ", nome_Responsavel=" + nome_Responsavel + ", status=" + status + ", mesa=" + mesa + "]";
	}

	public boolean hasValidId(){
		return getId() != null && getId() != 0;
	}

}
