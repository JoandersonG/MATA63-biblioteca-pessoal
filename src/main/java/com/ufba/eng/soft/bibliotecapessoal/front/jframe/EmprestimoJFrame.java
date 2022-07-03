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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EmprestimoJFrame extends JFrame {
    private JPanel contentPane;
    private JTextField idField; 
    private JTextField isbnLivroField;
    private UsuariosRepository usuariosRepository;
    private LivrosRepository livrosRepository;

    public EmprestimoJFrame(TipoUsuario tipoUsuario, UsuariosRepository usuariosRepository, LivrosRepository livrosRepository) {
        this.usuariosRepository = usuariosRepository;
        this.livrosRepository = livrosRepository;
        criarFormularioNome(tipoUsuario);
    }
    
    private void criarFormularioNome(TipoUsuario usuario) {
        setTitle("Persibi - Empréstimo de Livro");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(300, 300, 500, 350);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        EmprestaProfessorAction emprestaProfessorAction = new EmprestaProfessorAction();
        EmprestaAlunoAction emprestaAlunoAction = new EmprestaAlunoAction();
        EmprestaOrientandoAction emprestaOrientandoAction = new EmprestaOrientandoAction();
        LimparAction limparAction = new LimparAction();
        SairAction sairAction = new SairAction();
        
        setLayout(new BorderLayout());
        
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());
        
        JLabel titulo = new JLabel ("Empréstimo de Livro");
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
        
        JButton botaoBuscar = new JButton("Emprestar");
        botaoBuscar.setBackground(Color.GREEN);
        panelBotoes.add(botaoBuscar);
        
        if(usuario == TipoUsuario.PROFESSOR){
          botaoBuscar.addActionListener(emprestaProfessorAction);  
        }
        if(usuario == TipoUsuario.ALUNO){
            botaoBuscar.addActionListener(emprestaAlunoAction);  
        }
        if(usuario == TipoUsuario.ORIENTANDO){
            botaoBuscar.addActionListener(emprestaOrientandoAction);  
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
    
    
    private class EmprestaProfessorAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String idProfessor = idField.getText();
            String isbnLivro = isbnLivroField.getText();
            Professor professor = usuariosRepository.consultarProfessorId(idProfessor);
            realizarEmprestimo(professor, isbnLivro);
        }
    }

    private class EmprestaAlunoAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String idAluno = idField.getText();
            String isbnLivro = isbnLivroField.getText();
            Aluno aluno = usuariosRepository.consultarAlunoId(idAluno);
            realizarEmprestimo(aluno, isbnLivro);
        }
    }

    private class EmprestaOrientandoAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String idOrientando = idField.getText();
            String isbnLivro = isbnLivroField.getText();
            Orientando orientando = usuariosRepository.consultarOrientandoId(idOrientando);
            realizarEmprestimo(orientando, isbnLivro);
        }
    }

    private void realizarEmprestimo(UsuarioDoSistema usuarioDoSistema, String isbnLivro) {
        Livro livro = livrosRepository.getLivroPorISBN(isbnLivro);
        if (usuarioDoSistema == null) {
            JOptionPane.showMessageDialog(null, "Usuário(a) nao encontrado", "Emprestimo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (livro == null) {
            JOptionPane.showMessageDialog(null, "Livro nao encontrado", "Emprestimo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (livro.isEmprestadoPara(usuarioDoSistema.getIdUsuario())) {
            JOptionPane.showMessageDialog(null, "Livro ja esta na sua lista de emprestimos", "Emprestimo", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        if (!livro.temCopiasDisponiveisParaEmprestimo()) {
            JOptionPane.showMessageDialog(null, "Livro não possui cópias disponíveis, mas é possível adicionar à lista de reservas", "Emprestimo", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        livro.setEmprestado(true);
        livro.setEmprestimo(usuarioDoSistema);
        livrosRepository.atualizarLivro(livro);

        JOptionPane.showMessageDialog(null, "Livro adicionado à sua lista de empréstimo", "Emprestimo", JOptionPane.PLAIN_MESSAGE);
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
            EmprestimoJFrame.this.dispose();            
        }
    }
    
}



