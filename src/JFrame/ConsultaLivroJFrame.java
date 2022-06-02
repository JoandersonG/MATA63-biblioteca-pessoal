package JFrame;

import JFrame.ConsultaLivroJFrame;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ConsultaLivroJFrame extends JFrame{
    private JPanel contentPane;
    
    public static void main(String[] args) {
	
    }
    
    private String tipo;
    private JTextField identificacaoField;
    
    public ConsultaLivroJFrame(String tipo) {
        tipo = tipo;
        criarFormulario(tipo);
    }

    private void criarFormulario(String tipo) {
            tipo = tipo; 
            setTitle("Buscar Livro");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 450, 300);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(3, 3, 3, 3));
            setContentPane(contentPane);
            contentPane.setLayout(null);
        
        FecharAction fecharAction = new FecharAction();
        BuscarISBN buscarISBN = new BuscarISBN();
        BuscarNome buscarNome = new BuscarNome();
        BuscarCodBarra buscarCodBarra= new BuscarCodBarra();
        LimparAction limparAction = new LimparAction();
        
        setLayout(new BorderLayout());
        
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());
        
        JLabel titulo = new JLabel ("Buscar Livro");
        titulo.setFont(new Font("verdana", Font.PLAIN, 16));
        
        panelTitulo.add(titulo);
        
        JPanel panelConsulta = new JPanel();
        panelConsulta.setLayout(new FlowLayout());
        
        JLabel identificacaoLabel = new JLabel ("Identificação");
        identificacaoField = new JTextField(38);
       
        panelConsulta.add(identificacaoLabel);
        panelConsulta.add(identificacaoField);
        
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new FlowLayout());
        
        JButton botaoBuscar = new JButton("Buscar");
        panelBotoes.add(botaoBuscar);
        
        if(tipo == "ISBN"){ 
            botaoBuscar.addActionListener(buscarISBN);
            /* Se livro for encontrado pelo ISBN, será retornada uma mensagem
            contendo os dados do livro*/
        }
        if(tipo == "Nome"){ 
            botaoBuscar.addActionListener(buscarNome); 
            /* Se livro for encontrado pelo nome, será retornada uma mensagem
            contendo os dados do livro*/
        }
        if(tipo == "CodBarra"){ 
            botaoBuscar.addActionListener(buscarCodBarra);
            /* Se livro for encontrado pelo código de barras, será retornada uma mensagem
            contendo os dados do livro*/
        }
        
        JButton botaoLimpar = new JButton("Limpar");
        botaoLimpar.addActionListener(limparAction);
        
        JButton botaoSair = new JButton("Sair");
        botaoSair.addActionListener(fecharAction);
        
        panelBotoes.add(botaoLimpar);
        panelBotoes.add(botaoSair);
        
        add(panelTitulo, BorderLayout.NORTH);
        add(panelConsulta, BorderLayout.CENTER);
        add(panelBotoes, BorderLayout.SOUTH);        
    }
    
    private class LimparAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            identificacaoField.setText("");
        }
    }
    
    private class FecharAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            ConsultaLivroJFrame.this.dispose();            
        }
    }
    
    private class BuscarISBN implements ActionListener {
        public void actionPerformed(ActionEvent event) {
             JOptionPane.showMessageDialog(null, "Livro encontrado pelo ISBN!", "Consulta", JOptionPane.PLAIN_MESSAGE);       
            
        }

    }
    
    private class BuscarCodBarra implements ActionListener {
        public void actionPerformed(ActionEvent event) {
             JOptionPane.showMessageDialog(null, "Livro encontrado pelo código de barras!", "Consulta", JOptionPane.PLAIN_MESSAGE);       
            
        }

    }
    
    private class BuscarNome implements ActionListener {
        public void actionPerformed(ActionEvent event) {
             JOptionPane.showMessageDialog(null, "Livro encontrado pelo nome!", "Consulta", JOptionPane.PLAIN_MESSAGE);       
            
        }

    }
}