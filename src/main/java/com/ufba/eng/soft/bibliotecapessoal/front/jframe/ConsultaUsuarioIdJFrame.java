package com.ufba.eng.soft.bibliotecapessoal.front.jframe;

import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.LivrosRepository;
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

public class ConsultaUsuarioIdJFrame extends JFrame {
    private JPanel contentPane;
    private JTextField idField;
    private UsuariosRepository usuariosRepository;
    
    
    public ConsultaUsuarioIdJFrame(TipoUsuario tipoUsuario, UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
        criarFormularioNome(tipoUsuario);
    }
    
    private void criarFormularioNome(TipoUsuario tipoUsuario) {
        setTitle("Persibi - Buscando Usuário, pelo Id, no cadastro ...");
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
        
        JLabel titulo = new JLabel ("Busca de usuário pelo Id ...");
        titulo.setFont(new Font("verdana", Font.PLAIN, 16));
        panelTitulo.add(titulo);
        
        JPanel panelConsulta = new JPanel();
        panelConsulta.setLayout(new FlowLayout());
        
        JLabel idLabel = new JLabel ("Id");
        idField = new JTextField(40);     
        
        panelConsulta.add(idLabel);
        panelConsulta.add(idField);
        
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
            String idProfessor = idField.getText();
           
            Professor professor = usuariosRepository.consultarProfessorId(idProfessor);
            List<Livro> emprestimos = usuariosRepository.getTodosOsEmprestimosDoUsuario(idProfessor);
            if(professor != null){
                new MostrarInformacoesJFrame(professor, emprestimos).setVisible(true);
            }

            else{
                JOptionPane.showMessageDialog(null, "Professor(a) não encontrado", "Consulta", JOptionPane.PLAIN_MESSAGE);       
            }
            
        }
    }
    
    private class BuscarAlunoAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String idAluno = idField.getText();
           
            Aluno aluno = usuariosRepository.consultarAlunoId(idAluno);
            if(aluno != null){
                List<Livro> emprestimos = usuariosRepository.getTodosOsEmprestimosDoUsuario(idAluno);
                new MostrarInformacoesJFrame(aluno, emprestimos).setVisible(true);
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Aluno(a) não encontrado", "Consulta", JOptionPane.PLAIN_MESSAGE);       
            }
        }
    }
    
    private class BuscarOrientandoAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String idOrientando = idField.getText();
           
            Orientando orientando = usuariosRepository.consultarOrientandoId(idOrientando);
            List<Livro> emprestimos = usuariosRepository.getTodosOsEmprestimosDoUsuario(idOrientando);
            if(orientando != null){
                new MostrarInformacoesJFrame(orientando, emprestimos).setVisible(true);
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Orientando(a) não encontrado", "Consulta", JOptionPane.PLAIN_MESSAGE);       
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
            ConsultaUsuarioIdJFrame.this.dispose();            
        }
    }
    
}
    

