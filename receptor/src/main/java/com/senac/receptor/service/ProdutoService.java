package com.senac.receptor.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.senac.receptor.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	private ProdutoRepository produtoRepository;
	
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	@RabbitListener(queues = "fila-get-produto")
    private void subscribe(String opcao){
        System.out.println(produtoRepository.findAll());
        
	}
	
	/*@RabbitListener(queues = "fila-post-produto")
	public void salvarProduto(Produto produto) {
		this.produtoRepository.save(produto);
	}*/
}
