package br.com.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.model.Cardapio;


@Repository
public class CardapioDao extends AbstractDao<Cardapio> {

	@Override
	public Class<Cardapio> getTypeClass() {
		return Cardapio.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cardapio> filtrar(Cardapio filtro){
		String str = "select c from Cardapio c where upper(nome) like upper(:nome)";
		if(filtro.getNome() == null){
			filtro.setNome("");
		}
	
		Query query = eM.createQuery(str);   
		
		query.setParameter("nome", "%"+filtro.getNome()+"%");
		
		return query.getResultList();
	}

}
