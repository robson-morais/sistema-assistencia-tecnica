package sistema.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import sistema.SistemaAssistenciaTecnica;

public class ListarTudoController implements ActionListener {
    private SistemaAssistenciaTecnica sistema;
    private JFrame janelaPrincipal;

    public ListarTudoController(SistemaAssistenciaTecnica sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
            JOptionPane.showMessageDialog(null, sistema.listarTodasAsEncomendas());
    }

}
