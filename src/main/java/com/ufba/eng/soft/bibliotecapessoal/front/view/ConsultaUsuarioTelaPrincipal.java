package com.ufba.eng.soft.bibliotecapessoal.front.view;

import com.ufba.eng.soft.bibliotecapessoal.front.jframe.CadastroJFrame;
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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class ConsultaUsuarioTelaPrincipal extends JFrame {
    private JPanel contentPane;
    private String identificacao;


/**
     * Create the frame.
     */
    public ConsultaUsuarioTelaPrincipal() throws FileNotFoundException, IOException {
            setTitle("\"Persibi - Consulta de Usuário");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(300, 300, 650, 500);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);
            getContentPane().setBackground(Color.WHITE);  
            
            JLabel titulo1 = new JLabel ("Consulte um usuário");
            titulo1.setBounds(55, 90, 500, 300);
            titulo1.setFont(new Font("verdana", Font.CENTER_BASELINE, 16));
            contentPane.add(titulo1);
            
            JLabel titulo2 = new JLabel ("Escolha a opção: Nome ou Id");
            titulo2.setBounds(20, 115, 500, 300);
            titulo2.setFont(new Font("verdana", Font.CENTER_BASELINE, 16));
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

            JButton btnNome = new JButton("Nome");
            btnNome.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            identificacao = "Nome";
                        try {
                            new ConsultaUsuarioTelaInterna(identificacao).setVisible(true);
                        } catch (IOException ex) {
                            Logger.getLogger(ConsultaUsuarioTelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
            });
            btnNome.setForeground(Color.WHITE);
            btnNome.setBounds(360, 120, 200, 70);
            btnNome.setBackground(Color.BLUE);
            contentPane.add( btnNome);

            JButton btnId = new JButton("Id");
            btnId.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            identificacao = "Id";
                        try {
                            new ConsultaUsuarioTelaInterna(identificacao).setVisible(true);
                        } catch (IOException ex) {
                            Logger.getLogger(ConsultaUsuarioTelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
            });
            btnId.setForeground(Color.WHITE);
            btnId.setBounds(360, 220, 200, 70);
            btnId.setBackground(Color.RED);
            contentPane.add(btnId);        

            JButton btnSair = new JButton("Sair");
            btnSair.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                           ConsultaUsuarioTelaPrincipal.this.dispose();
                    }
            });
            btnSair.setForeground(Color.black);
            btnSair.setBounds(428, 400, 70, 23);
            btnSair.setBackground(Color.lightGray);
            contentPane.add(btnSair);

    }
}
