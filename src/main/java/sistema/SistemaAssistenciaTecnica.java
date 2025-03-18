package sistema;

import sistema.enums.Categoria;
import sistema.exceptions.CadastroException;
import sistema.exceptions.PesquisaException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAssistenciaTecnica implements EncomendasInterface {

    private Map<String, Servico> encomendas;
    private GravadorDeDados gravador;

    public SistemaAssistenciaTecnica(){
        this.encomendas = new HashMap<>();
        this.gravador = new GravadorDeDados();
    }

    public void cadastrarEncomenda (String id, Servico encomenda) throws CadastroException {
        if (!this.encomendas.containsKey(id)) {
            this.encomendas.put(id, encomenda);
            System.out.println("sistema.projeto.Encomenda " + id + " cadastrada com sucesso!");
        } else {
            throw new CadastroException("sistema.projeto.Encomenda já cadatrada no sistema");
        }
    }

    public List<Servico> listarTodasAsEncomendas() {
        List<Servico> encomendasList = new ArrayList<>();
        for (Servico en: this.encomendas.values()) {
            encomendasList.add(en);
        } return encomendasList;
    }

    public void pesquisarParaAlterar (String pesquisaId, String novoStatus) throws PesquisaException {
        Servico encomendaEncontrada = this.encomendas.get(pesquisaId);
        if (encomendaEncontrada != null) {
            encomendaEncontrada.setStatus(novoStatus);
        } else {
            throw new PesquisaException("Serviço não encontrado no sistema.");
        }
    }


    public List<Servico> consultarServicosPorStatus(String status) {

        List<Servico> servicosComStatus = new ArrayList<>();
        if (!this.encomendas.isEmpty()) {
            for (Servico servico: this.encomendas.values()) {
                if (servico.getStatus().equalsIgnoreCase(status))
                servicosComStatus.add(servico);
            }
        }
        return servicosComStatus;
    }

    @Override
    public void salvarDados() throws IOException {
        this.gravador.salvarDados(encomendas);
    }

    @Override
    public void recuperarDados() throws IOException {
        this.encomendas = this.gravador.recuperarDados();
    }

    // Necessária apenas para converter String em Enum
    public Categoria stringToEnum (String categoriaString) {
        Categoria ctg = null;
        for (Categoria cat: Categoria.values()) {
            if (categoriaString.toUpperCase().equals(cat.name())) {
                ctg = cat;
            }
        } return ctg;
    }

    public Map<String, Servico> getEncomendas() {
        return this.encomendas;
    }

    public boolean existe(String id) {
        return this.encomendas.containsKey(id);
    }

}
