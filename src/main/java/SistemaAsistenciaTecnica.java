import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    //TODO
    public static void main(String[] args) throws CadastroException {
        Map<Integer, Encomenda> encomendas = new HashMap<>();
        SistemaAsistenciaTecnica sistema = new SistemaAsistenciaTecnica(encomendas);

        //todo: cadastraEncomenda
        Encomenda o = new Encomenda("Tablet Apple iPad Air 5", "conector danificado", "Robson");
        sistema.cadastrarEncomenda(o.getId(), o);
        System.out.println(o.toString());
        //sistema.cadastrarEncomenda(o.getId(), o); //Deve lançar exceção aqui.


        //todo:
    }
}
