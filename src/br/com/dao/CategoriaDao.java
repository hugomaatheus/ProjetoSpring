package br.com.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.model.Categoria;


@Repository
public class CategoriaDao extends AbstractDao<Categoria> {

	@Override
	public Class<Categoria> getTypeClass() {
		return Categoria.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> filtrar(Categoria filtro){
		String str = "select c from Categoria c where upper(nome) like upper(:nome)";
		if(filtro.getNome() == null){
			filtro.setNome("");
		}
	
		Query query = eM.createQuery(str);   
		
		query.setParameter("nome", "%"+filtro.getNome()+"%");
		
		return query.getResultList();
	}
	
}
