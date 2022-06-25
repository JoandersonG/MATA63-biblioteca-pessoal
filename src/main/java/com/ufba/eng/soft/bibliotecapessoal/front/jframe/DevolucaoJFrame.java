/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DevolucaoJFrame extends JFrame {
    private JPanel contentPane;
    private String isbnLivro;
    private String idUsuario;
    private UsuarioDoSistema usuario = null;
    private Livro livro = null;
    private JTextField isbnLivroField;
    
    
    
    public DevolucaoJFrame(String isbnLivro, String idUsuario) {
        this.isbnLivro = isbnLivro;
        this.idUsuario = idUsuario;
        criarDescricaoDevolucao(isbnLivro, idUsuario);
    }
    
    private void criarDescricaoDevolucao(String isbnLivro, String idUsuario) {
        
        this.livro = new LivrosRepositoryImpl().getLivroPorISBN(isbnLivro); //Encontra livro pelo ISBN
        System.out.println("Livro encontrado: " + this.livro + " " + isbnLivro );
        UsuariosRepositoryImpl consulta = new UsuariosRepositoryImpl();
        
        if(consulta.consultarOrientandoId(idUsuario) != null){
            this.usuario = (Orientando) consulta.consultarOrientandoId(idUsuario);
        }
        else if(consulta.consultarAlunoId(idUsuario) != null){
            this.usuario = (Aluno) consulta.consultarAlunoId(idUsuario);
        }
        else{
            this.usuario = (Professor) consulta.consultarProfessorId(idUsuario);
        }  
        
        //Se o livro não existir
        if(livro == null){
            JOptionPane.showMessageDialog(null, "Livro n�o encontrado", "Consulta", JOptionPane.PLAIN_MESSAGE);       
        }
        //Se o livro não estiver emprestado
        else if (!livro.getEmprestadoo())
        {
            JOptionPane.showMessageDialog(null, "Livro não está emprestado", "Consulta", JOptionPane.PLAIN_MESSAGE);
        }
        //Se o livro não estiver na lista de emprestados do usuário
        else if(!usuario.consultarLivroEmprestado(livro)){
            JOptionPane.showMessageDialog(null, "Livro não está emprestado para esse usuário", "Consulta", JOptionPane.PLAIN_MESSAGE);
        
        }
        
        else{
        
        //Definições gráficas
        
        //Definições das ações "sair" e "devolver"
        DevolucaoAction devolucaoAction = new DevolucaoAction();
        SairAction sairAction = new SairAction();

        //Definições iniciais da janela - título, tamanho, layout, cor, etc
        setTitle("Persibi - Devolucao de Livro");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(300, 300, 500, 350);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());
        
        //Componente JLabel
        JLabel titulo = new JLabel ("Devolucao de Livro");
        titulo.setFont(new Font("verdana", Font.PLAIN, 16));
        panelTitulo.add(titulo);
        
        JPanel panelConsulta = new JPanel();
        panelConsulta.setLayout(new FlowLayout());
        
                
        JLabel descricaoLivro = new JLabel (livro.toString());
        descricaoLivro.setFont(new Font("verdana", Font.PLAIN, 16));   
        panelConsulta.add(descricaoLivro);  
        
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new FlowLayout());
        
        JButton botaoDevolver = new JButton("Devolver");
        botaoDevolver.setBackground(Color.GREEN);
        panelBotoes.add(botaoDevolver);
        botaoDevolver.addActionListener(devolucaoAction);
        
        JButton botaoSair = new JButton("Sair");
        botaoSair.setBackground(Color.lightGray);
        botaoSair.addActionListener(sairAction);
        panelBotoes.add(botaoSair);
        
        add(panelTitulo, BorderLayout.NORTH);
        add(panelConsulta, BorderLayout.CENTER);
        add(panelBotoes, BorderLayout.SOUTH);
        }
    }
    
    //Classe a ser executada se o botão "devolver" for clicado
    private class DevolucaoAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            
            if(livro != null){
                    if(livro.getEmprestadoo()){
                        
                        livro.setEmprestado(false);
                        
                        usuario.setEmprestimo("Nao");
                        
                        usuario.realizarDevolucao(livro);
                        
                        DevolucaoJFrame.this.dispose();
                        
                    }    
                                      
                    else{
                        JOptionPane.showMessageDialog(null, "Livro não está emprestado para esse usuário!", "Devolucao", JOptionPane.PLAIN_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Isbn não encontrado", "Devolucao", JOptionPane.PLAIN_MESSAGE);
                }
                
            }
            
        }
    
    private class SairAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            DevolucaoJFrame.this.dispose();            
        }
    }
}



