
import java.sql.*;
public class Conexion {
    static String baseDeDatos= "clinica";
    static String parametros="?useSSL=false&serverTimezone=UTC";
    static String user = "root";
    static String password = "1234";
    static String url = "jdbc:mysql://localhost:3306/" + baseDeDatos + parametros;

    private Connection conexion = null;
    
    public void ConexionBaseDeDatos() throws SQLException{
        conexion = DriverManager.getConnection(url, user, password);
    }
    public Connection getConnection() { return conexion; }
    public void desconectar(){
        if(conexion != null){
            try{
                System.out.println("Desconectandose de " + baseDeDatos);
                conexion.close();
                System.out.println("Has sido desconectado de " + baseDeDatos);
            }catch (SQLException e){
                System.err.println(e);
            }

        }
    }
}
