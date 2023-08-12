package login;

//Importação de todas as bibliotecas que estou utilizando na classe
import java.awt.Color; 
import java.awt.Font; //Trabalha com fontes
import java.awt.SystemColor; //Trabalha com cores
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton; //Trabalha com botões
import javax.swing.JFrame; //Trabalha com fremes
import javax.swing.JLabel; //Trabalha com labels
import javax.swing.JPanel; //Trabalha com paineis
import javax.swing.JPasswordField; //Trabalha com campos de senhas
import javax.swing.JTextField; //Trabalha com  campos de texto
import javax.swing.JOptionPane; //Trabalhando com mensagem

public class TelaLogin extends JFrame {
    private Boolean usuarioValido;
    
    //tela Objeto JPanel (tela em si)
    private final JPanel panelTela;
    
    //txtUsuario Objeto JTextField (campo na tela)
    final JTextField txtUsuario;
    
    //pswSenha Objeto JPasswordField (campo na tela)
    private final JPasswordField pswSenha;
    
    
    //Método construir
    public TelaLogin(){
    
        //coloca o objeto na referencia do centro da tela
        setLocationRelativeTo(null);
        
        //Não permite que o objeto seja espandido
        setResizable(false);
        
        //Coloca titulo na caixa JFrame
        setTitle("Login");
        
        //Quando clicado no x eu encerro todo o programa
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Define posicionamento e tamenho
        //          x      y     width    heigth
        setBounds(500, 200, 426, 212);
        
        //Crio um objeto JPanel e atribuo ele a variavel tela
        panelTela = new JPanel();
        
        //Define a cor de fundo do JPanel (tela)
        panelTela.setBackground(SystemColor.black);
        setContentPane(panelTela);
        
        //Vou utilizar o menu panel sem ultilizar o padrão
        panelTela.setLayout(null);
        
        //Adiciona elementos na tela: Criando um objeto do tipo JLabel o valor ao atribuir
        JLabel lblIdentificao = new JLabel ("IDENTIFICAÇÃO");
        
        //Localiza na tela
        lblIdentificao.setBounds(144, 0, 160, 39);
        
        //Define fonte
        lblIdentificao.setFont(new Font("Arial", 1, 20));
        
        //Troca a cor do texto para branco 
        lblIdentificao.setForeground(Color.white);
        
        //Aadicione o meu label ao meu painel
        panelTela.add(lblIdentificao);
        
        //Indentificação e Posicionamento dos labels
        JLabel lblUsuario = new JLabel("Usuario: ");        
        lblUsuario.setBounds(40, 65, 70, 15);
        lblUsuario.setForeground(Color.white);
        lblUsuario.setFont(new Font("Arial", 1, 14));
        panelTela.add(lblUsuario);
        
        JLabel lblSenha = new JLabel("Senha: ");        
        lblSenha.setBounds(40, 92, 70, 15);
        lblSenha.setForeground(Color.white);
        lblSenha.setFont(new Font("Arial", 1, 14));
        panelTela.add(lblSenha);
                        
        //Indentificação e Posicionamento dos texts files
        txtUsuario = new JTextField();
        txtUsuario.setBounds(112, 63, 219, 19);
        panelTela.add(txtUsuario);
        txtUsuario.setColumns(10);
        
        pswSenha = new JPasswordField();
        pswSenha.setBounds(112, 90, 219, 19);
        panelTela.add(pswSenha);
        
        //Indentificação e Posicionamento dos botões
        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(230, 136, 117, 25);
        btnEntrar.setForeground(Color.black);
        btnEntrar.setBackground(SystemColor.white);
        panelTela.add(btnEntrar);
        
        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(90, 136, 117, 25);
        btnCadastrar.setForeground(Color.black);
        btnCadastrar.setBackground(SystemColor.white);
        panelTela.add(btnCadastrar);
        
        
        
        
         //Ação no botão de entrar no sistema
        btnEntrar.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){

                Usuario usu = new Usuario();

                usu.setUsuario(txtUsuario.getText());
                usu.setSenha(pswSenha.getText());

                if ("".equals(txtUsuario.getText())){

                    JOptionPane.showMessageDialog(null, "Campo usúario precisa ser imformado!",
                                                "Atenção",
                                                JOptionPane.ERROR_MESSAGE);

                    txtUsuario.grabFocus();
                }else if ("".equals(pswSenha.getText())){

                    JOptionPane.showMessageDialog(null, "Campo senha precisa ser imformado!",
                                                "Atenção",
                                                JOptionPane.ERROR_MESSAGE);

                    pswSenha.grabFocus();
                }else{

                    usuarioValido = usu.verificaUsuario(usu.getUsuario(), usu.getSenha());


                    if(usuarioValido == true){

                        JOptionPane.showMessageDialog(null, "Usuario valido em nossa base de dados",
                                                "Atenção",
                                                JOptionPane.INFORMATION_MESSAGE);
                                     
                        //Abrimos a tela de Home
                        TelaHome t = new TelaHome(usu.getUsuario(), usu.getSenha());
                        t.setVisible(true);

                        //Fecho a tela de cadastro
                        dispose();
                    }else{

                        JOptionPane.showMessageDialog(null, "Usuario invalido ou inexistente",
                                                "Atenção",
                                                JOptionPane.ERROR_MESSAGE);

                        LimpaText();

                        txtUsuario.grabFocus();
                    }           

                }
            }        

        });
        
         //Ação no botão de entrar no sistema
        btnCadastrar.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                
                //Abrimos a tela de Home
                TelaCadastro Tcadast = new TelaCadastro();
                Tcadast.setVisible(true);

                //Fecho a tela de cadastro
                dispose();
                    
            }        

        });
           
    }  

    
    public void AbreTela(){
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
    } 

    public void LimpaText(){
        txtUsuario.setText("");
        pswSenha.setText("");
    }
    
}
