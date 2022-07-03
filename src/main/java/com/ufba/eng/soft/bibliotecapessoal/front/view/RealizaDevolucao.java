/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufba.eng.soft.bibliotecapessoal.front.view;

import com.ufba.eng.soft.bibliotecapessoal.front.jframe.DevolucaoJFrame;
import com.ufba.eng.soft.bibliotecapessoal.front.jframe.EmprestimoJFrame;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.LivrosRepository;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.UsuariosRepository;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Guilherme Costa
 */
public class RealizaDevolucao extends JFrame{
    private final JPanel contentPane;
    private UsuariosRepository usuariosRepository;
    private LivrosRepository livrosRepository;

/**
     * Create the frame.
     */
    public RealizaDevolucao(UsuariosRepository usuariosRepository, LivrosRepository livrosRepository) throws FileNotFoundException, IOException {
            this.usuariosRepository = usuariosRepository;
            this.livrosRepository = livrosRepository;
        
        setTitle("\"Persibi - Devolução de Livro");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(300, 300, 650, 500);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);
            getContentPane().setBackground(Color.WHITE);     
            
            JLabel titulo1 = new JLabel (" Bem-vindo a página de devolução ");
            titulo1.setBounds(55, 90, 500, 300);
            titulo1.setFont(new Font("verdana", Font.CENTER_BASELINE, 16));
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
            

            JLabel codigoLivroLabel = new JLabel("Digite o código do livro: ");
            codigoLivroLabel.setBounds(360, 80, 200, 20);
            codigoLivroLabel.setFont(new Font("verdana", Font.CENTER_BASELINE, 14));
            
            JTextField j = new JTextField();
            j.setColumns(20);
            j.setBounds(360,100, 200, 30);
            
            JLabel codigoUsuarioLabel = new JLabel("Digite o ID de usuário: ");
            codigoUsuarioLabel.setBounds(360, 180, 200, 20);
            codigoUsuarioLabel.setFont(new Font("verdana", Font.CENTER_BASELINE, 14));
            
            JTextField t = new JTextField();
            t.setColumns(20);
            t.setBounds(360,200, 200, 30);
            
            contentPane.add(codigoLivroLabel);
            contentPane.add(j);            
            contentPane.add(codigoUsuarioLabel);
            contentPane.add(t);

            JButton btnDevolver = new JButton("Devolver");
            btnDevolver.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        System.out.println(j.getText());
                        System.out.println(t.getText());
                        new  DevolucaoJFrame(j.getText(),t.getText(), usuariosRepository, livrosRepository).setVisible(true);
                    }
            });
            btnDevolver.setForeground(Color.WHITE);
            btnDevolver.setBounds(428, 300, 110, 23);
            btnDevolver.setBackground(Color.BLUE);
            
            JButton btnSair = new JButton("Sair");
            btnSair.addActionListener((ActionEvent evt) -> {
                RealizaDevolucao.this.dispose();
            });
            btnSair.setForeground(Color.black);
            btnSair.setBounds(428, 400, 70, 23);
            btnSair.setBackground(Color.lightGray);
            
//            contentPane.add()
            contentPane.add(btnDevolver);
            contentPane.add(btnSair);
    }
}