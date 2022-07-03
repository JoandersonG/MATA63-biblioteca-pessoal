package com.ufba.eng.soft.bibliotecapessoal.front.jframe;

import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.UsuariosRepository;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Aluno;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Orientando;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Professor;
import com.ufba.eng.soft.bibliotecapessoal.model.user.TipoUsuario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ConsultaUsuarioNomeJFrame extends JFrame {
    private JPanel contentPane;
    private JTextField nomeField;
    private UsuariosRepository usuariosRepository;


    public ConsultaUsuarioNomeJFrame(TipoUsuario tipoUsuario, UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
        criarFormularioNome(tipoUsuario);
    }
    
    private void criarFormularioNome(TipoUsuario tipoUsuario) {
        setTitle("Persibi - Buscando Usuário, pelo nome, no cadastro ...");
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
        
        JLabel titulo = new JLabel ("Busca de usuário pelo nome ...");
        titulo.setFont(new Font("verdana", Font.PLAIN, 16));
        panelTitulo.add(titulo);
        
        JPanel panelConsulta = new JPanel();
        panelConsulta.setLayout(new FlowLayout());
        
        JLabel nomeLabel = new JLabel ("Nome");
        nomeField = new JTextField(40);     
        
        panelConsulta.add(nomeLabel);
        panelConsulta.add(nomeField);
        
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new FlowLayout());
        
        JButton botaoBuscar = new JButton("Buscar");
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
            String nomeProfessor = nomeField.getText();
           
            Professor professor = usuariosRepository.consultarProfessorNome(nomeProfessor);
            if(professor != null){
                List<Livro> emprestimos = usuariosRepository.getTodosOsEmprestimosDoUsuario(professor.getIdUsuario());
                List<Livro> reservas = usuariosRepository.getTodasAsReservasDoUsuario(professor.getIdUsuario());
                new MostrarInformacoesJFrame(professor, emprestimos, reservas).setVisible(true);
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Professor(a) não encontrado", "Consulta", JOptionPane.PLAIN_MESSAGE);       
            }
        }
    }
    
    private class BuscarAlunoAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
             String nomeAluno = nomeField.getText();
           
            Aluno aluno = usuariosRepository.consultarAlunoNome(nomeAluno);
            if(aluno != null){
                List<Livro> emprestimos = usuariosRepository.getTodosOsEmprestimosDoUsuario(aluno.getIdUsuario());
                List<Livro> reservas = usuariosRepository.getTodasAsReservasDoUsuario(aluno.getIdUsuario());
                new MostrarInformacoesJFrame(aluno, emprestimos, reservas).setVisible(true);
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Aluno(a) não encontrado", "Consulta", JOptionPane.PLAIN_MESSAGE);       
            }
        }
    }
    
    private class BuscarOrientandoAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
             String nomeOrientando = nomeField.getText();
           
            Orientando orientando = usuariosRepository.consultarOrientandoNome(nomeOrientando);
            if(orientando != null){
                List<Livro> emprestimos = usuariosRepository.getTodosOsEmprestimosDoUsuario(orientando.getIdUsuario());
                List<Livro> reservas = usuariosRepository.getTodasAsReservasDoUsuario(orientando.getIdUsuario());
                new MostrarInformacoesJFrame(orientando, emprestimos, reservas).setVisible(true);
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Orientando(a) não encontrado", "Consulta", JOptionPane.PLAIN_MESSAGE);       
            }
        }
    }
    
    private class LimparAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            nomeField.setText("");
        }
    }
    
    private class SairAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            ConsultaUsuarioNomeJFrame.this.dispose();            
        }
    }
    
}
    

