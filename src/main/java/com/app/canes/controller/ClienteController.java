/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.canes.controller;

import com.app.canes.model.Cliente;
import com.app.canes.model.Endereco;
import com.app.canes.model.Telefone;
import com.app.canes.model.dto.ClienteForm;
import com.app.canes.service.ClienteService;
import jakarta.validation.Valid;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Carlos Borges
 */
@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public String listarClientes(Model model) {

        List<Cliente> clientes = service.listarTodos();
        model.addAttribute("clientes", clientes);

        return "cliente";
    }

    @PostMapping("/salvar")
   public String salvar(
        @Valid ClienteForm form,
        BindingResult result) {

    if (result.hasErrors()) {
        return "cliente-cadastro";
    }
        
        Cliente cliente;

        if (form.getId() != null) {

            cliente = service.buscarPorId(form.getId());

        } else {

            cliente = new Cliente();
            cliente.setData(new Date());

            if (cliente.getTelefone() == null) {
                cliente.setTelefone(new Telefone());
            }

            if (cliente.getEndereco() == null) {
                cliente.setEndereco(new Endereco());
            }
        }

        cliente.setNome(form.getNome());

        cliente.getTelefone().setNumero(form.getTelefone());

        cliente.getEndereco().setLogradouro(form.getLogradouro());
        cliente.getEndereco().setNumero(form.getNumero());
        cliente.getEndereco().setBairro(form.getBairro());
        cliente.getEndereco().setCidade(form.getCidade());
        cliente.getEndereco().setEstado(form.getEstado());
        cliente.getEndereco().setCep(form.getCep());

        service.salvar(cliente);

        return "redirect:/clientes";
    }
    
    @GetMapping("/editar/{id}") 
    public String editar(@PathVariable Integer id, Model model) { 
        
        Cliente cliente = service.buscarPorId(id);         
        model.addAttribute("cliente", cliente); 
        return "cliente-cadastro"; 
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) {

        service.excluir(id);

        return "redirect:/clientes";
    }

}
