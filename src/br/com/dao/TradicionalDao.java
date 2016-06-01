package br.com.dao;

import org.springframework.stereotype.Repository;

import br.com.model.Pedido;

@Repository
public class TradicionalDao extends PedidoDao {
	
	public Class<Pedido> getTypeClass() {
		return Pedido.class;
	}
}
