package br.com.dao;

import org.springframework.stereotype.Repository;

import br.com.model.Tradicional;

@Repository
public class TradicionalDao extends AbstractDao<Tradicional> {
	
	public Class<Tradicional> getTypeClass() {
		return Tradicional.class;
	}
}
