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

public class TelaHome extends JFrame {
    
   
    
    //tela Objeto JPanel (tela em si)
    private final JPanel panelTela;
       
    private String usuario;
    private String senha;
    
    public TelaHome(String usuario, String senha) {
                
        //coloca o objeto na referencia do centro da tela
        setLocationRelativeTo(null);
        
        //Não permite que o objeto seja espandido
        setResizable(false);
        
        //Coloca titulo na caixa JFrame
        setTitle("Menu");
        
        //Quando clicado no x eu encerro todo o programa
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Define posicionamento e tamenho
        //          x      y     width    heigth
        setBounds(500, 200, 487, 212);
        
        //Crio um objeto JPanel e atribuo ele a variavel tela
        panelTela = new JPanel();
        
        //Define a cor de fundo do JPanel (tela)
        panelTela.setBackground(SystemColor.black);
        setContentPane(panelTela);
        
        //Vou utilizar o menu panel sem ultilizar o padrão
        panelTela.setLayout(null);
        
        //Adiciona elementos na tela: Criando um objeto do tipo JLabel o valor ao atribuir
        //JLabel lblOla = new JLabel ("Bem-vinda Ana Clara!");
        
        JLabel lblOla = new JLabel ("Bem-vinda, "+ usuario +"!");
        
        lblOla.setBounds(24, 45, 160, 39);        
        lblOla.setFont(new Font("Arial", 1, 17));    
        lblOla.setForeground(Color.white);
        panelTela.add(lblOla);
        
        
                        
        
        
        //Indentificação e Posicionamento dos botões
        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(30, 136, 117, 25);
        btnExcluir.setForeground(Color.black);
        btnExcluir.setBackground(SystemColor.white);
        panelTela.add(btnExcluir);
        
        JButton btnAlterar = new JButton("Alterar Dados");
        btnAlterar.setBounds(180, 136, 117, 25);
        btnAlterar.setForeground(Color.black);
        btnAlterar.setBackground(SystemColor.white);
        panelTela.add(btnAlterar);  
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(330, 136, 117, 25);
        btnVoltar.setForeground(Color.black);
        btnVoltar.setBackground(SystemColor.white);
        panelTela.add(btnVoltar); 
        
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Abrimos a tela de login novamente
                TelaLogin tLogin = new TelaLogin();
                tLogin.AbreTela();

                //Fecho a tela de home
                dispose();
            }
        });
        
        
        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                
                int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir sua conta?", "Confirmação de exclusão", JOptionPane.YES_NO_OPTION);
                
                if (confirmacao == JOptionPane.YES_OPTION) {
                    
                //Instancio a classe usuario
                Usuario usu = new Usuario();
                
                //Chama o método responsável por excluir o usuário no banco de dados
                boolean resultExclusao = usu.excluiUsuario(usuario);

                    if (resultExclusao) {
                        JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
                        //Fecha a tela atual e abre a tela de login
                        dispose();
                        TelaLogin telaLogin = new TelaLogin();
                        telaLogin.AbreTela();
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possível excluir o usuário!");
                    }
                }    
            }
        });
        
        btnAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                                  
                //Abrimos a tela de Home
                TelaAlterar alt = new TelaAlterar(usuario, senha);
                alt.setVisible(true);

                //Fecho a tela de cadastro
                dispose();
                    
            }
        });
        
        

        

    }

    private TelaHome() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void AbreTela(){
        TelaHome tela = new TelaHome();
        tela.setVisible(true);
    } 

    //public void setUsuario(String usuario){
    //   this.usuario = usuario;
    //} 
    
}

 // Pega o nome do usuário logado
 //String usuario = lblOla.getText().substring(14, lblOla.getText().length() - 1);