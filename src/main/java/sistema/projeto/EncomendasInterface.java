package sistema.projeto;

import sistema.projeto.exceptions.CadastroException;
import sistema.projeto.exceptions.PesquisaException;

public interface EncomendasInterface {
    void cadastrarEncomenda (int id, Encomenda encomenda) throws CadastroException;
    void pesquisarParaAlterar (int id, String novoStatus) throws PesquisaException;
    String consultarServicosPendentes () throws PesquisaException;
    String consultarServicosProntos () throws PesquisaException;
}
