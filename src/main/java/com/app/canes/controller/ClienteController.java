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
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

        System.out.println("Clientes encontrados: " + clientes.size());

        model.addAttribute("clientes", clientes);

        return "cliente";
    }

    @PostMapping("/salvar")
    public String salvar(ClienteForm form) {

        Telefone telefone
                = new Telefone(null, form.getTelefone());

        Endereco endereco
                = new Endereco(
                        null,
                        form.getLogradouro(),
                        form.getNumero(),
                        form.getBairro(),
                        form.getCidade(),
                        form.getEstado(),
                        form.getCep()
                );

        Cliente cliente
                = new Cliente(
                        null,
                        form.getNome(),
                        new Date(),
                        telefone,
                        endereco
                );

        service.salvar(cliente);

        return "redirect:/clientes";
    }
}
