package com.ufba.eng.soft.bibliotecapessoal.front.jframe;

import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.LivrosRepositoryImpl;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.UsuariosRepositoryImpl;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Aluno;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Orientando;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Professor;
import com.ufba.eng.soft.bibliotecapessoal.model.user.UsuarioDoSistema;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

public class EmprestimoJFrame extends JFrame {
    private JPanel contentPane;
    private String usuario;
    private JTextField idField; 
    private JTextField isbnLivroField;
    
    
    
    public EmprestimoJFrame(String usuario) {
        usuario = usuario;
        criarFormularioNome(usuario);
    }
    
    private void criarFormularioNome(String usuario) {
        usuario = usuario; 
        setTitle("Persibi - Empréstimo de Livro");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(300, 300, 500, 350);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        EmprestaProfessorAction emprestaProfessorAction = new EmprestaProfessorAction();
        EmprestaAlunoAction emprestaAlunoAction = new EmprestaAlunoAction();
        EmprestaOrientandoAction emprestaOrientandoAction = new EmprestaOrientandoAction();
        LimparAction limparAction = new LimparAction();
        SairAction sairAction = new SairAction();
        
        setLayout(new BorderLayout());
        
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());
        
        JLabel titulo = new JLabel ("Empréstimo de Livro");
        titulo.setFont(new Font("verdana", Font.PLAIN, 16));
        panelTitulo.add(titulo);
        
        JPanel panelConsulta = new JPanel();
        panelConsulta.setLayout(new FlowLayout());
        
        JLabel idLabel = new JLabel ("Id do usuario");
        idField = new JTextField(40);     
        
        panelConsulta.add(idLabel);
        panelConsulta.add(idField);
        
        JLabel isbnLivroLabel = new JLabel ("ISBN do livro");
        isbnLivroField = new JTextField(40);     
        
        panelConsulta.add(isbnLivroLabel);
        panelConsulta.add(isbnLivroField);
        
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new FlowLayout());
        
        JButton botaoBuscar = new JButton("Emprestar");
        botaoBuscar.setBackground(Color.GREEN);
        panelBotoes.add(botaoBuscar);
        
        if(usuario == "Professor"){ 
          botaoBuscar.addActionListener(emprestaProfessorAction);  
        }
        if(usuario == "Aluno"){ 
            botaoBuscar.addActionListener(emprestaAlunoAction);  
        }
        if(usuario == "Orientando"){ 
            botaoBuscar.addActionListener(emprestaOrientandoAction);  
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
    
    
    private class EmprestaProfessorAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String idProfessor = idField.getText();
            String isbnLivro = isbnLivroField.getText();
           
          
            Professor professor = (Professor) new UsuariosRepositoryImpl().consultarProfessorId(idProfessor);
            Livro livro = (Livro) new LivrosRepositoryImpl().getLivroPorISBN(isbnLivro);
            
            if(professor != null){
                
                if(livro != null){
                                        
                    if(!livro.getEmprestadoo()){
                        
                        livro.setEmprestado(true);
                      
                        professor.setEmprestimo("sim");
                        
                        professor.addLivroListaEmprestimos(livro);
                        
                        new FormularioDeEmprestimoJFrame().setVisible(true);
                        
                    }    
                                      
                    else{
                        JOptionPane.showMessageDialog(null, "Livro não está disponível no momento: Faça reserva!", "Emprestimo", JOptionPane.PLAIN_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Isbn não encontrado", "Emprestimo", JOptionPane.PLAIN_MESSAGE);
                }
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Usuário(a) não encontrado", "Emprestimo", JOptionPane.PLAIN_MESSAGE);       
            }
            
            
        }
    }
    
    private class EmprestaAlunoAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String idAluno = idField.getText();
            String isbnLivro = isbnLivroField.getText();
           
          
            Aluno aluno = (Aluno) new UsuariosRepositoryImpl().consultarAlunoId(idAluno);
            Livro livro = (Livro) new LivrosRepositoryImpl().getLivroPorISBN(isbnLivro);
            
            if(aluno != null){
                    if(livro != null){
                    
                    
                    if(!livro.getEmprestadoo()){
                        
                        livro.setEmprestado(true);
                        
                        aluno.setEmprestimo("sim");
                        
                        aluno.addLivroListaEmprestimos(livro);
                        
                        new FormularioDeEmprestimoJFrame().setVisible(true);
                        
                    }    
                                      
                    else{
                        JOptionPane.showMessageDialog(null, "Livro não está disponível no momento: Faça reserva!", "Emprestimo", JOptionPane.PLAIN_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Isbn não encontrado", "Emprestimo", JOptionPane.PLAIN_MESSAGE);
                }
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Usuário(a) não encontrado", "Emprestimo", JOptionPane.PLAIN_MESSAGE);       
            }
            
            
        }
    }
    
    private class EmprestaOrientandoAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String idOrientando = idField.getText();
            String isbnLivro = isbnLivroField.getText();
           
          
            Orientando orientando = (Orientando) new UsuariosRepositoryImpl().consultarOrientandoId(idOrientando);
            Livro livro = (Livro) new LivrosRepositoryImpl().getLivroPorISBN(isbnLivro);
            
            if(orientando != null){
                    if(livro != null){
                    
                    
                    if(!livro.getEmprestadoo()){
                        
                        livro.setEmprestado(true);
                        
                        orientando.setEmprestimo("sim");
                        
                        orientando.addLivroListaEmprestimos(livro);
                        
                        new FormularioDeEmprestimoJFrame().setVisible(true);
                        
                    }    
                                      
                    else{
                        JOptionPane.showMessageDialog(null, "Livro não está disponível no momento: Faça reserva!", "Emprestimo", JOptionPane.PLAIN_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Isbn não encontrado", "Emprestimo", JOptionPane.PLAIN_MESSAGE);
                }
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Usuário(a) não encontrado", "Emprestimo", JOptionPane.PLAIN_MESSAGE);       
            }
            
            
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
            EmprestimoJFrame.this.dispose();            
        }
    }
    
}



