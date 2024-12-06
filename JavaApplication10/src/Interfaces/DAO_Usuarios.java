
package Interfaces;

import Modelo_Persona.Persona;
import java.util.List;
public interface DAO_Usuarios {
    public void registar (Persona persona)throws Exception;
    public void modificar (Persona persona)throws Exception;
    public void eliminar (Persona persona)throws Exception;
    public List<Persona> Listar()throws Exception;


}
