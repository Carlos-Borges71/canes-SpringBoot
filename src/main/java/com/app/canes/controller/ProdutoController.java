/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.canes.controller;

import com.app.canes.model.Produto;
import com.app.canes.model.dto.ProdutoForm;
import com.app.canes.service.ProdutoService;
import jakarta.validation.Valid;
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
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public String listarProdutos(Model model) {

        List<Produto> produtos = service.listarTodos();
        model.addAttribute("produtos", produtos);

        return "produto";
    }

    @PostMapping("/salvar")
    public String salvar(
            @Valid ProdutoForm form,
            BindingResult result) {

        if (result.hasErrors()) {
            result.getAllErrors()
                    .forEach(System.out::println);
            return "cadastro-produto";
        }

        Produto produto;

        if (form.getId() != null) {

            produto = service.buscarPorId(form.getId());
        } else {
            produto = new Produto();
        }

        Double valor = Double.parseDouble(
                form.getValor()
                        .replace("R$", "")
                        .replace(".", "")
                        .replace(",", ".")
                        .trim()
        );

        produto.setNome(form.getNome());
        produto.setCodigo(form.getCodigo());
        produto.setEstoque(form.getEstoque());
        produto.setValor(valor);

        service.salvar(produto);

        return "redirect:/produtos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {

        Produto produto = service.buscarPorId(id);
        model.addAttribute("produto", produto);
        return "cadastro-produto";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) {

        service.excluir(id);

        return "redirect:/produtos";
    }

}
