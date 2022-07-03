package com.ufba.eng.soft.bibliotecapessoal.front.jframe;

import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.LivrosRepository;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.UsuariosRepository;
import com.ufba.eng.soft.bibliotecapessoal.model.user.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ReservaLivroJFrame extends JFrame {
    private JPanel contentPane;
    private TipoUsuario tipoUsuario;
    private JTextField idField; 
    private JTextField isbnLivroField;
    private LivrosRepository livrosRepository;
    private UsuariosRepository usuariosRepository;
    
    
    
    public ReservaLivroJFrame(TipoUsuario tipoUsuario, LivrosRepository livrosRepository, UsuariosRepository usuariosRepository) {
        this.tipoUsuario = tipoUsuario;
        this.livrosRepository = livrosRepository;
        this.usuariosRepository = usuariosRepository;
        criarFormularioNome(tipoUsuario);
    }
    
    private void criarFormularioNome(TipoUsuario tipoUsuario) {
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

        if(tipoUsuario == TipoUsuario.PROFESSOR){
          botaoBuscar.addActionListener(buscarProfessorAction);
        }
        if(tipoUsuario == TipoUsuario.ALUNO){
            botaoBuscar.addActionListener(buscarAlunoAction);  
        }
        if(tipoUsuario == TipoUsuario.ORIENTANDO){
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
            Professor professor = usuariosRepository.consultarProfessorId(idProfessor);
            realizarReserva(professor, isbnLivro);
        }
    }

    private void realizarReserva(UsuarioDoSistema usuarioDoSistema, String isbnLivro) {
        Livro livro = livrosRepository.getLivroPorISBN(isbnLivro);
        if (usuarioDoSistema == null) {
            JOptionPane.showMessageDialog(null, "Usuário(a) nao encontrado", "Reserva", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (livro == null) {
            JOptionPane.showMessageDialog(null, "Livro nao encontrado", "Reserva", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (livro.isReservadoPara(usuarioDoSistema.getIdUsuario())) {
            JOptionPane.showMessageDialog(null, "Livro ja esta na sua lista de reserva", "Reserva", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        if (livro.isEmprestadoPara(usuarioDoSistema.getIdUsuario())) {
            JOptionPane.showMessageDialog(null, "Livro ja esta na sua lista de empréstimos", "Reserva", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        livro.setReservado(true);
        livro.setReserva(usuarioDoSistema);
        livrosRepository.atualizarLivro(livro);

        JOptionPane.showMessageDialog(null, "Livro adicionado à sua lista de reserva", "Reserva", JOptionPane.PLAIN_MESSAGE);
    }

    private class BuscarAlunoAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String idAluno = idField.getText();
            String isbnLivro = isbnLivroField.getText();

            Aluno aluno = usuariosRepository.consultarAlunoId(idAluno);
            realizarReserva(aluno, isbnLivro);
        }
    }
    
    private class BuscarOrientandoAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String idOrientando = idField.getText();
            String isbnLivro = isbnLivroField.getText();
          
            Orientando orientando = usuariosRepository.consultarOrientandoId(idOrientando);
            realizarReserva(orientando, isbnLivro);
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
