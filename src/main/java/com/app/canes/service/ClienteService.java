/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.canes.service;

import com.app.canes.model.Cliente;
import com.app.canes.model.Produto;





public class ClienteService {
    
     public void salvar(Cliente cliente) {

        if (cliente.getNome() == null ||
            cliente.getNome().isBlank()) {

            throw new RuntimeException("Nome obrigatório");
        }

           System.out.println("=== CLIENTE CADASTRADO ===");
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Telefone: " + cliente.getTelefone().getNumero());
        System.out.println("Cidade: " + cliente.getEndereco().getCidade());

        System.out.println("\nProdutos:");

        for (Produto produto : cliente.getProduto()) {

            System.out.println(
                    produto.getCodigo()
                    + " - "
                    + produto.getNome()
                    + " - R$ "
                    + produto.getValor()
            );
        }
    }
     
     

}
