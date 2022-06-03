package com.ufba.eng.soft.bibliotecapessoal.front.view;

import com.ufba.eng.soft.bibliotecapessoal.front.jframe.EmprestimoJFrame;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.LivrosRepository;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarLivroTelaPrincipal extends JFrame{
    
    private LivrosRepository livrosRepository;
    private JPanel contentPane;
    private String identificacao;
    
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
                            //TODO: remover as prox duas linhas e inserir num 
                            //      novo método na classe GerenciadorDeTelas.java
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}

    public ConsultarLivroTelaPrincipal (LivrosRepository livrosRepository) {
        this.livrosRepository = livrosRepository;
        setTitle("Consulta de Livro");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(150, 150, 500, 350);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JButton btnISBN = new JButton("ISBN");
	btnISBN .addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
                                                           identificacao = "ISBN";
			new EmprestimoJFrame(identificacao).setVisible(true);
		}
	});
	btnISBN.setForeground(Color.BLUE);
	btnISBN.setBounds(155, 58, 149, 53);
	contentPane.add(btnISBN);
	
	JButton btnNome = new JButton("Nome");
	btnNome.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
                                                          identificacao = "Nome";
			new EmprestimoJFrame(identificacao).setVisible(true);
		}
	});
	btnNome.setForeground(Color.RED);
	btnNome.setBounds(155, 106, 149, 53);
	contentPane.add(btnNome);
	
	JButton btnCodBarra = new JButton("Cód. de Barra");
	btnCodBarra.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
                                                          identificacao = "CodBarra";
			new EmprestimoJFrame(identificacao).setVisible(true);
		}
	});
	btnCodBarra.setForeground(Color.GREEN);
	btnCodBarra.setBounds(155, 154, 149, 53);
	contentPane.add(btnCodBarra);
        
                    JButton btnSair = new JButton("Sair");
                    btnSair.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent evt) {
                                   ConsultarLivroTelaPrincipal.this.dispose();
                            }
                    });
                    btnSair.setForeground(Color.black);
                    btnSair.setBounds(300, 250, 149, 53);
                    contentPane.add(btnSair);
        
}

}