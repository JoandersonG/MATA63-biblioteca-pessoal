/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufba.eng.soft.bibliotecapessoal.front.jframe;

import com.ufba.eng.soft.bibliotecapessoal.model.repository.LivrosRepository;
import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import com.ufba.eng.soft.bibliotecapessoal.model.product.Autor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MostrarInformacoesLivroJFrame extends JFrame {
    private JPanel contentPane;
    private JTextField isbnField;    
    
    
    public MostrarInformacoesLivroJFrame(Livro livro) {
        
        criarFormulario(livro);
    }
    
    private void criarFormulario(Livro livro) {
       
        setTitle("Persibi - Informações do livro buscado");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(300, 300, 500, 350);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        SairAction sairAction = new SairAction();
        
        setLayout(new BorderLayout());
        
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new FlowLayout());
        
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());
        
        JLabel titulo = new JLabel ("Informações do livro buscado");
        titulo.setFont(new Font("arial black", Font.PLAIN, 18));
        panelTitulo.add(titulo);
        
        JPanel panelConsulta = new JPanel();
        panelConsulta.setLayout(new FlowLayout());
        
        final JTextArea nomeLabel = new JTextArea("Nome : "); 
        nomeLabel.setEditable(false); 
        nomeLabel.setLineWrap(true);
        nomeLabel.setFont(new Font("arial black", Font.PLAIN, 16));
        final JTextArea nomeLivroLabel = new JTextArea(livro.getNomeDoLivro()); 
        nomeLivroLabel.setEditable(false); 
        nomeLivroLabel.setLineWrap(true);
        nomeLivroLabel.setBounds(20, 150, 310, 150);
        nomeLivroLabel.setWrapStyleWord(true);
        nomeLivroLabel.setFont(new Font("verdana", Font.PLAIN, 16));
        panelConsulta.add(nomeLabel);
        panelConsulta.add(nomeLivroLabel);
        
        
        final JTextArea isbnLabel = new JTextArea("Código ISBN : "); 
        isbnLabel.setEditable(false); 
        isbnLabel.setLineWrap(true);
        isbnLabel.setFont(new Font("arial black", Font.PLAIN, 16));
        final JTextArea isbnLivroLabel = new JTextArea(livro.getCodigoISBN()); 
        isbnLivroLabel.setEditable(false); 
        isbnLivroLabel.setLineWrap(true);
        isbnLivroLabel.setLineWrap(true);
        isbnLivroLabel.setBounds(20, 150, 310, 150);
        isbnLivroLabel.setFont(new Font("verdana", Font.PLAIN, 16));
        panelConsulta.add(isbnLabel);
        panelConsulta.add(isbnLivroLabel);
        
        final JTextArea codBarraLabel = new JTextArea("Código de barras : "); 
        codBarraLabel.setEditable(false); 
        codBarraLabel.setLineWrap(true);
        codBarraLabel.setFont(new Font("arial black", Font.PLAIN, 16));
        final JTextArea codBarraLivroLabel = new JTextArea(livro.getCodigoDeBarras()); 
        codBarraLivroLabel.setEditable(false); 
        codBarraLivroLabel.setLineWrap(true);
        codBarraLivroLabel.setLineWrap(true);
        codBarraLivroLabel.setBounds(20, 150, 310, 150);
        codBarraLivroLabel.setFont(new Font("verdana", Font.PLAIN, 16));
        codBarraLivroLabel.doLayout();
        panelConsulta.add(codBarraLabel);
        panelConsulta.add(codBarraLivroLabel);
        
        final JTextArea autorLabel = new JTextArea("Autor : "); 
        autorLabel.setEditable(false); 
        autorLabel.setLineWrap(true);
        autorLabel.setFont(new Font("arial black", Font.PLAIN, 16));
        final JTextArea autorLivroLabel = new JTextArea(livro.getAutor().getNome()); 
        autorLivroLabel.setEditable(false); 
        autorLivroLabel.setLineWrap(true);
        autorLivroLabel.setLineWrap(true);
        autorLivroLabel.setBounds(20, 150, 310, 150);
        autorLivroLabel.setFont(new Font("verdana", Font.PLAIN, 16));
        autorLivroLabel.doLayout();
        panelConsulta.add(autorLabel);
        panelConsulta.add(autorLivroLabel);
        
        final JTextArea generoLabel = new JTextArea("Gênero : "); 
        generoLabel.setEditable(false); 
        generoLabel.setLineWrap(true);
        generoLabel.setFont(new Font("arial black", Font.PLAIN, 16));
        final JTextArea generoLivroLabel = new JTextArea(livro.getGenero().name());
        generoLivroLabel.setEditable(false); 
        generoLivroLabel.setLineWrap(true);
        generoLivroLabel.setLineWrap(true);
        generoLivroLabel.setBounds(20, 150, 310, 150);
        generoLivroLabel.setFont(new Font("verdana", Font.PLAIN, 16));
        generoLivroLabel.doLayout();
        panelConsulta.add(generoLabel);
        panelConsulta.add(generoLivroLabel);
        
        JButton botaoSair = new JButton("Sair");
        botaoSair.setBackground(Color.lightGray);
        botaoSair.addActionListener(sairAction);
        panelBotoes.add(botaoSair);
        
        add(panelTitulo, BorderLayout.NORTH);
        add(panelConsulta, BorderLayout.CENTER);
        add(panelBotoes, BorderLayout.SOUTH); 
            
    }
    
    private class SairAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            MostrarInformacoesLivroJFrame.this.dispose();            
        }
    }
    
    
}
