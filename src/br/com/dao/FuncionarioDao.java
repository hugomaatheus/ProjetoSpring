package br.com.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.model.Funcionario;


@Repository
public class FuncionarioDao extends AbstractDao<Funcionario> {

	@Override
	public Class<Funcionario> getTypeClass() {
		// TODO Auto-generated method stub
		return Funcionario.class;
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> filtrar(Funcionario filtro){
		String str = "select f from Funcionario f where upper(nome) like upper(:nome)";
		if(filtro.getNome() == null){
			filtro.setNome("");
		}
	
		Query query = eM.createQuery(str);   
		
		query.setParameter("nome", "%"+filtro.getNome()+"%");
		
		return query.getResultList();
	}
	
}
