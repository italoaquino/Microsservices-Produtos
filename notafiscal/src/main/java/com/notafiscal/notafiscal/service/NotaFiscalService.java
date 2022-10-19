package com.notafiscal.notafiscal.service;

import com.notafiscal.notafiscal.FeingModels.ProdutoDTO;
import com.notafiscal.notafiscal.feingClients.ProdutoFeingClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NotaFiscalService {

    private ProdutoFeingClient produtoFeingClient;

    public NotaFiscalService(ProdutoFeingClient produtoFeingClient){
        this.produtoFeingClient= produtoFeingClient;
    }

    public String criarNotaFiscalString(Integer id){

        ResponseEntity<ProdutoDTO> produto = produtoFeingClient.getById(id);
        String notaFiscal = "Produto: " + produto.getBody().getName() + " -  Valor: " + produto.getBody().getValor();
        return notaFiscal;
    }

}
