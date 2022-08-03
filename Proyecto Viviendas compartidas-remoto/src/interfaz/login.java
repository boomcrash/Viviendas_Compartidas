
package interfaz;

import conectar.Conexion;
import control.TextPrompt;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class login extends javax.swing.JFrame {
    public static String tipo_usuario;
    public static int id_persona;
    public static String usuario;
    public static String contraseña;
    TextPrompt prueba;
        
    public login() {
        initComponents();
        this.setLocationRelativeTo(this);
        prueba = new TextPrompt("Usuario o correo electrónico", jtUsuario_empresa);
        prueba = new TextPrompt("Password", jpContraseña_empresa);
        jbRegistro.setEnabled(false);
    }
    
    public void validar(){
        if(jtUsuario_empresa.getText().isEmpty()){
            jtUsuario_empresa.setBackground(Color.red);
        }
        if(jpContraseña_empresa.getText().isEmpty()){
             jpContraseña_empresa.setBackground(Color.red);
        }
        if(!jtUsuario_empresa.getText().isEmpty()&&!jpContraseña_empresa.getText().isEmpty()){
        Conexion conect= new Conexion();
        com.mysql.jdbc.Connection conexion2=(com.mysql.jdbc.Connection) conect.getconection();
        PreparedStatement buscador = null,buscador2=null;
        ResultSet dato = null;
        ResultSet dato2 = null;
       try{
        buscador= (PreparedStatement) conexion2.prepareStatement("select * from cuenta where usuario=? and contraseña=?");
        buscador.setString(1,jtUsuario_empresa.getText());
        buscador.setString(2,jpContraseña_empresa.getText());
        dato=buscador.executeQuery();
        if(dato.next())
        {
            String id=dato.getString("id_cuenta");

            if(jtUsuario_empresa.getText().equalsIgnoreCase(dato.getString("usuario"))&&jpContraseña_empresa.getText().equalsIgnoreCase(dato.getString("contraseña")))
            {
                JOptionPane.showMessageDialog(null, "INGRESO EXITOSO");
                try{
                String sql="select `tipo` from cuenta where id_cuenta=?";
                buscador2= (PreparedStatement) conexion2.prepareStatement(sql);
                buscador2.setString(1, id);
                dato2=buscador2.executeQuery();
                if(dato2.next()){
                tipo_usuario=dato2.getString("tipo");
                System.out.println(tipo_usuario);
                try{
                   if(tipo_usuario.equalsIgnoreCase("ANFITRION")){
                            String sql2="select `id_anfitrion` from anfitrion where cuenta_id=?";
                            buscador2= (PreparedStatement) conexion2.prepareStatement(sql2);
                            buscador2.setString(1, id);
                            dato2=buscador2.executeQuery();
                            if(dato2.next()){
                            id_persona=dato2.getInt("id_anfitrion");}
                            System.out.println(id);
                   }else if(tipo_usuario.equalsIgnoreCase("HUESPED")){
                            String sql3="select `id_huesped` from huesped where cuenta_id=?";
                            buscador2= (PreparedStatement) conexion2.prepareStatement(sql3);
                            buscador2.setString(1, id);
                            dato2=buscador2.executeQuery();
                            if(dato2.next()){
                            id_persona=dato2.getInt("id_huesped");}
                            System.out.println(id);
                   }
                 dispose();
                if(tipo_usuario.equalsIgnoreCase("huesped")){
                    huesped x=new huesped();
                    x.setVisible(true); 
                }else if(tipo_usuario.equalsIgnoreCase("anfitrion")){
                    viviendas x=new viviendas();
                    x.setVisible(true);
                }
                }catch(Exception e){
                    System.out.println("error de obtener id");
                }
               
               
                }
                }catch(SQLException ex)
                {
                    System.err.println("ERROR EN OBTENER DATOS 2");
                }
            }
        }
        
       }catch(SQLException ex)
       {
           System.err.println("ERROR EN OBTENER DATOS");
       }finally{
           try{buscador.close();} catch (Exception e){}
           try{buscador2.close();} catch (Exception e){}
            try{dato.close();} catch (Exception e){}
            try{dato2.close();} catch (Exception e){}
            try{conexion2.close();} catch (Exception e){}
       }
    }
    }
    
    public void validar2(){
        if(!jtUsuario_empresa.getText().isEmpty()){
            if(!jpContraseña_empresa.getText().isEmpty()){
                jbRegistro.setEnabled(true);                
            }else{
                jbRegistro.setEnabled(false);
            }                      
        }else{
            jbRegistro.setEnabled(false);
        }         
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtUsuario_empresa = new javax.swing.JTextField();
        jbIniciarsesion_empresa = new javax.swing.JButton();
        jpContraseña_empresa = new javax.swing.JPasswordField();
        jbRegistro = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ESPACIO DE TRABAJO COMPARTIDO");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtUsuario_empresa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtUsuario_empresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtUsuario_empresaKeyReleased(evt);
            }
        });

        jbIniciarsesion_empresa.setText("INICIAR SESIÓN");
        jbIniciarsesion_empresa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbIniciarsesion_empresa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbIniciarsesion_empresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIniciarsesion_empresaActionPerformed(evt);
            }
        });

        jpContraseña_empresa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpContraseña_empresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jpContraseña_empresaKeyReleased(evt);
            }
        });

        jbRegistro.setText("REGISTRARSE");
        jbRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbRegistro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistroActionPerformed(evt);
            }
        });

        jMenu1.setText("Opciones");

        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbIniciarsesion_empresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                    .addComponent(jtUsuario_empresa)
                    .addComponent(jpContraseña_empresa))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtUsuario_empresa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpContraseña_empresa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbIniciarsesion_empresa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistroActionPerformed
         usuario = jtUsuario_empresa.getText().trim();
        contraseña = jpContraseña_empresa.getText().trim();
        registro regis = new registro(this, true);
        regis.setVisible(true);
        this.dispose();
       
    }//GEN-LAST:event_jbRegistroActionPerformed

    private void jbIniciarsesion_empresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIniciarsesion_empresaActionPerformed
        validar();
    }//GEN-LAST:event_jbIniciarsesion_empresaActionPerformed

    private void jtUsuario_empresaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtUsuario_empresaKeyReleased
        jtUsuario_empresa.setBackground(Color.white);
        validar2();
    }//GEN-LAST:event_jtUsuario_empresaKeyReleased

    private void jpContraseña_empresaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpContraseña_empresaKeyReleased
        jpContraseña_empresa.setBackground(Color.white);
        validar2();
    }//GEN-LAST:event_jpContraseña_empresaKeyReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JButton jbIniciarsesion_empresa;
    private javax.swing.JButton jbRegistro;
    private javax.swing.JPasswordField jpContraseña_empresa;
    private javax.swing.JTextField jtUsuario_empresa;
    // End of variables declaration//GEN-END:variables
}