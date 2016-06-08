package br.com.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.model.ItemPedido;

@Repository
public class ItemPedidoDao extends AbstractDao<ItemPedido> {

	@Override
	public Class<ItemPedido> getTypeClass() {
		return ItemPedido.class;
	}

	@SuppressWarnings("unchecked")
	public List<ItemPedido> listarItensPedidos(Long id) {
				
				Query query = eM.createQuery("select i from ItemPedido i where i.pedido.id = :id");
				query.setParameter("id", id);
				List<ItemPedido> itens =  query.getResultList();
				return itens;
			}
	

}
