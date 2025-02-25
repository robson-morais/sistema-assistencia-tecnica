import Exceptions.CadastroException;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws CadastroException {
        Map<Integer, Encomenda> encomendas = new HashMap<>();
        SistemaAsistenciaTecnica sistema = new SistemaAsistenciaTecnica(encomendas);

        //todo: cadastraEncomenda
        Encomenda o = new Encomenda("Tablet Apple iPad Air 5", "Robson", "conector danificado");
        Encomenda a = new Encomenda ("iPhone 11", "Numb", "Pelicula");
        System.out.println(o.getId());
        System.out.println(a.getId());

    }
}
