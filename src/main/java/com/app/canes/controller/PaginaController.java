/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.canes.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Carlos Borges
 */
@Controller
public class PaginaController {

    @GetMapping("/")
    public String inicio() {
        return "login";
    }

    @GetMapping("/cadastro_cliente")
    public String cadastro_cliente() {
        return "cliente-cadastro";
    }

    @GetMapping("/cadastro_usuario")
    public String cadastro_usuario() {
        return "usuario-cadastro";
    }

    @GetMapping("/cadastro_produto")
    public String cadastro_produto() {
        return "cadastro-produto";
    }

    @GetMapping("/menu")
    public String menu() {

        return "menu";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate(); // remove usuário da sessão

        return "redirect:/";
    }
}
