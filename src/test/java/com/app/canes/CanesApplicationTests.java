package com.app.canes;

import com.app.canes.model.Cliente;
import com.app.canes.model.Produto;
import com.app.canes.model.Usuario;
import com.app.canes.model.dto.ProdutoForm;
import com.app.canes.repository.UsuarioRepository;
import com.app.canes.service.UsuarioService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.util.Optional;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class CanesApplicationTests {

    @Test
    void deveCalcularValorTotalDoEstoque() {

        Produto produto = new Produto();

        produto.setValor(50.0);
        produto.setEstoque(10);

        Double total = produto.calcularValorTotalEstoque();

        assertEquals(500.0, total);
    }

    private final Validator validator
            = Validation.buildDefaultValidatorFactory()
                    .getValidator();

    @Test
    void naoDevePermitirNomeVazio() {

        ProdutoForm form = new ProdutoForm();

        form.setNome("");

        Set<ConstraintViolation<ProdutoForm>> erros
                = validator.validate(form);

        assertFalse(erros.isEmpty());
    }

    @Test
    void deveCadastrarCliente() {

        Cliente cliente = new Cliente();

        cliente.setNome("Carlos");

        assertEquals(
                "Carlos",
                cliente.getNome()
        );
    }

    @Autowired
    private UsuarioService service;

    @Test
    void loginInvalidoDeveRetornarNull() {

        Usuario usuario
                = service.autenticar(
                        "teste",
                        "senhaerrada");

        assertNull(usuario);
    }

    @Test
    void deveCriarProduto() {

        Produto produto
                = new Produto();

        produto.setNome("Notebook");

        assertEquals(
                "Notebook",
                produto.getNome()
        );
    }

    @Autowired
    private UsuarioRepository repository;

    @Test
    void deveBuscarUsuarioPorLoginESenha() {

        Usuario usuario
                = new Usuario();

        usuario.setLogin("adminTest");
        usuario.setSenha("123");

        repository.save(usuario);

        Optional<Usuario> resultado
                = repository.findByLoginAndSenha(
                        "adminTest",
                        "123");

        assertTrue(resultado.isPresent());
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveAbrirTelaClientes()
            throws Exception {

        Usuario usuario = new Usuario();

        usuario.setNome("Administrador");
        usuario.setSetor("ADMIN");

        mockMvc.perform(
                get("/clientes")
                        .sessionAttr(
                                "usuarioLogado",
                                usuario)
        )
                .andExpect(status().isOk());
    }
}
