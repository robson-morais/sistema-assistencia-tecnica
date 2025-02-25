import Exceptions.CadastroException;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws CadastroException {
        Map<String, Encomenda> encomendas = new HashMap<>();
        SistemaAsistenciaTecnica sistema = new SistemaAsistenciaTecnica(encomendas);

        Encomenda o = new Encomenda("Tablet Apple iPad Air 5", "Robson", "conector danificado");
        Encomenda a = new Encomenda ("iPhone 11", "Numb", "Pelicula");

        //todo: cadastraEncomenda
        try {
            sistema.cadastrarEncomenda(o.getId(), o);
            sistema.cadastrarEncomenda(a.getId(), a);
        } catch (CadastroException e) {
            e.printStackTrace();
        }

        System.out.println(o.getId());
        System.out.println(a.getId());

        JOptionPane.showInputDialog("Gerenciamento de Atendimentos:\n1. Cadastrar serviço;\n2. Consultar serviços agendados;\n3. Consultar serviços prontos\n4. Sair");
    }
}
