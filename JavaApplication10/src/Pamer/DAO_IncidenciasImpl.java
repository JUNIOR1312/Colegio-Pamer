
package Pamer;

import Conexiones.database;
import Interfaces.DAO_incidencias;
import Modelo_Incidencia.incidencias;
import Modelo_Persona.Persona;
import Modelo_Persona.profesores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_IncidenciasImpl extends database implements DAO_incidencias  {

    @Override
    public void registrar(incidencias incidencias) throws Exception {
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO incidencias( tipo, descripcion, fecha_creacion, estado ,prioridad, id_profesor, id_salon, id_alumno) VALUES(?,?,?,?,?,?,?,?)");
                    
            st.setString(1, incidencias.getTipo());
            st.setString(2, incidencias.getDescripcion());
            st.setTimestamp(3, incidencias.getFechaCreacion()); 
            st.setString(4, incidencias.getEstado());
            st.setString(5, incidencias.getPrioridad());
            
            
            Persona usuarioActual = Persona.obtenerUsuarioActual();

            if (usuarioActual instanceof profesores) {
                int id_profesor = ((profesores) usuarioActual).getId_Actual();
                int id_salon = incidencias.getIdSalon();
                int id_alumno = incidencias.getIdAlumno();
                
                // Impresiones de depuración
                System.out.println("ID Profesor: " + id_profesor);
                System.out.println("ID Salón: " + id_salon);
                System.out.println("ID Alumno: " + id_alumno);
                
                
                st.setInt(6, id_profesor); // id_profesor
                st.setInt(7, id_salon); // id_salon
                st.setInt(8, id_alumno); // id_alumno
            } else {
                this.conectar();
                throw new IllegalStateException("Usuario actual no reconocido");
            }
            
            st.executeUpdate();
        } catch (ClassNotFoundException | IllegalStateException | SQLException e) {
            throw e;
        }finally{
            this.conectar();
        }
    }

    @Override
    public void busqueda(incidencias incidencias) throws Exception {
        String sql = "SELECT * FROM incidencias WHERE id = ?";
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setInt(1, incidencias.getId());

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                incidencias.setTipo(rs.getString("tipo"));
                incidencias.setDescripcion(rs.getString("descripcion"));
                incidencias.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
                incidencias.setEstado(rs.getString("estado"));
                incidencias.setPrioridad(rs.getString("prioridad"));
                incidencias.setIdProfesor(rs.getInt("id_profesor"));
                incidencias.setIdSalon(rs.getInt("id_salon"));
                incidencias.setIdAlumno(rs.getInt("id_alumno"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.conectar();
        }
    }

    @Override
    public void modificar(incidencias incidencias) throws Exception {
         String sql = "UPDATE incidencias SET tipo = ?, descripcion = ?, fecha_creacion = ?, estado = ?, prioridad = ?, id_profesor = ?, id_salon = ?, id_alumno = ? WHERE id = ?";
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, incidencias.getTipo());
            st.setString(2, incidencias.getDescripcion());
            st.setTimestamp(3, incidencias.getFechaCreacion());
            st.setString(4, incidencias.getEstado());
            st.setString(5, incidencias.getPrioridad());
            st.setInt(6, incidencias.getIdProfesor());
            st.setInt(7, incidencias.getIdSalon());
            st.setInt(8, incidencias.getIdAlumno());
            st.setInt(9, incidencias.getId());

            st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.conectar();
        }
    }

    @Override
    public List<incidencias> Listar() throws Exception {
        
         List<incidencias> lista = new ArrayList<>();
        String sql = "SELECT * FROM incidencias";
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                incidencias incidencia = new incidencias();
                incidencia.setId(rs.getInt("id"));
                incidencia.setTipo(rs.getString("tipo"));
                incidencia.setDescripcion(rs.getString("descripcion"));
                incidencia.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
                incidencia.setEstado(rs.getString("estado"));
                incidencia.setPrioridad(rs.getString("prioridad"));
                incidencia.setIdProfesor(rs.getInt("id_profesor"));
                incidencia.setIdSalon(rs.getInt("id_salon"));
                incidencia.setIdAlumno(rs.getInt("id_alumno"));

                lista.add(incidencia);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.conectar();
        }
        return lista;
        
    }

    @Override
    public void eliminar(incidencias incidencias) throws Exception {
        
         String sql = "DELETE FROM incidencias WHERE id = ?";
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setInt(1, incidencias.getId());

            st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            this.conectar();
        }
    }
    
}
