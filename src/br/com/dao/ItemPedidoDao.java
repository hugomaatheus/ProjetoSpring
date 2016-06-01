package br.com.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.model.ItemPedido;

@Repository
public class ItemPedidoDao extends AbstractDao<ItemPedido> {

	@Override
	public Class<ItemPedido> getTypeClass() {
		// TODO Auto-generated method stub
		return ItemPedido.class;
	}

}
