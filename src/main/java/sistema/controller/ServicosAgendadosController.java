package sistema.controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sistema.SistemaAssistenciaTecnica;

public class ServicosAgendadosController implements ActionListener {
    private SistemaAssistenciaTecnica sistema;
    private JFrame janela;

    public ServicosAgendadosController(SistemaAssistenciaTecnica sistema, JFrame janela){
        this.sistema = sistema;
        this.janela = janela;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
            String status = "A fazer";
            JOptionPane.showMessageDialog(null, sistema.consultarServicosPorStatus(status));
    }
}
