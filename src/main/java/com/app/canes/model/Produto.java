package com.app.canes.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.text.NumberFormat;
import java.util.Locale;


/**
 *
 * @author Carlos Borges
 */
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int codigo;
    private String nome;
    private int estoque;

  
    private Double valor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Produto() {

    }

    public Produto(Integer id, int codigo, String nome, int estoque, Double valor) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.estoque = estoque;
        this.valor = valor;
    }

    public Double calcularValorTotalEstoque() {
        return valor * estoque;
    }

    @Transient
    public String getValorFormatado() {
        return NumberFormat
                .getCurrencyInstance(new Locale("pt", "BR"))
                .format(valor);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
