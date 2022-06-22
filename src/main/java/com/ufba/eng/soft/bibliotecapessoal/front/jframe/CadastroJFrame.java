package com.ufba.eng.soft.bibliotecapessoal.front.jframe;

import com.ufba.eng.soft.bibliotecapessoal.model.repository.UsuariosRepository;
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

public class CadastroJFrame extends JFrame {
    private JPanel contentPane;
    private TipoUsuario tipoUsuario;
    private JTextField idField;
    private JTextField nomeField;
    private JTextField usernameField;
    private JTextField senhaField;
    private UsuariosRepository usuariosRepository;
    
    public CadastroJFrame(UsuariosRepository usuariosRepository, TipoUsuario tipoUsuario) {
        this.usuariosRepository = usuariosRepository;
        this.tipoUsuario = tipoUsuario;
        criarFormulario(tipoUsuario);
    }
    
    private void criarFormulario(TipoUsuario tipoUsuario) {
        setTitle("Persibi - Formul�rio de Cadastro do Usu�rio");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(300, 300, 500, 350);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        CadastrarAction cadastrarAction = new CadastrarAction();
        LimparAction limparAction = new LimparAction();
        SairAction sairAction = new SairAction();
        
        setLayout(new BorderLayout());
        
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout());
        
        JLabel titulo = new JLabel ("Formul�rio");
        titulo.setFont(new Font("verdana", Font.PLAIN, 16));
        panelTitulo.add(titulo);
        
        JPanel panelCadastro = new JPanel();
        panelCadastro.setLayout(new FlowLayout());
        
        JLabel nomeLabel = new JLabel ("Nome");
        nomeField = new JTextField(40);
        
        JLabel idLabel = new JLabel ("Identifica��o-ID");
        idField = new JTextField(40);
        
        JLabel usernameLabel = new JLabel ("Username");
        usernameField = new JTextField(40);
        
        JLabel senhaLabel = new JLabel ("Senha");
        senhaField = new JTextField(40);
        
        panelCadastro.add(nomeLabel);
        panelCadastro.add(nomeField);
        panelCadastro.add(idLabel);
        panelCadastro.add(idField);
        panelCadastro.add(usernameLabel);
        panelCadastro.add(usernameField);
        panelCadastro.add(senhaLabel);
        panelCadastro.add(senhaField);
        
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new FlowLayout());
        
        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setBackground(Color.GREEN);
        panelBotoes.add(botaoCadastrar);
        
        if(tipoUsuario == TipoUsuario.PROFESSOR){ 
           botaoCadastrar.addActionListener(cadastrarAction);  
        }
        if(tipoUsuario == TipoUsuario.ALUNO){ 
            botaoCadastrar.addActionListener(cadastrarAction);  
        }
        if(tipoUsuario == TipoUsuario.ORIENTANDO){ 
            botaoCadastrar.addActionListener(cadastrarAction);  
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
      
    private class CadastrarAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            
            //Verifica campos
            ResultadoVerificacao resultadoNome = VerificadorDeCampos.nome(nomeField.getText());
            ResultadoVerificacao resultadoIdUsuario = VerificadorDeCampos.idUsuario(idField.getText());
            ResultadoVerificacao resultadoUsername = VerificadorDeCampos.userName(usernameField.getText());
            ResultadoVerificacao resultadoSenha = VerificadorDeCampos.senha(senhaField.getText());
            
            boolean valido = true;
            if (!resultadoNome.isValido()) {
                JOptionPane.showMessageDialog(null, "N�o foi poss�vel realizar cadastro. Erro: " + resultadoNome.getMotivo(), "Erro verificando Campos", JOptionPane.ERROR_MESSAGE);       
                valido = false;
                return;
            }
            
            if (!resultadoIdUsuario.isValido()) {
                JOptionPane.showMessageDialog(null, "N�o foi poss�vel realizar cadastro. Erro: " + resultadoIdUsuario.getMotivo(), "Erro verificando Campos", JOptionPane.ERROR_MESSAGE);       
                valido = false;
                return;
            }
            
            if (!resultadoUsername.isValido()) {
                JOptionPane.showMessageDialog(null, "N�o foi poss�vel realizar cadastro. Erro: " + resultadoUsername.getMotivo(), "Erro verificando Campos", JOptionPane.ERROR_MESSAGE);       
                valido = false;
                return;
            }
            
            if (!resultadoSenha.isValido()) {
                JOptionPane.showMessageDialog(null, "N�o foi poss�vel realizar cadastro. Erro: " + resultadoSenha.getMotivo(), "Erro verificando Campos", JOptionPane.ERROR_MESSAGE);       
                valido = false;
                return;
            }
            
            
            
            if(valido){
                if (tipoUsuario == TipoUsuario.PROFESSOR) {
                Professor novoUsuario = new Professor(
                    idField.getText(), 
                    nomeField.getText(), 
                    usernameField.getText(), 
                    senhaField.getText()
                );
                usuariosRepository.adicionarNovoProfessor(novoUsuario);
                JOptionPane.showMessageDialog(null, "Professor(a) cadastrado com sucesso", "Cadastro", JOptionPane.PLAIN_MESSAGE);       
                return;
                }
                
                if (tipoUsuario == TipoUsuario.ALUNO) {
                Aluno novoUsuario = new Aluno(
                    idField.getText(), 
                    nomeField.getText(),
                    usernameField.getText(), 
                    senhaField.getText()
                );
                usuariosRepository.adicionarNovoAluno(novoUsuario);
                JOptionPane.showMessageDialog(null, "Aluno(a) cadastrado com sucesso", "Cadastro", JOptionPane.PLAIN_MESSAGE);       
                return;
                }
            
                if (tipoUsuario == TipoUsuario.ORIENTANDO) {
                    Orientando novoUsuario = new Orientando(
                        idField.getText(), 
                        nomeField.getText(),
                        usernameField.getText(), 
                        senhaField.getText()
                    );
                    usuariosRepository.adicionarNovoOrientando(novoUsuario);
                    JOptionPane.showMessageDialog(null, "Orientando(a) cadastrado com sucesso", "Cadastro", JOptionPane.PLAIN_MESSAGE);       
                    return;
                }
            }    
            
        }
    }
    
    private class LimparAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            nomeField.setText("");
            idField.setText("");
            usernameField.setText("");
            senhaField.setText("");
        }
    }
    
    private class SairAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            CadastroJFrame.this.dispose();            
        }
    }
    
}
    

