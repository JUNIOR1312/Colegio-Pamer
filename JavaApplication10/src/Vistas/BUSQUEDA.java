
package Vistas;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class BUSQUEDA extends javax.swing.JPanel {
    
    public BUSQUEDA() {
        initComponents();
        
        llenarTablaIncidencias();
        actualizarTablaIncidencias();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnbuscar = new javax.swing.JButton();
        txtbusqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        modeloTablaIncidencias = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(100, 100));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lupa.png"))); // NOI18N
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        txtbusqueda.setToolTipText("");
        txtbusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbusquedaActionPerformed(evt);
            }
        });

        modeloTablaIncidencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "Tipo", "Descripción", "Fecha de Creación", "Estado", "Prioridad", "ID Profesor", "ID Salón", "ID Alumno"
            }
        ));
        jScrollPane1.setViewportView(modeloTablaIncidencias);

        btnEditar.setText("EDITAR DATOS");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(233, 233, 233)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(btnbuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtbusqueda)
                    .addComponent(btnbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtbusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbusquedaActionPerformed
        
    }//GEN-LAST:event_txtbusquedaActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int selectedRow = modeloTablaIncidencias.getSelectedRow();
        if (selectedRow >= 0) {
            DefaultTableModel modeloTablaIncidencias = (DefaultTableModel) this.modeloTablaIncidencias.getModel();
            int id = (int) modeloTablaIncidencias.getValueAt(selectedRow, 0);
            String tipo = (String) modeloTablaIncidencias.getValueAt(selectedRow, 1);
            String descripcion = (String) modeloTablaIncidencias.getValueAt(selectedRow, 2);
            String estado = (String) modeloTablaIncidencias.getValueAt(selectedRow, 4);
            String prioridad = (String) modeloTablaIncidencias.getValueAt(selectedRow, 5);

            JTextField txtTipo = new JTextField(tipo);
            JTextField txtDescripcion = new JTextField(descripcion);
            JTextField txtEstado = new JTextField(estado);
            JTextField txtPrioridad = new JTextField(prioridad);

            Object[] message = {
                "Tipo:", txtTipo,
                "Descripción:", txtDescripcion,
                "Estado (Abierta, En proceso, Cerrada):", txtEstado,
                "Prioridad (Alta, Media, Baja):", txtPrioridad
            };

            int option = JOptionPane.showConfirmDialog(null, message, "Editar Incidencia", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                estado = txtEstado.getText();
                prioridad = txtPrioridad.getText();
                
                if (!estado.equals("Abierta") && !estado.equals("En proceso") && !estado.equals("Cerrada")) {
                    JOptionPane.showMessageDialog(null, "Estado debe ser 'Abierta', 'En proceso' o 'Cerrada'.");
                    return;
                }
                
                if (!prioridad.equals("Alta") && !prioridad.equals("Media") && !prioridad.equals("Baja")) {
                    JOptionPane.showMessageDialog(null, "Prioridad debe ser 'Alta', 'Media' o 'Baja'.");
                    return;
                }

                tipo = txtTipo.getText();
                descripcion = txtDescripcion.getText();

                String url = "jdbc:mysql://localhost/Pamer";  
                String user = "root";  
                String password = "andre"; 

                try (Connection conn = DriverManager.getConnection(url, user, password);
                     PreparedStatement stmt = conn.prepareStatement("UPDATE Incidencias SET tipo=?, descripcion=?, estado=?, prioridad=? WHERE id=?")) {
                    stmt.setString(1, tipo);
                    stmt.setString(2, descripcion);
                    stmt.setString(3, estado);
                    stmt.setString(4, prioridad);
                    stmt.setInt(5, id);
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                modeloTablaIncidencias.setValueAt(tipo, selectedRow, 1);
                modeloTablaIncidencias.setValueAt(descripcion, selectedRow, 2);
                modeloTablaIncidencias.setValueAt(estado, selectedRow, 4);
                modeloTablaIncidencias.setValueAt(prioridad, selectedRow, 5);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fila para editar.");
        }
    
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int selectedRow = modeloTablaIncidencias.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) modeloTablaIncidencias.getValueAt(selectedRow, 0);
            
            // Eliminar de la base de datos
            String url = "jdbc:mysql://localhost/Pamer";  
            String user = "root";  
            String password = "andre";  

            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement stmt = conn.createStatement()) {
                String sql = "DELETE FROM Incidencias WHERE id = " + id;
                stmt.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
                return;
            }

            // Eliminar de la tabla
            DefaultTableModel modeloTablaIncidencias = (DefaultTableModel) this.modeloTablaIncidencias.getModel();
            modeloTablaIncidencias.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        String textoBusqueda = txtbusqueda.getText();
        if (!textoBusqueda.trim().isEmpty()) {
            filtrarTablaIncidencias(textoBusqueda);
        } else {
            llenarTablaIncidencias();
        }
    }//GEN-LAST:event_btnbuscarActionPerformed
 // Método para llenar la tabla con incidencias
    private void llenarTablaIncidencias() {
        DefaultTableModel modeloTablaIncidencias = (DefaultTableModel) this.modeloTablaIncidencias.getModel();
        modeloTablaIncidencias.setRowCount(0); // Limpiar la tabla

        String url = "jdbc:mysql://localhost/Pamer";  
        String user = "root";  
        String password = "andre"; 

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM Incidencias";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Query ejecutada correctamente.");
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String tipo = rs.getString("tipo");
                String descripcion = rs.getString("descripcion");
                String fechaCreacion = rs.getString("fecha_creacion");
                String estado = rs.getString("estado");
                String prioridad = rs.getString("prioridad");
                int idProfesor = rs.getInt("id_profesor");
                int idSalon = rs.getInt("id_salon");
                int idAlumno = rs.getInt("id_alumno");

                modeloTablaIncidencias.addRow(new Object[]{id, tipo, descripcion, fechaCreacion, estado, prioridad, idProfesor, idSalon, idAlumno});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

