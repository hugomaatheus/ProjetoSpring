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
	
	@SuppressWarnings("unchecked")
	public List<Mesa> filtrar(Mesa filtro){
		String str = "select m from Mesa m where m.numero = :numero";
		if(filtro.getNumero() == null){
			filtro.setNumero(0);
		}
				
		if(filtro.getStatus() != null){
			str+=" and m.status = :status";
		}
		
		Query query = eM.createQuery(str);
		
		query.setParameter("numero", filtro.getNumero());
		
		if(filtro.getStatus() != null){
			query.setParameter("status", filtro.getStatus());
		}
		
		return query.getResultList();

	}
}
