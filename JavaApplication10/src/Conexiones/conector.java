
package Conexiones;

import com.sun.jdi.connect.spi.Connection;
import java.sql.SQLException;

public class conector {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        database db = new database();
        db.conectar();

    }
    
}
