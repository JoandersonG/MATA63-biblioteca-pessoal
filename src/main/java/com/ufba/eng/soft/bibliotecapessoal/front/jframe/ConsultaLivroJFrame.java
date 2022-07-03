package com.ufba.eng.soft.bibliotecapessoal.front.jframe;

import com.ufba.eng.soft.bibliotecapessoal.model.repository.LivrosRepository;
import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ConsultaLivroJFrame extends JFrame {
    private JPanel contentPane;
    private JTextField identificacaoField;
    private LivrosRepository livrosRepository;

    
    public ConsultaLivroJFrame(String tipoDeBusca, LivrosRepository livrosRepository) {
        this.livrosRepository = livrosRepository;
        criarFormularioNome(tipoDeBusca);
    }
    
    private void criarFormularioNome(String tipoDeBusca) {
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
        
        JLabel identificacaoLabel = new JLabel ("Identicação");
        identificacaoField = new JTextField(40);     
        
        panelConsulta.add(identificacaoLabel);
        panelConsulta.add(identificacaoField);
        
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new FlowLayout());
        
        JButton botaoBuscar = new JButton("Buscar");
        botaoBuscar.setBackground(Color.GREEN);
        panelBotoes.add(botaoBuscar);
        
        if(tipoDeBusca.equals("ISBN")){
            botaoBuscar.addActionListener(buscarLivroISBNAction);  
        }
        if(tipoDeBusca.equals("Nome")){
            botaoBuscar.addActionListener(buscarLivroNomeAction);  
        }//todo: revisar acentuações
        if(tipo == "Cód. Barras"){ 
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
            
            Livro livro = livrosRepository.getLivroPorISBN(identificacaoLivro);
           
            if(livro != null){
                new MostrarInformacoesLivroJFrame(livro).setVisible(true);
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Livro não encontrado", "Consulta", JOptionPane.PLAIN_MESSAGE);       
            }
        }
    }
    
    private class BuscarLivroNomeAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String identificacaoLivro = identificacaoField.getText();

            List<Livro> livrosComTituloParcial = livrosRepository.getLivrosComTituloParcial(identificacaoLivro);
            Livro livro = livrosComTituloParcial.isEmpty() ? null : livrosComTituloParcial.get(0);
           
            if(livro != null){
                new MostrarInformacoesLivroJFrame(livro).setVisible(true);
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Livro não encontrado", "Consulta", JOptionPane.PLAIN_MESSAGE);       
            }
        }
    }
    
    private class BuscarLivroCodAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
           String identificacaoLivro = identificacaoField.getText();
            
            Livro livro = livrosRepository.getLivroPorCodBarras(identificacaoLivro);
           
            if(livro != null){
                new MostrarInformacoesLivroJFrame(livro).setVisible(true);
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Livro não encontrado", "Consulta", JOptionPane.PLAIN_MESSAGE);       
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
            ConsultaLivroJFrame.this.dispose();
        }
    }
    
}
    


