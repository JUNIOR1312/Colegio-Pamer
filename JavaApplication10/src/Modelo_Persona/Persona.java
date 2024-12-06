
package Modelo_Persona;

public abstract class  Persona {
    
    private static Persona usuarioActual;

    public static Persona obtenerUsuarioActual() {
        return usuarioActual;
    }

    public static void establecerUsuarioActual(Persona usuario) {
        usuarioActual = usuario;
    }
    
    
    
    

    int id_actual;
    private String nombre;
    private String apellido;


    public abstract int getId_Actual();

    public void setId_Actual(int id_actual) {
        this.id_actual = id_actual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
    
}
