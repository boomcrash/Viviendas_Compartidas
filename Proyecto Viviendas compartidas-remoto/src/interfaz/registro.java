
package interfaz;

import conectar.Conexion;
import control.TextPrompt;
import static interfaz.login.contraseña;
import static interfaz.login.usuario;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class registro extends javax.swing.JDialog {
    public int id_usuario;
    TextPrompt prueba;
    String usu = login.usuario;
    String contr = login.contraseña;
    
    public registro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(this);
        jbRegistrarse.setEnabled(false);
        prueba = new TextPrompt("Nombre",jTNombre);
        prueba = new TextPrompt("Cedula",jTCi);
        prueba = new TextPrompt("Dirección",jTDireccion);
        prueba = new TextPrompt("Telefono",jTTlefono);  
        validar();
    }
    
     

    public void validar(){
        if(jTNombre.getText().isEmpty()){
            jTNombre.setBackground(Color.red);
        }
        if(jTCi.getText().isEmpty()){
            jTCi.setBackground(Color.red);
        }
        if(jTDireccion.getText().isEmpty()){
            jTDireccion.setBackground(Color.red);
        }
        if(jTTlefono.getText().isEmpty()){
            jTTlefono.setBackground(Color.red);
        }        
    }

    public void validar2(){
        if(!jTNombre.getText().isEmpty()){
            if(!jTCi.getText().isEmpty()){
                if(!jTDireccion.getText().isEmpty()){
                    if(!jTTlefono.getText().isEmpty()){
                        jbRegistrarse.setEnabled(true);
                    }else{
                        jbRegistrarse.setEnabled(false);}
                }else{
                    jbRegistrarse.setEnabled(false);}
            }else{
                jbRegistrarse.setEnabled(false);}
        }else{
            jbRegistrarse.setEnabled(false);}
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTCi = new javax.swing.JTextField();
        jTNombre = new javax.swing.JTextField();
        jTTlefono = new javax.swing.JTextField();
        jTDireccion = new javax.swing.JTextField();
        jbRegistrarse = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BIENVENIDO");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTCi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTCi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTCiKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTCiKeyTyped(evt);
            }
        });

        jTNombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTNombreKeyTyped(evt);
            }
        });

        jTTlefono.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTTlefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTTlefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTTlefonoKeyTyped(evt);
            }
        });

        jTDireccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTDireccionKeyReleased(evt);
            }
        });

        jbRegistrarse.setText("REGISTRARSE");
        jbRegistrarse.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistrarseActionPerformed(evt);
            }
        });

        buttonGroup2.add(jToggleButton1);
        jToggleButton1.setText("ANFITRION");
        jToggleButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        buttonGroup2.add(jToggleButton2);
        jToggleButton2.setText("HUESPED");
        jToggleButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTNombre)
                            .addComponent(jTCi)
                            .addComponent(jTDireccion)
                            .addComponent(jTTlefono))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTCi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTTlefono, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jbRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistrarseActionPerformed

        if(!jTNombre.getText().isEmpty()&&!jTCi.getText().isEmpty()&&!jTDireccion.getText().isEmpty()&&!jTTlefono.getText().isEmpty()&&(jToggleButton1.isSelected()||jToggleButton2.isSelected()))
     {Conexion conect= new Conexion();
      Connection conexion=(Connection) conect.getconection();
         
     PreparedStatement ps=null,ps2=null;
     ResultSet rs=null;
         try { System.out.println(usuario+"      "+contraseña);
                System.out.println("BBBB");
                if(jToggleButton2.isSelected()){
                   
                    ps2=(PreparedStatement) conexion.prepareStatement("insert into cuenta (usuario,contraseña,tipo) values(?,?,?)");
                    ps2.setString(1, usuario);
                    ps2.setString(2, contraseña);
                    ps2.setString(3,"HUESPED");
                    ps2.executeUpdate();
                     System.out.println("AAAAA");
                    ps2=(PreparedStatement) conexion.prepareStatement("select  id_cuenta from cuenta where usuario=? and contraseña=?");
                   ps2.setString(1, usu);
                    ps2.setString(2, contr);
                    rs=ps2.executeQuery();
                    if(rs.next()){
                        id_usuario=rs.getInt("id_cuenta");
                    }
                    ps2=(PreparedStatement) conexion.prepareStatement("insert into huesped (nombres,cedula,direccion,telefono,cuenta_id) values(?,?,?,?,?)");
                    ps2.setString(1, jTNombre.getText());
                    ps2.setString(2, jTCi.getText());
                    ps2.setString(3,jTDireccion.getText());
                    ps2.setString(4, jTTlefono.getText());
                    ps2.setInt(5, id_usuario);
                    ps2.executeUpdate();
                }else if(jToggleButton1.isSelected()){
                    ps2=(PreparedStatement) conexion.prepareStatement("insert into cuenta (usuario,contraseña,tipo) values(?,?,?)");
                    ps2.setString(1, usuario);
                    ps2.setString(2, contraseña);
                    ps2.setString(3,"ANFITRION");
                    ps2.executeUpdate();
                     System.out.println("AAAAA");
                    ps2=(PreparedStatement) conexion.prepareStatement("select  id_cuenta from cuenta where usuario=? and contraseña=?");
                    ps2.setString(1, usuario);
                    ps2.setString(2,contraseña);
                    rs=ps2.executeQuery();
                    if(rs.next()){
                        id_usuario=rs.getInt("id_cuenta");
                    }
                    ps2=(PreparedStatement) conexion.prepareStatement("insert into anfitrion (nombres,cedula,direccion,telefono,cuenta_id) values(?,?,?,?,?)");
                    ps2.setString(1, jTNombre.getText());
                    ps2.setString(2, jTCi.getText());
                    ps2.setString(3,jTDireccion.getText());
                    ps2.setString(4, jTTlefono.getText());
                    ps2.setInt(5, id_usuario);
                    ps2.executeUpdate();
                }
             // TODO add your handling code here:
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR DE REGISTRO !\nERROR DE CONEXION");
         }finally {try{ps2.close();} catch (Exception e){}
         {try{ps.close();} catch (Exception e){}
            try{conexion.close();} catch (Exception e){}
            
         }
    }
          /*panel.removeAll();
        panel.repaint();
        limpiar();*/
     }else {JOptionPane.showMessageDialog(null, "ERROR DE REGISTRO !\nREVISE QUE LOS CAMPOS ESTEN LLENADOS CORRECTAMENTE.");}
