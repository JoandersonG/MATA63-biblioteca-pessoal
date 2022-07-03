/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufba.eng.soft.bibliotecapessoal.front.jframe;

import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import com.ufba.eng.soft.bibliotecapessoal.model.user.UsuarioDoSistema;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MostrarInformacoesJFrame extends JFrame {
    private JPanel contentPane;
    private String usuario;
    private JTextField idField;    
    
    
    public MostrarInformacoesJFrame(UsuarioDoSistema usuario, List<Livro> emprestimos) {
        
        criarFormularioNome(usuario, emprestimos);
    }
    
    private void criarFormularioNome(UsuarioDoSistema usuario, List<Livro> emprestimos) {
       
        setTitle("Persibi - Informações do usuário buscado");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        
        JLabel titulo = new JLabel ("Informações do usuário buscado");
        titulo.setFont(new Font("arial black", Font.PLAIN, 18));
        panelTitulo.add(titulo);
        
        JPanel panelConsulta = new JPanel();
        panelConsulta.setLayout(new FlowLayout());
        
        final JTextArea nomeLabel = new JTextArea("Nome : "); 
        nomeLabel.setEditable(false); 
        nomeLabel.setLineWrap(true);
        nomeLabel.setFont(new Font("arial black", Font.PLAIN, 16));
        final JTextArea nomeUsuarioLabel = new JTextArea(usuario.getNomeDeUusario()); 
        nomeUsuarioLabel.setEditable(false); 
        nomeUsuarioLabel.setLineWrap(true);
        nomeUsuarioLabel.setBounds(20, 150, 310, 150);
        nomeUsuarioLabel.setWrapStyleWord(true);
        nomeUsuarioLabel.setFont(new Font("verdana", Font.PLAIN, 16));
        panelConsulta.add(nomeLabel);
        panelConsulta.add(nomeUsuarioLabel);
        
        
        final JTextArea idLabel = new JTextArea("Id : "); 
        idLabel.setEditable(false); 
        idLabel.setLineWrap(true);
        idLabel.setFont(new Font("arial black", Font.PLAIN, 16));
        final JTextArea idUsuarioLabel = new JTextArea(String.valueOf(usuario.getIdUsuario()));
        idUsuarioLabel.setEditable(false); 
        idUsuarioLabel.setLineWrap(true);
        idUsuarioLabel.setLineWrap(true);
        idUsuarioLabel.setBounds(20, 150, 310, 150);
        idUsuarioLabel.setFont(new Font("verdana", Font.PLAIN, 16));
        panelConsulta.add(idLabel);
        panelConsulta.add(idUsuarioLabel);
        
        final JTextArea userNameLabel = new JTextArea("User : "); 
        userNameLabel.setEditable(false); 
        userNameLabel.setLineWrap(true);
        userNameLabel.setFont(new Font("arial black", Font.PLAIN, 16));
        final JTextArea userNameUsuarioLabel = new JTextArea(usuario.getUserName()); 
        userNameUsuarioLabel.setEditable(false); 
        userNameUsuarioLabel.setLineWrap(true);
        userNameUsuarioLabel.setLineWrap(true);
        userNameUsuarioLabel.setBounds(20, 150, 310, 150);
        userNameUsuarioLabel.setFont(new Font("verdana", Font.PLAIN, 16));
        userNameUsuarioLabel.doLayout();
        panelConsulta.add(userNameLabel);
        panelConsulta.add(userNameUsuarioLabel);
        
        final JTextArea debitoLabel = new JTextArea("Déb. : "); 
        debitoLabel.setEditable(false); 
        debitoLabel.setLineWrap(true);
        debitoLabel.setFont(new Font("arial black", Font.PLAIN, 16));
        final JTextArea debitoUsuarioLabel = new JTextArea(usuario.getDebito()); 
        debitoUsuarioLabel.setEditable(false); 
        debitoUsuarioLabel.setLineWrap(true);
        debitoUsuarioLabel.setLineWrap(true);
        debitoUsuarioLabel.setBounds(20, 150, 310, 150);
        debitoUsuarioLabel.setFont(new Font("verdana", Font.PLAIN, 16));
        debitoUsuarioLabel.doLayout();
        panelConsulta.add(debitoLabel);
        panelConsulta.add(debitoUsuarioLabel);

        JTextArea emprestimoLabel = new JTextArea("Emp. : ");
        emprestimoLabel.setEditable(false);
        emprestimoLabel.setLineWrap(true);
        emprestimoLabel.setFont(new Font("arial black", Font.PLAIN, 16));
        JTextArea emprestimoUsuarioLabel = new JTextArea(emprestimos.size() == 0 ? "Nenhum livro em empréstimo" : " ");
        emprestimoUsuarioLabel.setEditable(false);
        emprestimoUsuarioLabel.setLineWrap(true);
        emprestimoUsuarioLabel.setLineWrap(true);
        emprestimoUsuarioLabel.setBounds(20, 150, 310, 150);
        emprestimoUsuarioLabel.setFont(new Font("verdana", Font.PLAIN, 16));
        emprestimoUsuarioLabel.doLayout();
        panelConsulta.add(emprestimoLabel);
        panelConsulta.add(emprestimoUsuarioLabel);

        if (!emprestimos.isEmpty()) {
            JTextArea isbnArea = new JTextArea("ISBN:");
            isbnArea.setEditable(false);
            isbnArea.setLineWrap(true);
            isbnArea.setFont(new Font("arial", Font.PLAIN, 16));
            JTextArea nomeLivroArea = new JTextArea("Nome do Livro");
            nomeLivroArea.setEditable(false);
            nomeLivroArea.setLineWrap(true);
            nomeLivroArea.setLineWrap(true);
            nomeLivroArea.setBounds(20, 150, 310, 150);
            nomeLivroArea.setFont(new Font("verdana", Font.PLAIN, 16));
            nomeLivroArea.doLayout();
            panelConsulta.add(isbnArea);
            panelConsulta.add(nomeLivroArea);
        }
        int qtdAdicionada = inserirListaDeEmprestimos(emprestimos, panelConsulta);
        setBounds(300, 300, 500, 350 + (qtdAdicionada * 50));

        final JTextArea reservaLabel = new JTextArea("Res. : "); 
        reservaLabel.setEditable(false); 
        reservaLabel.setLineWrap(true);
        reservaLabel.setFont(new Font("arial black", Font.PLAIN, 16));
        final JTextArea reservaUsuarioLabel = new JTextArea(usuario.getEmprestimo()); 
        reservaUsuarioLabel.setEditable(false); 
        reservaUsuarioLabel.setLineWrap(true);
        reservaUsuarioLabel.setLineWrap(true);
        reservaUsuarioLabel.setBounds(20, 150, 310, 150);
        reservaUsuarioLabel.setFont(new Font("verdana", Font.PLAIN, 16));
        reservaUsuarioLabel.doLayout();
        panelConsulta.add(reservaLabel);
        panelConsulta.add(reservaUsuarioLabel);
        
        JButton botaoSair = new JButton("Sair");
        botaoSair.setBackground(Color.lightGray);
        botaoSair.addActionListener(sairAction);
        panelBotoes.add(botaoSair);
        
        add(panelTitulo, BorderLayout.NORTH);
        add(panelConsulta, BorderLayout.CENTER);
        add(panelBotoes, BorderLayout.SOUTH); 
            
    }

    private int inserirListaDeEmprestimos(List<Livro> emprestimos, JPanel panelConsulta) {
        for (Livro livro: emprestimos) {
            JTextArea isbnArea = new JTextArea(livro.getCodigoISBN() + ":");
            isbnArea.setEditable(false);
            isbnArea.setLineWrap(true);
            isbnArea.setFont(new Font("arial", Font.PLAIN, 16));
            JTextArea nomeLivroArea = new JTextArea(livro.getNomeDoLivro());
            nomeLivroArea.setEditable(false);
            nomeLivroArea.setLineWrap(true);
            nomeLivroArea.setLineWrap(true);
            nomeLivroArea.setBounds(20, 150, 310, 150);
            nomeLivroArea.setFont(new Font("verdana", Font.PLAIN, 16));
            nomeLivroArea.doLayout();
            panelConsulta.add(isbnArea);
            panelConsulta.add(nomeLivroArea);
        }
        return emprestimos.size();
    }

    private class SairAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            MostrarInformacoesJFrame.this.dispose();            
        }
    }
    
    
}

