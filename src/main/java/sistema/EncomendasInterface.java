package sistema;

import sistema.exceptions.CadastroException;
import sistema.exceptions.PesquisaException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EncomendasInterface {
    void cadastrarEncomenda (String id, Encomenda encomenda) throws CadastroException;
    void pesquisarParaAlterar (String id, String novoStatus) throws PesquisaException;
    List<Encomenda> consultarServicosPendentes () throws PesquisaException;
    List<Encomenda> consultarServicosProntos () throws PesquisaException;
    void salvarDados(Map<String, Encomenda> encomendas) throws IOException;
    void recuperarDados() throws IOException;
}
