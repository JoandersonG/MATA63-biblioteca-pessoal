
package com.ufba.eng.soft.bibliotecapessoal.front.view;

import com.ufba.eng.soft.bibliotecapessoal.front.jframe.CadastroJFrame;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
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


public class CadastroUsuarioTelaPrincipal extends JFrame {
    private JPanel contentPane;
    private String usuario;

/**
 * Launch the application.
 */
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				CadastroUsuarioTelaPrincipal frame = new CadastroUsuarioTelaPrincipal();
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
    public CadastroUsuarioTelaPrincipal() throws FileNotFoundException, IOException {
            setTitle("\"Persibi - Cadastro de Usuário");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(300, 300, 650, 500);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);
            getContentPane().setBackground(Color.WHITE);        

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
            btnProfessor.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            usuario = "Professor";
                            new CadastroJFrame(usuario).setVisible(true);
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
                            new CadastroJFrame(usuario).setVisible(true);
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
                            new CadastroJFrame(usuario).setVisible(true);
                    }
            });
            btnOrientando.setForeground(Color.WHITE);
            btnOrientando.setBounds(360, 280, 200, 70);
            btnOrientando.setBackground(Color.GREEN);
            contentPane.add(btnOrientando);

            JButton btnSair = new JButton("Sair");
            btnSair.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                           CadastroUsuarioTelaPrincipal.this.dispose();
                    }
            });
            btnSair.setForeground(Color.black);
            btnSair.setBounds(428, 400, 70, 23);
            btnSair.setBackground(Color.lightGray);
            contentPane.add(btnSair);

    }
}