// Método para filtrar la tabla con incidencias
    private void filtrarTablaIncidencias(String textoBusqueda) {
        DefaultTableModel modeloTablaIncidencias = (DefaultTableModel) this.modeloTablaIncidencias.getModel();
        modeloTablaIncidencias.setRowCount(0); // Limpiar la tabla

        String url = "jdbc:mysql://localhost/Pamer";  
        String user = "root";  
        String password = "andre"; 

        String sql = "SELECT * FROM Incidencias WHERE id LIKE ? OR id_profesor LIKE ? OR id_alumno LIKE ? OR tipo LIKE ? OR descripcion LIKE ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            String likeQuery = "%" + textoBusqueda + "%";
            stmt.setString(1, likeQuery);
            stmt.setString(2, likeQuery);
            stmt.setString(3, likeQuery);
            stmt.setString(4, likeQuery);
            stmt.setString(5, likeQuery);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String tipo = rs.getString("tipo");
                String descripcion = rs.getString("descripcion");
                String fechaCreacion = rs.getString("fecha_creacion");
                String estado = rs.getString("estado");
                String prioridad = rs.getString("prioridad");
                int idProfesor = rs.getInt("id_profesor");
                int idSalon = rs.getInt("id_salon");
                int idAlumno = rs.getInt("id_alumno");

                modeloTablaIncidencias.addRow(new Object[]{id, tipo, descripcion, fechaCreacion, estado, prioridad, idProfesor, idSalon, idAlumno});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
// Método para llenar la tabla después de registrar una nueva incidencia (llamado desde otra parte deñl código)

    public void actualizarTablaIncidencias() {
        llenarTablaIncidencias();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable modeloTablaIncidencias;
    private javax.swing.JTextField txtbusqueda;
    // End of variables declaration//GEN-END:variables


}
