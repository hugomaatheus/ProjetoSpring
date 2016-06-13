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
		String str="";
		
		if(!filtro.getNome().equals("")){
			str = "select c from Cardapio c where upper(nome) like upper(:nome)";
		}else if(filtro.getNome().equals("") && filtro.getCategoria().getId() != null){
			str = "select c from Cardapio c where categoria_id = :categ";
		}
	
		if(!filtro.getNome().equals("") && filtro.getCategoria().getId() != null){
			str += " and categoria_id = :categ";
		}
		
		Query query = eM.createQuery(str);
		
		if(!filtro.getNome().equals(""))
		query.setParameter("nome", "%" + filtro.getNome() + "%");
		
		if(filtro.getCategoria().getId() != null)
			query.setParameter("categ", filtro.getCategoria().getId());
			
		return query.getResultList();
	}

}
