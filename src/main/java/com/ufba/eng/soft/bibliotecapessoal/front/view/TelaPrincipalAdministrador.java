package com.ufba.eng.soft.bibliotecapessoal.front.view;

import com.ufba.eng.soft.bibliotecapessoal.front.util.Style;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.LivrosRepository;
import com.ufba.eng.soft.bibliotecapessoal.model.repository.UsuariosRepository;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TelaPrincipalAdministrador extends JFrame {
    private JPanel contentPane;
    private String usuario;
    private UsuariosRepository usuariosRepository;
    private final LivrosRepository livrosRepository;

    /**
     * Create the frame.
     * @throws java.io.IOException
     */
    public TelaPrincipalAdministrador(UsuariosRepository usuariosRepository, LivrosRepository livrosRepository) throws IOException {
            this.usuariosRepository = usuariosRepository;
            this.livrosRepository = livrosRepository;
            setTitle("Persibi - Administrador");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(300, 300, 650, 500);
            contentPane = new JPanel();
            //contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);
            getContentPane().setBackground(Color.WHITE);
            
            JLabel titulo1 = new JLabel ("Bem vindo(a),");
            titulo1.setBounds(45, 90, 500, 300);
            titulo1.setFont(Style.getStandardFont(20));
            contentPane.add(titulo1);
            
            JLabel titulo2 = new JLabel ("administrador(a)!");
            titulo2.setBounds(20, 115, 500, 300);
            titulo2.setFont(Style.getStandardFont(20));
            contentPane.add(titulo2);

            JLabel gerenciamentoUsuarios = new JLabel ("Gestão de usuários");
            gerenciamentoUsuarios.setBounds(280, 1, 500, 75);
            gerenciamentoUsuarios.setFont(Style.getStandardFont(14));
            contentPane.add(gerenciamentoUsuarios);

        JLabel gerenciamentoBiblioteca = new JLabel ("Gestão de acervo");
        gerenciamentoBiblioteca.setBounds(280, 1, 500, 360);
        gerenciamentoBiblioteca.setFont(Style.getStandardFont(14));
        contentPane.add(gerenciamentoBiblioteca);

        JLabel gerenciamentoEmprestimos = new JLabel ("Gestão de empréstimos");
        gerenciamentoEmprestimos.setBounds(280, 1, 500, 637);
        gerenciamentoEmprestimos.setFont(Style.getStandardFont(14));
        contentPane.add(gerenciamentoEmprestimos);

        File file = new File(".\\src\\main\\java\\com\\ufba\\eng\\soft\\bibliotecapessoal\\front\\Logotype\\LogoBiblioteca.png");
            FileInputStream fis = new FileInputStream(file);  
            BufferedImage bufferedImage = ImageIO.read(fis);
            ImageIcon imageIcon = new ImageIcon(bufferedImage);            

            JLabel jLabel = new JLabel();
            jLabel.setBounds(5, 0, 350, 350);
            jLabel.setVisible(true);
            jLabel.setIcon(imageIcon);
            contentPane.add(jLabel);            
            
            JButton btnCadastrarUsuario = new JButton("Cadastrar Usuário");
            btnCadastrarUsuario.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        try {
                            new CadastroUsuarioTelaPrincipal(usuariosRepository).setVisible(true);
                        } catch (IOException ex) {
                            Logger.getLogger(TelaPrincipalAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
            });
            btnCadastrarUsuario.setBounds(280, 50, 149, 53);
        Style.setStandardUiButtonStyle(btnCadastrarUsuario, Style.getGreenColor());

            contentPane.add(btnCadastrarUsuario); 
            
            JButton btnConsultarUsuario = new JButton("Consultar Usuário");
            btnConsultarUsuario.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        try {
                            new ConsultaUsuarioTelaPrincipal(usuariosRepository).setVisible(true);
                        } catch (IOException ex) {
                            Logger.getLogger(TelaPrincipalAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
            });
            btnConsultarUsuario.setBounds(440, 50, 149, 53);
        Style.setStandardUiButtonStyle(btnConsultarUsuario, Style.getPurpleColor());
            contentPane.add(btnConsultarUsuario);
            
            JButton btnAtualizarUsuario = new JButton("Atualizar Usuário");
            btnAtualizarUsuario.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            
                    }
            });
        Style.setStandardUiButtonStyle(btnAtualizarUsuario, Style.getEasyBlueColor());
            btnAtualizarUsuario.setBounds(280, 110, 149, 53);
            contentPane.add(btnAtualizarUsuario);
            
            JButton btnCRemoverUsuario = new JButton("Remover Usuário");
            btnCRemoverUsuario.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        try {
                            new RemoveUsuarioTelaPrincipal(usuariosRepository).setVisible(true);
                        } catch (IOException ex) {
                            Logger.getLogger(TelaPrincipalAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
            });
        btnCRemoverUsuario.setBounds(440, 110, 149, 53);
        Style.setStandardUiButtonStyle(btnCRemoverUsuario, Style.getGrayColor());
        contentPane.add(btnCRemoverUsuario);
            
            JButton btnCadastrarLivro = new JButton("Cadastrar Livro");
            btnCadastrarLivro.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        try {
                            new CadastroLivroTelaPrincipal(livrosRepository).setVisible(true);
                        } catch (IOException ex) {
                            Logger.getLogger(TelaPrincipalAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
            });
        Style.setStandardUiButtonStyle(btnCadastrarLivro, Style.getGreenColor());
            btnCadastrarLivro.setBounds(280, 190, 149, 53);
            contentPane.add(btnCadastrarLivro);
            
            JButton btnConsultarLivro = new JButton("Consultar Livro");
            btnConsultarLivro.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            try {
                            new ConsultarLivroTelaPrincipal(livrosRepository).setVisible(true);
                        } catch (IOException ex) {
                            Logger.getLogger(TelaPrincipalAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
            });
        Style.setStandardUiButtonStyle(btnConsultarLivro, Style.getPurpleColor());
            btnConsultarLivro.setBounds(440, 190, 149, 53);
            contentPane.add(btnConsultarLivro);
            
            JButton btnAtualizarLivro = new JButton("Atualizar Livro");
            btnAtualizarLivro.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            
                    }
            });
        Style.setStandardUiButtonStyle(btnAtualizarLivro, Style.getEasyBlueColor());
            btnAtualizarLivro.setBounds(280, 250, 149, 53);
            contentPane.add(btnAtualizarLivro);
             
            JButton btnRemoverLivro = new JButton("Remover Livro");
            btnRemoverLivro.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        try {
                            new RemoveLivroTelaPrincipal(livrosRepository).setVisible(true);
                        } catch (IOException ex) {
                            Logger.getLogger(TelaPrincipalAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                        }                            
                    }
            });
        Style.setStandardUiButtonStyle(btnRemoverLivro, Style.getGrayColor());
            btnRemoverLivro.setBounds(440, 250, 149, 53);
            contentPane.add(btnRemoverLivro);            
            
            JButton btnConsultarReserva = new JButton("Consultar Reserva");
            btnAtualizarLivro.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        
                    }
            });
        Style.setStandardUiButtonStyle(btnConsultarReserva, Style.getPurpleColor());
            btnConsultarReserva.setBounds(280, 330, 149, 53);
            contentPane.add(btnConsultarReserva);
            
            JButton btnConsultarEmprestimo = new JButton("Consultar Empréstimo");
            btnAtualizarLivro.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            
                    }
            });
            
        Style.setStandardUiButtonStyle(btnConsultarEmprestimo, Style.getOrangeColor());
            btnConsultarEmprestimo.setBounds(440, 330, 149, 53);
            contentPane.add(btnConsultarEmprestimo);
            
            JButton btnRealizarEmprestimo = new JButton("Realizar Empréstimo");
            btnRealizarEmprestimo.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        try {
                            new EmprestaLivroTelaPrincipal(usuariosRepository, livrosRepository).setVisible(true);
                        } catch (IOException ex) {
                            Logger.getLogger(TelaPrincipalAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
            });
        Style.setStandardUiButtonStyle(btnRealizarEmprestimo, Style.getOrangeColor());
           btnRealizarEmprestimo.setBounds(280, 390, 149, 53);
            contentPane.add(btnRealizarEmprestimo);
            
            JButton btnRealizarDevolucao = new JButton("Realizar Devolução");
            btnRealizarDevolucao.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        try {
                            new RealizaDevolucao(usuariosRepository, livrosRepository).setVisible(true);
                        } catch (IOException ex) {
                            Logger.getLogger(TelaPrincipalAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
            });
            
        Style.setStandardUiButtonStyle(btnRealizarDevolucao, Style.getPurpleColor());
            btnRealizarDevolucao.setBounds(440, 390, 149, 53);
            contentPane.add(btnRealizarDevolucao);
            
            JButton btnSair = new JButton("Sair");
            
            btnSair.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                       TelaPrincipalAdministrador.this.dispose();
                }
        });
        Style.setStandardUiButtonStyle(btnSair, Style.getExitRed());
            btnSair.setBounds(43, 330, 149, 53);
            contentPane.add(btnSair);            
            
    }
}
