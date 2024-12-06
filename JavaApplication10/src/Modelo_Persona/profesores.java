
package Modelo_Persona;

public class profesores extends Persona {
    private int idActual;
    private String id_usuario;
    private String contraseña;
    private String direccion;
    private String telefono;
    private String cargo;


    public String getUsuario() {
        return id_usuario;
    }

    public void setUsuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
     // Métodos específicos para los profesores pruebas
    @Override
    public int getId_Actual() {
        return idActual;
    }

    @Override
    public void setId_Actual(int idActual) {
        this.idActual = idActual;
    }
}
