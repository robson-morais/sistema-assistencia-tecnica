import Exceptions.CadastroException;

import java.util.Map;

public class SistemaAsistenciaTecnica {

    private Map<Integer, Encomenda> encomendas;

    SistemaAsistenciaTecnica(Map<Integer, Encomenda> encomendas){
        this.encomendas = encomendas;
    }

    public void cadastrarEncomenda (Integer id, Encomenda encomenda) throws CadastroException {
        if (!this.encomendas.containsKey(id)) {
            this.encomendas.put(id, encomenda);
        } else {
            throw new CadastroException("Encomenda já cadatrada no sistema");
        }
    }

}