login a = new login();
a.setVisible(true);
this.dispose();
    }//GEN-LAST:event_jbRegistrarseActionPerformed

    private void jTNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreKeyTyped
        char ch = evt.getKeyChar();
        if(!Character.isLetter(ch)
                && ch != KeyEvent.VK_BACK_SPACE
                && ch != KeyEvent.VK_SPACE
                && ch != KeyEvent.VK_DELETE) {
            JOptionPane.showMessageDialog(this, "NO DIGITE LETRAS", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            evt.consume();
        }
    }//GEN-LAST:event_jTNombreKeyTyped

    private void jTCiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCiKeyTyped
        Character ch = evt.getKeyChar();
        if (!Character.isDigit(ch) && ch != KeyEvent.VK_BACK_SPACE && ch != KeyEvent.VK_DELETE) {
            JOptionPane.showMessageDialog(this, "SOLO DIGITE NUMEROS", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            evt.consume();
        }
    }//GEN-LAST:event_jTCiKeyTyped

    private void jTTlefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTTlefonoKeyTyped
        Character ch = evt.getKeyChar();
        if (!Character.isDigit(ch) && ch != KeyEvent.VK_BACK_SPACE && ch != KeyEvent.VK_DELETE) {
            JOptionPane.showMessageDialog(this, "SOLO DIGITE NUMEROS", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            evt.consume();
        }
    }//GEN-LAST:event_jTTlefonoKeyTyped

    private void jTCiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCiKeyReleased
        jTCi.setBackground(Color.white);
        validar2();
        validar();
    }//GEN-LAST:event_jTCiKeyReleased

    private void jTNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreKeyReleased
        jTNombre.setBackground(Color.white);
        validar2();
        validar();
    }//GEN-LAST:event_jTNombreKeyReleased

    private void jTTlefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTTlefonoKeyReleased
        jTTlefono.setBackground(Color.white);
        validar2();
        validar();
    }//GEN-LAST:event_jTTlefonoKeyReleased

    private void jTDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTDireccionKeyReleased
        jTDireccion.setBackground(Color.white);
        validar2();
        validar();
    }//GEN-LAST:event_jTDireccionKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTCi;
    private javax.swing.JTextField jTDireccion;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTextField jTTlefono;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JButton jbRegistrarse;
    // End of variables declaration//GEN-END:variables
}
