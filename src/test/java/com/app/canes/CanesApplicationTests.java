package com.app.canes;

import com.app.canes.model.Produto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
    
//     @Test
//    void deveValidarNomeCliente() {
//
//        ClienteService service = new ClienteService();
//
//        assertTrue(
//                service.validarNome("Carlos")
//        );
//    }
//
//    @Test
//    void naoDeveValidarNomeVazio() {
//
//        ClienteService service = new ClienteService();
//
//        assertFalse(
//                service.validarNome("")
//        );
//    }

}
