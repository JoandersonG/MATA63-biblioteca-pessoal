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

public class ConsultaLivroJFrame extends JFrame {
    private JPanel contentPane;
    private String tipo;
    private JTextField identificacaoField;
    
    
    public ConsultaLivroJFrame(String tipo) {
        tipo = tipo;
        criarFormularioNome(tipo);
    }
    
    private void criarFormularioNome(String tipo) {
        tipo = tipo;
        setTitle("Persibi - Buscando Livro ...");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(300, 300, 500, 350);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        BuscarLivroISBNAction buscarLivroISBNAction = new BuscarLivroISBNAction();
        BuscarLivroNomeAction buscarLivroNomeAction = new BuscarLivroNomeAction();
        BuscarLivroCodAction buscarLivroCodAction = new BuscarLivroCodAction();
        LimparAction limparAction = new LimparAction();
        SairAction sairAction = new SairAction();
        
        setLayout(new BorderLayout());
        
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());
        
        JLabel titulo = new JLabel ("Busca de Livro ...");
        titulo.setFont(new Font("verdana", Font.PLAIN, 16));
        panelTitulo.add(titulo);
        
        JPanel panelConsulta = new JPanel();
        panelConsulta.setLayout(new FlowLayout());
        
        JLabel identificacaoLabel = new JLabel ("Identica��o");
        identificacaoField = new JTextField(40);     
        
        panelConsulta.add(identificacaoLabel);
        panelConsulta.add(identificacaoField);
        
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new FlowLayout());
        
        JButton botaoBuscar = new JButton("Buscar");
        botaoBuscar.setBackground(Color.GREEN);
        panelBotoes.add(botaoBuscar);
        
        if(tipo == "ISBN"){ 
            botaoBuscar.addActionListener(buscarLivroISBNAction);  
        }
        if(tipo == "Nome"){ 
            botaoBuscar.addActionListener(buscarLivroNomeAction);  
        }
        if(tipo == "C�d. Barras"){ 
            botaoBuscar.addActionListener(buscarLivroCodAction);  
        }
          

        
        JButton botaoLimpar = new JButton("Limpar");
        botaoLimpar.setBackground(Color.red);
        botaoLimpar.addActionListener(limparAction);
        
        JButton botaoSair = new JButton("Sair");
        botaoSair.setBackground(Color.lightGray);
        botaoSair.addActionListener(sairAction);
        
        panelBotoes.add(botaoLimpar);
        panelBotoes.add(botaoSair);
        
        add(panelTitulo, BorderLayout.NORTH);
        add(panelConsulta, BorderLayout.CENTER);
        add(panelBotoes, BorderLayout.SOUTH);        
    }
    
    
    private class BuscarLivroISBNAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String identificacaoLivro = identificacaoField.getText();
            
            Livro livro = (Livro) new LivrosRepositoryImpl().getLivroPorISBN(identificacaoLivro);
           
            if(livro != null){
                new MostrarInformacoesLivroJFrame(livro).setVisible(true);
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Livro n�o encontrado", "Consulta", JOptionPane.PLAIN_MESSAGE);       
            }
        }
    }
    
    private class BuscarLivroNomeAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String identificacaoLivro = identificacaoField.getText();
            
            Livro livro = (Livro) new LivrosRepositoryImpl().getLivroPorNome(identificacaoLivro);
           
            if(livro != null){
                new MostrarInformacoesLivroJFrame(livro).setVisible(true);
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Livro n�o encontrado", "Consulta", JOptionPane.PLAIN_MESSAGE);       
            }
        }
    }
    
    private class BuscarLivroCodAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
           String identificacaoLivro = identificacaoField.getText();
            
            Livro livro = (Livro) new LivrosRepositoryImpl().getLivroPorCodBarras(identificacaoLivro);
           
            if(livro != null){
                new MostrarInformacoesLivroJFrame(livro).setVisible(true);
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Livro n�o encontrado", "Consulta", JOptionPane.PLAIN_MESSAGE);       
            }
        }
    }
    
    private class LimparAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            identificacaoField.setText("");
        }
    }
    
    private class SairAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            ConsultaLivroJframe.this.dispose();            
        }
    }
    
}
    


