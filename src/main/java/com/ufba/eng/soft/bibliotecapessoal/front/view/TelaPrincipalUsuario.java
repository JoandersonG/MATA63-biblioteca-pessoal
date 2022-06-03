package com.ufba.eng.soft.bibliotecapessoal.front.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipalUsuario extends JFrame {
    
    //TODO: finalizar esta implementação: receber a classe gerenciadorDeTelas no
    //construtor para poder chamar o método que inicializa ConsultarLivroTelaPrincipal
    GerenciadorDeTelas gerenciadorDeTelas;
    private JPanel contentPane;
    private String usuario;

/**
 *///TODO: a ideia é remover esses métodos main e as linhas dentro dele (29 e 30)
    //serem movidas para um me´todo em GerenciadorDeTelas
    public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                    public void run() {
                            try {
                                    TelaPrincipalUsuario frame = new TelaPrincipalUsuario();
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
    public TelaPrincipalUsuario() {
            setTitle("Biblioteca Pessoal - Usuário");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(300, 300, 650, 500);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JButton btnConsultarLivro = new JButton("Consultar Livro");
            btnConsultarLivro.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        //Corrigir a prox linha para pegar a instancia diretamente
                        //da classe GerenciadorDeTelas
//                            new ConsultarLivroTelaPrincipal().setVisible(true);
                    }
            });
            btnConsultarLivro.setForeground(Color.BLUE);
            btnConsultarLivro.setBounds(240, 83, 149, 53);
            contentPane.add(btnConsultarLivro); 
            
            JButton btnRealizarEmprestimo = new JButton("Empréstimo ");
            btnRealizarEmprestimo.addActionListener(new ActionListener() {
                     public void actionPerformed(ActionEvent arg0) {
                         //O mesmo apontado na linha 52
//                            new ConsultarLivroTelaPrincipal().setVisible(true);
                    }
            });
            btnRealizarEmprestimo.setForeground(Color.BLUE);
            btnRealizarEmprestimo.setBounds(240, 161, 149, 53);
            contentPane.add(btnRealizarEmprestimo);
            
            JButton btnRealizarReserva = new JButton("Reserva");
            btnRealizarReserva.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            
                    }
            });
            
           btnRealizarReserva.setForeground(Color.BLUE);
            btnRealizarReserva.setBounds(240, 239, 149, 53);
            contentPane.add(btnRealizarReserva); 
            
            JButton btnRealizarDevolucao = new JButton("Devolução");
            btnRealizarDevolucao.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            
                    }
            });
            btnRealizarDevolucao.setForeground(Color.BLUE);
            btnRealizarDevolucao.setBounds(240, 317, 149, 53);
            contentPane.add(btnRealizarDevolucao);
            
    }
}
