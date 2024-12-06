
package Interfaces;
import Modelo_Incidencia.incidencias;
import java.util.List;
public interface DAO_incidencias {
    public void registrar (incidencias incidencias) throws Exception;
    public void busqueda (incidencias incidencias) throws Exception;
    public void eliminar (incidencias incidencias) throws Exception;
    public void modificar (incidencias incidencias) throws Exception;
    public List<incidencias> Listar()throws Exception;


}
