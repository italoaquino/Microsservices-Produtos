package com.produtos.services;

import com.produtos.dtos.ProdutoDTO;
import com.produtos.entities.Produto;
import com.produtos.repositories.ProdutoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutosService {

	private final ProdutoRepository produtoRepository;
	
	public ProdutosService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public List<ProdutoDTO> get(){
		return produtoRepository.findAll().stream()
				.map(produto -> toDTO(produto)).collect(Collectors.toList());
	}

	public ProdutoDTO getById(Integer id){
		Produto produto = produtoRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException(id, Produto.class.getName()));
		return toDTO(produto);
	}
	
	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}

	public Produto update(Integer id, Produto produto){
		Produto obj = toModel(getById(id));

		obj.setName(produto.getName());
		obj.setValor(produto.getValor());
		return produtoRepository.save(obj);
	}

	public void delete(Integer id){

		Produto obj = toModel(getById(id));

		try {
			produtoRepository.delete(obj);
		}
		catch (DataIntegrityViolationException ex){
			throw new DataIntegrityViolationException(ex.getMessage(), ex.getCause());
		}
	}

	public ProdutoDTO toDTO(Produto produto){
		ProdutoDTO produtoDTO = new ProdutoDTO();
		produtoDTO.setId(produto.getId());
		produtoDTO.setName(produto.getName());
		produtoDTO.setValor(produto.getValor());
		return produtoDTO;
	}

	public Produto toModel(ProdutoDTO produtoDto){
		Produto produto = new Produto();
		produto.setId(produtoDto.getId());
		produto.setName(produtoDto.getName());
		produto.setValor(produtoDto.getValor());
		return produto;
	}
}
