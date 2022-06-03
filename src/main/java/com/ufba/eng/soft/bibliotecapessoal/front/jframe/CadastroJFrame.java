package com.ufba.eng.soft.bibliotecapessoal.front.jframe;



import java.awt.BorderLayout;
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



public class CadastroJFrame extends JFrame {
    private JPanel contentPane;
    
    
    public static void main(String[] args) {
	
}
    private String usuario;
    private JTextField idField;
    private JTextField nomeField;
    private JTextField usernameField;
    private JTextField senhaField;
    
    public CadastroJFrame(String usuario) {
        //super("Cadastro de Professor");
        usuario = usuario;
        criarFormulario(usuario);
    }

    private void criarFormulario(String usuario) {
        usuario = usuario; 
        setTitle("Cadastro de Usuário");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(3, 3, 3, 3));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        FecharAction fecharAction = new FecharAction();
        SalvarProfessorAction salvarProfessorAction = new SalvarProfessorAction();
        SalvarAlunoAction salvarAlunoAction = new SalvarAlunoAction();
        SalvarOrientandoAction salvarOrientandoAction = new SalvarOrientandoAction();
        LimparAction limparAction = new LimparAction();
        
        setLayout(new BorderLayout());
        
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());
        
        JLabel titulo = new JLabel ("Formulário");
        titulo.setFont(new Font("verdana", Font.PLAIN, 16));
        
        panelTitulo.add(titulo);
        
        JPanel panelCadastro = new JPanel();
        panelCadastro.setLayout(new FlowLayout());
        
        JLabel idLabel = new JLabel ("Identificação-ID");
        idField = new JTextField(38);
        
        JLabel nomeLabel = new JLabel ("Nome");
        nomeField = new JTextField(38);
        
        JLabel usernameLabel = new JLabel ("Username");
        usernameField = new JTextField(38);
        
        JLabel senhaLabel = new JLabel ("Senha");
        senhaField = new JTextField(38);
        
        panelCadastro.add(nomeLabel);
        panelCadastro.add(nomeField);
        panelCadastro.add(idLabel);
        panelCadastro.add(idField);
        panelCadastro.add(usernameLabel);
        panelCadastro.add(usernameField);
        panelCadastro.add(senhaLabel);
        panelCadastro.add(senhaField);
        
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new FlowLayout());
        
        JButton botaoSalvar = new JButton("Salvar");
        panelBotoes.add(botaoSalvar);
        
        if(usuario == "Professor"){ 
            botaoSalvar.addActionListener(salvarProfessorAction);  
        }
        if(usuario == "Aluno"){ 
            botaoSalvar.addActionListener(salvarAlunoAction);  
        }
        if(usuario == "Orientando"){ 
            botaoSalvar.addActionListener(salvarOrientandoAction);  
        }
        
        JButton botaoLimpar = new JButton("Limpar");
        botaoLimpar.addActionListener(limparAction);
        
        JButton botaoSair = new JButton("Sair");
        botaoSair.addActionListener(fecharAction);
        
        panelBotoes.add(botaoLimpar);
        panelBotoes.add(botaoSair);
        
        add(panelTitulo, BorderLayout.NORTH);
        add(panelCadastro, BorderLayout.CENTER);
        add(panelBotoes, BorderLayout.SOUTH);        
    }
    
    private class LimparAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            nomeField.setText("");
            idField.setText("");
            usernameField.setText("");
            senhaField.setText("");
        }
    }
    
    private class FecharAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            CadastroJFrame.this.dispose();            
        }
    }
    
    private class SalvarProfessorAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
             JOptionPane.showMessageDialog(null, "Professor(a) cadastrado com sucesso", "Cadastro", JOptionPane.PLAIN_MESSAGE);       
            
        }

    }
    
    private class SalvarAlunoAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
             JOptionPane.showMessageDialog(null, "Aluno(a) cadastrado com sucesso", "Cadastro", JOptionPane.PLAIN_MESSAGE);       
            
        }

    }
    
    private class SalvarOrientandoAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
             JOptionPane.showMessageDialog(null, "Orientando(a) cadastrado com sucesso", "Cadastro", JOptionPane.PLAIN_MESSAGE);       
            
        }

    }
}
    

