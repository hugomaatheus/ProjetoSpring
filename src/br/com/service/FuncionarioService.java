package br.com.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dao.CardapioDao;
import br.com.dao.DeliveryDao;
import br.com.dao.ItemPedidoDao;
import br.com.dao.PedidoDao;
import br.com.dao.ReservaDao;
import br.com.dao.TradicionalDao;
import br.com.model.Delivery;
import br.com.model.Funcionario;
import br.com.model.ItemPedido;
import br.com.model.Mesa;
import br.com.model.Reserva;
import br.com.model.Tradicional;
import br.com.model.Usuario;
import br.com.util.Status;


@Service
@Transactional
public class FuncionarioService extends UsuarioService {
	
	@Autowired
	private ReservaDao reservaDao;
	
	@Autowired
	private TradicionalDao tradicionalDao;
	
	@Autowired
	private PedidoDao pDao;
	
	@Autowired
	private CardapioDao cDao;
	
	@Autowired
	private ItemPedidoDao iDao;
	
	@Autowired
	private DeliveryDao deliveryDao;
	
	
	//Manter Reserva - OK
	public void cadastrarReserva(Reserva reserva) {

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
		
		Reserva reserva = reservaDao.getById(id);
		Calendar data = Calendar.getInstance();

		if(reserva.getStatus() == Status.ATIVO) {
			reserva.setDataFinal(data);
			reserva.setStatus(Status.CANCELADO);
			reserva.getMesa().setStatus(Status.LIVRE);
			reservaDao.update(reserva);
		}

		else
			JOptionPane.showMessageDialog(null, "Você está tentando cancelar "
					+ "uma reserva já cancelada!");
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
public void cadastrarPedidoDelivery(Usuario funcionario, List<ItemPedido> itens) {
		
		ItemPedido i = new ItemPedido();
		
		Tradicional tradicional = new Tradicional((Funcionario) funcionario);
		tradicional.setStatus(Status.ANDAMENTO);
		tradicionalDao.save(tradicional);
		
		for (ItemPedido item : itens) {
			i.setCardapio(item.getCardapio());
			i.setPedido(tradicional);
			i.setQuantidade(item.getQuantidade());
			iDao.save(i);
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
		return (Delivery) deliveryDao.getById(id);
	}

	public List<Tradicional> listarTradicional() {
		
		List<Tradicional> tradicionais = new ArrayList<Tradicional>();
		tradicionais = tradicionalDao.listar();

		return tradicionais; 
	}
	
}
