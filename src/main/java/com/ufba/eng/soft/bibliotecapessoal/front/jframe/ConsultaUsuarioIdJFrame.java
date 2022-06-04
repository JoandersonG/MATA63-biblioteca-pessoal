package com.ufba.eng.soft.bibliotecapessoal.front.jframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ConsultaUsuarioIdJFrame extends JFrame {
    private JPanel contentPane;
    private String usuario;
    private JTextField idField;    
    
    
    public ConsultaUsuarioIdJFrame(String usuario) {
        usuario = usuario;
        criarFormularioNome(usuario);
    }
    
    private void criarFormularioNome(String usuario) {
        usuario = usuario; 
        setTitle("Persibi - Buscando Usuário, pelo Id, no cadastro ...");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(300, 300, 500, 350);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        BuscarProfessorAction buscarProfessorAction = new BuscarProfessorAction();
        BuscarAlunoAction buscarAlunoAction = new BuscarAlunoAction();
        BuscarOrientandoAction buscarOrientandoAction = new BuscarOrientandoAction();
        LimparAction limparAction = new LimparAction();
        SairAction sairAction = new SairAction();
        
        setLayout(new BorderLayout());
        
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());
        
        JLabel titulo = new JLabel ("Busca de usuário pelo Id ...");
        titulo.setFont(new Font("verdana", Font.PLAIN, 16));
        panelTitulo.add(titulo);
        
        JPanel panelConsulta = new JPanel();
        panelConsulta.setLayout(new FlowLayout());
        
        JLabel idLabel = new JLabel ("Id");
        idField = new JTextField(40);     
        
        panelConsulta.add(idLabel);
        panelConsulta.add(idField);
        
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new FlowLayout());
        
        JButton botaoBuscar = new JButton("Buscar");
        botaoBuscar.setBackground(Color.GREEN);
        panelBotoes.add(botaoBuscar);
        
        if(usuario == "Professor"){ 
          botaoBuscar.addActionListener(buscarProfessorAction);  
        }
        if(usuario == "Aluno"){ 
            botaoBuscar.addActionListener(buscarAlunoAction);  
        }
        if(usuario == "Orientando"){ 
            botaoBuscar.addActionListener(buscarOrientandoAction);  
        }
        
        JButton botaoLimpar = new JButton("Limpar");
        botaoLimpar.setBackground(Color.red);
        botaoLimpar.addActionListener(limparAction);
        
        JButton botaoSair = new JButton("Sair");
        botaoSair.setBackground(Color.lightGray);
        botaoSair.addActionListener(sairAction);
        
        panelBotoes.add(botaoLimpar);
        panelBotoes.add(botaoSair);
        
        add(panelTitulo, BorderLayout.NORTH);
        add(panelConsulta, BorderLayout.CENTER);
        add(panelBotoes, BorderLayout.SOUTH);        
    }
    
    
    private class BuscarProfessorAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
             JOptionPane.showMessageDialog(null, "Professor(a) encontrado com sucesso", "Consulta", JOptionPane.PLAIN_MESSAGE); 
             //Exibir informações do usuário
            
        }
    }
    
    private class BuscarAlunoAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
             JOptionPane.showMessageDialog(null, "Aluno(a) cencontrado com sucesso", "Consulta", JOptionPane.PLAIN_MESSAGE);       
             //Exibir informações do usuário
        }
    }
    
    private class BuscarOrientandoAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
             JOptionPane.showMessageDialog(null, "Orientando(a) encontrado com sucesso", "Consulta", JOptionPane.PLAIN_MESSAGE);       
             //Exibir informações do usuário
        }
    }
    
    private class LimparAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            idField.setText("");
        }
    }
    
    private class SairAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            ConsultaUsuarioIdJFrame.this.dispose();            
        }
    }
    
}
    

