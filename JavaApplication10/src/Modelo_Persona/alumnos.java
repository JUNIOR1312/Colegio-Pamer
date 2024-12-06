
package Modelo_Persona;

public class alumnos extends Persona{
    private int id_salon;

    public int getIdSalon() {
        return id_salon;
    }

    public void setIdSalon(int id_salon) {
        this.id_salon = id_salon;
    }

    @Override
    public int getId_Actual() {
        return this.id_actual;
    }
    
    
    
}
