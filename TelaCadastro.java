
package login;

//Importação de todas as bibliotecas que estou utilizando na classe
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class TelaCadastro extends JFrame{
    //Declaração dos atributos de tela
    private final JPanel tela;
    private final JTextField txtNome;
    private final JTextField txtUsuario;
    private final JPasswordField passSenha;
    private final JPasswordField passConfSenha;
    
    //valida se o usuario é correto
    private boolean usuarioValido;
    
    //Valida se o cadastro foi realizado corretamente
    private boolean cadastroValido;
    
    //Método construtor da classe
    public TelaCadastro(){
        setLocationRelativeTo(null);        
        setResizable(false);        
        setTitle("Cadastro");        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        setBounds(500, 200, 426, 230);
        
        tela = new JPanel();
        tela.setBackground(SystemColor.GRAY);
        setContentPane(tela);
        tela.setLayout(null);
        
        //Adiciona elementos na tela
        JLabel lblIdentificao = new JLabel("Informar campo para cadastro");
        lblIdentificao.setBounds(60, 0, 500, 39);
        lblIdentificao.setFont(new Font("Arial", 3, 19));
        tela.add(lblIdentificao);
        
        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(24, 50, 70, 15);
        tela.add(lblNome);
        
        txtNome = new JTextField();
        txtNome.setBounds(120, 50, 219, 19);
        tela.add(txtNome);
        txtNome.setColumns(10);
        
        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setBounds(24, 75, 70, 15);
        tela.add(lblUsuario);
        
        txtUsuario = new JTextField();
        txtUsuario.setBounds(120, 75, 219, 19);
        tela.add(txtUsuario);
        txtUsuario.setColumns(10);
        
        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setBounds(24, 100, 70, 15);
        tela.add(lblSenha);
        
        passSenha = new JPasswordField();
        passSenha.setBounds(120, 100, 219, 19);
        tela.add(passSenha);
        
        JLabel lblconfsenha = new JLabel("Confirmar Senha");
        lblconfsenha.setBounds(24, 125, 100, 15);
        tela.add(lblconfsenha);
        
        passConfSenha = new JPasswordField();
        passConfSenha.setBounds(120, 125, 219, 19);
        tela.add(passConfSenha);
        
        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(200, 156, 117, 25);
        tela.add(btnCadastrar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(200, 156, 117, 25);
        tela.add(btnCancelar);
        
        
        
        
        
        
        //Ação do botão de cadastrar usuario na base de dados
        btnCadastrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Instancio a classe usuario
                Usuario usu = new Usuario();
                
                //Ultilizo o setter de nome, usuario e senha
                usu.setNome(txtNome.getText());
                usu.setUsuario(txtUsuario.getText());
                usu.setSenha(passSenha.getText());
                
                if("".equals(usu.getNome())){
                    //Vamos dar uma mensagem na tela
                    JOptionPane.showMessageDialog(null,
                            "Campo nome do usuario precisa ser informado!",
                            "Atenção",
                            JOptionPane.ERROR_MESSAGE);
                        
                    //Volta o cursor para o campo txtNome
                    txtNome.grabFocus();                
                }else if("".equals(usu.getUsuario())){
                    JOptionPane.showMessageDialog(null,
                            "Campo usuario precisa ser imformado!",
                            "Atenção",
                            JOptionPane.ERROR_MESSAGE);
                    //Volta o cursor para o campo passSenha
                    txtUsuario.grabFocus();                
                }else if("".equals(usu.getSenha())){
                    JOptionPane.showMessageDialog(null,
                            "Campo de senha precisa ser imformado!",
                            "Atenção",
                            JOptionPane.ERROR_MESSAGE);
                    //Volta o cursor para o campo passSenha
                    passSenha.grabFocus();                
                }else if(!passSenha.getText().equals(passConfSenha.getText())){
                    JOptionPane.showMessageDialog(null,
                            "Campo de senha e confirmação não são iguais!",
                            "Atenção",
                            JOptionPane.ERROR_MESSAGE);
                    //Volta o cursor para o campo passSenha
                    passSenha.grabFocus();                
                }else{
                    
                    //Verifico se o usuario conta no banco de dados
                    usuarioValido = usu.verificaUsuario(usu.getUsuario());
                                        
                    
                    if(usuarioValido == true){
                        //Usuario existe na base de dados
                        JOptionPane.showMessageDialog(null,
                                "Usuario já existente em nossa base de dados",
                                "Atenção",
                                JOptionPane.ERROR_MESSAGE);

                        //Volta o cursor para o campo txtNome
                        txtUsuario.grabFocus();
                    
                    }else{
                        //Efetivo o cadastro do usuario
                        cadastroValido = usu.cadastraUsuario(usu.getNome(),
                                                            usu.getUsuario(),
                                                            usu.getSenha());
                        
                        if(cadastroValido == true){
                            //Usuario cadastrado na base de dados
                            JOptionPane.showMessageDialog(null,
                                    "Usuario cadastrado corretamente, voltaremos a tela de login",
                                    "Atenção",
                                    JOptionPane.ERROR_MESSAGE);
                            
                            //Abrimos a tela de login novamente
                            TelaLogin tLogin = new TelaLogin();
                            tLogin.AbreTela();
                            
                            //Fecho a tela de cadastro
                            dispose();
                        
                        }else{
                            //Usuario cadastrado na base de dados
                            JOptionPane.showMessageDialog(null,
                                    "Problema ao inserir o usuario",
                                    "Atenção",
                                    JOptionPane.ERROR_MESSAGE);                                                
                        }                  
                    
                    }
                
                }          

            }
        });
    }
    
    public void AbreTela(){    
        TelaCadastro painelCadastro = new TelaCadastro();
        painelCadastro.setVisible(true);
    }
            
        
}