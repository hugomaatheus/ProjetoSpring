package br.com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dao.CardapioDao;
import br.com.model.Cardapio;
import br.com.util.Status;

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
		List<Cardapio> lista = new ArrayList<Cardapio>();
		for (Cardapio cardapio : cardapioDao.listar()) {
			if(cardapio.getStatus() != Status.INATIVO)
				lista.add(cardapio);
		}
		
		return lista;
	}

	public void remover(Cardapio cardapio) {
		cardapioDao.delete(cardapio);
	}

	public Cardapio buscarPorId(Long id) {
		return cardapioDao.getById(id);
	}

	public List<Cardapio> buscar(Cardapio filtro) {
		List<Cardapio> lista = new ArrayList<Cardapio>();
		for (Cardapio cardapio : cardapioDao.filtrar(filtro)) {
			if(cardapio.getStatus() != Status.INATIVO)
				lista.add(cardapio);
		}
		
		return lista;
	}
	
	public Cardapio cancelar(Long id) {
		Cardapio cardapio = cardapioDao.getById(id);
		
		if(cardapio.getStatus() == Status.ATIVO){
			cardapio.setStatus(Status.INATIVO);
		}
		
		return cardapio;
	}

}
