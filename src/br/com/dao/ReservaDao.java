package br.com.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.model.Reserva;

@Repository
public class ReservaDao extends AbstractDao<Reserva>{


	@Override
	public Class<Reserva> getTypeClass() {
		return Reserva.class;
	}

	@SuppressWarnings("unchecked")
	public List<Reserva> filtrarReservas(Reserva filtro) {

		String str = "";
		
		if(!filtro.getDataInicial().equals("")){
		 str = "select r from Reserva r where datainicial like :datainicial";
		}else if(filtro.getDataInicial().equals("") && !filtro.getDataFinal().equals("")){
			str = "select r from Reserva r where datafinal like :datafinal";
		}else if(filtro.getDataInicial().equals("") && filtro.getDataFinal().equals("") && filtro.getMesa().getId() != null){
			str = "select r from Reserva r where mesa_id = :mesa";
		}else if(filtro.getDataInicial().equals("") && filtro.getDataFinal().equals("") && filtro.getMesa().getId() == null && !filtro.getNome_Responsavel().equals("")){
			str = "select r from Reserva r where upper(nome_responsavel) like upper(:nomeresponsavel)";
		}

		if(!filtro.getDataInicial().equals("") && !filtro.getDataFinal().equals("")){
			str+=" and datafinal like :datafinal";
		}
		
		if((!filtro.getDataInicial().equals("") || !filtro.getDataFinal().equals("")) && filtro.getMesa().getId() != null){
			str+=" and mesa_id = :mesa";
		}
		
		if((!filtro.getDataInicial().equals("") || !filtro.getDataFinal().equals("") || filtro.getMesa().getId() != null) && !filtro.getNome_Responsavel().equals("")){
			str+=" and nome_responsavel like :nomeresponsavel";
		}
		
		Query query = eM.createQuery(str);
	
		if(!filtro.getDataInicial().equals(""))
		query.setParameter("datainicial", "%" + filtro.getDataInicial() + "%");
		
		if(!filtro.getDataFinal().equals("")){
			query.setParameter("datafinal", "%" + filtro.getDataFinal() + "%");
		}
		
		if(filtro.getMesa().getId() != null){
			query.setParameter("mesa", filtro.getMesa().getId());
		}
		
		if(!filtro.getNome_Responsavel().equals("")){
			query.setParameter("nomeresponsavel", "%" + filtro.getNome_Responsavel() + "%");
		}
		
		return query.getResultList();

	}
}
