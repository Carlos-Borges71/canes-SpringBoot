/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.canes.advice;

import com.app.canes.model.Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute
    public void adicionarUsuario(
            HttpSession session,
            Model model) {

        Usuario usuario
                = (Usuario) session.getAttribute(
                        "usuarioLogado");

        model.addAttribute(
                "usuarioLogado",
                usuario);
    }
}
