/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax. swing.JPasswordField;
import javax.swing.JTextField;



public class TelaAlterar extends JFrame{
    private final JPanel tela;
    private final JTextField txtNome;
    private final JPasswordField passSenha;
    private final JPasswordField passNovaSenha;
    private final JPasswordField passConfPass;   
    
    private String usuario;
    private String senha;
    
    public TelaAlterar(String usuario, String senha){
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Senac - Alteração");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 426, 230);
        
        tela = new JPanel();
        tela.setBackground(SystemColor.gray);
        setContentPane(tela);
        tela.setLayout (null);
        
        JLabel lblIdentificao = new JLabel("Informar campos para alteração");
        lblIdentificao.setBounds(60, 0, 500, 39);
        lblIdentificao.setFont(new Font("Arial", 3, 19));
        tela.add(lblIdentificao);
        
        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(24, 50, 70, 15);
        tela.add(lblNome);
        
        txtNome = new JTextField(usuario);        
        txtNome.setBounds(120, 50, 219, 19);        
        tela.add(txtNome);
        txtNome.setColumns(10);
        
        
        JLabel lblsenha = new JLabel("Senha Atual");
        lblsenha.setBounds(24, 75, 70, 15);
        tela.add(lblsenha);
        
        passSenha = new JPasswordField();
        passSenha.setBounds(120, 75, 219, 19);
        tela.add(passSenha);
        
        JLabel lblnovasenha = new JLabel("Nova Senha");
        lblnovasenha.setBounds(24, 100, 70, 15);
        tela.add(lblnovasenha);
        
        passNovaSenha = new JPasswordField();
        passNovaSenha.setBounds(120, 125, 219, 19);
        tela.add(passNovaSenha);
        
        JLabel lblconfsenha = new JLabel("Confirmar Senha");
        lblconfsenha.setBounds(24, 125, 100, 15);
        tela.add(lblconfsenha);
        
        passConfPass = new JPasswordField();
        passConfPass.setBounds(120, 100, 219, 19);
        tela.add(passConfPass);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(50, 156, 117, 25);
        tela.add(btnCancelar);
        
        JButton btnAlterar = new JButton("Alterar");
        btnAlterar.setBounds(200, 156, 117, 25);
        tela.add(btnAlterar);
        
        
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Abrimos a tela de login novamente
                TelaLogin tLogin = new TelaLogin();
                tLogin.AbreTela();

                //Fecho a tela de home
                dispose();
            }
        });
        
        btnAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
               
                
                //Instancio a classe usuario
                String nome = txtNome.getText();
                String senhaAtual = new String(passSenha.getPassword());
                String novaSenha = new String(passNovaSenha.getPassword());
                String confirmarSenha = new String(passConfPass.getPassword());
                
                
                // Verifica se o campo senha está preenchido
                if ("".equals(senhaAtual)) {
                    JOptionPane.showMessageDialog(null, "Favor preencher o campo de Senha Atual.");
                    return;
                }
                
                 // Verifica se a senha atual está correta
                if (!senhaAtual.equals(senha)) {
                    JOptionPane.showMessageDialog(null, "Senha atual incorreta.");
                    return;
                } 
                
                if ("".equals(novaSenha)) {
                    JOptionPane.showMessageDialog(null, "Favor preencher o campo de Nova Senha e Confirmação de Senha");
                    return;
                }                
                              
                if (!novaSenha.equals(confirmarSenha)) {
                    JOptionPane.showMessageDialog(null, "As senhas nova e de confirmação não são iguais.");
                    return;
                }
                
                if (novaSenha.equals(senhaAtual)) {
                    JOptionPane.showMessageDialog(null, "A nova senha deve ser diferente da senha atual.");
                    return;
                }
                  
                // Confirma a alteração dos dados
                int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que quer alterar esses dados?", "Confirmação de alteração", JOptionPane.YES_NO_OPTION);
                
                if (resposta == JOptionPane.YES_OPTION) {
                    
                     Usuario usu = new Usuario();
                    
                    boolean resultAlterar = usu.alterarUsuario(nome, novaSenha, usuario);

                    if (resultAlterar) {
                        JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso.");
                        //Fecha a tela atual e abre a tela de login
                        dispose();
                        TelaLogin telaLogin = new TelaLogin();
                        telaLogin.AbreTela();
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao alterar usuário.");
                    }
                }
                
            }
        });
        
        
        
    }

    private TelaAlterar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }




    
    public void AbreTela(){
        TelaAlterar panelAlterar = new TelaAlterar();
        panelAlterar.setVisible(true);
    }
}
