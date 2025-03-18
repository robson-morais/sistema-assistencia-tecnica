package sistema;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import sistema.enums.Categoria;
import sistema.exceptions.CadastroException;
import sistema.exceptions.PesquisaException;
import sistema.SistemaAssistenciaTecnica;

import java.util.HashMap;
import java.util.Map;

public class AssistenciaTecnicaTest {

    private Map<String, Servico> encomendas;
    private SistemaAssistenciaTecnica sistema;

    @BeforeEach
    void setUp(){
        this.encomendas = new HashMap<>();
        this.sistema = new SistemaAssistenciaTecnica();
    }

    @Test
    public void testaCadastro() {
        Servico enc1 = new Servico("aparelho a", "descrição a",Categoria.MANUTENCAO, "12345678901");
        try {
            sistema.cadastrarEncomenda(enc1.getIdToString(), enc1);
        } catch (CadastroException c) {
            System.out.println(c.getMessage());
        }
    }
}
