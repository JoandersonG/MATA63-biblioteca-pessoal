/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufba.eng.soft.bibliotecapessoal.front.jframe;

import com.ufba.eng.soft.bibliotecapessoal.model.product.GeneroLivro;
import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;

import com.ufba.eng.soft.bibliotecapessoal.model.product.Autor;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.LivrosRepository;
import com.ufba.eng.soft.bibliotecapessoal.util.ResultadoVerificacao;
import com.ufba.eng.soft.bibliotecapessoal.util.VerificadorDeCampos;

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

public class RemoveLivroJFrame extends JFrame {
    
    private JPanel contentPane;
    private LivrosRepository livrosRepository;
    private GeneroLivro generoLivro;
    private JTextField tituloField;
    private JTextField autorField;
    private JTextField idAutorField;
    private JTextField isbnField;
    private JTextField codDeBarraField;
    
    
    public RemoveLivroJFrame(LivrosRepository livrosRepository, GeneroLivro generoLivro) {
        this.livrosRepository = livrosRepository;
        this.generoLivro = generoLivro;
        criarFormulario(generoLivro);
    }
    
    private void criarFormulario(GeneroLivro generoLivro) {
        setTitle("Persibi - Formul�rio de Cadastro do Livro");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(300, 300, 505, 350);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        CadastrarAction cadastrarAction = new CadastrarAction();
        LimparAction limparAction = new LimparAction();
        SairAction sairAction = new SairAction();
        
        setLayout(new BorderLayout());
        
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());
        
        JLabel titulo = new JLabel ("Formul�rio");
        titulo.setFont(new Font("verdana", Font.PLAIN, 16));
        panelTitulo.add(titulo);
        
        JPanel panelCadastro = new JPanel();
        panelCadastro.setLayout(new FlowLayout());
        
        JLabel isbnFieldLabel = new JLabel ("ISBN");
        isbnField = new JTextField(40);
   
        

        panelCadastro.add(isbnFieldLabel);
        panelCadastro.add(isbnField);

        
        
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new FlowLayout());
        
        JButton botaoRemover = new JButton("Remover");
        botaoRemover.setBackground(Color.GREEN);
        panelBotoes.add(botaoRemover);        
       
        botaoRemover.addActionListener(cadastrarAction);  
        
        JButton botaoLimpar = new JButton("Limpar");
        botaoLimpar.setBackground(Color.red);
        botaoLimpar.addActionListener(limparAction);
        
        JButton botaoSair = new JButton("Sair");
        botaoSair.setBackground(Color.lightGray);
        botaoSair.addActionListener(sairAction);
        
        panelBotoes.add(botaoLimpar);
        panelBotoes.add(botaoSair);
        
        add(panelTitulo, BorderLayout.NORTH);
        add(panelCadastro, BorderLayout.CENTER);
        add(panelBotoes, BorderLayout.SOUTH);        
    }
      
    private class CadastrarAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            //Verifica��o de campos. A ser feito: verificar todos os campos do formulario
            
            String ISBN = isbnField.getText();
            
            if (livrosRepository.removerLivro(ISBN)) {
                JOptionPane.showMessageDialog(null, "Livro removido com sucesso.");       
            }else{
                JOptionPane.showMessageDialog(null, "Livro não encontrao.");
            }
        }    
    }
   
    
    
    private class LimparAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            tituloField.setText("");
            autorField.setText("");
            idAutorField.setText("");
            isbnField.setText("");
            codDeBarraField.setText("");
        }
    }
    
    private class SairAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            RemoveLivroJFrame.this.dispose();            
        }
    }
    
}
    

    

