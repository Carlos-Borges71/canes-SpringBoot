/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.canes.service;

import com.app.canes.model.Telefone;
import com.app.canes.repository.TelefoneRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carlos Borges
 */
@Service
public class TelefoneService {
  
   @Autowired
    private TelefoneRepository telefoneRepository;

    

    public Telefone salvar(Telefone produto) {

        return telefoneRepository.save(produto);
    }

    public Telefone buscarPorId(Integer id) {

        return telefoneRepository.findById(id)
                .orElseThrow(()
                        -> new RuntimeException("Cliente não encontrado"));
    }

    public List<Telefone> listarTodos() {

        return telefoneRepository.findAll();
    }

    public Telefone atualizar(Integer id, Telefone telefoneAtualizado) {

        Telefone telefoneExistente = telefoneRepository.findById(id)
                .orElseThrow(()
                        -> new RuntimeException("Telefone não encontrado"));

        telefoneExistente.setNumero(telefoneAtualizado.getNumero());
       
        

        return telefoneRepository.save(telefoneExistente);
    }

    public void excluir(Integer id) {

        Telefone telefone = buscarPorId(id);

        telefoneRepository.delete(telefone);
    }
}
