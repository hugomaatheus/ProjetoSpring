package br.com.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.model.Usuario;
import br.com.util.Tipo;


@Repository
public class UsuarioDao extends AbstractDao<Usuario> {

	@Override
	public Class<Usuario> getTypeClass() {
		// TODO Auto-generated method stub
		return Usuario.class;
	}
	
	
public Usuario logar(String login, String senha){
		
		Query query = eM.createQuery("select u from Usuario u where u.login = :login and u.senha = :senha");
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		List<Usuario> usuarios =  query.getResultList();
		
		return usuarios.isEmpty() ? null : usuarios.get(0);
	}
	
	

	public Object listarCliente(){
		Query query = eM.createQuery("SELECT u FROM Usuario u WHERE u.tipo = :tipo");
		query.setParameter("tipo", Tipo.CLIENTE);
		return query.getResultList();

	}
	
//	public Usuario buscarPorLogin(String login) {
//		Query query = eM.createNamedQuery("findByLogin");
//		query.setParameter("login", login);
//		try{
//		Usuario usuario = (Usuario) query.getSingleResult();
//		return usuario;
//		}catch(Exception e){
//			
//		}

}
