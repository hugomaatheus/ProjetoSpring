package br.com.util;

import java.util.List;

import br.com.model.Delivery;
import br.com.service.ClienteService;

public class mizera {

	public static void main(String[] args) {

		ClienteService clienteservice = new ClienteService();
		Delivery delivery = clienteservice.buscarPedidoDelivery(1L);
		System.out.println(delivery);

	}

}
