/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufba.eng.soft.bibliotecapessoal.front.jframe;

import com.ufba.eng.soft.bibliotecapessoal.model.product.GeneroLivro;
import com.ufba.eng.soft.bibliotecapessoal.model.product.Livro;

import com.ufba.eng.soft.bibliotecapessoal.model.product.Autor;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.LivrosRepository;
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

public class CadastroLivroJFrame extends JFrame {
    
    private JPanel contentPane;
    private LivrosRepository livrosRepository;
    private GeneroLivro generoLivro;
    private JTextField tituloField;
    private JTextField autorField;
    private JTextField idAutorField;
    private JTextField qtdCopiasField;
    private JTextField isbnField;
    private JTextField codDeBarraField;
    
    
    public CadastroLivroJFrame(LivrosRepository livrosRepository, GeneroLivro generoLivro) {
        this.livrosRepository = livrosRepository;
        this.generoLivro = generoLivro;
        criarFormulario(generoLivro);
    }
    
    private void criarFormulario(GeneroLivro generoLivro) {
        setTitle("Persibi - Formulário de Cadastro do Livro");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(300, 300, 505, 400);
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
        
        JLabel titulo = new JLabel ("Formulário");
        titulo.setFont(new Font("verdana", Font.PLAIN, 16));
        panelTitulo.add(titulo);
        
        JPanel panelCadastro = new JPanel();
        panelCadastro.setLayout(new FlowLayout());
        
        JLabel tituloLabel = new JLabel ("Título");
        tituloField = new JTextField(40);
        
        JLabel autorLabel = new JLabel ("Autor(a)");
        autorField = new JTextField(40);

        JLabel idAutorLabel = new JLabel ("ID-Autor(a)");
        idAutorField = new JTextField(40);

        JLabel qtdCopiasLabel = new JLabel ("Quantidade de Cópias");
        qtdCopiasField = new JTextField(40);
        
        JLabel isbnFieldLabel = new JLabel ("ISBN");
        isbnField = new JTextField(40);
        
        JLabel codDeBarraFieldLabel = new JLabel ("Cód. De Barra");
        codDeBarraField = new JTextField(40);
        
        
        panelCadastro.add(tituloLabel);
        panelCadastro.add(tituloField);
        panelCadastro.add(autorLabel);
        panelCadastro.add(autorField);
        panelCadastro.add(idAutorLabel);
        panelCadastro.add(idAutorField);
        panelCadastro.add(qtdCopiasLabel);
        panelCadastro.add(qtdCopiasField);
        panelCadastro.add(isbnFieldLabel);
        panelCadastro.add(isbnField);
        panelCadastro.add(codDeBarraFieldLabel);
        panelCadastro.add(codDeBarraField);
        
        
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new FlowLayout());
        
        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setBackground(Color.GREEN);
        panelBotoes.add(botaoCadastrar);        
       
        botaoCadastrar.addActionListener(cadastrarAction);  
        
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
            //Verificação de campos. A ser feito: verificar todos os campos do formulario
            
            ResultadoVerificacao resultadoTitulo = VerificadorDeCampos.titulo(tituloField.getText());
            ResultadoVerificacao resultadoAutor = VerificadorDeCampos.autor(autorField.getText());
            ResultadoVerificacao resultadoIDAutor = VerificadorDeCampos.idAutor(idAutorField.getText());
            ResultadoVerificacao resultadoqtdCopias = VerificadorDeCampos.copias(qtdCopiasField.getText());
            ResultadoVerificacao resultadoIsnb = VerificadorDeCampos.isbn(isbnField.getText());
            ResultadoVerificacao resultadoCodDeBarra = VerificadorDeCampos.codDeBarra(codDeBarraField.getText());

            if (!resultadoTitulo.isValido()) {
                JOptionPane.showMessageDialog(null, "Não foi possível realizar cadastro. Erro: " + resultadoTitulo.getMotivo(), "Erro verificando Campos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (!resultadoAutor.isValido()) {
                JOptionPane.showMessageDialog(null, "Não foi possível realizar cadastro. Erro: " + resultadoAutor.getMotivo(), "Erro verificando Campos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (!resultadoIDAutor.isValido()) {
                JOptionPane.showMessageDialog(null, "Não foi possível realizar cadastro. Erro: " + resultadoIDAutor.getMotivo(), "Erro verificando Campos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (!resultadoIsnb.isValido()) {
                JOptionPane.showMessageDialog(null, "Não foi possível realizar cadastro. Erro: " + resultadoIsnb.getMotivo(), "Erro verificando Campos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (!resultadoCodDeBarra.isValido()) {
                JOptionPane.showMessageDialog(null, "Não foi possível realizar cadastro. Erro: " + resultadoCodDeBarra.getMotivo(), "Erro verificando Campos", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!resultadoqtdCopias.isValido()) {
                JOptionPane.showMessageDialog(null, "Não foi possível realizar cadastro. Erro: " + resultadoCodDeBarra.getMotivo(), "Erro verificando Campos", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Autor autor = new Autor (
//                    idAutorField.getText(),
                autorField.getText()
            );

            Livro novoLivro = new Livro(
                tituloField.getText(),
                isbnField.getText(),
                codDeBarraField.getText(),
                autor,
                generoLivro,
                Integer.parseInt(qtdCopiasField.getText())
            );

            livrosRepository.adicionarNovoLivro(novoLivro);
            JOptionPane.showMessageDialog(null, "Novo livro cadastrado com sucesso", "Cadastro", JOptionPane.PLAIN_MESSAGE);

        }
            
    }
    
    
    private class LimparAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            tituloField.setText("");
            autorField.setText("");
            idAutorField.setText("");
            isbnField.setText("");
            codDeBarraField.setText("");
        }
    }
    
    private class SairAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            CadastroLivroJFrame.this.dispose();            
        }
    }
    
}
    

    

