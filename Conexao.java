package login;


import java.sql.Connection; //Conexão com o banco de dados
import java.sql.DriverManager; // Drive de conexão, em nosso caso Mysql
import java.sql.ResultSet; //Resultados das operações em banco de dados
import java.sql.Statement; //Interpretação dos comandos SQL - CRUD


public class Conexao {
    //Atributos de conexao ligados as bibliotecas importadas
    public Connection con = null;
    public Statement stmt = null;
    public ResultSet resultset = null;
    
    //Atributos de conexão
    private final String servidor = "jdbc:mysql://127.0.0.1:3306/login";
                                    //Servidor de banco de dados
    private final String usuario = "root"; // Usuario do banco de dados
    private final String senha = ""; //Senha do banco de dados
    private final String driver = "com.mysql.jdbc.Driver"; //Drive de conexão

    //Método de abertura de conexão com o banco de dados
    public Connection AbrirConexao() {
        try {
            Class.forName(driver); //Driver de utilização
            
            //Atributos de conexão
            con = DriverManager.getConnection(servidor,usuario, senha);
            stmt = con.createStatement();//Fazendo conexão com o banco de dados 
            
            //Mensagem informando que a conexão foi realizada com sucesso
            System.out.println("Conexão aberta com sucesso");
        }
        catch(Exception e){
            //Mensagem de saída caso haja erro
            System.out.println("Erro ao acessar o banco de dados, verifique");
        }
        
        return con;//Retorna a conexão
    }

    //Método de fechamento de conexão com o banco de dados
    public void FecharConexao(){
        try {
            con.close();//Fechamento da conexão com o banco de dados
            //Mensagem que fechou a conexão
            System.out.println("Conexão fializada com sucesso");
        }
        catch(Exception e){
            //Mensagem de erro ao fechar conexão
            System.out.println("Erro ao encerrar conexão" + e.getMessage());
        }
    
    }




}


