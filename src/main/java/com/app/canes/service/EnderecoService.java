/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.canes.service;

import com.app.canes.model.Endereco;
import com.app.canes.repository.EnderecoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Carlos Borges
 */
@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    

    public Endereco salvar(Endereco endereco) {

        return enderecoRepository.save(endereco);
    }

    public Endereco buscarPorId(Integer id) {

        return enderecoRepository.findById(id)
                .orElseThrow(()
                        -> new RuntimeException("Cliente não encontrado"));
    }

    public List<Endereco> listarTodos() {

        return enderecoRepository.findAll();
    }

    public Endereco atualizar(Integer id, Endereco enderecoAtualizado) {

        Endereco enderecoExistente = enderecoRepository.findById(id)
                .orElseThrow(()
                        -> new RuntimeException("Endereco não encontrado"));

        enderecoExistente.setLogradouro(enderecoAtualizado.getLogradouro());
        enderecoExistente.setNumero(enderecoAtualizado.getNumero());
        enderecoExistente.setBairro(enderecoAtualizado.getBairro());
        enderecoExistente.setCidade(enderecoAtualizado.getCidade());
        enderecoExistente.setEstado(enderecoAtualizado.getEstado());
        

        return enderecoRepository.save(enderecoExistente);
    }

    public void excluir(Integer id) {

        Endereco endereco = buscarPorId(id);

        enderecoRepository.delete(endereco);
    }

}
