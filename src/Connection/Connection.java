package Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    private static final String url = "jdbc:mysql://localhost:3306/cadastro";

    private static final String user = "root";

    private static final String pswd = "root";
    
     private static java.sql.Connection conn;

    public static java.sql.Connection getConnection() {
        try {

            if (conn == null) {

                conn = DriverManager.getConnection(url, user, pswd);
                
                return conn;
            }else{
                
                return conn;
            }

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }

    }

 }


