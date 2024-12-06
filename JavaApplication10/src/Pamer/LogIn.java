package Pamer;
import Conexiones.database;
import Modelo_Persona.Persona;
import Modelo_Persona.profesores;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LogIn extends javax.swing.JFrame {
    int xMouse,yMouse;
    private database db;
    private Connection connection;
    public LogIn() throws ClassNotFoundException, SQLException {
        initComponents();
        db = new database();
        
        try {
            db.conectar(); // Conecta a la base de datos al inicializar login
            connection = db.getConnection(); // Supuestamente mantiene la coneion abierta
        } catch (ClassNotFoundException | SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos: " + ex.getMessage(), "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }
        
        userTxt.setForeground(Color.GRAY);
        userTxt.setText("Ingrese su usuario");
        passTxt.setForeground(Color.GRAY);
        passTxt.setText("********");
    }    
    
          
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        collegebg = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        exitbtn = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        userTxt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        passLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        passTxt = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JPanel();
        loginbtntext = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        collegebg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/college1.png"))); // NOI18N
        collegebg.setText("jLabel1");
        bg.add(collegebg, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 250, 500));

        logo.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        logo.setForeground(new java.awt.Color(0, 0, 153));
        logo.setText("Colegios Pamer");
        bg.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 150, 30));

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.setForeground(new java.awt.Color(255, 255, 255));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        exitbtn.setBackground(new java.awt.Color(255, 255, 255));

        exitTxt.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        exitTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTxt.setText("X");
        exitTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout exitbtnLayout = new javax.swing.GroupLayout(exitbtn);
        exitbtn.setLayout(exitbtnLayout);
        exitbtnLayout.setHorizontalGroup(
            exitbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exitbtnLayout.createSequentialGroup()
                .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        exitbtnLayout.setVerticalGroup(
            exitbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exitbtnLayout.createSequentialGroup()
                .addComponent(exitTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(exitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 751, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 40));

        title.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        title.setText("INICIAR SESIÓN");
        bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        userLabel.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        userLabel.setText("USUARIO");
        bg.add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        userTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        userTxt.setForeground(new java.awt.Color(204, 204, 204));
        userTxt.setText("Ingrese su usuario");
        userTxt.setBorder(null);
        userTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userTxtMousePressed(evt);
            }
        });
        userTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTxtActionPerformed(evt);
            }
        });
        bg.add(userTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 460, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 460, -1));

        passLabel.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        passLabel.setText("CONTRASEÑA");
        bg.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 460, -1));

        passTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        passTxt.setForeground(new java.awt.Color(204, 204, 204));
        passTxt.setText("********");
        passTxt.setBorder(null);
        passTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passTxtMousePressed(evt);
            }
        });
        bg.add(passTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 460, 30));

        loginBtn.setBackground(new java.awt.Color(54, 71, 101));

        loginbtntext.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        loginbtntext.setForeground(new java.awt.Color(255, 255, 255));
        loginbtntext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginbtntext.setText("ENTRAR");
        loginbtntext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginbtntext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginbtntextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginbtntextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginbtntextMouseExited(evt);
            }
        });

        javax.swing.GroupLayout loginBtnLayout = new javax.swing.GroupLayout(loginBtn);
        loginBtn.setLayout(loginBtnLayout);
        loginBtnLayout.setHorizontalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginbtntext, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        loginBtnLayout.setVerticalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginbtntext, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        bg.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 200, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse=evt.getX();
        yMouse=evt.getY();        
    }//GEN-LAST:event_headerMousePressed
    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        this.setLocation(x-xMouse,y-yMouse);                      
    }//GEN-LAST:event_headerMouseDragged

    private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitTxtMouseClicked

    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseEntered
       exitbtn.setBackground(Color.RED);       
exitTxt.setForeground(Color.WHITE);       
    }//GEN-LAST:event_exitTxtMouseEntered

    private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseExited
exitbtn.setBackground(Color.WHITE);
exitTxt.setForeground(Color.BLACK); 
    }//GEN-LAST:event_exitTxtMouseExited

    private void loginbtntextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginbtntextMouseEntered
        loginBtn.setBackground(new Color(100,133,201));       
    }//GEN-LAST:event_loginbtntextMouseEntered

    private void loginbtntextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginbtntextMouseExited
                loginBtn.setBackground(new Color(54,71,101));       
    }//GEN-LAST:event_loginbtntextMouseExited

    private void userTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxtMousePressed
        if (userTxt.getText().equals("Ingrese su usuario")){
        userTxt.setText("");
        userTxt.setForeground(Color.black);    
        }
        if (String.valueOf(passTxt.getPassword()).isEmpty()){
        passTxt.setText("********");
        userTxt.setForeground(Color.gray);    
        }       
    }//GEN-LAST:event_userTxtMousePressed

    private void passTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passTxtMousePressed
        if (String.valueOf(passTxt.getPassword()).equals("********")){
        passTxt.setText("");
        userTxt.setForeground(Color.black);                
        }
       if (userTxt.getText().isEmpty()){
             userTxt.setText("Ingrese su usuario");
        userTxt.setForeground(Color.gray);   
       }     
    }//GEN-LAST:event_passTxtMousePressed
private boolean authenticate(String username, String password) throws ClassNotFoundException {
        String query = "SELECT * FROM Profesores WHERE usuario = ? AND contraseña = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                profesores profesor = new profesores();
                profesor.setId_Actual(rs.getInt("id_usuario"));
                profesor.setUsuario(rs.getString("usuario"));
                profesor.setContraseña(rs.getString("contraseña"));
                profesor.setDireccion(rs.getString("dirección"));
                profesor.setTelefono(rs.getString("teléfono"));
                profesor.setCargo(rs.getString("cargo"));

                // Establecer el usuario actual
                Persona.establecerUsuarioActual(profesor);
                
                return true;  // Retorna true si encuentra un usuario con las credenciales dadas
            }
            return false;
        } catch (SQLException e) {
            return false;
        }
    }

    private void loginbtntextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginbtntextMouseClicked
        try {
            String username = userTxt.getText();
            String password = String.valueOf(passTxt.getPassword());
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese usuario y contraseña", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (authenticate(username, password)) {
                JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso");
                //redirigir a la siguiente
                new PanelPrincipal().setVisible(true);
                this.dispose(); // Cerrar la ventana actual de inicio de sesión
            } else {
                
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_loginbtntextMouseClicked

    private void userTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTxtActionPerformed
                     
    }//GEN-LAST:event_userTxtActionPerformed
    public static void main(String args[]) {  
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new LogIn().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JLabel collegebg;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JPanel exitbtn;
    private javax.swing.JPanel header;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel loginBtn;
    private javax.swing.JLabel loginbtntext;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passTxt;
    private javax.swing.JLabel title;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables
}
