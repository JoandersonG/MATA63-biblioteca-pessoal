package com.ufba.eng.soft.bibliotecapessoal.front.view;

import com.ufba.eng.soft.bibliotecapessoal.model.repository.LivrosRepository;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.UsuariosRepository;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TelaPrincipalUsuario extends JFrame {
    
    
    private JPanel contentPane;
    private String usuario;
    private UsuariosRepository usuariosRepository;
    private final LivrosRepository livrosRepository;

    /**
     * Create the frame.
     * @throws java.io.IOException
     */
    
    public TelaPrincipalUsuario(UsuariosRepository usuariosRepository, LivrosRepository livrosRepository) throws IOException {
            this.usuariosRepository = usuariosRepository;
            this.livrosRepository = livrosRepository;
            setTitle("Persibi - Usuário");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(300, 300, 650, 500);
            contentPane = new JPanel();
            //contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);
            getContentPane().setBackground(Color.WHITE);
            
            JLabel titulo1 = new JLabel ("Bem vindo(a),");
            titulo1.setBounds(45, 90, 500, 300);
            titulo1.setFont(new Font("verdana", Font.CENTER_BASELINE, 20));
            contentPane.add(titulo1);
            
            JLabel titulo2 = new JLabel ("usuário(a)!");
            titulo2.setBounds(20, 115, 500, 300);
            titulo2.setFont(new Font("verdana", Font.CENTER_BASELINE, 20));
            contentPane.add(titulo2);            
           
            File file = new File(".\\src\\main\\java\\com\\ufba\\eng\\soft\\bibliotecapessoal\\front\\Logotype\\LogoBiblioteca.png");
            FileInputStream fis = new FileInputStream(file);  
            BufferedImage bufferedImage = ImageIO.read(fis);
            ImageIcon imageIcon = new ImageIcon(bufferedImage);            

            JLabel jLabel = new JLabel();
            jLabel.setBounds(5, 0, 350, 350);
            jLabel.setVisible(true);
            jLabel.setIcon(imageIcon);
            contentPane.add(jLabel);  

            JButton btnConsultarLivro = new JButton("Consultar Livro");
            btnConsultarLivro.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            try {
                            new ConsultarLivroTelaPrincipal(livrosRepository).setVisible(true);
                        } catch (IOException ex) {
                            Logger.getLogger(TelaPrincipalAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
            });
            btnConsultarLivro.setForeground(Color.BLACK);
            btnConsultarLivro.setBounds(360, 83, 149, 53);
            btnConsultarLivro.setBackground(Color.green);
            contentPane.add(btnConsultarLivro); 
            
            JButton btnRealizarEmprestimo = new JButton("Empréstimo ");
            btnRealizarEmprestimo.addActionListener(new ActionListener() {
                     public void actionPerformed(ActionEvent arg0) {
                         //O mesmo apontado na linha 52
//                            new ConsultarLivroTelaPrincipal().setVisible(true);
                    }
            });
            btnRealizarEmprestimo.setForeground(Color.BLACK);
            btnRealizarEmprestimo.setBounds(360, 161, 149, 53);
            btnRealizarEmprestimo.setBackground(Color.red);
            contentPane.add(btnRealizarEmprestimo);
            
            JButton btnRealizarReserva = new JButton("Reserva");
            btnRealizarReserva.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        try {
                            new ReservaLivroTelaPrincipal(livrosRepository, usuariosRepository).setVisible(true);
                        } catch (IOException ex) {
                            Logger.getLogger(TelaPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
            });
            btnRealizarReserva.setForeground(Color.BLACK);
            btnRealizarReserva.setBounds(360, 239, 149, 53);
            btnRealizarReserva.setBackground(Color.green);
            contentPane.add(btnRealizarReserva);
            
           JButton btnRealizarDevolucao = new JButton("Devolução");
           btnRealizarDevolucao.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            
                    }
            });
           btnRealizarDevolucao.setForeground(Color.BLACK);
           btnRealizarDevolucao.setBounds(360, 317, 149, 53);
           btnRealizarDevolucao.setBackground(Color.red);
           contentPane.add(btnRealizarDevolucao);
           
           JButton btnSair = new JButton("Sair");
            btnSair.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                       TelaPrincipalUsuario.this.dispose();
                }
        });
            btnSair.setForeground(Color.black);
            btnSair.setBounds(400, 420, 70, 23);
            btnSair.setBackground(Color.lightGray);
            contentPane.add(btnSair);            
    }
}
