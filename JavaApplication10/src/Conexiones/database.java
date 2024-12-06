package Conexiones;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
    public Connection conexion;
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/Pamer";
    
    private static final String USER="root";
    private static final String PASS="andre";
    
    public void conectar() throws ClassNotFoundException, SQLException{
        try{
            Class.forName(JDBC_DRIVER);
            conexion = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Conexión exitosa");
        } catch(SQLException ex){
            System.out.println("Error al conectar a la base de datos: " + ex.getMessage());
            throw ex;
        }
    }
   
    public Connection getConnection() {
        return conexion;
    } 
    public void Cerrar() throws SQLException{
        if(conexion != null){
            if(!conexion.isClosed()){
                conexion.close();
            }
        }
        
        
        
        
        
    }
}
