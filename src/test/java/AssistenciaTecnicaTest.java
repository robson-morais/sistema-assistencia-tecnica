import Exceptions.CadastroException;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class AssistenciaTecnicaTest {

    private SistemaAsistenciaTecnica sistema;
    private Map<Integer, Encomenda> encomendas;

    @BeforeEach
    void setUp() {
        this.encomendas = new HashMap<>();
        this.sistema = new SistemaAsistenciaTecnica(encomendas);
    }

    @Test
    public void testaCadastro() {

    }

}
