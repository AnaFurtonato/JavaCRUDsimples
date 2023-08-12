package login;

import java.sql.ResultSet; //Resultado do banco de dados

public class Usuario {
    //Criação dos atributos privado da classe
    private String usuario;
    private String nome;
    private String senha;
    
    //Atributo que armazenará o retorno do banco de dados
    private boolean resultUsuario;
    
    //Atributo que armazenará o cadastro do banco de dados
    private boolean resultCadastro;
    
    //criação dos getters e setters
    public String getUsuario(){
        return usuario;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    
    public String getSenha(){
        return senha;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    //Método de verificação da autenticação do usuario
    public Boolean verificaUsuario(String usuario, String senha){
    
        //Fazer a instancia da conexão com o banco de dados
        Conexao banco = new Conexao();
        
        try{
            //abro a conexão com o banco de dados
            banco.AbrirConexao();
                        
            //Criando parâmetro de retorno
            banco.stmt = banco.con.createStatement();
            
            //Executando a consulta no banco de dados
            banco.resultset = 
                    banco.stmt.executeQuery("SELECT * FROM usuario " 
                                            + "WHERE apelido = '" + usuario + "'"
                                            + "AND senha = '" + senha + "'");
            
            //Verifica se existe retorno de dados no banco
            if (banco.resultset.next()){
                //caso tenha
                resultUsuario = true;
            }else{
                //caso não tenha
                resultUsuario = false;
            }
            
            banco.FecharConexao(); //Fecha nossa conexão com o banco de dados
            
        }catch (Exception ec){
            System.out.println("Erro ao contruir usuario" + ec.getMessage());
        
        }
        
        return resultUsuario;
    
    
    }    
    
    //Sobrecarga de metodo
    //Método de verificação da autenticação do usuario
    public Boolean verificaUsuario(String usuario){
    
        //Fazer a instancia da conexão com o banco de dados
        Conexao banco = new Conexao();
        
        try{
            //abro a conexão com o banco de dados
            banco.AbrirConexao();
                        
            //Criando parâmetro de retorno
            banco.stmt = banco.con.createStatement();
            
            //Executando a consulta no banco de dados
            banco.resultset = 
                    banco.stmt.executeQuery("SELECT * FROM usuario " 
                                            + "WHERE apelido = '" + usuario + "'");
            
            //Verifica se existe retorno de dados no banco
            if (banco.resultset.next()){
                //caso tenha
                resultUsuario = true;
            }else{
                //caso não tenha
                resultUsuario = false;
            }
            
            banco.FecharConexao(); //Fecha nossa conexão com o banco de dados
            
        }catch (Exception ec){
            System.out.println("Erro ao contruir usuario" + ec.getMessage());
        
        }
        
        return resultUsuario;
    
    
    }    
    
    
    //Método de cadastro do usuario na base
    public Boolean cadastraUsuario(String nome, String usuario, String senha){
    
        //Fazer a instancia da conexão com o banco de dados
        Conexao banco = new Conexao();
        
        try{
            //abro a conexão com o banco de dados
            banco.AbrirConexao();
                        
            //Criando parâmetro de retorno
            banco.stmt = banco.con.createStatement();
            
            //Executando a consulta no banco de dados
            banco.stmt.execute("INSERT INTO usuario (nome, apelido, senha)"
                                + "VALUES ('" + nome + "','" + usuario + "', '" 
                                + senha + "')");
            
            //Caso insira
            resultCadastro = true;          
            
            
        }catch (Exception ec){
            //Aconteceu algum problema
            System.out.println("Erro ao inserir usuario" + ec.getMessage());
            resultCadastro = false;
        }
        
        banco.FecharConexao(); //Fecha nossa conexão com o banco de dados
        
        return resultCadastro;
    
    
    }
    
    
    //Método para excluir usuario no banco de dados
    public boolean excluiUsuario(String usuario) {

        boolean resultExclusao;

        //Fazer a instancia da conexão com o banco de dados
        Conexao banco = new Conexao();

        try{
            //abro a conexão com o banco de dados
            banco.AbrirConexao();

            //Criando parâmetro de retorno
            banco.stmt = banco.con.createStatement();

            //Executando a consulta no banco de dados
            banco.stmt.execute("DELETE FROM usuario WHERE apelido='" + usuario + "'");
            
            //Caso insira
            resultExclusao = true;      


        }catch (Exception ec){
            //Aconteceu algum problema
            System.out.println("Erro ao excluir usuario: " + ec.getMessage());
            resultExclusao = false;
        }

        banco.FecharConexao(); //Fecha nossa conexão com o banco de dados

        return resultExclusao;

    }
    
    
    //Método para excluir usuario no banco de dados
    public boolean alterarUsuario(String nome, String novaSenha, String usuario) {
        
        boolean resultAterar;

        //Fazer a instancia da conexão com o banco de dados
        Conexao banco = new Conexao();

        try{
            //abro a conexão com o banco de dados
            banco.AbrirConexao();

            //Criando parâmetro de retorno
            banco.stmt = banco.con.createStatement();

            //Executando a consulta no banco de dados
            banco.stmt.execute("UPDATE usuario SET apelido='" + nome + "', senha='" + novaSenha + "' WHERE apelido='" + usuario + "'" );
            
            //Caso insira
            resultAterar = true;      


        }catch (Exception ec){
            //Aconteceu algum problema
            System.out.println("Erro ao excluir usuario: " + ec.getMessage());
            resultAterar = false;
        }

        banco.FecharConexao(); //Fecha nossa conexão com o banco de dados

        return resultAterar;
    

    }
    
}
