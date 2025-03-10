package sistema.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import sistema.SistemaAssistenciaTecnica;
import sistema.exceptions.PesquisaException;

public class AlterarStatusController implements ActionListener {
    private SistemaAssistenciaTecnica sistema;
    private JFrame janelaPrincipal;

    public AlterarStatusController (SistemaAssistenciaTecnica sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pesquisando = JOptionPane.showInputDialog("Digite o CPF do cliente ");
        if (sistema.existe(pesquisando)) {
            String novoStatus = JOptionPane.showInputDialog("Digite o novo status para este registro de encomenda: ");
           try {
                sistema.pesquisarParaAlterar(pesquisando, novoStatus);
            } catch (PesquisaException p) {
                p.printStackTrace();
                JOptionPane.showMessageDialog(null, p.getMessage());
            }
        }
    }
}
