import Exceptions.CadastroException;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class AssistenciaTecnicaTest {

    private SistemaAsistenciaTecnica sistema;
    private Map<String, Encomenda> encomendas;

    @BeforeEach
    void setUp() {
        this.encomendas = new HashMap<>();
        this.sistema = new SistemaAsistenciaTecnica(encomendas);
    }

    @Test
    public void testaCadastro() {


        Encomenda o = new Encomenda("iPhone 5", "Reparo tela", "Robsohjhn");

        Encomenda o2 = new Encomenda("iPhone 5", "Reparo tela", "Robsohjhn");
        //assertThrows(CadastroException.class, ()-> sistema.cadastrarEncomenda("));

    }

}
