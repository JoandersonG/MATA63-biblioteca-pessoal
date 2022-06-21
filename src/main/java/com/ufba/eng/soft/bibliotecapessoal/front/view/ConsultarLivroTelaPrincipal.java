package com.ufba.eng.soft.bibliotecapessoal.front.view;

import com.ufba.eng.soft.bibliotecapessoal.front.jframe.ConsultaLivroJframe;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.EventQueue;
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

public class ConsultarLivroTelaPrincipal extends JFrame{
    
    private JPanel contentPane;
    private String tipo;

    public ConsultarLivroTelaPrincipal () throws FileNotFoundException, IOException {
           setTitle("\"Persibi - Consulta de Livro");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(300, 300, 650, 500);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);
            getContentPane().setBackground(Color.WHITE);  
            
            JLabel titulo1 = new JLabel ("Consulte um livro");
            titulo1.setBounds(55, 90, 500, 300);
            titulo1.setFont(new Font("verdana", Font.CENTER_BASELINE, 16));
            contentPane.add(titulo1);
            
            JLabel titulo2 = new JLabel ("Escolha a opção: ");
            titulo2.setBounds(55, 115, 500, 300);
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

            JButton btnIsbn = new JButton("ISBN");
            btnIsbn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            tipo = "ISBN";
                            new ConsultaLivroJframe(tipo).setVisible(true);
                    }
            });
            btnIsbn.setForeground(Color.BLACK);
            btnIsbn.setBounds(360, 120, 200, 70);
            btnIsbn.setBackground(Color.red);
            contentPane.add(btnIsbn);
            
            JButton btnNome = new JButton("Nome");
            btnNome.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            tipo = "Nome";
                            new ConsultaLivroJframe(tipo).setVisible(true);
                    }
            });
            btnNome.setForeground(Color.BLACK);
            btnNome.setBounds(360, 220, 200, 70);
            btnNome.setBackground(Color.GREEN);
            contentPane.add( btnNome);
            
            JButton btnCod = new JButton("Cód. Barras");
            btnCod.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            tipo = "Cód. Barras";
                            new ConsultaLivroJframe(tipo).setVisible(true);
                    }
            });
            btnCod.setForeground(Color.BLACK);
            btnCod.setBounds(360, 320, 200, 70);
            btnCod.setBackground(Color.YELLOW);
            contentPane.add( btnCod);

            

            JButton btnSair = new JButton("Sair");
            btnSair.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                           ConsultarLivroTelaPrincipal.this.dispose();
                    }
            });
            btnSair.setForeground(Color.black);
            btnSair.setBounds(428, 400, 70, 23);
            btnSair.setBackground(Color.lightGray);
            contentPane.add(btnSair);
    }
}
