package DAO;

import GetSet.CadastroGetSet;
import Connection.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CadastroDAO {

    public void cadastrar(CadastroGetSet cgs) {
       
        // ESCREVENDO NO MYSQL
        String sql = "INSERT INTO cadastro(nome, dataNascimento, telefone, login, senha)"
                + "VALUES(?, ?, ?, ?, ?)";

        // CRIANDO PREPARED STATEMENT
        PreparedStatement ps = null;
        try {
            
            // TESTANDO CONEXÃO E MANDANDO A STRING SQL PARA O BANCO
            ps = Connection.getConnection().prepareStatement(sql);

            // SETANDO CADA DADO 
            ps.setString(1, cgs.getNome());
            ps.setInt(2, cgs.getDataNascimento());
            ps.setDouble(3, cgs.getTelefone());
            ps.setString(4, cgs.getLogin());
            ps.setString(5, cgs.getSenha());
            
            // EXECUTANDO
            ps.execute();
            
            // FECHANDO
            ps.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    // CRIANDO BOOLEANS PARA VERIFICAÇÕES
    public boolean loginExistente = true;
 

    public void verUserExist(CadastroGetSet lista) {
        
        // ESCREVENDO NO MYSQL
        String sql = "SELECT * FROM cadastro";

        // CRIANDO RESULT SET
        ResultSet rs = null;

        // CRIANDO PREPARED STATEMENT
        PreparedStatement ps = null;

        try {
            
            // TESTANDO CONEXÃO E MANDANDO A STRING SQL PARA O BANCO
            ps = Connection.getConnection().prepareStatement(sql);
            
            // FAZENDO UM EXECUTE QUERY
            rs = ps.executeQuery();
            
            // CRIANDO STRING PARA A VERIFICAÇÃO
            String login;
            String senha;
            int id;
          
            // PUXANDO INFORMAÇÕES DA TABELA(SE MANTEM NO WHILE ENQUANTO TIVER INFORMAÇÕES)
            while (rs.next()) {
                login = rs.getString("login");
                id = rs.getInt("id");

                // IF DE VERIFICAÇÃO(CASO O NOME DE USUARIO FOR IGUAL AO NOME DE USUARIO PUXADO DA TABELA)
                if (lista.getLogin().equals(login)) {
                    loginExistente = true;
                    System.out.println("Nome de usuario inválido! Tente Novamente. \n\n");

                }
             

            }

        } catch (SQLException e) {
            System.out.println(e);

        }
    }
}
