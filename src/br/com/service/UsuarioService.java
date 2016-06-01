package br.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dao.UsuarioDao;
import br.com.model.Funcionario;
import br.com.model.Usuario;

@Service
@Transactional
public class UsuarioService {
		
		@Autowired
		protected UsuarioDao usuarioDao;
	
		public Usuario logar(String login, String senha){
			return usuarioDao.logar(login, senha);	
		}

		public Funcionario buscarUsuario(Long id) {
			// TODO Auto-generated method stub
			return null;
		}
		
		public void cadastrarUsuario(Funcionario f) {
			// TODO Auto-generated method stub
			
		}

}
