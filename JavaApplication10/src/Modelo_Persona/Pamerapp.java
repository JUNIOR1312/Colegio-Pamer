
package Modelo_Persona;

import Pamer.LogIn;
import java.sql.SQLException;

public class Pamerapp {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        LogIn login = new LogIn();
        login.setVisible(true);
        login.setTitle("Login de gestor de incidencias");
    }
    
}
