/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.canes.model.dto;

import jakarta.validation.constraints.NotBlank;

public class UsuarioForm {

    private Integer id;

    @NotBlank(message = "Informe o nome")
    private String nome;
    @NotBlank(message = "Informe o telefone")
    private String telefone;
    @NotBlank(message = "Infome o setor")
    private String setor;
    @NotBlank(message = "Infome o login")
    private String login;
    @NotBlank(message = "Infome o senha")
    private String senha;
    @NotBlank(message = "Informe o logradouro")
    private String logradouro;
    @NotBlank(message = "Informe o numero")
    private String numero;
    @NotBlank(message = "Informe o bairro")
    private String bairro;
    @NotBlank(message = "Informe o cidade")
    private String cidade;
    @NotBlank(message = "Informe o estado")
    private String estado;
    @NotBlank(message = "Informe o cep")
    private String cep;

    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
