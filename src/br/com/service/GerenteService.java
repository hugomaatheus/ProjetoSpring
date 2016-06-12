package br.com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dao.CardapioDao;
import br.com.dao.CategoriaDao;
import br.com.dao.FuncionarioDao;
import br.com.dao.ItemPedidoDao;
import br.com.dao.MesaDao;
import br.com.model.Cardapio;
import br.com.model.Categoria;
import br.com.model.Funcionario;
import br.com.model.Gerente;
import br.com.model.ItemPedido;
import br.com.model.Mesa;
import br.com.util.Status;
import br.com.util.Tipo;


@Service
public class GerenteService extends UsuarioService {
	
	@Autowired
	private CardapioDao cardapioDao;
	
//	@Autowired
//	private UsuarioDao gerenteDao;
	
	@Autowired
	private CategoriaDao categoriaDao;
	
	@Autowired
	private MesaDao mesaDao;
	
	@Autowired
	private FuncionarioDao funcionarioDao;
	
	@Autowired
	private ItemPedidoDao itemPedidoDao;
	
	
	//Manter Cardapio
	//OK
	public void cadastrarCardapio(Cardapio c) {
		
		cardapioDao.update(c);
	}
	
	public List<Cardapio> buscar(Cardapio filtro){
		
		List<Cardapio> cardapios = new ArrayList<Cardapio>();
		cardapios = cardapioDao.filtrar(filtro);

		return cardapios;
	}
	
	
	public List<Cardapio> consultarTodosCardapios() {
		
		List<Cardapio> cardapios = new ArrayList<Cardapio>();
		
		cardapios = cardapioDao.listar();
		
		return cardapios; 
	}
	
	public Cardapio consultarCardapio(Long id) {
		
		Cardapio c = new Cardapio();
		c = cardapioDao.getById(id);		
		
		return c;
	}
	//OK
	public void atualizarCardapio(Cardapio c) {
		
		cardapioDao.update(c);
		
	}
	
	//OK
	public void excluirCardapio(Long id) {
		
		Cardapio c;
		
		c = cardapioDao.getById(id);
		c.setCategoria(null);
		cardapioDao.delete(c);
		
		
	}
	
	public Gerente logar(String login, String senha){
		
		return (Gerente) usuarioDao.logar(login, senha);
	}
	////////////////////////////////////////
	
	
	//Manter Categoria - OK
	public void cadastrarCategoria(Categoria c) {
		
		c.setStatus(Status.ATIVO);
		categoriaDao.save(c);
		
	}
	
	//OK
	public void atualizarCategoria(Categoria c) {
		
		categoriaDao.update(c);
		
	}
	
	//OK
	public void excluirCategoria(Long id) {
		
		Categoria categoria;
		categoria = categoriaDao.getById(id);
		categoriaDao.delete(categoria);
	}
	
	//OK
	public Categoria consultarCategoria(Long id) {
		
		Categoria c = new Categoria();
		c = categoriaDao.getById(id);
		
		return c;
	}
	
	
	public List<Categoria> listarTodasCategorias() {
		

		List<Categoria> categorias = new ArrayList<Categoria>();
		categorias = categoriaDao.listar();
		
		return categorias; 
	}
	
	public List<Categoria> buscar(Categoria filtro){
		
		List<Categoria> categorias = new ArrayList<Categoria>();
		categorias = categoriaDao.filtrar(filtro);
		 
		return categorias;
	}
	
	/////////////////////////////////////////////
	
	
	//OK
	public void cadastrarMesa(Funcionario f) {
		
		Mesa mesa = new Mesa();
		mesa.setStatus(Status.LIVRE);
		mesaDao.save(mesa);
		
	}
	
	//OK
	public void atualizarMesa(Mesa m) {
		
		mesaDao.update(m);
		
	}
	
	//OK
	public Mesa buscarMesa(Long id) {
		
		Mesa m = new Mesa();
		m = mesaDao.getById(id);
		
		return m;
	}
	
	//OK
	public void excluirMesa(Long id) {
		
		Mesa m = mesaDao.getById(id);
		mesaDao.delete(m);

	}
	
public List<Mesa> consultarTodosMesas() {
		
	List<Mesa> mesas = new ArrayList<Mesa>();
	mesas = mesaDao.listar();	
		
	return mesas; 
}
	
	/////////////////////////////////////////////
	
	//OK
	@Override
	public void cadastrarUsuario(Funcionario f) {
		
		f.setStatus(Status.ATIVO);
		f.setTipo(Tipo.FUNCIONARIO);
		funcionarioDao.save(f);
		
	}

//	@Override
//	public void desativarUsuario(Long id) {
//		
//	}
	
	//Violando fk na tabela Reserva
	//Criar consulta que deixe nulo a fk da reserva que aquele funcionario fez
	public void excluirUsuario(Long id) {
		
		Funcionario f = funcionarioDao.getById(id);
		
		funcionarioDao.delete(f);
	}
	
	//OK
	public void atualizarUsuario(Funcionario f) {
		
		
		funcionarioDao.update(f);
		
	}
	
	//OK
	@Override
	public Funcionario buscarUsuario(Long id) {
		
		Funcionario f = null;
		f = funcionarioDao.getById(id);
		
		
		return f;
	}

	public List<Funcionario> listarTodosFuncionarios() {
		

		List<Funcionario> funcionarios = null;
		funcionarios = (List<Funcionario>) funcionarioDao.listar();
		
		return funcionarios; 
	}
	
	public Mesa buscar(int numero) {
		
		Mesa mesa = new Mesa();
		mesa = (Mesa) mesaDao.buscarMesa(numero);
		
		return mesa;
		
	}
	
	public ItemPedido buscarItem(Long id) {
		
		ItemPedido itemPedido = new ItemPedido();
		
		itemPedido = itemPedidoDao.getById(id);
		
		return itemPedido;
	}

}
