/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufba.eng.soft.bibliotecapessoal.front.jframe;

import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.LivrosRepository;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.UsuariosRepository;
import com.ufba.eng.soft.bibliotecapessoal.model.user.UsuarioDoSistema;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DevolucaoJFrame extends JFrame {
    private JPanel contentPane;
    private UsuariosRepository usuariosRepository;
    private LivrosRepository livrosRepository;
    private UsuarioDoSistema usuario = null;
    private Livro livro = null;
    
    
    
    public DevolucaoJFrame(String isbnLivro, String idUsuario, UsuariosRepository usuariosRepository, LivrosRepository livrosRepository) {
        this.usuariosRepository = usuariosRepository;
        this.livrosRepository = livrosRepository;
        criarDescricaoDevolucao(isbnLivro, idUsuario);
    }


    private void criarDescricaoDevolucao(String isbnLivro, String idUsuario) {
        SairAction sairAction = new SairAction();

        this.livro = livrosRepository.getLivroPorISBN(isbnLivro); //Encontra livro pelo ISBN

        if(usuariosRepository.consultarOrientandoId(idUsuario) != null){
            this.usuario = usuariosRepository.consultarOrientandoId(idUsuario);
        }
        else if(usuariosRepository.consultarAlunoId(idUsuario) != null){
            this.usuario = usuariosRepository.consultarAlunoId(idUsuario);
        }
        else{
            this.usuario = usuariosRepository.consultarProfessorId(idUsuario);
        }

        //Se o livro não existir
        if(livro == null){
            JOptionPane.showMessageDialog(null, "Livro não encontrado", "Consulta", JOptionPane.PLAIN_MESSAGE);
            sairAction.actionPerformed(null);
            return;
        }
        //Se o livro não estiver emprestado
        else if (!livro.isEmprestadoPara(idUsuario))
        {
            JOptionPane.showMessageDialog(null, "Livro não está emprestado para esse usuário", "Consulta", JOptionPane.PLAIN_MESSAGE);
            sairAction.actionPerformed(null);
            return;
        }

        mostrarDescricaoDeLivro(livro);
        /*//Definições gráficas

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
        add(panelBotoes, BorderLayout.SOUTH);*/
    }

    private void mostrarDescricaoDeLivro(Livro livro) {

        setTitle("Persibi - Devolução");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 300, 500, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        DevolucaoAction devolucaoAction = new DevolucaoAction();
        DevolucaoJFrame.SairAction sairAction = new DevolucaoJFrame.SairAction();

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

        JButton botaoDevolver = new JButton("Devolver");
        botaoDevolver.setBackground(Color.GREEN);
        panelBotoes.add(botaoDevolver);
        botaoDevolver.addActionListener(devolucaoAction);

        add(panelTitulo, BorderLayout.NORTH);
        add(panelConsulta, BorderLayout.CENTER);
        add(panelBotoes, BorderLayout.SOUTH);

    }

    //Classe a ser executada se o botão "devolver" for clicado
    private class DevolucaoAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {

            livro.removeEmprestimo(usuario);
            livrosRepository.atualizarLivro(livro);
            DevolucaoJFrame.this.dispose();
           /* if(livro != null){
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
                
            }*/

        }
    }
    
    private class SairAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            DevolucaoJFrame.this.dispose();            
        }
    }
}



