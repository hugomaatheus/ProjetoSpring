package br.com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dao.CategoriaDao;
import br.com.model.Categoria;
import br.com.util.Status;

@Service
@Transactional
public class CategoriaService {

	@Autowired
	private CategoriaDao categoriaDao;
	
	public void inserir(Categoria categoria) {
		categoriaDao.save(categoria);
	}

	public void atualizar(Categoria categoria) {
		categoriaDao.update(categoria);
	}

	public List<Categoria> listar() {
		List<Categoria> lista = new ArrayList<Categoria>();
		for (Categoria categoria : categoriaDao.listar()) {
			if(categoria.getStatus() != Status.INATIVO)
				lista.add(categoria);
		}
		
		return lista;
	}

	public void remover(Categoria categoria) {
		categoriaDao.delete(categoria);
	}

	public Categoria buscarPorId(Long id) {
		return categoriaDao.getById(id);
	}

	public List<Categoria> buscar(Categoria filtro) {
		return categoriaDao.filtrar(filtro);
	}
	
	public Categoria cancelar(Long id) {
		Categoria categoria = categoriaDao.getById(id);
		
		if(categoria.getStatus() == Status.ATIVO){
			categoria.setStatus(Status.INATIVO);
		}
		
		return categoria;
	}
	
}
