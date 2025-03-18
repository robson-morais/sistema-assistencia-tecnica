package sistema;

import sistema.exceptions.CadastroException;
import sistema.exceptions.PesquisaException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EncomendasInterface {
    void cadastrarEncomenda (String id, Servico encomenda) throws CadastroException;
    void pesquisarParaAlterar (String id, String novoStatus) throws PesquisaException;
    List<Servico> consultarServicosPendentes () throws PesquisaException;
    List<Servico> consultarServicosProntos () throws PesquisaException;
    
    void salvarDados(Map<String, Servico> encomendas) throws IOException;
    void recuperarDados() throws IOException;
}
