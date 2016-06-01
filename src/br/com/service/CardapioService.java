package br.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dao.CardapioDao;
import br.com.model.Cardapio;

@Service
@Transactional
public class CardapioService {

	@Autowired
	private CardapioDao cardapioDao;

	public void inserir(Cardapio cardapio) {
		cardapioDao.save(cardapio);
	}

	public void atualizar(Cardapio cardapio) {
		cardapioDao.update(cardapio);
	}

	public List<Cardapio> listar() {
		return cardapioDao.listar();
	}

	public void remover(Cardapio cardapio) {
		cardapioDao.delete(cardapio);;
	}

	public Cardapio buscarPorId(Long id) {
		return cardapioDao.getById(id);
	}

	public List<Cardapio> buscar(Cardapio filtro) {
		return cardapioDao.filtrar(filtro);
	}

}
