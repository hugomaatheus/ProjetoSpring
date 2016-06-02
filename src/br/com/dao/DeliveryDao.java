package br.com.dao;

import org.springframework.stereotype.Repository;

import br.com.model.Delivery;

@Repository
public class DeliveryDao extends AbstractDao<Delivery> {

	
	public Class<Delivery> getTypeClass() {
		return Delivery.class;
	}

}
