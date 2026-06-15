/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.canes.service;

import com.app.canes.model.Produto;
import com.app.canes.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



/**
 *
 * @author Carlos Borges
 */
@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    

    public Produto salvar(Produto produto) {

        try{
        return produtoRepository.save(produto);
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return produto;
    }

    public Produto buscarPorId(Integer id) {

        return produtoRepository.findById(id)
                .orElseThrow(()
                        -> new RuntimeException("Cliente não encontrado"));
    }

    public List<Produto> listarTodos() {

        return produtoRepository.findAll(
        Sort.by(Sort.Direction.DESC, "id"
                ));
    }

    public Produto atualizar(Integer id, Produto produtoAtualizado) {

        Produto produtoExistente = produtoRepository.findById(id)
                .orElseThrow(()
                        -> new RuntimeException("produto não encontrado"));

        produtoExistente.setCodigo(produtoAtualizado.getCodigo());
        produtoExistente.setNome(produtoAtualizado.getNome());
        produtoExistente.setEstoque(produtoAtualizado.getEstoque());
        produtoExistente.setValor (produtoAtualizado.getValor());
       
        

        return produtoRepository.save(produtoExistente);
    }

    public void excluir(Integer id) {

        Produto endereco = buscarPorId(id);

        produtoRepository.delete(endereco);
    }
}
