package com.ciyama.ciyportifliojava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ciyama.ciyportifliojava.domain.Categoria;
import com.ciyama.ciyportifliojava.domain.Produto;
import com.ciyama.ciyportifliojava.repositories.CategoriaRepository;
import com.ciyama.ciyportifliojava.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repo.search(nome, categorias, pageRequest);
	}

}
