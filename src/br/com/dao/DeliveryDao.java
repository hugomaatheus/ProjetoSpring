package br.com.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.model.Delivery;

@Repository
public class DeliveryDao extends AbstractDao<Delivery> {

	
	public Class<Delivery> getTypeClass() {
		return Delivery.class;
	}

	@SuppressWarnings("unchecked")
	public List<Delivery> listarTodos() {
		
		 Query query = eM.createQuery("select delivery from Delivery d join d.pedio_id p");
			  List<Delivery> results = query.getResultList();
			  System.out.println(results);
			return results;

	}

}
