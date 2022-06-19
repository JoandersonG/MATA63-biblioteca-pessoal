package com.ufba.eng.soft.bibliotecapessoal.front.view;

import com.ufba.eng.soft.bibliotecapessoal.model.repository.LivrosRepository;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.UsuariosRepository;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.FlowLayout;
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

public class TelaPrincipalAdministrador extends JFrame {
    private JPanel contentPane;
    private String usuario;
    private UsuariosRepository usuariosRepository;
    private final LivrosRepository livrosRepository;

    /**
     * Create the frame.
     * @throws java.io.IOException
     */
    public TelaPrincipalAdministrador(UsuariosRepository usuariosRepository, LivrosRepository livrosRepository) throws IOException {
            this.usuariosRepository = usuariosRepository;
            this.livrosRepository = livrosRepository;
            setTitle("Persibi - Administrador");
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
            
            JLabel titulo2 = new JLabel ("administrador(a)!");
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
            
            JButton btnCadastrarUsuario = new JButton("Cadastrar Usuário");
            btnCadastrarUsuario.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        try {
                            new CadastroUsuarioTelaPrincipal(usuariosRepository).setVisible(true);
                        } catch (IOException ex) {
                            Logger.getLogger(TelaPrincipalAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
            });
            btnCadastrarUsuario.setForeground(Color.WHITE);
            btnCadastrarUsuario.setBounds(280, 50, 149, 53);
            btnCadastrarUsuario.setBackground(Color.blue);
            contentPane.add(btnCadastrarUsuario); 
            
            JButton btnConsultarUsuario = new JButton("Consultar Usuário");
            btnConsultarUsuario.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        try {
                            new ConsultaUsuarioTelaPrincipal().setVisible(true);
                        } catch (IOException ex) {
                            Logger.getLogger(TelaPrincipalAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
            });
            btnConsultarUsuario.setForeground(Color.WHITE);
            btnConsultarUsuario.setBounds(440, 50, 149, 53);
            btnConsultarUsuario.setBackground(Color.blue);
            contentPane.add(btnConsultarUsuario);
            
            JButton btnAtualizarUsuario = new JButton("Atualizar Usuário");
            btnAtualizarUsuario.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            
                    }
            });
            btnAtualizarUsuario.setForeground(Color.WHITE);
            btnAtualizarUsuario.setBounds(280, 110, 149, 53);
            btnAtualizarUsuario.setBackground(Color.blue);
            contentPane.add(btnAtualizarUsuario);
            
            JButton btnCRemoverUsuario = new JButton("Remover Usuário");
            btnCRemoverUsuario.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        try {
                            new RemoveUsuarioTelaPrincipal(usuariosRepository).setVisible(true);
                        } catch (IOException ex) {
                            Logger.getLogger(TelaPrincipalAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
            });
            
            btnCRemoverUsuario.setForeground(Color.WHITE);
            btnCRemoverUsuario.setBounds(440, 110, 149, 53);
            btnCRemoverUsuario.setBackground(Color.blue);
            contentPane.add(btnCRemoverUsuario); 
            
            JButton btnCadastrarLivro = new JButton("Cadastrar Livro");
            btnCadastrarLivro.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        try {
                            new CadastroLivroTelaPrincipal(livrosRepository).setVisible(true);
                        } catch (IOException ex) {
                            Logger.getLogger(TelaPrincipalAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
            });
            btnCadastrarLivro.setForeground(Color.WHITE);
            btnCadastrarLivro.setBounds(280, 190, 149, 53);
            btnCadastrarLivro.setBackground(Color.red);
            contentPane.add(btnCadastrarLivro);
            
            JButton btnConsultarLivro = new JButton("Consultar Livro");
            btnConsultarLivro.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            
                    }
            });
            btnConsultarLivro.setForeground(Color.WHITE);
            btnConsultarLivro.setBounds(440, 190, 149, 53);
            btnConsultarLivro.setBackground(Color.red);
            contentPane.add(btnConsultarLivro);
            
            JButton btnAtualizarLivro = new JButton("Atualizar Livro");
            btnAtualizarLivro.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            
                    }
            });
            btnAtualizarLivro.setForeground(Color.WHITE);
            btnAtualizarLivro.setBounds(280, 250, 149, 53);
            btnAtualizarLivro.setBackground(Color.red);
            contentPane.add(btnAtualizarLivro);
             
            JButton btnRemoverLivro = new JButton("Remover Livro");
            btnCadastrarLivro.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            
                    }
            });
            btnRemoverLivro.setForeground(Color.WHITE);
            btnRemoverLivro.setBounds(440, 250, 149, 53);
            btnRemoverLivro.setBackground(Color.red);
            contentPane.add(btnRemoverLivro);            
            
            JButton btnConsultarReserva = new JButton("Consultar Reserva");
            btnAtualizarLivro.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            
                    }
            });
            btnConsultarReserva.setForeground(Color.WHITE);
            btnConsultarReserva.setBounds(280, 330, 149, 53);
            btnConsultarReserva.setBackground(Color.GREEN);
            contentPane.add(btnConsultarReserva);
            
            JButton btnConsultarEmprestimo = new JButton("Consultar Empréstimo");
            btnAtualizarLivro.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            
                    }
            });
            btnConsultarEmprestimo.setForeground(Color.WHITE);
            btnConsultarEmprestimo.setBounds(440, 330, 149, 53);
            btnConsultarEmprestimo.setBackground(Color.GREEN);
            contentPane.add(btnConsultarEmprestimo);
            
            JButton btnSair = new JButton("Sair");
            btnSair.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                       TelaPrincipalAdministrador.this.dispose();
                }
        });
            btnSair.setForeground(Color.black);
            btnSair.setBounds(400, 420, 70, 23);
            btnSair.setBackground(Color.lightGray);
            contentPane.add(btnSair);            
            
    }
}
