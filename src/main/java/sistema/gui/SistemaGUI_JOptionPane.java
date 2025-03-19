package sistema.gui;

import sistema.Servico;
import sistema.GravadorDeDados;
import sistema.SistemaAssistenciaTecnica;
import sistema.enums.Categoria;
import sistema.exceptions.CadastroException;
import sistema.exceptions.PesquisaException;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SistemaGUI_JOptionPane {
    public static void main(String[] args) {

        Map<String, Servico> encomendas = new HashMap<>();
        SistemaAssistenciaTecnica sistema = new SistemaAssistenciaTecnica(encomendas);
        GravadorDeDados gravador = new GravadorDeDados();

        boolean dadosSalvos = false;
        
        try {
            encomendas = gravador.recuperarDados();
            dadosSalvos = true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        

        boolean sair = false;
        int contador = 0;

        while (!sair) {

            // A String 'MensagemMenu' informa se os dados da última sessão foram salvos e
            // o texto contido nela depende do valor da booleana 'dadosSalvos'.
            String mensagemMenu = "o gravador de dados não conseguiu salvar os dados no sistema.";

            if (dadosSalvos)
                mensagemMenu = "Os dados do sistema estão atualizados";

            contador = Integer.parseInt(JOptionPane.showInputDialog("[Informação: " + mensagemMenu + "]\n\nGERECIAMENTO DE ATENDIMENTOS:\n\n1. Cadastrar serviço;\n2. Listar todos os serviços encomendados;\n3. Consultar serviços agendados;\n4. Consultar serviços prontos\n5. Alterar status de serviço\n6. Sair"));
            switch (contador) {
                case 1: //Cadastrar serviço:
                    String aparelho = JOptionPane.showInputDialog("Tipo de aparelho:\nex.: Celular, computador, tablet, ect.");
                    String descricao = JOptionPane.showInputDialog("Descrição do Serviço:\nex.: troca de tela, formatação, troca de bateria, etc.)");
                    String categoriaString = JOptionPane.showInputDialog("Categoria: ");
                    Categoria categoria = sistema.stringToEnum(categoriaString);
                    String id = JOptionPane.showInputDialog("CPF do cliente: ");
                    while (id.length() != 11) {
                        JOptionPane.showMessageDialog(null, "Formato de cpf inválido.\nO CPF precisa ter 11 dígitos (Apenas números).");
                        id = JOptionPane.showInputDialog("CPF do cliente: ");
                    }

                    Servico encomenda = new Servico(aparelho, descricao, categoria, id);
                    JOptionPane.showMessageDialog(null, "Encomenda registrada no sistema:\n" + encomenda.toString());
                    try {
                        sistema.cadastrarEncomenda(id, encomenda);
                        System.out.println("OK!");
                    } catch (CadastroException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;

                case 2: // Exibir todas as encomendas:
                    JOptionPane.showMessageDialog(null, sistema.getServicosString());
                    break;

                case 3: // Consultar serviços agendados:
                    JOptionPane.showMessageDialog(null, sistema.consultarServicosPorStatus("A fazer"));
                    break;

                case 4: // Consultar serviços prontos:
                    JOptionPane.showMessageDialog(null, sistema.consultarServicosPorStatus("Pronto"));
                    break;

                case 5: // TODO: Alterar status de serviço:
                    String pesquisando = JOptionPane.showInputDialog("Digite o CPF do cliente ");
                    String novoStatus = JOptionPane.showInputDialog("Digite o novo status para este registro de encomenda: ");
                        try {
                            sistema.pesquisarParaAlterar(pesquisando, novoStatus);
                        } catch (PesquisaException p) {
                            p.printStackTrace();
                            JOptionPane.showMessageDialog(null, p.getMessage());
                        }

                    break;
                    
                case 6:
                    try {
                        sistema.salvarDados();
                        JOptionPane.showMessageDialog(null, "Dados salvos no sistema!");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    sair = true;
                    break;
            }
        }
    }
}
