
package interfaz;

import conectar.Conexion;
import static interfaz.login.id_persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class huesped extends javax.swing.JFrame {
int id_locales;
int id_habitacion;

    public huesped() {
        initComponents();
        this.setLocationRelativeTo(null); 
        llenarTabla2();
    }    
    
    public void facturar(){
        Conexion connect=new Conexion();
        com.mysql.jdbc.Connection conexion=(com.mysql.jdbc.Connection) connect.getconection();
        PreparedStatement ps=null,ps2=null;
        ResultSet rs=null;
        try {
                ps=(com.mysql.jdbc.PreparedStatement) conexion.prepareStatement("update habitacion set disp_habitaciones=? where id_habitacion=?");                
                ps.setInt(1,0);
                ps.setInt(2, id_habitacion);
                ps.executeUpdate();
                
                ps2=(PreparedStatement) conexion.prepareStatement("insert into reservacion (habitacion_id,huesped_id) values(?,?)");
                ps2.setInt(1,id_habitacion);
                ps2.setInt(2, id_persona);
                ps2.executeUpdate();
                JOptionPane.showMessageDialog(null, " HA RESERVADO CON EXITO!");
                
        } catch (SQLException ex) {
            System.err.println("ERROR");
        }finally {try{ps.close();ps2.close();} catch (Exception e){}
        try{rs.close();} catch (Exception e){}
        try{conexion.close();} catch (Exception e){}
        } 
 }
    
    public void llenarTabla2(){    
        DefaultTableModel modelo =new DefaultTableModel();
        tabla.setModel(modelo);
        Conexion connect=new Conexion();
        com.mysql.jdbc.Connection conexion=(com.mysql.jdbc.Connection) connect.getconection();
        PreparedStatement ps=null,ps2=null;
        ResultSet rs=null;
        try {
            ps=(com.mysql.jdbc.PreparedStatement) conexion.prepareStatement(""
                    + "select a.id_vivienda,b.id_anfitrion,a.direccion,a.precio_general,c.promocion,c.id_habitacion,c.num_habitacion,c.disp_habitaciones,d.servicios_id,d.precio,(a.precio_general-d.precio)\n" +
                    "from anfitrion b\n" +
                    "left join vivienda a on a.anfitrion_id=b.id_anfitrion\n" +
                    "left join habitacion c on c.vivienda_id=a.id_vivienda\n" +
                    "left join promocion d on d.habitacion_id=c.id_habitacion\n" +
                    "where c.disp_habitaciones=?");
            ps.setInt(1,1);
            rs=ps.executeQuery();
            modelo.addColumn("id_vivienda");
            modelo.addColumn("id_anfitrion");
            modelo.addColumn("direccion");
            modelo.addColumn("precio_general");
            modelo.addColumn("promocion");
            modelo.addColumn("id_habitacion");
            modelo.addColumn("num_habitacion");
            modelo.addColumn("disp_habitaciones");
            modelo.addColumn("servicios_id");
            modelo.addColumn("descuento");
            modelo.addColumn("precio_final");
            while(rs.next()){
                Object fila[]=new Object[11];
                for(int i=0;i<11;i++){
                    fila[i]=rs.getObject(i+1);                    
                }
                modelo.addRow(fila);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        generarFactura = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        generarFactura.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        generarFactura.setText("Facturar");
        generarFactura.setBorder(null);
        generarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarFacturaActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_vivienda", "id_anfitrion", "direccion", "precio_general", "promocion", "id_habitacion", "num_habitacion", "disponibilidad", "servicio", "descuento", "precio_final"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla);

        jMenu1.setText("File");

        jMenuItem1.setText("Personal");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Salir");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(generarFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 1032, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(generarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarFacturaActionPerformed
 facturar();
llenarTabla2();
    }//GEN-LAST:event_generarFacturaActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
  int i = tabla.getSelectedRow();
  TableModel model = tabla.getModel();       
 id_habitacion=Integer.parseInt(model.getValueAt(i, 5).toString());    

    }//GEN-LAST:event_tablaMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        editHuesped e = new editHuesped();
        e.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        login a = new login();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton generarFactura;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
