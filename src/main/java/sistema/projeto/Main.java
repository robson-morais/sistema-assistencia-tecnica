package sistema.projeto;

import sistema.projeto.exceptions.CadastroException;
import sistema.projeto.exceptions.PesquisaException;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws CadastroException {
        Map<Integer, Encomenda> encomendas = new HashMap<>();
        SistemaAsistenciaTecnica sistema = new SistemaAsistenciaTecnica(encomendas);

        boolean sair = false;
        int contador = 0;

        while (!sair) {
            contador = Integer.parseInt(JOptionPane.showInputDialog("Gerenciamento de Atendimentos:\n1. Cadastrar serviço;\n2. Consultar serviços agendados;\n3. Consultar serviços prontos\n4. Alterar status de serviço\n5. Sair"));
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
                case 2: // Consultar serviços agendados:
                    try {
                        JOptionPane.showMessageDialog(null, sistema.consultarServicosPendentes());
                    } catch (PesquisaException p) {
                        p.printStackTrace();
                        JOptionPane.showMessageDialog(null, p.getMessage());
                    }
                    break;
                case 3: // Consultar serviços prontos:
                    try {
                        JOptionPane.showMessageDialog(null, sistema.consultarServicosProntos());
                    } catch (PesquisaException p) {
                        p.printStackTrace();
                        JOptionPane.showMessageDialog(null, p.getMessage());
                    }
                    break;
                case 4: // Alterar status de serviço:
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
                case 5:
                    sair = true;
                    break;
                case 6:
                    System.out.println(encomendas.toString());
            }
        }
    }
}
