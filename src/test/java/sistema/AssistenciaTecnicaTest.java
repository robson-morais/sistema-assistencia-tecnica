package sistema;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import sistema.exceptions.CadastroException;
import sistema.exceptions.PesquisaException;

import java.util.HashMap;
import java.util.Map;

public class AssistenciaTecnicaTest {

    private Map<Integer, Encomenda> encomendas;
    private SistemaAsistenciaTecnica sistema;

    @BeforeEach
    void setUp(){
        this.encomendas = new HashMap<>();
        this.sistema = new SistemaAsistenciaTecnica(encomendas);
    }

    @Test
    public void testaCadastro() {
        Encomenda enc1 = new Encomenda("cliente a", "aparelho a", "descrição a",Categoria.MANUTENCAO,11);
        try {
            sistema.cadastrarEncomenda(enc1.getId(), enc1);
        } catch (CadastroException c) {
            System.out.println(c.getMessage());
        }
    }
}
