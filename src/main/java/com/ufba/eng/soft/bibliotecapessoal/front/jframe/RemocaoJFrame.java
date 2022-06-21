package com.ufba.eng.soft.bibliotecapessoal.front.jframe;

import com.ufba.eng.soft.bibliotecapessoal.model.repository.UsuariosRepository;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.UsuariosRepositoryImpl;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Aluno;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Orientando;
import com.ufba.eng.soft.bibliotecapessoal.model.user.Professor;
import com.ufba.eng.soft.bibliotecapessoal.model.user.TipoUsuario;
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

public class RemocaoJFrame extends JFrame {
    private JPanel contentPane;
    private TipoUsuario tipoUsuario;
    private JTextField idField;
    private JTextField nomeField;
    private JTextField usernameField;
    private JTextField senhaField;
    private UsuariosRepository usuariosRepository;
    
    public RemocaoJFrame(UsuariosRepository usuariosRepository, TipoUsuario tipoUsuario) {
        this.usuariosRepository = usuariosRepository;
        this.tipoUsuario = tipoUsuario;
        criarFormulario(tipoUsuario);
    }
    
    private void criarFormulario(TipoUsuario tipoUsuario) {
        setTitle("Persibi - Removendo usuário pelo ID...");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(300, 300, 500, 350);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        RemoverProfessorAction removerProfessorAction = new RemoverProfessorAction();
        RemoverAlunoAction removerAlunoAction = new RemoverAlunoAction();
        RemoverOrientandoAction removerOrientandoAction = new RemoverOrientandoAction();
        LimparAction limparAction = new LimparAction();
        SairAction sairAction = new SairAction();
        
        setLayout(new BorderLayout());
        
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());
        
        JLabel titulo = new JLabel ("Formulário");
        titulo.setFont(new Font("verdana", Font.PLAIN, 16));
        panelTitulo.add(titulo);
        
        JPanel panelCadastro = new JPanel();
        panelCadastro.setLayout(new FlowLayout());
        
        JLabel idLabel = new JLabel ("ID");
        idField = new JTextField(40);
       
        panelCadastro.add(idLabel);
        panelCadastro.add(idField);
        
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new FlowLayout());
        
        JButton botaoRemover = new JButton("Remover");
        botaoRemover.setBackground(Color.GREEN);
        panelBotoes.add(botaoRemover);
        
        if(tipoUsuario == TipoUsuario.PROFESSOR){ 
           botaoRemover.addActionListener(removerProfessorAction);  
        }
        if(tipoUsuario == TipoUsuario.ALUNO){ 
            botaoRemover.addActionListener(removerAlunoAction);  
        }
        if(tipoUsuario == TipoUsuario.ORIENTANDO){ 
            botaoRemover.addActionListener(removerOrientandoAction);  
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
        add(panelCadastro, BorderLayout.CENTER);
        add(panelBotoes, BorderLayout.SOUTH);        
    }
      
    private class RemoverProfessorAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String idProfessor = idField.getText();
           
            Professor professor = (Professor) new UsuariosRepositoryImpl().consultarProfessorId(idProfessor);
           
            if(professor != null){
                usuariosRepository.removerUsuarioProfessor(professor.getIdUsuario());
                JOptionPane.showMessageDialog(null, "Professor(a) removido(a) com sucesso", "Remoção", JOptionPane.PLAIN_MESSAGE);
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Professor(a) não encontrado", "Remoção", JOptionPane.PLAIN_MESSAGE);       
            }
            
        }
    }
    
    private class RemoverAlunoAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String idAluno = idField.getText();
           
            Aluno aluno = (Aluno) new UsuariosRepositoryImpl().consultarAlunoId(idAluno);
           
            if(aluno != null){
                usuariosRepository.removerUsuarioAluno(aluno.getIdUsuario());
                JOptionPane.showMessageDialog(null, "Aluno(a) removido(a) com sucesso", "Remoção", JOptionPane.PLAIN_MESSAGE);
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Aluno(a) não encontrado", "Remoção", JOptionPane.PLAIN_MESSAGE);       
            }
        }
    }
    
    private class RemoverOrientandoAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String idOrientando = idField.getText();
           
            Orientando orientando = (Orientando) new UsuariosRepositoryImpl().consultarOrientandoId(idOrientando);
           
            if(orientando != null){
                usuariosRepository.removerUsuarioOrientando(orientando.getIdUsuario());
                JOptionPane.showMessageDialog(null, "Orientando(a) removido(a) com sucesso", "Remoção", JOptionPane.PLAIN_MESSAGE);
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Orientando(a) não encontrado", "Remoção", JOptionPane.PLAIN_MESSAGE);       
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
            RemocaoJFrame.this.dispose();            
        }
    }
    
}
    

