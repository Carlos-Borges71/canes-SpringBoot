/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.canes.controller;

import com.app.canes.model.Usuario;
import com.app.canes.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    private final UsuarioService usuarioService;

    public LoginController(
            UsuarioService usuarioService) {

        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    @ResponseBody
    public boolean login(
            @RequestParam String login,
            @RequestParam String senha,
            HttpSession session) {

        Usuario usuario
                = usuarioService.autenticar(
                        login,
                        senha);

        if (usuario != null) {

            session.setAttribute(
                    "usuarioLogado",
                    usuario);

            return true;
        }

        return false;
    }
}
