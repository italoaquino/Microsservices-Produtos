package com.produtos.resources;

import com.produtos.dtos.ProdutoDTO;
import com.produtos.entities.Produto;
import com.produtos.services.ProdutosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/produtos")
public class ProdutoResource {

	private final ProdutosService produtosService;
	
	public ProdutoResource(ProdutosService produtosService) {
		this.produtosService = produtosService;
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProdutoDTO>> get(){
		return new ResponseEntity<List<ProdutoDTO>>(produtosService.get(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Produto> save(@Valid @RequestBody Produto produto){
		return new ResponseEntity<Produto>(produtosService.save(produto), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public ResponseEntity<ProdutoDTO> getById(@PathVariable Integer id){
		return new ResponseEntity<ProdutoDTO>(produtosService.getById(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public ResponseEntity<Produto> update(@Valid @PathVariable Integer id, @RequestBody Produto produto){
		produtosService.update(id, produto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		produtosService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	
	
}
