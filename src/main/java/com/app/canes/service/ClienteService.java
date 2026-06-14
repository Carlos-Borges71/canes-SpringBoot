/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.canes.service;


import com.app.canes.model.Cliente;
import com.app.canes.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;




@Service
public class ClienteService {
    
    
    @Autowired
    private ClienteRepository clienteRepository;

    

    public Cliente salvar(Cliente cliente) {

        return clienteRepository.save(cliente);
    }

    public Cliente buscarPorId(Integer id) {

        return clienteRepository.findById(id)
                .orElseThrow(()
                        -> new RuntimeException("Cliente não encontrado"));
    }

    public List<Cliente> listarTodos() {

        return clienteRepository.findAll( 
                Sort.by(Sort.Direction.DESC, "id"
                ));
    }

    public Cliente atualizar(Integer id, Cliente clienteAtualizado) {

        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(()
                        -> new RuntimeException("Cliente não encontrado"));

        clienteExistente.setNome(clienteAtualizado.getNome());
        clienteExistente.setTelefone(clienteAtualizado.getTelefone());
        clienteExistente.setEndereco(clienteAtualizado.getEndereco());

        return clienteRepository.save(clienteExistente);
    }

    public void excluir(Integer id) {

        Cliente cliente = buscarPorId(id);

        clienteRepository.delete(cliente);
    }

}
