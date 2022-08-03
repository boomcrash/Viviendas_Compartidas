
package interfaz;

import conectar.Conexion;
import control.TextPrompt;
import static interfaz.login.id_persona;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class editAnfitrion extends javax.swing.JFrame {
    TextPrompt prueba;
    
    public editAnfitrion() {
        initComponents();
        this.setLocationRelativeTo(null);
        prueba = new TextPrompt("Dirección",jTDireccion);
        prueba = new TextPrompt("Telefono",jTTelefono); 
        datos();

    }
  
    
    public void datos(){         
        Conexion connect=new Conexion();
        com.mysql.jdbc.Connection conexion=(com.mysql.jdbc.Connection) connect.getconection();
        PreparedStatement ps=null,ps2=null;
        ResultSet rs=null;
        try {
            ps=(com.mysql.jdbc.PreparedStatement) conexion.prepareStatement("select nombres,cedula,direccion,telefono from anfitrion where id_anfitrion=?");
            ps.setInt(1,id_persona);
            rs=ps.executeQuery();
            if(rs.next()){               
                jTCI.setText(rs.getString("cedula"));
                jTNombre.setText(rs.getString("nombres"));
                jTDireccion.setText(rs.getString("direccion"));
                jTTelefono.setText(rs.getString("telefono"));
              
            }       
        } catch (SQLException ex) {
            System.err.println("ERROR");
        }finally {try{ps.close();} catch (Exception e){}
        try{rs.close();} catch (Exception e){}
        try{conexion.close();} catch (Exception e){}
        }            
       }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTCI = new javax.swing.JTextField();
        jTNombre = new javax.swing.JTextField();
        jTDireccion = new javax.swing.JTextField();
        jTTelefono = new javax.swing.JTextField();
        jBedit = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DATOS");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTCI.setEnabled(false);

        jTNombre.setEnabled(false);
        jTNombre.setMinimumSize(new java.awt.Dimension(6, 32));
        jTNombre.setPreferredSize(new java.awt.Dimension(6, 32));

        jTDireccion.setPreferredSize(new java.awt.Dimension(6, 32));
        jTDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTDireccionKeyReleased(evt);
            }
        });

        jTTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTTelefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTTelefonoKeyTyped(evt);
            }
        });

        jBedit.setText("EDITAR");
        jBedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBeditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTCI, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(jTDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTTelefono))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jBedit, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTCI, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBedit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Opciones");

        jMenuItem2.setText("Regresar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBeditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBeditActionPerformed

        if(!jTCI.getText().isEmpty()&&!jTNombre.getText().isEmpty()&&!jTDireccion.getText().isEmpty()&&!jTTelefono.getText().isEmpty()){
            Conexion conect= new Conexion();
            com.mysql.jdbc.PreparedStatement ps2=null,ps=null;
            com.mysql.jdbc.Connection conexion=(com.mysql.jdbc.Connection) conect.getconection();
            try {
                ps2=(com.mysql.jdbc.PreparedStatement) conexion.prepareStatement("update anfitrion set cedula=?,nombres=?,direccion=?,telefono=? where id_anfitrion=?");            
                ps2.setString(1,jTCI.getText());
                ps2.setString(2,jTNombre.getText());
                ps2.setString(3,jTDireccion.getText());
                ps2.setString(4,jTTelefono.getText());
                ps2.setInt(5,id_persona);
                ps2.executeUpdate();            
                JOptionPane.showMessageDialog(null, "MODIFICADO CORRECTAMENTE");
            } catch (SQLException ex) {
                System.err.println("ERROR ");
            }finally {try{ps2.close();} catch (Exception e){}
            try{conexion.close();} catch (Exception e){}
            }
        }else {System.out.println("hola");JOptionPane.showMessageDialog(null, "ERROR DE REGISTRO !\nREVISE QUE LOS CAMPOS ESTEN LLENADOS CORRECTAMENTE.");}
    }//GEN-LAST:event_jBeditActionPerformed

    private void jTTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTTelefonoKeyTyped
        Character ch = evt.getKeyChar();
        if (!Character.isDigit(ch) && ch != KeyEvent.VK_BACK_SPACE && ch != KeyEvent.VK_DELETE) {
            JOptionPane.showMessageDialog(this, "SOLO DIGITE NUMEROS", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            evt.consume();
        }
    }//GEN-LAST:event_jTTelefonoKeyTyped

    private void jTTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTTelefonoKeyReleased

    }//GEN-LAST:event_jTTelefonoKeyReleased

    private void jTDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTDireccionKeyReleased

    }//GEN-LAST:event_jTDireccionKeyReleased

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        viviendas v = new viviendas();
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBedit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTCI;
    private javax.swing.JTextField jTDireccion;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTextField jTTelefono;
    // End of variables declaration//GEN-END:variables
}
