package TelasPrincipais;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BibliotecaTelaPrincipalUsuario extends JFrame {
    private JPanel contentPane;
    private String usuario;

/**
 * Launch the application.
 */
    public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                    public void run() {
                            try {
                                    BibliotecaTelaPrincipalUsuario frame = new BibliotecaTelaPrincipalUsuario();
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
    public BibliotecaTelaPrincipalUsuario() {
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
                            new ConsultarLivroTelaPrincipal().setVisible(true);
                    }
            });
            btnConsultarLivro.setForeground(Color.BLUE);
            btnConsultarLivro.setBounds(240, 83, 149, 53);
            contentPane.add(btnConsultarLivro); 
            
            JButton btnRealizarEmprestimo = new JButton("Empréstimo ");
            btnRealizarEmprestimo.addActionListener(new ActionListener() {
                     public void actionPerformed(ActionEvent arg0) {
                            new ConsultarLivroTelaPrincipal().setVisible(true);
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
