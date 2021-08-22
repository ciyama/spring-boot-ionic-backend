package com.ciyama.ciyportifliojava;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ciyama.ciyportifliojava.domain.Categoria;
import com.ciyama.ciyportifliojava.domain.Cidade;
import com.ciyama.ciyportifliojava.domain.Cliente;
import com.ciyama.ciyportifliojava.domain.Endereco;
import com.ciyama.ciyportifliojava.domain.Estado;
import com.ciyama.ciyportifliojava.domain.ItemPedido;
import com.ciyama.ciyportifliojava.domain.Pagamento;
import com.ciyama.ciyportifliojava.domain.PagamentoComBoleto;
import com.ciyama.ciyportifliojava.domain.PagamentoComCartao;
import com.ciyama.ciyportifliojava.domain.Pedido;
import com.ciyama.ciyportifliojava.domain.Produto;
import com.ciyama.ciyportifliojava.domain.enums.EstadoPagamento;
import com.ciyama.ciyportifliojava.domain.enums.TipoCliente;
import com.ciyama.ciyportifliojava.repositories.CategoriaRepository;
import com.ciyama.ciyportifliojava.repositories.CidadeRepository;
import com.ciyama.ciyportifliojava.repositories.ClienteRepository;
import com.ciyama.ciyportifliojava.repositories.EnderecoRepository;
import com.ciyama.ciyportifliojava.repositories.EstadoRepository;
import com.ciyama.ciyportifliojava.repositories.ItemPedidoRepository;
import com.ciyama.ciyportifliojava.repositories.PagamentoRepository;
import com.ciyama.ciyportifliojava.repositories.PedidoRepository;
import com.ciyama.ciyportifliojava.repositories.ProdutoRepository;

@SpringBootApplication
public class CiyportifoliojavaApplication implements CommandLineRunner {
	

	public static void main(String[] args) {
		SpringApplication.run(CiyportifoliojavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
