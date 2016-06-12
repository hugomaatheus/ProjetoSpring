package br.com.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.model.Pedido;

@Repository
public class PedidoDao extends AbstractDao<Pedido> {

	@Override
	public Class<Pedido> getTypeClass() {
		return Pedido.class;
	}
	
	// TIPO, STATUS, ID

	@SuppressWarnings("unchecked")
	public List<Pedido> filtrar(Pedido filtro) {
		
		String str = "";
		
		if(filtro.getId() != null){
		 str = "select p from Pedido p where id = :id";
		}else if(filtro.getStatus() != null && filtro.getId() == null){
			str = "select p from Pedido p where status = :status";
		}else if(filtro.getStatus() == null && filtro.getId() == null){
			str = "select p from Pedido p where tipo = :tipo";
		}

		if(filtro.getId() != null && filtro.getStatus() != null){
			str+=" and status = :status";
		}
		
		if((filtro.getId() != null || filtro.getStatus() != null) && filtro.getTipo() != null){
			str+=" and tipo = :tipo";
		}
		
		
		Query query = eM.createQuery(str);
	
		if(filtro.getId() != null)
		query.setParameter("id", filtro.getId());
		
		if(filtro.getStatus() != null){
			query.setParameter("status", filtro.getStatus());
		}
		
		if(filtro.getTipo() != null){
			query.setParameter("tipo", filtro.getTipo());
		}
		
		return query.getResultList();
	}

}
