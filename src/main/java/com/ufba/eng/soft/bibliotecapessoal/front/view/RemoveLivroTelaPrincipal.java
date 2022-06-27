/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufba.eng.soft.bibliotecapessoal.front.view;

/**
 *
 * @author vanes
 */

import com.ufba.eng.soft.bibliotecapessoal.front.jframe.CadastroLivroJFrame;
import com.ufba.eng.soft.bibliotecapessoal.front.jframe.RemoveLivroJFrame;
import com.ufba.eng.soft.bibliotecapessoal.model.product.GeneroLivro;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.LivrosRepository;
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
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class RemoveLivroTelaPrincipal extends JFrame {
    
    private JPanel contentPane;
    private LivrosRepository livrosRepository;
    

/**
     * Create the frame.
     */
    public RemoveLivroTelaPrincipal(LivrosRepository livrosRepository) throws FileNotFoundException, IOException {
            this.livrosRepository = livrosRepository;
            setTitle("Persibi - Remoção de Livro");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(300, 300, 650, 500);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);
            getContentPane().setBackground(Color.WHITE);        
            
            JLabel titulo1 = new JLabel ("Escolha o g�nero do livro");
            titulo1.setBounds(30, 90, 500, 300);
            titulo1.setFont(new Font("verdana", Font.CENTER_BASELINE, 16));
            contentPane.add(titulo1);
            
            JLabel titulo2 = new JLabel ("que deseja remover");
            titulo2.setBounds(50, 115, 500, 300);
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

            JButton btnInfantil = new JButton("Infantil");
            btnInfantil.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            new RemoveLivroJFrame(livrosRepository, GeneroLivro.INFANTIL).setVisible(true);
                    }
            });
            btnInfantil.setForeground(Color.WHITE);
            btnInfantil.setBounds(280, 50, 149, 53);
            btnInfantil.setBackground(Color.BLUE);
            contentPane.add(btnInfantil);

            JButton btnParadidatico = new JButton("Paradid�tico");
            btnParadidatico.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            new RemoveLivroJFrame(livrosRepository, GeneroLivro.PARADIDATICO).setVisible(true);
                    }   
            });
            btnParadidatico.setForeground(Color.WHITE);
            btnParadidatico.setBounds(440, 50, 149, 53);
            btnParadidatico.setBackground(Color.RED);
            contentPane.add(btnParadidatico);        

            JButton btnDidatico = new JButton("Did�tico");
            btnDidatico.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            new RemoveLivroJFrame(livrosRepository, GeneroLivro.DIDATICO).setVisible(true);
                    }
            });
            btnDidatico.setForeground(Color.WHITE);
            btnDidatico.setBounds(280, 110, 149, 53);
            btnDidatico.setBackground(Color.RED);
            contentPane.add(btnDidatico);
            
            JButton btnInfantoJuvenil = new JButton("Infanto Juvenil");
            btnInfantoJuvenil.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            new RemoveLivroJFrame(livrosRepository, GeneroLivro.INFANTO_JUVENIL).setVisible(true);
                    }
            });
            btnInfantoJuvenil.setForeground(Color.WHITE);
            btnInfantoJuvenil.setBounds(440, 110, 149, 53);
            btnInfantoJuvenil.setBackground(Color.BLUE);
            contentPane.add(btnInfantoJuvenil);

            JButton btnFantasia = new JButton("Fantasia");
            btnFantasia.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            new RemoveLivroJFrame(livrosRepository, GeneroLivro.FANTASIA).setVisible(true);
                    }
            });
            btnFantasia.setForeground(Color.WHITE);
            btnFantasia.setBounds(280, 170, 149, 53);
            btnFantasia.setBackground(Color.BLUE);
            contentPane.add(btnFantasia);        
            
            JButton btnPolicial = new JButton("Policial");
            btnPolicial.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            new RemoveLivroJFrame(livrosRepository, GeneroLivro.POLICIAL).setVisible(true);
                    }
            });
            btnPolicial.setForeground(Color.WHITE);
            btnPolicial.setBounds(440, 170, 149, 53);
            btnPolicial.setBackground(Color.RED);
            contentPane.add(btnPolicial);
            
            JButton btnBiografia = new JButton("Biografia");
            btnBiografia.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            new RemoveLivroJFrame(livrosRepository, GeneroLivro.BIOGRAFIA).setVisible(true);
                    }
            });
            btnBiografia.setForeground(Color.WHITE);
            btnBiografia.setBounds(280, 230, 149, 53);
            btnBiografia.setBackground(Color.RED);
            contentPane.add(btnBiografia);
            
            JButton btnReligioso = new JButton("Religioso");
            btnReligioso.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            new RemoveLivroJFrame(livrosRepository, GeneroLivro.RELIGIOSO).setVisible(true);
                    }
            });
            btnReligioso.setForeground(Color.WHITE);
            btnReligioso.setBounds(440, 230, 149, 53);
            btnReligioso.setBackground(Color.BLUE);
            contentPane.add(btnReligioso);
            
            JButton btnAutoAjuda = new JButton("Auto Ajuda");
            btnAutoAjuda.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            new RemoveLivroJFrame(livrosRepository, GeneroLivro.AUTOAJUDA).setVisible(true);
                    }
            });
            btnAutoAjuda.setForeground(Color.WHITE);
            btnAutoAjuda.setBounds(360, 290, 149, 53);
            btnAutoAjuda.setBackground(Color.BLUE);
            contentPane.add(btnAutoAjuda);
           
            
            JButton btnSair = new JButton("Sair");
            btnSair.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                           RemoveLivroTelaPrincipal.this.dispose();
                    }
            });
            btnSair.setForeground(Color.black);
            btnSair.setBounds(400, 420, 70, 23);
            btnSair.setBackground(Color.lightGray);
            contentPane.add(btnSair);
    }
}



