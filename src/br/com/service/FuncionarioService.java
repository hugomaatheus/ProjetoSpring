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

import br.com.dao.DeliveryDao;
import br.com.dao.FuncionarioDao;
import br.com.dao.ItemPedidoDao;
import br.com.dao.PedidoDao;
import br.com.dao.ReservaDao;
import br.com.dao.TradicionalDao;
import br.com.model.Delivery;
import br.com.model.Funcionario;
import br.com.model.ItemPedido;
import br.com.model.Mesa;
import br.com.model.Pedido;
import br.com.model.Reserva;
import br.com.model.Tradicional;
import br.com.model.Usuario;
import br.com.util.Status;
import br.com.util.Tipo;
import br.com.util.TipoPedido;


@Service
@Transactional
public class FuncionarioService extends UsuarioService {
	
	@Autowired
	private MesaService mesaService;
	
	@Autowired
	private ReservaDao reservaDao;
	
	@Autowired
	private TradicionalDao tradicionalDao;
	
	@Autowired
	private ItemPedidoDao iDao;
	
	@Autowired
	private DeliveryDao deliveryDao;
	
	@Autowired
	private FuncionarioDao funcionarioDao;
	
	@Autowired
	private PedidoDao pedidoDao;
	
	//Manter Reserva - OK
	public void cadastrarReserva(Reserva reserva, Funcionario funcionario) {
		
		reserva.setFuncionario(funcionario);
		reserva.getMesa().setStatus(Status.OCUPADA);
		
		reservaDao.save(reserva);

	}
	
	//OK
	public Reserva buscarReserva(Long id) {
		return reservaDao.getById(id);
	}
	
	public List<Reserva> listarTodasReservas() {
		
		List<Reserva> reservas = new ArrayList<Reserva>();
		
		reservas = reservaDao.listar();

		
		return reservas; 
	}
	
	//OK
	public void atualizarReserva(Reserva reserva) {

		reservaDao.update(reserva);		
	}
	
	//OK
	public void cancelarReserva(Long id) {
		Calendar calendar = new GregorianCalendar();
		Date date = new Date();
		calendar.setTime(date);
		
		Reserva reserva = reservaDao.getById(id);

		if(reserva.getStatus() == Status.LIVRE) {
			reserva.setDataFinal(calendar);
			reserva.setStatus(Status.CANCELADO);
			reservaDao.update(reserva);
		}
	}
	
	///////////////////////////////////////////
	
	
	//Manter Pedido Tradicional
	//Buscar mesa do pedido tradicional OK
	public Mesa buscarMesaTradicional(Long id) {
		
		Mesa m = null;
		
		Tradicional t =  (Tradicional) tradicionalDao.getById(id);
		m = t.getMesa();
		
		return m;
	}
	
	//Problema com tabelas que estão mapeando as listas
public void cadastrarPedidoTradicional(Usuario usuario, List<ItemPedido> itens) {
		
	System.out.println(itens);
	
		Calendar calendar = new GregorianCalendar();
		Date date = new Date();
		calendar.setTime(date);
		
		Tradicional tradicional = new Tradicional((Funcionario) usuario);
		tradicional.setData(calendar);
		tradicional.setTipo(TipoPedido.TRADICIONAL);
		tradicional.setStatus(Status.ANDAMENTO);
		tradicionalDao.save(tradicional);
		
		Double total = 0.0;
		for (ItemPedido item : itens) {
			total += item.getQuantidade() * item.getCardapio().getPreco();
			tradicional.setMesa(mesaService.buscarPorId(item.getTradicional().getMesa().getId()));
			item.setCardapio(item.getCardapio());
			item.setPedido(tradicional);
			item.setQuantidade(item.getQuantidade());
			tradicional.setTotal(total);
			iDao.save(item);
		}
		
		
	}
	
	//Buscar pedido tradicional - OK
	public Tradicional buscarPedidoTradicional(Long id) {
		return tradicionalDao.getById(id);
	}
	
	//OK
	public void cancelarPedidoTradicional(Long id) {
		
		Tradicional tradicional = (Tradicional) tradicionalDao.getById(id);
		
		if(tradicional.getStatus() == Status.ATIVO || tradicional.getStatus() == null)
			tradicional.setStatus(Status.CANCELADO);
		else
			JOptionPane.showMessageDialog(null, "Você está tentando cancelar "
					+ "uma reserva já cancelada!");
		
		tradicionalDao.update(tradicional);
	}
	///////////////////////////////////////////
	
	
	public Delivery buscarPedidoDelivery(Long id) {
		return deliveryDao.getById(id);
	}

	public List<Tradicional> listarTradicional() {
		
		List<Tradicional> listar = new ArrayList<Tradicional>();
		for (Tradicional tradicional : tradicionalDao.listar()) {
			if(tradicional.getStatus() != Status.INATIVO)
				listar.add(tradicional);
		}

		return listar; 
	}

	public List<Pedido> listarPedidos() {
		
		List<Pedido> listar = new ArrayList<Pedido>();
		for (Pedido pedido : pedidoDao.listar()) {
			if(pedido.getStatus() != Status.INATIVO)
				listar.add(pedido);
		}

		return listar; 
	}


	public ItemPedido buscarItemPedido(Long id){
		return iDao.getById(id);
	}

	public List<ItemPedido> listarItemPedido(Long id) {
		List<ItemPedido> itemPedido = new ArrayList<>();
		itemPedido = iDao.listarItensPedidos(id);

		return itemPedido;
	}

	public Tradicional cancelar(Long id) {
		Tradicional tradicional = tradicionalDao.getById(id);
		
		if(tradicional.getStatus() == Status.ANDAMENTO){
			tradicional.setStatus(Status.CANCELADO);
		}
		
		return tradicional;
	}
	
	public Tradicional atender(Long id) {
		Tradicional tradicional = tradicionalDao.getById(id);
		
		if(tradicional.getStatus() == Status.ANDAMENTO){
			tradicional.setStatus(Status.ATENDIDO);
		}
		
		return tradicional;
	}

	public void atualizarUsuario(Funcionario funcionario) {
		funcionarioDao.update(funcionario);		
	}
	
	public Funcionario buscarUsuario(Long id) {
		return funcionarioDao.getById(id);
	}
	
	public void cadastrarUsuario(Funcionario funcionario) {
		funcionario.setStatus(Status.ATIVO);
		funcionario.setTipo(Tipo.FUNCIONARIO);
		funcionarioDao.save(funcionario);
	}
	
}
