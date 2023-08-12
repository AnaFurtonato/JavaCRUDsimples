package login;


public class TestaConexao {

    
    public static void main(String[] args) {
        Conexao c = new Conexao(); //Instanciamos o objeto c de Conexão
        c.AbrirConexao(); //Chamamos o método de abertura da conexão do banco de dados
        
        try {
            Thread.sleep(4000);//Fazemos uma pausa de 4 segundos
            c.FecharConexao(); //Fechamos a conexão
        }
        catch(InterruptedException ex){
            //Mensagem de saída caso haja erro
            System.out.println("Azedou fazer o projeto dormir, verifique");
        }
    }
    
}
