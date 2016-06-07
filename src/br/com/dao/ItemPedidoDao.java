package br.com.dao;

import org.springframework.stereotype.Repository;

import br.com.model.ItemPedido;

@Repository
public class ItemPedidoDao extends AbstractDao<ItemPedido> {

	@Override
	public Class<ItemPedido> getTypeClass() {
		return ItemPedido.class;
	}

}
