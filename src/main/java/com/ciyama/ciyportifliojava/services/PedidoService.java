package com.ciyama.ciyportifliojava.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ciyama.ciyportifliojava.domain.ItemPedido;
import com.ciyama.ciyportifliojava.domain.PagamentoComBoleto;
import com.ciyama.ciyportifliojava.domain.Pedido;
import com.ciyama.ciyportifliojava.domain.enums.EstadoPagamento;
import com.ciyama.ciyportifliojava.repositories.ClienteRepository;
import com.ciyama.ciyportifliojava.repositories.ItemPedidoRepository;
import com.ciyama.ciyportifliojava.repositories.PagamentoRepository;
import com.ciyama.ciyportifliojava.repositories.PedidoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ClienteService clienteService;	
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;	
	
	@Autowired
	private EmailService emailService;
	
	public Pedido find(Integer id) throws ObjectNotFoundException {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", tipo: " + Pedido.class.getName()
				));
	}

	@Transactional
	public Pedido insert(Pedido obj) throws ObjectNotFoundException {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.setCliente(clienteService.find(obj.getCliente().getId()));
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento()); 
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setProduto(produtoService.find(ip.getProduto().getId()));
			ip.setPreco(produtoService.find(ip.getProduto().getId()).getPreco());
			ip.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItens());
		emailService.sendOrderConfirmationEmail(obj);
		return obj;
	}

}
