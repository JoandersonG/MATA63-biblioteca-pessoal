package com.ufba.eng.soft.bibliotecapessoal.front.view;

import com.ufba.eng.soft.bibliotecapessoal.front.jframe.CadastroJFrame;
import com.ufba.eng.soft.bibliotecapessoal.front.jframe.ConsultaUsuarioIdJFrame;
import com.ufba.eng.soft.bibliotecapessoal.front.jframe.ConsultaUsuarioNomeJFrame;
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


public class ConsultaUsuarioTelaInterna extends JFrame {
    private JPanel contentPane;
    private String identificacao;
    private String usuario;

/**
     * Create the frame.
     */
    public ConsultaUsuarioTelaInterna(String identificacao) throws FileNotFoundException, IOException {
            setTitle("\"Persibi - Consulta de Usu�rio");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(300, 300, 650, 500);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);
            getContentPane().setBackground(Color.WHITE);     
            
            JLabel titulo1 = new JLabel ("O usu�rio buscado �: ");
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
            
            identificacao = identificacao;
            
            if(identificacao == "Nome"){
                    JButton btnProfessor = new JButton("Professor");
                    btnProfessor.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent arg0) {
                                    usuario = "Professor";
                                    new ConsultaUsuarioNomeJFrame( usuario).setVisible(true);
                            }
                    });
                    btnProfessor.setForeground(Color.WHITE);
                    btnProfessor.setBounds(360, 80, 200, 70);
                    btnProfessor.setBackground(Color.BLUE);
                    contentPane.add(btnProfessor);

                    JButton btnAluno = new JButton("Aluno");
                    btnAluno.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent arg0) {
                                    usuario = "Aluno";
                                    new ConsultaUsuarioNomeJFrame( usuario).setVisible(true);
                            }
                    });
                    btnAluno.setForeground(Color.WHITE);
                    btnAluno.setBounds(360, 180, 200, 70);
                    btnAluno.setBackground(Color.RED);
                    contentPane.add(btnAluno);        

                    JButton btnOrientando = new JButton("Orientando");
                    btnOrientando.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent arg0) {
                                    usuario = "Orientando";
                                    new ConsultaUsuarioNomeJFrame(usuario).setVisible(true);
                            }
                    });
                    btnOrientando.setForeground(Color.WHITE);
                    btnOrientando.setBounds(360, 280, 200, 70);
                    btnOrientando.setBackground(Color.GREEN);
                    contentPane.add(btnOrientando);
            }
            
            if(identificacao == "Id"){
                    JButton btnProfessor = new JButton("Professor");
                    btnProfessor.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent arg0) {
                                    usuario = "Professor";
                                    new ConsultaUsuarioIdJFrame( usuario).setVisible(true);
                            }
                    });
                    btnProfessor.setForeground(Color.WHITE);
                    btnProfessor.setBounds(360, 80, 200, 70);
                    btnProfessor.setBackground(Color.BLUE);
                    contentPane.add(btnProfessor);

                    JButton btnAluno = new JButton("Aluno");
                    btnAluno.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent arg0) {
                                    usuario = "Aluno";
                                     new ConsultaUsuarioIdJFrame( usuario).setVisible(true);
                            }
                    });
                    btnAluno.setForeground(Color.WHITE);
                    btnAluno.setBounds(360, 180, 200, 70);
                    btnAluno.setBackground(Color.RED);
                    contentPane.add(btnAluno);        

                    JButton btnOrientando = new JButton("Orientando");
                    btnOrientando.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent arg0) {
                                    usuario = "Orientando";
                                     new ConsultaUsuarioIdJFrame( usuario).setVisible(true);
                            }
                    });
                    btnOrientando.setForeground(Color.WHITE);
                    btnOrientando.setBounds(360, 280, 200, 70);
                    btnOrientando.setBackground(Color.GREEN);
                    contentPane.add(btnOrientando);
            }
            
            

            JButton btnSair = new JButton("Sair");
            btnSair.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                           ConsultaUsuarioTelaInterna.this.dispose();
                    }
            });
            btnSair.setForeground(Color.black);
            btnSair.setBounds(428, 400, 70, 23);
            btnSair.setBackground(Color.lightGray);
            contentPane.add(btnSair);

    }
}

