import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.util.Map;
import static org.junit.Assert.*;

public class AssistenciaTecnicaTest {

    private SistemaAsistenciaTecnica sistema;
    private Map<Integer, Encomenda> encomendas;

    @BeforeEach
    void setUp() {
        this.sistema = new SistemaAsistenciaTecnica(encomendas);
    }

    @Test
    public void testaCadastro() throws IOException {
        Encomenda o = new Encomenda("iPhone 5", "Reparo tela", "Robsohjhn");
        assertEquals("iPhone 5", o.getAparelho());
    }

}
