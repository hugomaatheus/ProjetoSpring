package br.com.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.AbstractController;

import br.com.dao.CardapioDao;
import br.com.dao.DeliveryDao;
import br.com.dao.FuncionarioDao;
import br.com.dao.ItemPedidoDao;
import br.com.dao.PedidoDao;
import br.com.dao.ReservaDao;
import br.com.dao.TradicionalDao;
import br.com.model.Cardapio;
import br.com.model.Delivery;
import br.com.model.Funcionario;
import br.com.model.ItemPedido;
import br.com.model.Mesa;
import br.com.model.Pedido;
import br.com.model.Reserva;
import br.com.model.Tradicional;
import br.com.util.Status;

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
	
	@Autowired
	private FuncionarioDao funcionarioDao;
	
	@Autowired
	private CardapioDao cardapioDao;
	
	
	//Manter Reserva - OK
	public void cadastrarReserva(Reserva reserva, Funcionario f) {
		
		reserva.setStatus(Status.ATIVO);
		reserva.setFuncionario(f);
		reservaDao.update(reserva);
	}
	
	//OK
	public Reserva buscarReserva(Long id) {
		
		Reserva r = null;
		
		r = reservaDao.getById(id);
		
		return r;
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

		if(reserva.getStatus() == Status.ATIVO) {
			reserva.setStatus(Status.CANCELADO);
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
	public void cadastrarPedidoTradicional(Mesa m, Funcionario f) throws Exception {
		
		Calendar c = Calendar.getInstance();
		Date data = c.getTime();
		
		Collection<ItemPedido> itens = new ArrayList<ItemPedido>();
		Cardapio cardapio = new Cardapio();

		if(m.getCapacidade() < m.getNumero())
			throw new Exception("Número de pessoas na mesa excede a capacidade da mesa!");

		else {
			cardapio = cDao.getById(2L);
			
			m.setStatus(Status.OCUPADA);
			
			Pedido t = new Tradicional(m, f);
			t.setData(data);
			
			
			Pedido p = new Pedido();
			ItemPedido i = new ItemPedido(cardapio);
			p.setData(data);
			p.setStatus(Status.ANDAMENTO);
			i.setPedido(p);
			i.setCardapio(cardapio);
			
			for (Iterator<ItemPedido> iterator = itens.iterator(); iterator.hasNext();) {
				if(!(i.getId() == null)) {
					itens.add(i);
				}
			}
			
			p.setItens(itens);
			
			iDao.save(i);
			pDao.update(p);
			tradicionalDao.update(t);
	}
		
}
	
	//Buscar pedido tradicional - OK
	public Pedido buscarPedidoTradicional(Long id) {
		
		Pedido t = null;
		
		t =  tradicionalDao.getById(id);
		
		return t;
	}
	
	//OK
	public void cancelarPedidoTradicional(Long id) {
		
		Pedido tradicional = (Tradicional) tradicionalDao.getById(id);
		
		if(tradicional.getStatus() == Status.ATIVO || tradicional.getStatus() == null)
			tradicional.setStatus(Status.CANCELADO);
		else
			JOptionPane.showMessageDialog(null, "Você está tentando cancelar "
					+ "uma reserva já cancelada!");
		
		tradicionalDao.update(tradicional);
	}
	///////////////////////////////////////////
	
	
	public Delivery buscarPedidoDelivery(Long id) {
		
		Delivery d = null;

		d = (Delivery) deliveryDao.getById(id);

		return d;
	}
	
}
