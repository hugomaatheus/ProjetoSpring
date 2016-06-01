package br.com.dao;


import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.model.Gerente;

@Repository
public class GerenteDao extends AbstractDao<Gerente> {
	
	@Override
	public Class<Gerente> getTypeClass() {
		// TODO Auto-generated method stub
		return Gerente.class;
	}
	

}
