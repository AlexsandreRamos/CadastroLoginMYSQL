
package DAO;

import Connection.Connection;
import GetSet.LoginGetSet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    
    public boolean verificado;
  
    
    
    public void verificar(LoginGetSet LGS){
        String sql = "SELECT * FROM cadastro";
        
        PreparedStatement ps = null;
        
        ResultSet rs = null;
        
        try{
            
            ps = Connection.getConnection().prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            String login;
            String senha;
           
            
            while(rs.next()){
           
                login = rs.getString("login");
                senha = rs.getString("senha");
                
                
                
                if(LGS.getLogin().equals(login) && LGS.getSenha().equals(senha)){
                    verificado = true;
                    System.out.println("Logado!");
                }
                
            }
            
            
        }catch(SQLException e){
            System.out.println(e);
            
        }
        
    }
}
