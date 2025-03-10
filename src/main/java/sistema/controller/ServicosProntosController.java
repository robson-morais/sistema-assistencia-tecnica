package sistema.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import sistema.SistemaAssistenciaTecnica;
import sistema.exceptions.PesquisaException;

public class ServicosProntosController implements ActionListener {
    private SistemaAssistenciaTecnica sistema;
    private JFrame janela;

    public ServicosProntosController (SistemaAssistenciaTecnica sistema, JFrame janela) {
        this.sistema = sistema;
        this.janela = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       try {
        JOptionPane.showMessageDialog(null, sistema.consultarServicosProntos());
        } catch (PesquisaException p) {
            p.printStackTrace();
            JOptionPane.showMessageDialog(null, p.getMessage());
        }
    }
}
