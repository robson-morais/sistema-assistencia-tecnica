package sistema.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import sistema.Encomenda;
import sistema.SistemaAssistenciaTecnica;
import sistema.enums.Categoria;
import sistema.exceptions.CadastroException;

public class SistemaCadastroController implements ActionListener {
    private SistemaAssistenciaTecnica sistema;
    private JFrame janela;

    public SistemaCadastroController(SistemaAssistenciaTecnica sistema, JFrame janela) {
        this.sistema = sistema;
        this.janela = janela;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        String aparelho = JOptionPane.showInputDialog("Tipo de aparelho:\nex.: Celular, computador, tablet, ect.");
        String descricao = JOptionPane.showInputDialog("Descrição do Serviço:\nex.: troca de tela, formatação, troca de bateria, etc.)");
        String categoriaString = JOptionPane.showInputDialog("Categoria: ");
        Categoria categoria = sistema.stringToEnum(categoriaString);
        String id = JOptionPane.showInputDialog("CPF do cliente: ");
        while (id.length() != 11) {
            JOptionPane.showMessageDialog(null, "Formato de cpf inválido.\nO CPF precisa ter 11 dígitos (Apenas números).");
            id = JOptionPane.showInputDialog("CPF do cliente: ");
        }

        Encomenda encomenda = new Encomenda(aparelho, descricao, categoria, id);
        JOptionPane.showMessageDialog(null, "Encomenda registrada no sistema:\n" + encomenda.toString());
        try {
            sistema.cadastrarEncomenda(id, encomenda);
            System.out.println("OK!");
        } catch (CadastroException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
