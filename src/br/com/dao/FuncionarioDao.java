package br.com.dao;

import org.springframework.stereotype.Repository;

import br.com.model.Funcionario;


@Repository
public class FuncionarioDao extends AbstractDao<Funcionario> {

	@Override
	public Class<Funcionario> getTypeClass() {
		// TODO Auto-generated method stub
		return Funcionario.class;
	}
	
}
