package br.com.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.model.Mesa;

@Repository
public class MesaDao extends AbstractDao<Mesa> {


	@Override
	public Class<Mesa> getTypeClass() {
		return Mesa.class;
	}

	public Object buscarMesa(int numero) {
		Query query = eM.createQuery("select m from Mesa m where m.numero = :numero").setParameter("numero", numero);
		return query.getSingleResult();
	}

	public List<Mesa> filtrar(Mesa filtro) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
