package br.com.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dao.ClienteDao;
import br.com.dao.DeliveryDao;
import br.com.dao.ItemPedidoDao;
import br.com.dao.UsuarioDao;
import br.com.model.Cliente;
import br.com.model.Delivery;
import br.com.model.ItemPedido;
import br.com.model.Usuario;
import br.com.util.Status;
import br.com.util.Tipo;



@Service
@Transactional
public class ClienteService {

	@Autowired
	private ClienteDao clienteDao;
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private DeliveryDao deliveryDao;
	
	@Autowired
	private ItemPedidoDao itemPedidoDao;

	//Manter cliente - OK
	public void cadastrarUsuario(Usuario cliente) {
		
		cliente.setStatus(Status.ATIVO);
		cliente.setTipo(Tipo.CLIENTE);
		clienteDao.save((Cliente) cliente);
	}	

	//OK
	public void desativarUsuario(Cliente cliente) {

		if(cliente.getStatus() == Status.ATIVO) {
			cliente.setStatus(Status.INATIVO);
			clienteDao.update(cliente);
		}
		else
			JOptionPane.showConfirmDialog(null, "Você está tentando desativar"
					+ " um cliente já inativo");
		
	}
	
	//OK
	public void atualizarUsuario(Cliente cliente) {
		
		clienteDao.update(cliente);
		
	}
	
	//OK
	public Cliente buscarUsuario(Long id) {
	
		Cliente c = null;
		
		c = clienteDao.getById(id);
		
		return c;
	}
	
	public Cliente logar(String login, String senha){

		return (Cliente)usuarioDao.logar(login, senha);
	}
	//////////////////////////////////////////
	
	
	//Manter pedido - OK
	public Delivery buscarPedidoDelivery(Long id) {
		
		Delivery d = null;
		
		d = (Delivery) deliveryDao.getById(id);

		return d;	
	}
	
	public List<Delivery> listarTodos() {
		List<Delivery> result = new LinkedList<Delivery>();
		result = deliveryDao.listar();	
		return result;
	}
	//
public void cadastrarPedidoDelivery(Usuario cliente, List<ItemPedido> itens) {
		
		ItemPedido i = new ItemPedido(); 
		Calendar c = new GregorianCalendar();
		Date data = new Date();
		c.setTime(data);
		
		Delivery delivery = new Delivery((Cliente) cliente);
		delivery.setStatus(Status.ANDAMENTO);
		delivery.setData(c);
		deliveryDao.save(delivery);
		
		for (ItemPedido item : itens) {
			i.setCardapio(item.getCardapio());
			i.setPedido(delivery);
			i.setQuantidade(item.getQuantidade());
			itemPedidoDao.update(i);
		}
		
	}
	///////////////////////////////////////////
}
