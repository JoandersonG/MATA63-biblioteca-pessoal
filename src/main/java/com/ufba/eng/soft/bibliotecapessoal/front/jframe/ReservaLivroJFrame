package com.ufba.eng.soft.bibliotecapessoal.front.jframe;

import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.LivrosRepositoryImpl;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.UsuariosRepositoryImpl;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Aluno;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Orientando;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Professor;
import com.ufba.eng.soft.bibliotecapessoal.model.user.UsuarioDoSistema;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

public class ReservaLivroJFrame extends JFrame {
    private JPanel contentPane;
    private String usuario;
    private JTextField idField; 
    private JTextField isbnLivroField;
    
    
    
    public ReservaLivroJFrame(String usuario) {
        usuario = usuario;
        criarFormularioNome(usuario);
    }
    
    private void criarFormularioNome(String usuario) {
        usuario = usuario; 
        setTitle("Persibi - Reserva de Livro...");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(300, 300, 500, 350);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        BuscarProfessorAction buscarProfessorAction = new BuscarProfessorAction();
        BuscarAlunoAction buscarAlunoAction = new BuscarAlunoAction();
        BuscarOrientandoAction buscarOrientandoAction = new BuscarOrientandoAction();
        LimparAction limparAction = new LimparAction();
        SairAction sairAction = new SairAction();
        
        setLayout(new BorderLayout());
        
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());
        
        JLabel titulo = new JLabel ("Reserva de livro ...");
        titulo.setFont(new Font("verdana", Font.PLAIN, 16));
        panelTitulo.add(titulo);
        
        JPanel panelConsulta = new JPanel();
        panelConsulta.setLayout(new FlowLayout());
        
        JLabel idLabel = new JLabel ("Id do usuario");
        idField = new JTextField(40);     
        
        panelConsulta.add(idLabel);
        panelConsulta.add(idField);
        
        JLabel isbnLivroLabel = new JLabel ("ISBN do livro");
        isbnLivroField = new JTextField(40);     
        
