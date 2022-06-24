package com.ufba.eng.soft.bibliotecapessoal.front.jframe;

import com.ufba.eng.soft.bibliotecapessoal.model.repository.LivrosRepositoryImpl;
import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FormularioDeEmprestimoJFrame extends JFrame {
    private JPanel contentPane;
    private JTextField dataDeEmprestimoField;
    private JTextField dataDeDevolucaoField;
    
    public FormularioDeEmprestimoJFrame () {
        
        criarFormularioNome();
    }
    
    private void criarFormularioNome() {
        
        setTitle("Persibi - Empréstimo de Livro");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(300, 300, 500, 350);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        EmprestaAction emprestaAction = new EmprestaAction();
        LimparAction limparAction = new LimparAction();
        SairAction sairAction = new SairAction();
        
        setLayout(new BorderLayout());
        
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());
        
        JLabel titulo = new JLabel ("Persibi - Livro Disponível");
        titulo.setFont(new Font("verdana", Font.PLAIN, 16));
        panelTitulo.add(titulo);
        
        JPanel panelConsulta = new JPanel();
        panelConsulta.setLayout(new FlowLayout());
        
        JLabel dataDeEmprestimoLabel = new JLabel ("Data de Empréstimo");
        dataDeEmprestimoField = new JTextField(40);     
        
        JLabel dataDeDevolucaoLabel = new JLabel ("Data de Devolução");
        dataDeDevolucaoField = new JTextField(40);     
        
        panelConsulta.add(dataDeEmprestimoLabel);
         panelConsulta.add( dataDeEmprestimoField);
        panelConsulta.add(dataDeDevolucaoLabel);
        panelConsulta.add( dataDeDevolucaoField);
        
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new FlowLayout());
        
        JButton botaoEmprestar = new JButton("Emprestar");
        botaoEmprestar.setBackground(Color.GREEN);
        botaoEmprestar.addActionListener(emprestaAction);        

        
        JButton botaoLimpar = new JButton("Limpar");
        botaoLimpar.setBackground(Color.red);
        botaoLimpar.addActionListener(limparAction);
        
        JButton botaoSair = new JButton("Sair");
        botaoSair.setBackground(Color.lightGray);
        botaoSair.addActionListener(sairAction);
        
        panelBotoes.add(botaoEmprestar);
        panelBotoes.add(botaoLimpar);
        panelBotoes.add(botaoSair);
        
        add(panelTitulo, BorderLayout.NORTH);
        add(panelConsulta, BorderLayout.CENTER);
        add(panelBotoes, BorderLayout.SOUTH);        
    }
    
    
    private class EmprestaAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            
                JOptionPane.showMessageDialog(null, "Livro emprestado com sucesso", "Emprestimo", JOptionPane.PLAIN_MESSAGE);       
            
        }
    }
    
    
    
    private class LimparAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            dataDeEmprestimoField.setText("");
            dataDeDevolucaoField.setText("");
        }
    }
    
    private class SairAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            FormularioDeEmprestimoJFrame.this.dispose();            
        }
    }
    
}
    



