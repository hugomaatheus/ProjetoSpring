package br.com.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.model.AbstractEntity;



public abstract class AbstractDao <T extends AbstractEntity> {
	
	@PersistenceContext
	protected EntityManager eM;
	
	
	public void save(T entity) {
		eM.persist(entity);
	}
	
	public void update(T entity) {
		eM.merge(entity);
	}
	
	public void delete(T entity) {
		entity = eM.find(getTypeClass(), entity.getId());
		eM.remove(entity);
	}
	
	public T getById(Long id) {
		return eM.find(getTypeClass(), id);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listar() {
		Query query = eM.createQuery("select e from " + getTypeClass().getSimpleName() + " e");
		return query.getResultList();
	}

	public abstract Class<T> getTypeClass();
	
	
}
