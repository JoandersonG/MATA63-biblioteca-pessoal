
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
public CadastroUsuarioTelaPrincipal() {
	setTitle("Cadastro de Usuário");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(150, 150, 500, 350);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JButton btnProfessor = new JButton("Professor");
	btnProfessor.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
                        usuario = "Professor";
			new CadastroJFrame(usuario).setVisible(true);
		}
	});
	btnProfessor.setForeground(Color.BLUE);
	btnProfessor.setBounds(155, 58, 149, 53);
	contentPane.add(btnProfessor);
	
	JButton btnAluno = new JButton("Aluno");
	btnAluno.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
                        usuario = "Aluno";
			new CadastroJFrame(usuario).setVisible(true);
		}
	});
	btnAluno.setForeground(Color.RED);
	btnAluno.setBounds(155, 106, 149, 53);
	contentPane.add(btnAluno);
	
	JButton btnOrientando = new JButton("Orientando");
	btnOrientando.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
                        usuario = "Orientando";
			new CadastroJFrame(usuario).setVisible(true);
		}
	});
	btnOrientando.setForeground(Color.GREEN);
	btnOrientando.setBounds(155, 154, 149, 53);
	contentPane.add(btnOrientando);
        
        JButton btnSair = new JButton("Sair");
        btnSair.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                       CadastroUsuarioTelaPrincipal.this.dispose();
                }
        });
        btnSair.setForeground(Color.black);
	btnSair.setBounds(300, 250, 149, 53);
	contentPane.add(btnSair);
        
}

}

