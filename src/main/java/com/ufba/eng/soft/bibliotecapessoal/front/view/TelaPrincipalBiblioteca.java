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

public class TelaPrincipalBiblioteca extends JFrame {
    private JPanel contentPane;
    private String usuario;
    private UsuariosRepository usuariosRepository;
    private final LivrosRepository livrosRepository;

    /**
     * Create the frame.
     * @throws java.io.IOException
     */
    public TelaPrincipalBiblioteca(UsuariosRepository usuariosRepository, LivrosRepository livrosRepository) throws IOException {
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
           
            File file = new File(".\\src\\main\\java\\com\\ufba\\eng\\soft\\bibliotecapessoal\\front\\Logotype\\LogoBiblioteca.png");
            FileInputStream fis = new FileInputStream(file);  
            BufferedImage bufferedImage = ImageIO.read(fis);
            ImageIcon imageIcon = new ImageIcon(bufferedImage);            

            JLabel jLabel = new JLabel();
            jLabel.setBounds(5, 0, 350, 350);
            jLabel.setVisible(true);
            jLabel.setIcon(imageIcon);
            contentPane.add(jLabel);            
            
            JButton btnUsuario = new JButton("Usuário");
            btnUsuario.addActionListener((ActionEvent arg0) -> {
                try {
                    new TelaPrincipalUsuario(usuariosRepository, livrosRepository).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(TelaPrincipalBiblioteca.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            btnUsuario.setForeground(Color.WHITE);
            btnUsuario.setBounds(350, 100, 149, 53);
            btnUsuario.setBackground(Color.blue);
            contentPane.add(btnUsuario); 
            
            JButton btnAdministrador = new JButton("Administrador");
            btnAdministrador.addActionListener((ActionEvent arg0) -> {
                try {
                    new TelaPrincipalAdministrador(usuariosRepository, livrosRepository).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(TelaPrincipalBiblioteca.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            btnAdministrador.setForeground(Color.WHITE);
            btnAdministrador.setBounds(350, 250, 149, 53);
            btnAdministrador.setBackground(Color.red);
            contentPane.add(btnAdministrador);
            
            
            
            JButton btnSair = new JButton("Sair");
            btnSair.addActionListener((ActionEvent evt) -> {
                TelaPrincipalBiblioteca.this.dispose();
            });
            btnSair.setForeground(Color.black);
            btnSair.setBounds(400, 420, 70, 23);
            btnSair.setBackground(Color.lightGray);
            contentPane.add(btnSair);            
            
    }
}
