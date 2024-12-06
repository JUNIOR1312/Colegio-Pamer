package Vistas;


import Modelo_Incidencia.incidencias;
import Pamer.DAO_IncidenciasImpl;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import Conexiones.database;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;


public class REGISTRAR extends javax.swing.JPanel {
    
    private database db;
    
    public REGISTRAR() {
        initComponents();
        ComboBoxes();
        
        db = new database();
        
        try {
            db.conectar(); // Conecta a la base de datos al inicializar LogIn
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos: " + ex.getMessage(), "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }
        //---------------------------------
        // Agregar ActionListeners a cbxGrado y cbxSección
        cbxGrado.addActionListener((ActionEvent e) -> {
            actualizarCbxAlumno();
        });

        cbxSección.addActionListener((ActionEvent e) -> {
            actualizarCbxAlumno();
        });
        // Inicializar y configurar el Timer para actualizar el JLabel del tiempo
        Timer timer = new Timer(1000, (ActionEvent e) -> {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            time.setText(sdf.format(new Date()));
        });
        timer.start();   
        
    }
private void ComboBoxes() {
        cbxTipo.addItem("Académico");
        cbxTipo.addItem("Salud");
        cbxTipo.addItem("Familiar");
        cbxTipo.addItem("Otro");

        cbxPrioridad.addItem("Alta");
        cbxPrioridad.addItem("Media");
        cbxPrioridad.addItem("Baja");

        cbxGrado.addItem("1°");
        cbxGrado.addItem("2°");
        cbxGrado.addItem("3°");
        cbxGrado.addItem("4°");
        cbxGrado.addItem("5°");

        cbxSección.addItem("A");
        cbxSección.addItem("B");

    }

private void actualizarCbxAlumno() {
    cbxAlumno.removeAllItems(); // Limpiar los elementos actuales

    String grado = cbxGrado.getSelectedItem().toString();
    String seccion = cbxSección.getSelectedItem().toString();
    int idSalon = getSalonId(grado, seccion);

    String sql = "SELECT nombre FROM Alumnos WHERE id_salon = ?";

    try (PreparedStatement pstmt = db.conexion.prepareStatement(sql)) {
        pstmt.setInt(1, idSalon);

        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                cbxAlumno.addItem(rs.getString("nombre"));
            }
        }
    } catch (SQLException e) {
        System.out.println("Error al actualizar cbxAlumno: " + e.getMessage());
    }
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNom = new javax.swing.JTextField();
        cbxAlumno = new javax.swing.JComboBox<>();
        cbxTipo = new javax.swing.JComboBox<>();
        cbxPrioridad = new javax.swing.JComboBox<>();
        time = new javax.swing.JTextField();
        cbxGrado = new javax.swing.JComboBox<>();
        cbxSección = new javax.swing.JComboBox<>();
        txtDescripcion = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(100, 100));
        setPreferredSize(new java.awt.Dimension(715, 703));

        jPanel1.setPreferredSize(new java.awt.Dimension(715, 703));

        txtNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomActionPerformed(evt);
            }
        });

        cbxAlumno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alumnos:" }));
        cbxAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAlumnoActionPerformed(evt);
            }
        });

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "." }));

        cbxPrioridad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "." }));

        time.setText("fecha y hora:");
        time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeActionPerformed(evt);
            }
        });

        cbxGrado.setMaximumRowCount(6);
        cbxGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "." }));
        cbxGrado.setToolTipText("");
        cbxGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxGradoActionPerformed(evt);
            }
        });

        cbxSección.setMaximumRowCount(3);
        cbxSección.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "." }));
        cbxSección.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSecciónActionPerformed(evt);
            }
        });

        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel4.setText("Prioridad");

        jLabel7.setText("Breve descripción:");

        jLabel8.setText("Sección");

        jLabel9.setText("Grado");

        jLabel5.setText("tipo");

        jLabel1.setText("Nombre del alumno");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbxPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbxSección, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbxAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8))))
                        .addGap(0, 111, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxSección, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnLimpiar))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxGradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxGradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxGradoActionPerformed

    private void cbxSecciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSecciónActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSecciónActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            incidencias incidencia = new incidencias();
            
            incidencia.setTipo(cbxTipo.getSelectedItem().toString());
            incidencia.setDescripcion(txtDescripcion.getText());
            incidencia.setEstado("Abierta"); // Estado inicial
            incidencia.setPrioridad(cbxPrioridad.getSelectedItem().toString());
            incidencia.setFechaCreacion(new java.sql.Timestamp(new java.util.Date().getTime()));

            /////////////////
            // Obtener el ID del profesor desde la sesión actual
            int idProfesor = getUsuario_actual();
            incidencia.setIdProfesor(idProfesor);
            
            
            
            ///////////////////////////////////////////////////////////////////////////////
            int idSalon = getSalonId(cbxGrado.getSelectedItem().toString(), cbxSección.getSelectedItem().toString());
            incidencia.setIdSalon(idSalon);

            // Obtener ID del alumno basado en la selección
            String nombreAlumno = cbxAlumno.getSelectedItem().toString();
            int idAlumno = getAlumnoId(nombreAlumno);
            incidencia.setIdAlumno(idAlumno);
            /////////////////////////////////////////////////////////////////////////////////
            
            
            
            // Llamar al método para guardar la incidencia en la base de datos
            DAO_IncidenciasImpl daoIncidencias = new DAO_IncidenciasImpl();
            daoIncidencias.registrar(incidencia);
            
            JOptionPane.showMessageDialog(this, "Incidencia registrada con éxito");
        } catch (Exception ex) {
            Logger.getLogger(REGISTRAR.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al registrar la incidencia: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    
    
    }//GEN-LAST:event_btnAgregarActionPerformed
/////////////////////////////////////////////////////////////////////////////////////////////////
private int getSalonId(String grado, String seccion) {
    int idSalon = 0;
    String nombreSalon = grado + " " + seccion; // Combinamos grado y sección para obtener el nombre del salón
    String sql = "SELECT id_salon FROM Salones WHERE nombre = ?";

    try (PreparedStatement pstmt = db.conexion.prepareStatement(sql)) {
        pstmt.setString(1, nombreSalon);

        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                idSalon = rs.getInt("id_salon");
            }
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener el ID del salón: " + e.getMessage());
    }

    return idSalon;
}

