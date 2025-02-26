import Exceptions.CadastroException;
import Exceptions.PesquisaException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SistemaAsistenciaTecnica {

    private Map<Integer, Encomenda> encomendas;

    SistemaAsistenciaTecnica(Map<Integer, Encomenda> encomendas){
        this.encomendas = encomendas;
    }

    public void cadastrarEncomenda (int id, Encomenda encomenda) throws CadastroException {
        if (!this.encomendas.containsKey(id)) {
            this.encomendas.put(id, encomenda);
            System.out.println("Encomenda " + id + " cadastrada com sucesso!");
        } else {
            throw new CadastroException("Encomenda já cadatrada no sistema");
        }
    }

    public void pesquisarParaAlterar (int pesquisaId, String novoStatus) throws PesquisaException {
        Encomenda encomendaEncontrada = this.encomendas.get(pesquisaId);
        if (this.encomendas.values().contains(encomendaEncontrada)) {
            encomendaEncontrada.setStatus(novoStatus);
        } else {
            throw new PesquisaException("Serviço não encontrado no sistema.");
        }

    }

    public String consultarServicosPendentes () throws PesquisaException {
        String txtAfazer = "============\n";
        if (!this.encomendas.isEmpty()) {
            for (Encomenda enc: this.encomendas.values()) {
                if (enc.getStatus().equalsIgnoreCase("A fazer")){
                    txtAfazer += enc.toString() + "\n==========\n";
                }
            } return txtAfazer;
        } else {
            throw new PesquisaException("Não há serviços pendentes no sistema.");
        }
    }

    public String consultarServicosProntos () throws PesquisaException {
        String txtFeito = "============\n";
        if (!this.encomendas.isEmpty()) {
            for (Encomenda enc: this.encomendas.values()) {
                if (enc.getStatus().equalsIgnoreCase("Feito")){
                    txtFeito+= enc.toString() + "\n";
                }
            } return txtFeito;
        } else {
            throw new PesquisaException("Nenhum serviço finalizado foi registrado no sistema ainda.");
        }
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

}
