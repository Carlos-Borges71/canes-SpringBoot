/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.canes.controller;

import com.app.canes.model.Endereco;
import com.app.canes.model.Telefone;
import com.app.canes.model.Usuario;
import com.app.canes.model.dto.UsuarioForm;
import com.app.canes.service.UsuarioService;
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
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public String listarUsuario(Model model) {

        List<Usuario> usuarios = service.listarTodos();
        model.addAttribute("usuarios", usuarios);

        return "usuario";
    }   
    

    @PostMapping("/salvar")
   public String salvar(
        @Valid UsuarioForm form,
        BindingResult result) {

    if (result.hasErrors()) {
        return "usuario-cadastro";
    }
        
        Usuario usuario;

        if (form.getId() != null) {

            usuario = service.buscarPorId(form.getId());

        } else {

            usuario = new Usuario();
            usuario.setData(new Date());

            if (usuario.getTelefone() == null) {
                usuario.setTelefone(new Telefone());
            }

            if (usuario.getEndereco() == null) {
                usuario.setEndereco(new Endereco());
            }
        }

        usuario.setNome(form.getNome());
        usuario.setLogin(form.getLogin());
        usuario.setSetor(form.getSetor());
        usuario.setSenha(form.getSenha());

        usuario.getTelefone().setNumero(form.getTelefone());

        usuario.getEndereco().setLogradouro(form.getLogradouro());
        usuario.getEndereco().setNumero(form.getNumero());
        usuario.getEndereco().setBairro(form.getBairro());
        usuario.getEndereco().setCidade(form.getCidade());
        usuario.getEndereco().setEstado(form.getEstado());
        usuario.getEndereco().setCep(form.getCep());

        service.salvar(usuario);

        return "redirect:/usuarios";
    }
    
    @GetMapping("/editar/{id}") 
    public String editar(@PathVariable Integer id, Model model) { 
        
        Usuario usuario = service.buscarPorId(id);         
        model.addAttribute("usuario", usuario); 
        return "usuario-cadastro"; 
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) {

        service.excluir(id);

        return "redirect:/usuarios";
    }

}
