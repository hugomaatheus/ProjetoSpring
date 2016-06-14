package br.com.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dao.ClienteDao;
import br.com.dao.DeliveryDao;
import br.com.dao.ItemPedidoDao;
import br.com.dao.PedidoDao;
import br.com.dao.UsuarioDao;
import br.com.model.Cliente;
import br.com.model.Delivery;
import br.com.model.ItemPedido;
import br.com.model.Pedido;
import br.com.model.Usuario;
import br.com.util.Status;
import br.com.util.Tipo;
import br.com.util.TipoPedido;



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
	
	@Autowired
	private PedidoDao pedidoDao;

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
	
	public void ativarUsuario(Cliente cliente) {
		cliente.setStatus(Status.ATIVO);
		clienteDao.update(cliente);
	}

	
	//OK
	public void atualizarUsuario(Cliente cliente) {
		
		clienteDao.update(cliente);
		
	}
	
	//OK
	public Cliente buscarUsuario(Long id) {
		return clienteDao.getById(id);
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
	
	public List<Pedido> listarTodos() {
		List<Pedido> listar = new ArrayList<Pedido>();
		for (Pedido pedido : pedidoDao.listar()) {
			if(pedido.getStatus() != Status.INATIVO)
				listar.add(pedido);
		}

		return listar; 
	}
	//
public void cadastrarPedidoDelivery(Usuario cliente, List<ItemPedido> itens) {
		
		ItemPedido i = new ItemPedido(); 
		Calendar c = new GregorianCalendar();
		Date data = new Date();
		c.setTime(data);
		
		Delivery delivery = new Delivery((Cliente) cliente);
		delivery.setTipo(TipoPedido.DELIVERY);
		delivery.setStatus(Status.ANDAMENTO);
		delivery.setData(c);
		deliveryDao.save(delivery);
		
		for (ItemPedido item : itens) {
			i.setCardapio(item.getCardapio());
			i.setPedido(delivery);
			System.out.println(item.getPedido().getTotal());
			delivery.setTotal(item.getPedido().getTotal());
			i.setQuantidade(item.getQuantidade());
			deliveryDao.update(delivery);
			itemPedidoDao.update(i);
		}
		
	}

	public List<ItemPedido> listarItemPedido(Long id) {
	List<ItemPedido> itemPedido = new ArrayList<>();
	itemPedido = itemPedidoDao.listarItensPedidos(id);

	return itemPedido;
	
	}
	
	public ItemPedido buscarItem(Long id) {
		return itemPedidoDao.getById(id);
	}

	public Cliente buscarPorEmail(String email) {

		return clienteDao.buscarPorEmail(email);
		
	}

	

	///////////////////////////////////////////
}
