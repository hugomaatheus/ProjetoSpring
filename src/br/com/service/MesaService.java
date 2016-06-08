package br.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dao.MesaDao;
import br.com.model.Mesa;
import br.com.util.Status;

@Service
@Transactional
public class MesaService {

	@Autowired
	private MesaDao mesaDao;

	public void inserir(Mesa mesa) {
		mesaDao.save(mesa);
	}

	public void atualizar(Mesa mesa) {
		mesaDao.update(mesa);
	}

	public List<Mesa> listar() {
		return mesaDao.listar();
	}

	public void remover(Mesa mesa) {
		mesaDao.delete(mesa);
	}

	public Mesa buscarPorId(Long id) {
		return mesaDao.getById(id);
	}

	public List<Mesa> buscar(Mesa filtro) {
		return mesaDao.filtrar(filtro);
	}

	public void cancelar(Long id) {
		Mesa mesa = mesaDao.getById(id);
		
		if(mesa.getStatus() == Status.SIM) {
			mesa.setStatus(Status.NAO);
			mesaDao.update(mesa);
		}
		
	}

}
