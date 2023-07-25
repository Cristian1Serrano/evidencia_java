/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package evidenciamodulosjdbc;

/**
 *
 * @author Creat
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class EvidenciaModulosJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3310/prueba_padtea";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EvidenciaModulosJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conexion = DriverManager.getConnection(url,usuario,password);
            statement = conexion.createStatement();
            statement.executeUpdate("INSERT INTO USUARIOS(USUARIO, CONTRASEÑA) VALUES('MARIA',9999)");
            rs = statement.executeQuery("SELECT * FROM USUARIOS");
            rs.next();
            do{
                System.out.println(rs.getInt("id")+ " : "+rs.getString("usuario"));
            }while(rs.next());
            
        } catch (SQLException ex) {
            Logger.getLogger(EvidenciaModulosJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

        // ... Código existente ...
