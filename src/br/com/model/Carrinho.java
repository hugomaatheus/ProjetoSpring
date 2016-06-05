package br.com.model;

import java.util.ArrayList;
import java.util.List;

import br.com.service.GerenteService;

public class Carrinho {
	
	private static List<ItemPedido> itens = new ArrayList<ItemPedido>();
	static GerenteService gC = new GerenteService();
	
	private ItemPedido itemPedido;
	private int qtd;
	
	public static List<ItemPedido> getItens() {
		return itens;
	}

	public static void setItens(List<ItemPedido> itens) {
		Carrinho.itens = itens;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public void addItem(Long id) {
		itemPedido = gC.buscarItem(id);
		itens.add(itemPedido);
	}
	
	public void limparCarrinho() {
		itens.clear();
	}

}
