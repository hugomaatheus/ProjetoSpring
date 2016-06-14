package br.com.dao;



import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.model.Cliente;



@Repository
public class ClienteDao extends AbstractDao<Cliente> {

	@Override
	public Class<Cliente> getTypeClass() {
		return Cliente.class;
	}
	
	
	public Cliente buscarPorEmail(String email) {
		
		String str = "";
		
		if(email != null){
		 str = "select u from Usuario u where email = :email";
		}
			
		Query query = eM.createQuery(str);
		query.setParameter("email", email);
		
		return (Cliente) query.getSingleResult();
	}


}
