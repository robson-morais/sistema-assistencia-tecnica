package sistema.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPanel;

import sistema.SistemaAssistenciaTecnica;
import sistema.*;
import sistema.controller.AlterarStatusController;
import sistema.controller.ListarTudoController;
import sistema.controller.ServicosAgendadosController;
import sistema.controller.ServicosProntosController;
import sistema.controller.SistemaCadastroController;

public class SistemaGUI_JFrame extends JFrame {
    JLabel linha1, linha2, linha3;
    //ImageIcon imagem = new ImageIcon("/home/r0bstark/IdeaProjects/sistema-assistencia-tecnica/Resources/Imagens/blur.jpeg");
    ImageIcon imagem = new ImageIcon("Resources/Imagens/blur.jpeg");

    JButton botaoCadastro, botaoListarTudo, botaoAfazer, botaoProntos, botaoAlterar;

    SistemaAssistenciaTecnica sistema = new SistemaAssistenciaTecnica();

    public SistemaGUI_JFrame() {
        setTitle("Gerenciamento de Encomendas");
        setSize(1280, 720);
        setLocation(0, 0);
        setResizable(true); 

        linha2 = new JLabel(imagem);
        linha2.setBounds(0, 0, 1280, 720);
        linha3 = new JLabel("GERENCIAMENTO DE SERVIÇOS", JLabel.CENTER);
        linha3.setForeground(Color.WHITE);
        linha3.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 24));


        // Criar painel para os botões (com fundo transparente)
        JPanel painelBotoes = new JPanel();
        painelBotoes.setOpaque(false); // Mantém o fundo transparente
        painelBotoes.setLayout(new GridLayout(6, 1, 10, 10)); // Organiza os botões verticalmente
        painelBotoes.setBounds(450, 230, 400, 230); // Centraliza os botões
        
        botaoCadastro = new JButton("Cadastrar serviço");
        botaoCadastro.addActionListener(new SistemaCadastroController(sistema, this));

        botaoListarTudo = new JButton("Listar todos os serviços registrados");
        botaoListarTudo.addActionListener(new ListarTudoController(sistema, this));

        botaoAfazer = new JButton("Consultar serviços agendados");
        botaoAfazer.addActionListener(new ServicosAgendadosController(sistema, this));

        botaoProntos = new JButton("Consultar serviços finalizados");
        botaoProntos.addActionListener(new ServicosProntosController(sistema, this));

        botaoAlterar = new JButton("Alterar Status de serviço");
        botaoAlterar.addActionListener(new AlterarStatusController(sistema, this));

        // Adicionar botões ao painel
        painelBotoes.add(linha3);
        painelBotoes.add(botaoCadastro);
        painelBotoes.add(botaoListarTudo);
        painelBotoes.add(botaoAfazer);
        painelBotoes.add(botaoProntos);
        painelBotoes.add(botaoAlterar);
         /* 
        getContentPane().setLayout(new GridLayout(3,1));
        getContentPane().add(botaoCadastro);
        getContentPane().add(linha2);
        getContentPane().add(botaoListarTudo);
        getContentPane().add(new JLabel());
        getContentPane().add(botaoAfazer);
        */
        add(painelBotoes);
        add(linha2);
    }
    public static void main(String [] args){
        JFrame janela = new SistemaGUI_JFrame();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
