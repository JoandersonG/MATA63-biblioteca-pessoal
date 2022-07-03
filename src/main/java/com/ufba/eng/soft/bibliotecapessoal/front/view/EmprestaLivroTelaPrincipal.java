package com.ufba.eng.soft.bibliotecapessoal.front.view;

import com.ufba.eng.soft.bibliotecapessoal.front.jframe.EmprestimoJFrame;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.LivrosRepository;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.UsuariosRepository;
import com.ufba.eng.soft.bibliotecapessoal.model.user.TipoUsuario;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EmprestaLivroTelaPrincipal extends JFrame {
    private JPanel contentPane;
    private String identificacao;
    private String usuario;
    private UsuariosRepository usuariosRepository;
    private LivrosRepository livrosRepository;

/**
     * Create the frame.
     */
    public EmprestaLivroTelaPrincipal(UsuariosRepository usuariosRepository, LivrosRepository livrosRepository) throws FileNotFoundException, IOException {
            this.usuariosRepository = usuariosRepository;
            this.livrosRepository = livrosRepository;

            setTitle("\"Persibi - Empréstimo de Livro");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(300, 300, 650, 500);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);
            getContentPane().setBackground(Color.WHITE);     
            
            JLabel titulo1 = new JLabel ("Voce eh um: ");
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
            

            JButton btnProfessor = new JButton("Professor");
            btnProfessor.addActionListener(arg0 -> new  EmprestimoJFrame(TipoUsuario.PROFESSOR, usuariosRepository, livrosRepository).setVisible(true));
            btnProfessor.setForeground(Color.WHITE);
            btnProfessor.setBounds(360, 80, 200, 70);
            btnProfessor.setBackground(Color.BLUE);
            contentPane.add(btnProfessor);

            JButton btnAluno = new JButton("Aluno");
            btnAluno.addActionListener(arg0 -> new  EmprestimoJFrame(TipoUsuario.ALUNO, usuariosRepository, livrosRepository).setVisible(true));
            btnAluno.setForeground(Color.WHITE);
            btnAluno.setBounds(360, 180, 200, 70);
            btnAluno.setBackground(Color.RED);
            contentPane.add(btnAluno);        

            JButton btnOrientando = new JButton("Orientando");
            btnOrientando.addActionListener(arg0 -> new  EmprestimoJFrame(TipoUsuario.ORIENTANDO, usuariosRepository, livrosRepository).setVisible(true));
            btnOrientando.setForeground(Color.WHITE);
            btnOrientando.setBounds(360, 280, 200, 70);
            btnOrientando.setBackground(Color.GREEN);
            contentPane.add(btnOrientando);

            JButton btnSair = new JButton("Sair");
            btnSair.addActionListener(evt -> EmprestaLivroTelaPrincipal.this.dispose());
            btnSair.setForeground(Color.black);
            btnSair.setBounds(428, 400, 70, 23);
            btnSair.setBackground(Color.lightGray);
            contentPane.add(btnSair);

    }
}

