package br.com.dao;


import org.springframework.stereotype.Repository;

import br.com.model.Cliente;



@Repository
public class ClienteDao extends AbstractDao<Cliente> {

	@Override
	public Class<Cliente> getTypeClass() {
		return Cliente.class;
	}
	
	

}
