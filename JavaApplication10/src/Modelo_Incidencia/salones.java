
package Modelo_Incidencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class salones extends incidencias{
    private int id_salon;
    private String nombre;
    private int idProfesor;
    
    
    //G-Y-S

    @Override
    public int getIdSalon() {
        return id_salon;
    }

    @Override
    public void setIdSalon(int id_salon) {
        this.id_salon = id_salon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int getIdProfesor() {
        return idProfesor;
    }

    @Override
    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }
    
    

}
