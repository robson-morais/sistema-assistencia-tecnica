package sistema;

import sistema.exceptions.CadastroException;
import sistema.exceptions.PesquisaException;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Integer, Encomenda> encomendas = new HashMap<>();
        SistemaAsistenciaTecnica sistema = new SistemaAsistenciaTecnica(encomendas);

        /*GravadorDeDados gravador = new GravadorDeDados();

        boolean dadosSalvos = false;

        try {
            encomendas = gravador.recuperarDados();
            dadosSalvos = true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        boolean sair = false;
        int contador = 0;

        while (!sair) {

            // A String 'MensagemMenu' informa se os dados da última sessão foram salvos e
            // o texto contido nela depende do valor da booleana 'dadosSalvos'.
            String mensagemMenu = "(o gravador de dados não conseguiu salvar os dados no sistema)";
            /*
            if (dadosSalvos){
                mensagemMenu = "Os dados do sistema estão atualizados";
            }*/

            contador = Integer.parseInt(JOptionPane.showInputDialog("[Informação: " + mensagemMenu + "]\n\nGERECIAMENTO DE ATENDIMENTOS:\n\n1. Cadastrar serviço;\n2. Listar todos os serviços encomendados;\n3. Consultar serviços agendados;\n4. Consultar serviços prontos\n5. Alterar status de serviço\n6. Sair"));
            switch (contador) {
                case 1: //Cadastrar serviço:
                    String cliente =  JOptionPane.showInputDialog("Nome do cliente: ");
                    String aparelho = JOptionPane.showInputDialog("Tipo de aparelho: ");
                    String descricao = JOptionPane.showInputDialog("Descrição do Serviço: ");
                    String categoriaString = JOptionPane.showInputDialog("Categoria: ");
                    Categoria categoria = sistema.stringToEnum(categoriaString);
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Id: "));

                    Encomenda encomenda = new Encomenda(cliente, aparelho, descricao, categoria, id);
                    JOptionPane.showMessageDialog(null, encomenda.toString());
                    try {
                        sistema.cadastrarEncomenda(id, encomenda);
                        System.out.println("OK!");
                    } catch (CadastroException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;

                case 2: // Exibir todas as encomendas:
                    JOptionPane.showMessageDialog(null, encomendas.toString());
                    break;

                case 3: // Consultar serviços agendados:
                    try {
                        JOptionPane.showMessageDialog(null, sistema.consultarServicosPendentes());
                    } catch (PesquisaException p) {
                        p.printStackTrace();
                        JOptionPane.showMessageDialog(null, p.getMessage());
                    }
                    break;

                case 4: // Consultar serviços prontos:
                    try {
                        JOptionPane.showMessageDialog(null, sistema.consultarServicosProntos());
                    } catch (PesquisaException p) {
                        p.printStackTrace();
                        JOptionPane.showMessageDialog(null, p.getMessage());
                    }
                    break;

                case 5: // Alterar status de serviço:
                    int pesquisando = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do registro: "));
                    if (encomendas.containsKey(pesquisando)) {
                        System.out.println(encomendas.get(pesquisando).toString());
                        String novoStatus = JOptionPane.showInputDialog("Digite o novo status para este registro: ");
                        try {
                            sistema.pesquisarParaAlterar(pesquisando, novoStatus);
                        } catch (PesquisaException p) {
                            p.printStackTrace();
                            JOptionPane.showMessageDialog(null, p.getMessage());
                        }
                    }
                    break;

                case 6:
                    /*try {
                        sistema.salvarDados(encomendas);
                        JOptionPane.showMessageDialog(null, "Dados salvos no sistema!");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }*/
                    sair = true;
                    break;
            }
        }
    }
}
