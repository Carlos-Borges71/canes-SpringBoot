/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.canes.service;

import com.app.canes.model.Usuario;
import com.app.canes.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carlos Borges
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {

        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorId(Integer id) {

        return usuarioRepository.findById(id)
                .orElseThrow(()
                        -> new RuntimeException("usuario não encontrado"));
    }

    public List<Usuario> listarTodos() {

        return usuarioRepository.findAll();
    }

    public Usuario atualizar(Integer id, Usuario usuarioAtualizado) {

        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(()
                        -> new RuntimeException("produto não encontrado"));

        usuarioExistente.setNome(usuarioAtualizado.getNome());
        usuarioExistente.setSetor(usuarioAtualizado.getSetor());
        usuarioExistente.setLogin(usuarioAtualizado.getSetor());
        usuarioExistente.setSenha(usuarioAtualizado.getSenha());

        return usuarioRepository.save(usuarioExistente);
    }

    public void excluir(Integer id) {

        Usuario endereco = buscarPorId(id);

        usuarioRepository.delete(endereco);
    }
}