        panelConsulta.add(isbnLivroLabel);
        panelConsulta.add(isbnLivroField);
        
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new FlowLayout());
        
        JButton botaoBuscar = new JButton("Reservar");
        botaoBuscar.setBackground(Color.GREEN);
        panelBotoes.add(botaoBuscar);
        
        if(usuario == "Professor"){ 
          botaoBuscar.addActionListener(buscarProfessorAction);  
        }
        if(usuario == "Aluno"){ 
            botaoBuscar.addActionListener(buscarAlunoAction);  
        }
        if(usuario == "Orientando"){ 
            botaoBuscar.addActionListener(buscarOrientandoAction);  
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
    
    
    private class BuscarProfessorAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String idProfessor = idField.getText();
            String isbnLivro = isbnLivroField.getText();
          
            Professor professor = (Professor) new UsuariosRepositoryImpl().consultarProfessorId(idProfessor);
            int indexProfessor = new UsuariosRepositoryImpl().getTodosOsProfessoresCadastrados().indexOf(professor);
            Livro livro = (Livro) new LivrosRepositoryImpl().getLivroPorISBN(isbnLivro);
            int indexLivro = new LivrosRepositoryImpl().getTodosOsLivros().indexOf(livro);
            boolean reservado = false;
            
            if(professor != null){
                //new MostrarInformacoesJFrame(professor).setVisible(true);
                if(livro != null){
                    
                    ArrayList<Livro> livrosReservados = professor.getLivrosReservados();
                    for (Livro livro1 : livrosReservados) {
                        if (livro1.getCodigoISBN().equals(isbnLivro)) {
                            reservado = true;
                            break;
                        }
                    }
                    
                    // ISSO AQUI PODE SER UM CONSULTAR RESERVA PRA VER SE LIVRO ESTA DISPONIVEL PARA EMPRESTIMO
                    /*if(livro.isEmprestado() == false){
                        JOptionPane.showMessageDialog(null, "Livro disponivel para emprestimo", "Reserva", JOptionPane.PLAIN_MESSAGE);
                    }*/
                    
                    if(reservado == false){
                        livro.setReservado(true);
                        professor.setLivrosReservados(livro);
                        livro.setProfessoresReserva(professor);
                        new LivrosRepositoryImpl().adicionarReservaProfessor(livro, indexLivro);
                        new UsuariosRepositoryImpl().atualizarUsuarioProfessor(professor, indexProfessor);
                        JOptionPane.showMessageDialog(null, "Livro adicionado a sua lista de reserva", "Reserva", JOptionPane.PLAIN_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Livro ja esta na sua lista de reserva", "Reserva", JOptionPane.PLAIN_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Livro nao encontrado", "Reserva", JOptionPane.PLAIN_MESSAGE);
                }
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Professor(a) nao encontrado", "Reserva", JOptionPane.PLAIN_MESSAGE);       
            }
            
        }
    }
    
    private class BuscarAlunoAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String idAluno = idField.getText();
            String isbnLivro = isbnLivroField.getText();
          
            Aluno aluno = (Aluno) new UsuariosRepositoryImpl().consultarAlunoId(idAluno);
            int indexAluno = new UsuariosRepositoryImpl().getTodosOsAlunosCadastrados().indexOf(aluno);
            Livro livro = (Livro) new LivrosRepositoryImpl().getLivroPorISBN(isbnLivro);
            int indexLivro = new LivrosRepositoryImpl().getTodosOsLivros().indexOf(livro);
            boolean reservado = false;
            
            if(aluno != null){
                //new MostrarInformacoesJFrame(professor).setVisible(true);
                if(livro != null){
                    
                    ArrayList<Livro> livrosReservados = aluno.getLivrosReservados();
                    for (Livro livro1 : livrosReservados) {
                        if (livro1.getCodigoISBN().equals(isbnLivro)) {
                            reservado = true;
                            break;
                        }
                    }
                    
                    // ISSO AQUI PODE SER UM CONSULTAR RESERVA PRA VER SE LIVRO ESTA DISPONIVEL PARA EMPRESTIMO
                    /*if(livro.isEmprestado() == false){
                        JOptionPane.showMessageDialog(null, "Livro disponivel para emprestimo", "Reserva", JOptionPane.PLAIN_MESSAGE);
                    }*/
                    
                    if(reservado == false){
                        livro.setReservado(true);
                        aluno.setLivrosReservados(livro);
                        livro.setAlunosReserva(aluno);
                        new LivrosRepositoryImpl().adicionarReservaAluno(livro, indexLivro);
                        new UsuariosRepositoryImpl().atualizarUsuarioAluno(aluno, indexAluno);
                        JOptionPane.showMessageDialog(null, "Livro adicionado a sua lista de reserva", "Reserva", JOptionPane.PLAIN_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Livro ja esta na sua lista de reserva", "Reserva", JOptionPane.PLAIN_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Livro nao encontrado", "Reserva", JOptionPane.PLAIN_MESSAGE);
                }
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Aluno(a) nao encontrado", "Reserva", JOptionPane.PLAIN_MESSAGE);       
            }
            
        }
    }
    
    private class BuscarOrientandoAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String idOrientando = idField.getText();
            String isbnLivro = isbnLivroField.getText();
          
            Orientando orientando = (Orientando) new UsuariosRepositoryImpl().consultarOrientandoId(idOrientando);
            int indexOrientando = new UsuariosRepositoryImpl().getTodosOsOrientandosCadastrados().indexOf(orientando);
            Livro livro = (Livro) new LivrosRepositoryImpl().getLivroPorISBN(isbnLivro);
            int indexLivro = new LivrosRepositoryImpl().getTodosOsLivros().indexOf(livro);
            boolean reservado = false;
            
            if(orientando != null){
                //new MostrarInformacoesJFrame(professor).setVisible(true);
                if(livro != null){
                    
                    ArrayList<Livro> livrosReservados = orientando.getLivrosReservados();
                    for (Livro livro1 : livrosReservados) {
                        if (livro1.getCodigoISBN().equals(isbnLivro)) {
                            reservado = true;
                            break;
                        }
                    }
                    
                    // ISSO AQUI PODE SER UM CONSULTAR RESERVA PRA VER SE LIVRO ESTA DISPONIVEL PARA EMPRESTIMO
                    /*if(livro.isEmprestado() == false){
                        JOptionPane.showMessageDialog(null, "Livro disponivel para emprestimo", "Reserva", JOptionPane.PLAIN_MESSAGE);
                    }*/
                    
                    if(reservado == false){
                        livro.setReservado(true);
                        orientando.setLivrosReservados(livro);
                        livro.setOrientandosReserva(orientando);
                        new LivrosRepositoryImpl().adicionarReservaOrientando(livro, indexLivro);
                        new UsuariosRepositoryImpl().atualizarUsuarioOrientando(orientando, indexOrientando);
                        JOptionPane.showMessageDialog(null, "Livro adicionado a sua lista de reserva", "Reserva", JOptionPane.PLAIN_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Livro ja esta na sua lista de reserva", "Reserva", JOptionPane.PLAIN_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Livro nao encontrado", "Reserva", JOptionPane.PLAIN_MESSAGE);
                }
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Orientando(a) nao encontrado", "Reserva", JOptionPane.PLAIN_MESSAGE);       
            }
            
        }
    }
    
    private class LimparAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            idField.setText("");
        }
    }
    
    private class SairAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            ReservaLivroJFrame.this.dispose();            
        }
    }
    
}
