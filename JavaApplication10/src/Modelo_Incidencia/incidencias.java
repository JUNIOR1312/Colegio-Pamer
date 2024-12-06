
package Modelo_Incidencia;
import java.sql.Timestamp;


public class incidencias {
    private int id;
    private String tipo;
    private String descripcion;
    private Timestamp fechaCreacion;
    private String estado;
    private String prioridad;
    private int id_profesor;
    private int id_salon;
    private int id_alumno;

 
    
    //G-Y-S

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public java.sql.Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public int getIdProfesor() {
        return id_profesor;
    }

    public void setIdProfesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public int getIdSalon() {
        return id_salon;
    }

    public void setIdSalon(int id_salon) {
        this.id_salon = id_salon;
    }

    public int getIdAlumno() {
        return id_alumno;
    }

    public void setIdAlumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    
    
}
