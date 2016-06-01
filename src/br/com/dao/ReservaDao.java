package br.com.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.model.Reserva;

@Repository
public class ReservaDao extends AbstractDao<Reserva>{


	@Override
	public Class<Reserva> getTypeClass() {
		// TODO Auto-generated method stub
		return Reserva.class;
	}

	
	
}
