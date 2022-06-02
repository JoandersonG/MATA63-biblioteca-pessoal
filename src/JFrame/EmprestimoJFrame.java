package JFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EmprestimoJFrame extends JFrame{
    private JPanel contentPane;
    
    public static void main(String[] args) {
	
    }
    
    private String tipo;
    private JTextField identificacaoField;
    
    public EmprestimoJFrame(String tipo) {
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
            contendo a data de empréstimo e de devolução prevista. Muda-se o status
            do livro no banco de dados para emprestado*/
        }
        if(tipo == "Nome"){ 
            botaoBuscar.addActionListener(buscarNome); 
            /* Se livro for encontrado pelo nome, será retornada uma mensagem
            contendo a data de empréstimo e de devolução prevista. Muda-se o status
            do livro no banco de dados para emprestado*/
        }
        if(tipo == "CodBarra"){ 
            botaoBuscar.addActionListener(buscarCodBarra);
            /* Se livro for encontrado pelo código de barras, será retornada uma mensagem
            contendo a data de empréstimo e de devolução prevista. Muda-se o status
            do livro no banco de dados para emprestado*/
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
            EmprestimoJFrame.this.dispose();            
        }
    }
    
    private class BuscarISBN implements ActionListener {
        public void actionPerformed(ActionEvent event) {
             //Operação de empréstimo por ISBN
        }

    }
    
    private class BuscarCodBarra implements ActionListener {
        public void actionPerformed(ActionEvent event) {
             //Operação de empréstimo por código de barras       
        }

    }
    
    private class BuscarNome implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            //Operação de empréstimo por nome           
        }

    }
    
}