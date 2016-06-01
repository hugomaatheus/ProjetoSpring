package br.com.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.model.Pedido;

@Repository
public class PedidoDao extends AbstractDao<Pedido> {

	@Override
	public Class<Pedido> getTypeClass() {
		return Pedido.class;
	}

}