//////////////////////////////////////////////////////////////////////////////////////////////////
private int getAlumnoId(String nombreAlumno) {
    int idAlumno = 0;
    String sql = "SELECT id FROM Alumnos WHERE nombre = ?";

    try (PreparedStatement pstmt = db.conexion.prepareStatement(sql)) {
        pstmt.setString(1, nombreAlumno);

        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                idAlumno = rs.getInt("id");
            }
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener el ID del alumno: " + e.getMessage());
    }

    return idAlumno;
}

/////////////////////////////////////////////////////////

//persona
public class Usuario_actual {
    private static int id;

    public static void setId(int userId) {
        id = userId;
    }

    public static int getId() {
        return id;
    }
    }

private int getUsuario_actual() {
        // Este método debe retornar el ID del profesor actual que ha iniciado sesió
        return Usuario_actual.getId();
    }   
//////////
private void limpiarCampos() {
        txtNom.setText("");
        cbxTipo.setSelectedIndex(0);
        cbxPrioridad.setSelectedIndex(0);
        cbxGrado.setSelectedIndex(0);
        cbxSección.setSelectedIndex(0);
        cbxAlumno.setSelectedIndex(0);
        txtDescripcion.setText("");
    }
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
      limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed
  
    private void txtNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomActionPerformed
        
    }//GEN-LAST:event_txtNomActionPerformed

    private void cbxAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxAlumnoActionPerformed

    private void timeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        time.setText(sdf.format(new Date()));
    }//GEN-LAST:event_timeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cbxAlumno;
    private javax.swing.JComboBox<String> cbxGrado;
    private javax.swing.JComboBox<String> cbxPrioridad;
    private javax.swing.JComboBox<String> cbxSección;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField time;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNom;
    // End of variables declaration//GEN-END:variables

    public void size(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
