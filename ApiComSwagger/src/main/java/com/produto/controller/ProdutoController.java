package com.produto.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.produto.model.Produto;
import com.produto.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value = "ApiRestFull com Spring boot e documentada com Swagger2")
@CrossOrigin(origins = "*") //qualquer dominio pode acessar a api
public class ProdutoController {

@Autowired
ProdutoRepository produtoRepository;

//ENDPOINTS//

@PostMapping("/produto")
@ApiOperation(value = "Salva um produto.")
public Produto cadastrarProduto(@RequestBody Produto produto) {	
	return produtoRepository.save(produto);
	
  }

@DeleteMapping("/produto")
@ApiOperation(value = "Exclui um produto.")
public void deletarProduto(@RequestBody Produto produto) {
	produtoRepository.delete(produto);	
  }

@GetMapping("/produto")
@ApiOperation(value = "Retorna uma lista de produtos.")
public List<Produto> listarTodos(){
    return produtoRepository.findAll();
  }

@GetMapping("/produto/{id}")
@ApiOperation(value = "Retorna um produto através do Id")
public Optional<Produto> buscarPorId(@PathVariable(value = "id")Long id) {
	return produtoRepository.findById(id); 
  }
	
@PutMapping("/produto")
@ApiOperation(value = "Altera um produto.")
public Produto alterarProduto(@RequestBody Produto produto) {
	produtoRepository.save(produto);	
	return produto;
  }

}

