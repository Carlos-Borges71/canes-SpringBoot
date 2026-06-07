package com.app.canes;

import com.app.canes.model.Cliente;
import com.app.canes.model.Endereco;
import com.app.canes.model.Produto;
import com.app.canes.model.Telefone;
import com.app.canes.service.ClienteService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CanesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CanesApplication.class, args);
                
                
                
                 Telefone telefone = new Telefone(
                null,
                "(21)99999-9999"
        );

        Endereco endereco = new Endereco(
                null,
                "Rua das Flores",
                "100",
                "Centro",
                "Rio de Janeiro",
                "RJ",
                "20000-000"
        );

        Produto produto1 = new Produto(
                1,
                1001,
                "Camiseta",
                10,
                59.90
        );

        Produto produto2 = new Produto(
                2,
                1002,
                "Calça Jeans",
                5,
                129.90
        );

        List<Produto> produtos = new ArrayList<>();
        produtos.add(produto1);
        produtos.add(produto2);

        Cliente cliente = new Cliente(
                1,
                "Julio Black",
                new Date(),
                telefone,
                endereco
        );

        cliente.setProduto(produtos);

        
        
        
        
        ClienteService clienteService = new ClienteService();
        
        
        clienteService.salvar(cliente);
        
        
        
        
	}
        
        
}
