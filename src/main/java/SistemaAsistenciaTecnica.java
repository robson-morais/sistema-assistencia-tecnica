import Exceptions.CadastroException;

import java.util.Map;

public class SistemaAsistenciaTecnica {

    private Map<String, Encomenda> encomendas;

    SistemaAsistenciaTecnica(Map<String, Encomenda> encomendas){
        this.encomendas = encomendas;
    }

    public void cadastrarEncomenda (String id, Encomenda encomenda) throws CadastroException {
        if (!this.encomendas.containsKey(id)) {
            this.encomendas.put(id, encomenda);
            System.out.println("Encomenda " + id + " cadastrada com sucesso!");
        } else {
            throw new CadastroException("Encomenda já cadatrada no sistema");
        }
    }

}
