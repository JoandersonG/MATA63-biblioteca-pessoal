package com.ufba.eng.soft.bibliotecapessoal.front.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipalAdministrador extends JFrame {
    private JPanel contentPane;
    private String usuario;

    
    
    public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                    public void run() {
                            try {
                                    TelaPrincipalAdministrador frame = new TelaPrincipalAdministrador();
                                    frame.setVisible(true);
                            } catch (Exception e) {
                                    e.printStackTrace();
                            }
                    }
            });
    }

    /**
     * Create the frame.
     */
    public TelaPrincipalAdministrador() {
            setTitle("Biblioteca Pessoal - Administrador");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(300, 300, 650, 500);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JButton btnCadastrarUsuario = new JButton("Cadastrar Usuário");
            btnCadastrarUsuario.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            new CadastroUsuarioTelaPrincipal().setVisible(true);
                    }
            });
            btnCadastrarUsuario.setForeground(Color.BLUE);
            btnCadastrarUsuario.setBounds(50, 50, 149, 53);
            contentPane.add(btnCadastrarUsuario); 
            
            JButton btnConsultarUsuario = new JButton("Consultar Usuário");
            btnConsultarUsuario.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            
                    }
            });
            btnConsultarUsuario.setForeground(Color.BLUE);
            btnConsultarUsuario.setBounds(240, 50, 149, 53);
            contentPane.add(btnConsultarUsuario);
            
            JButton btnAtualizarUsuario = new JButton("Atualizar Usuário");
            btnAtualizarUsuario.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            
                    }
            });
            btnAtualizarUsuario.setForeground(Color.BLUE);
            btnAtualizarUsuario.setBounds(430, 50, 149, 53);
            contentPane.add(btnAtualizarUsuario);
            
            JButton btnCRemoverUsuario = new JButton("Remover Usuário");
            btnCRemoverUsuario.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            
                    }
            });
            
            btnCRemoverUsuario.setForeground(Color.BLUE);
            btnCRemoverUsuario.setBounds(50, 150, 149, 53);
            contentPane.add(btnCRemoverUsuario); 
            
            JButton btnCadastrarLivro = new JButton("Cadastrar Livro");
            btnCadastrarLivro.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            
                    }
            });
            btnCadastrarLivro.setForeground(Color.BLUE);
            btnCadastrarLivro.setBounds(240, 150, 149, 53);
            contentPane.add(btnCadastrarLivro);
            
            JButton btnAtualizarLivro = new JButton("Atualizar Livro");
            btnAtualizarLivro.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            
                    }
            });
            btnAtualizarLivro.setForeground(Color.BLUE);
            btnAtualizarLivro.setBounds(430, 150, 149, 53);
            contentPane.add(btnAtualizarLivro);
             
            
            JButton btnRemoverLivro = new JButton("Remover Livro");
            btnCadastrarLivro.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            
                    }
            });
            btnRemoverLivro.setForeground(Color.BLUE);
            btnRemoverLivro.setBounds(50, 250, 149, 53);
            contentPane.add(btnRemoverLivro);
            
            JButton btnConsultarReserva = new JButton("Consultar Reserva");
            btnAtualizarLivro.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            
                    }
            });
            btnConsultarReserva.setForeground(Color.BLUE);
            btnConsultarReserva.setBounds(240, 250, 149, 53);
            contentPane.add(btnConsultarReserva);
            
            JButton btnConsultarEmprestimo = new JButton("Consultar Empréstimo");
            btnAtualizarLivro.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            
                    }
            });
            btnConsultarEmprestimo.setForeground(Color.BLUE);
            btnConsultarEmprestimo.setBounds(430, 250, 149, 53);
            contentPane.add(btnConsultarEmprestimo);
            
            
            
    }
}
