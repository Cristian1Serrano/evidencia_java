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

try {
    conexion = DriverManager.getConnection(url, usuario, password);
    statement = conexion.createStatement();

    // Actualizar el usuario 'MARIA' si existe
    String usuarioAActualizar = "MARIA";
    String nuevoNombre = "MARIA_MODIFICADO";
    String sqlActualizarUsuario = "UPDATE USUARIOS SET USUARIO = ? WHERE USUARIO = ?";
    PreparedStatement psActualizar = conexion.prepareStatement(sqlActualizarUsuario);
    psActualizar.setString(1, nuevoNombre);
    psActualizar.setString(2, usuarioAActualizar);
    int filasAfectadas = psActualizar.executeUpdate();

    // Comprobar si se actualizó el usuario 'MARIA'
    if (filasAfectadas > 0) {
        System.out.println("Usuario 'MARIA' actualizado correctamente.");
    } else {
        System.out.println("El usuario 'MARIA' no existe en la base de datos.");
    }

    // Mostrar los usuarios después de la actualización
    rs = statement.executeQuery("SELECT * FROM USUARIOS");
    while (rs.next()) {
        System.out.println(rs.getInt("id") + " : " + rs.getString("usuario"));
    }

} catch (SQLException ex) {
    Logger.getLogger(EvidenciaModulosJDBC.class.getName()).log(Level.SEVERE, null, ex);
}

        

try {
    conexion = DriverManager.getConnection(url, usuario, password);
    statement = conexion.createStatement();

    // Eliminar usuario 'MARIA'
    String usuarioAEliminar = "MARIA";
    String sqlEliminarUsuario = "DELETE FROM USUARIOS WHERE USUARIO = ?";
    PreparedStatement psEliminar = conexion.prepareStatement(sqlEliminarUsuario);
    psEliminar.setString(1, usuarioAEliminar);
    int filasAfectadas = psEliminar.executeUpdate();

    // Comprobar si se eliminó el usuario 'MARIA'
    if (filasAfectadas > 0) {
        System.out.println("Usuario 'MARIA' eliminado correctamente.");
    } else {
        System.out.println("El usuario 'MARIA' no existe en la base de datos.");
    }

    // Mostrar los usuarios después de la eliminación
    rs = statement.executeQuery("SELECT * FROM USUARIOS");
    rs.next();
    do {
        System.out.println(rs.getInt("id") + " : " + rs.getString("usuario"));
    } while (rs.next());

} catch (SQLException ex) {
    Logger.getLogger(EvidenciaModulosJDBC.class.getName()).log(Level.SEVERE, null, ex);
}
