package sistema.projeto;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import sistema.projeto.exceptions.CadastroException;
import sistema.projeto.exceptions.PesquisaException;

import java.util.HashMap;
import java.util.Map;

public class AssistenciaTecnicaTest {

    @Test
    public void testaSistema() {
        Map<Integer, Encomenda> encomendas = new HashMap<>();
        SistemaAsistenciaTecnica sistema = new SistemaAsistenciaTecnica(encomendas);

        try {
            // Cadastro:
            sistema.cadastrarEncomenda(11, new Encomenda("Robson", "iPhone 6s", "Troca de tela", Categoria.MANUTENCAO, 11));
            // Pesquisar serviços pendentes:
            sistema.consultarServicosPendentes();
            // Altera status de serviço;
            sistema.pesquisarParaAlterar(11,"Feito");
        } catch (PesquisaException | CadastroException c) {
            c.printStackTrace();
        }
    }

}
