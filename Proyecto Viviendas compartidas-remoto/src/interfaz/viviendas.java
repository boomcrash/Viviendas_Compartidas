
package interfaz;

import conectar.Conexion;
import control.TextPrompt;
import static interfaz.login.id_persona;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class viviendas extends javax.swing.JFrame {
    TextPrompt prueba;

    int id_vivienda;
    int num,num2;
    public viviendas() {
        initComponents();
        this.setLocationRelativeTo(this); 
        prueba = new TextPrompt("Dirección",jtUbicacion);
        prueba = new TextPrompt("Precio",jtPrecio);               
        prueba = new TextPrompt("Precio",jTPrecioPromocion);
        prueba = new TextPrompt("Descripción",jTDescripcion);
        prueba = new TextPrompt("Nº",jTNumeroHabitacion);
        jPanel2.setVisible(false);
        jComboBox1.setVisible(false);
        jTPrecioPromocion.setVisible(false);
        jTDescripcion.setVisible(false);
        jButton1.setEnabled(false);
        System.out.println(id_persona);
        llenarTabla();
    }

    
    public void llenarTabla(){    
        DefaultTableModel modelo =new DefaultTableModel();
        tabla.setModel(modelo);
        Conexion connect=new Conexion();
        com.mysql.jdbc.Connection conexion=(com.mysql.jdbc.Connection) connect.getconection();
        PreparedStatement ps=null,ps2=null;
        ResultSet rs=null;
        try {
            ps=(com.mysql.jdbc.PreparedStatement) conexion.prepareStatement("select id_vivienda,direccion,precio_general from vivienda where anfitrion_id=?");
            ps.setInt(1,id_persona);
            rs=ps.executeQuery();
            modelo.addColumn("id_vivienda");
            modelo.addColumn("direcccion");
            modelo.addColumn("precio_general");
            while(rs.next()){
                Object fila[]=new Object[3];
                for(int i=0;i<3;i++){
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
    
    
    
    public void llenarTabla2(){    
        DefaultTableModel modelo =new DefaultTableModel();
        tabla1.setModel(modelo);
        Conexion connect=new Conexion();
        com.mysql.jdbc.Connection conexion=(com.mysql.jdbc.Connection) connect.getconection();
        PreparedStatement ps=null,ps2=null;
        ResultSet rs=null;
        try {
            ps=(com.mysql.jdbc.PreparedStatement) conexion.prepareStatement("select num_habitacion,vivienda_id,disp_habitaciones,promocion,id_habitacion from habitacion where vivienda_id=?");
            ps.setInt(1,id_vivienda);
            rs=ps.executeQuery();
            modelo.addColumn("num_habitacion");
            modelo.addColumn("vivienda_id");
            modelo.addColumn("disp_habitaciones");
            modelo.addColumn("promocion");
            modelo.addColumn("id_habitacion");
            while(rs.next()){
                Object fila[]=new Object[5];
                for(int i=0;i<5;i++){
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
    public void limpiar(){
        jtUbicacion.setText("");
        jtPrecio.setText("");
        buttonGroup1.clearSelection();
    }
    
    public String validar(){
        String x = "si";
        if(jtUbicacion.getText().isEmpty()){
            jtUbicacion.setBackground(Color.red);
            x = "primera";
        }
        if(jtPrecio.getText().isEmpty()){            
            jtPrecio.setBackground(Color.red);       
            x = "segunda";
        }
        return x;
    }
    
    public void promocion(){
        if(promocion.isSelected()){
            jComboBox1.setVisible(true);
            jTPrecioPromocion.setVisible(true);
            jTDescripcion.setVisible(true);              
        }else{
            jComboBox1.setVisible(false);
            jTPrecioPromocion.setVisible(false);
            jTDescripcion.setVisible(false);            
        }   
    }
  
    public void validar2(){
        if(jTNumeroHabitacion.getText().isEmpty()){
            jTNumeroHabitacion.setBackground(Color.red);
        }
    }    
   
    public void validar3(){
        if(!jTNumeroHabitacion.getText().isEmpty()){
            if(!buttonGroup1.isSelected(null)){
                        jButton1.setEnabled(true);
                    }else{
                jButton1.setEnabled(false);}
        }else{
            jButton1.setEnabled(false);}
    }    
    
    public void validar4(){
        if(!jTPrecioPromocion.getText().isEmpty()){
            if(!jTDescripcion.getText().isEmpty()){
                jButton1.setEnabled(true);
            }
        }        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jCheckBox1 = new javax.swing.JCheckBox();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jtUbicacion = new javax.swing.JTextField();
        jtPrecio = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jbRegistrarse = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jcSI = new javax.swing.JCheckBox();
        jcNO = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        promocion = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTPrecioPromocion = new javax.swing.JTextField();
        jTDescripcion = new javax.swing.JTextField();
        jTNumeroHabitacion = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADMINISTRACIÓN DE ANFITRIONES");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtUbicacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtUbicacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtUbicacionKeyReleased(evt);
            }
        });

        jtPrecio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtPrecioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtPrecioKeyTyped(evt);
            }
        });

        tabla.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "mapasingue", null},
                {null, "florida", null},
                {null, "peca", null},
                {null, "pascuales", null}
            },
            new String [] {
                "id_vivienda", "ubicacion", "precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        jScrollPane3.setViewportView(tabla);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ADMINISTRACIÓN DE VIVIENDAS");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbRegistrarse.setText("REGISTRAR");
        jbRegistrarse.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistrarseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtPrecio)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                            .addComponent(jtUbicacion)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jbRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jbRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ADMINISTRACIÓN DE HABITACIONES");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel3.setMaximumSize(new java.awt.Dimension(184, 18));
        jLabel3.setMinimumSize(new java.awt.Dimension(184, 18));

        jLabel8.setText(" Habitación Nº");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel8.setPreferredSize(new java.awt.Dimension(72, 26));

        buttonGroup1.add(jcSI);
        jcSI.setText("SI");
        jcSI.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jcSI.setMaximumSize(new java.awt.Dimension(31, 26));
        jcSI.setMinimumSize(new java.awt.Dimension(31, 26));
        jcSI.setPreferredSize(new java.awt.Dimension(31, 26));
        jcSI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcSIMouseClicked(evt);
            }
        });
        jcSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcSIActionPerformed(evt);
            }
        });
        jcSI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcSIKeyReleased(evt);
            }
        });

        buttonGroup1.add(jcNO);
        jcNO.setText("NO");
        jcNO.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jcNO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcNOMouseClicked(evt);
            }
        });
        jcNO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcNOKeyReleased(evt);
            }
        });

        jLabel9.setText(" Disponibilidad");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel9.setPreferredSize(new java.awt.Dimension(71, 26));

        jButton1.setText("AÑADIR");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tabla1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(2), null, null, null, null},
                { new Integer(3), null, null, null, null},
                { new Integer(10), null, null, null, null},
                { new Integer(5), null, null, null, null},
                { new Integer(35), null, null, null, null},
                { new Integer(2), null, null, null, null},
                { new Integer(88), null, null, null, null}
            },
            new String [] {
                "# habitacion", "vivienda_id", "disponibilidad", "promocion", "id_habitacion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabla1);

        promocion.setText("Promoción");
        promocion.setMaximumSize(new java.awt.Dimension(75, 28));
        promocion.setMinimumSize(new java.awt.Dimension(75, 28));
        promocion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                promocionItemStateChanged(evt);
            }
        });
        promocion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                promocionActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "luz", "agua", "comida" }));

        jTPrecioPromocion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTPrecioPromocionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTPrecioPromocionKeyTyped(evt);
            }
        });

        jTDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTDescripcionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTDescripcionKeyTyped(evt);
            }
        });

        jTNumeroHabitacion.setDragEnabled(true);
        jTNumeroHabitacion.setMinimumSize(new java.awt.Dimension(6, 27));
        jTNumeroHabitacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTNumeroHabitacionFocusLost(evt);
            }
        });
        jTNumeroHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNumeroHabitacionActionPerformed(evt);
            }
        });
        jTNumeroHabitacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNumeroHabitacionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTNumeroHabitacionKeyTyped(evt);
            }
        });

        jButton2.setText("ELIMINAR");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(promocion, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTDescripcion)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTNumeroHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jcSI, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jcNO))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTPrecioPromocion))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcSI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcNO)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTNumeroHabitacion, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTPrecioPromocion)
                    .addComponent(jComboBox1)
                    .addComponent(promocion, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jTDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jMenu1.setText("Opciones");

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
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void jbRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistrarseActionPerformed
        if(validar().equals("si")){
            System.out.println("código");
        }
        
         if(!jtUbicacion.getText().isEmpty()&&!jtPrecio.getText().isEmpty()){
            Conexion conect= new Conexion();
            Connection conexion=(Connection) conect.getconection();             
            PreparedStatement ps=null,ps2=null;
            ResultSet rs=null;
            try {
                System.out.println("BBBB");                 
                ps2=(PreparedStatement) conexion.prepareStatement("insert into vivienda (direccion,precio_general,anfitrion_id) values(?,?,?)");
                System.out.println("BBBB");  
                ps2.setString(1,jtUbicacion.getText());
                ps2.setDouble(2, Double.parseDouble(jtPrecio.getText()));
                ps2.setInt(3,id_persona);
                ps2.executeUpdate();
                JOptionPane.showMessageDialog(null, " REGISTRO EXITOSO!");
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
         llenarTabla();
    }//GEN-LAST:event_jbRegistrarseActionPerformed

    private void jtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPrecioKeyTyped
        Character ch = evt.getKeyChar();
        if (!Character.isDigit(ch) && ch != KeyEvent.VK_BACK_SPACE && ch != KeyEvent.VK_DELETE) {
            JOptionPane.showMessageDialog(this, "SOLO DIGITE NUMEROS", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            evt.consume();
        }
    }//GEN-LAST:event_jtPrecioKeyTyped

    private void tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla1MouseClicked
         int i = tabla1.getSelectedRow();
         TableModel model = tabla1.getModel();
         num = Integer.parseInt(model.getValueAt(i, 0).toString());
         num2 = Integer.parseInt(model.getValueAt(i, 4).toString());   
         
            Conexion conect= new Conexion();
            Connection conexion=(Connection) conect.getconection();             
            PreparedStatement ps=null,ps2=null;
            ResultSet rs=null;
            try {
                System.out.println("BBBB");                 
                ps2=(PreparedStatement) conexion.prepareStatement("select * from habitacion where id_habitacion=?");
                System.out.println("BBBB");  
                ps2.setInt(1,num2);
                rs=ps2.executeQuery();
                if(rs.next()){
                    if(rs.getInt("promocion")==0){
                         promocion.setSelected(false);
                        jTNumeroHabitacion.setText(String.valueOf(rs.getInt("num_habitacion")));
                        int valor=rs.getInt("disp_habitaciones");

                        if(valor==1){
                            jcSI.setSelected(true);
                        }else if(valor==0){
                            jcNO.setSelected(false);
                        }

                    }else if(rs.getInt("promocion")==1){
                         promocion.setSelected(true);
                         jTNumeroHabitacion.setText(String.valueOf(rs.getInt("num_habitacion")));
                        int valor=rs.getInt("disp_habitaciones");

                        if(valor==1){
                            jcSI.setSelected(true);
                        }else if(valor==0){
                            jcNO.setSelected(false);
                        }

                         ps2=(PreparedStatement) conexion.prepareStatement("select * from promocion where habitacion_id=?");
                         System.out.println("BBBB");  
                         ps2.setInt(1,num2);
                         rs=ps2.executeQuery();
                         if(rs.next()){
                             int servicio=rs.getInt("servicios_id");
                             double servicios=rs.getDouble("precio");
                             String descripcion=rs.getString("descripcion");
                             if(servicios==1){
                                 jComboBox1.setSelectedIndex(0);
                             }else if (servicios==2){
                                 jComboBox1.setSelectedIndex(1);
                             }else if (servicios==3){
                                 jComboBox1.setSelectedIndex(2);
                             } 
                             jTPrecioPromocion.setText(String.valueOf(servicios));
                             jTDescripcion.setText(String.valueOf(descripcion));
                         }
                         System.out.println("PROMOCION");
                    }
                    
                     
                }
               
                // TODO add your handling code here:
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR DE CONSULTA ");
            }finally {try{ps2.close();} catch (Exception e){}
            {try{ps.close();} catch (Exception e){}
            try{conexion.close();} catch (Exception e){}
            }
            }
            /*panel.removeAll();
            panel.repaint();
            limpiar();*/
        
    }//GEN-LAST:event_tabla1MouseClicked

    private void jtUbicacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtUbicacionKeyReleased
        jtUbicacion.setBackground(Color.white);
    }//GEN-LAST:event_jtUbicacionKeyReleased

    private void jtPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPrecioKeyReleased
        jtPrecio.setBackground(Color.white);
    }//GEN-LAST:event_jtPrecioKeyReleased

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        jPanel2.setVisible(true);
        int i = tabla.getSelectedRow();
         TableModel model = tabla.getModel();
         id_vivienda = Integer.parseInt(model.getValueAt(i, 0).toString());
        llenarTabla2();
    }//GEN-LAST:event_tablaMouseClicked

    private void promocionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_promocionItemStateChanged
        promocion();  
    }//GEN-LAST:event_promocionItemStateChanged

    private void jTPrecioPromocionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPrecioPromocionKeyTyped
        Character ch = evt.getKeyChar();
        if (!Character.isDigit(ch) && ch != KeyEvent.VK_BACK_SPACE && ch != KeyEvent.VK_DELETE) {
            JOptionPane.showMessageDialog(this, "SOLO DIGITE NUMEROS", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            evt.consume();
        }
    }//GEN-LAST:event_jTPrecioPromocionKeyTyped

    private void jTDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTDescripcionKeyTyped
        char ch = evt.getKeyChar();
        if(!Character.isLetter(ch)
                && ch != KeyEvent.VK_BACK_SPACE
                && ch != KeyEvent.VK_SPACE
                && ch != KeyEvent.VK_DELETE) {
            JOptionPane.showMessageDialog(this, "NO DIGITE LETRAS", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            evt.consume();
        }
    }//GEN-LAST:event_jTDescripcionKeyTyped

    private void jTNumeroHabitacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNumeroHabitacionKeyTyped
        Character ch = evt.getKeyChar();
        if (!Character.isDigit(ch) && ch != KeyEvent.VK_BACK_SPACE && ch != KeyEvent.VK_DELETE) {
            JOptionPane.showMessageDialog(this, "SOLO DIGITE NUMEROS", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            evt.consume();
        }
    }//GEN-LAST:event_jTNumeroHabitacionKeyTyped

    private void jTNumeroHabitacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTNumeroHabitacionFocusLost
        TableModel model = tabla1.getModel();
        for (int i = 0; i < tabla1.getRowCount(); i++) {
            if(jTNumeroHabitacion.getText().trim().compareTo(model.getValueAt(i, 0).toString())==0){
                JOptionPane.showMessageDialog(this, "HABITACIÓN YA EXISTE", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
                jTNumeroHabitacion.setText("");
                jTNumeroHabitacion.setBackground(Color.red);
                jButton1.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jTNumeroHabitacionFocusLost

    private void jTNumeroHabitacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNumeroHabitacionKeyReleased
        validar2();
        validar3();
        jTNumeroHabitacion.setBackground(Color.white);
    }//GEN-LAST:event_jTNumeroHabitacionKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TableModel model = tabla1.getModel();
        String marcador = "";
        for (int i = 0; i < tabla1.getRowCount(); i++) {
            if(jTNumeroHabitacion.getText().trim().compareTo(model.getValueAt(i, 0).toString())==0){
                jTNumeroHabitacion.setText("");
                jTNumeroHabitacion.setBackground(Color.red);
                jButton1.setEnabled(false);                
                marcador = "hola";
                break;
            }
        }
        if(marcador.equals("")){
            if(!promocion.isSelected()){
                
            
             if(!jTNumeroHabitacion.getText().isEmpty()&&(jcSI.isSelected()||jcNO.isSelected())){
            Conexion conect= new Conexion();
            Connection conexion=(Connection) conect.getconection();             
            PreparedStatement ps=null,ps2=null;
            ResultSet rs=null;
            int id = 0,id_servicio = 0;
            try {
                if(promocion.isSelected()){
                    System.out.println("BBBB");
                    System.out.println(id_vivienda);
                    ps2=(PreparedStatement) conexion.prepareStatement("insert into habitacion (num_habitacion,vivienda_id,disp_habitaciones,promocion) values(?,?,?,?)");
                    System.out.println("AAA");  
                    ps2.setString(1,jTNumeroHabitacion.getText());
                    ps2.setInt(2, id_vivienda);
                     if(jcSI.isSelected()){
                          ps2.setInt(3,1);
                    }else if(jcNO.isSelected()){
                        ps2.setInt(3,0);
                    }
                    ps2.setInt(4,1);
                    ps2.executeUpdate();
                     System.out.println("CCC");  
                    ps2= (PreparedStatement) conexion.prepareStatement("select id_habitacion from habitacion where num_habitacion=? and vivienda_id=?");
                    ps2.setInt(1,Integer.parseInt(jTNumeroHabitacion.getText()));
                    ps2.setInt(2,id_vivienda);
                    rs=ps2.executeQuery();
                    if(rs.next())
                    {
                        id=rs.getInt("id_habitacion");
                    }
                     System.out.println("DDDD");  
                     ps2= (PreparedStatement) conexion.prepareStatement("select id_servicio from servicio where nombre=?");
                    ps2.setString(1,jComboBox1.getSelectedItem().toString());
                    rs=ps2.executeQuery();
                    if(rs.next())
                    {
                        id_servicio=rs.getInt("id_servicio");
                    }
                    
                     ps2=(PreparedStatement) conexion.prepareStatement("insert into promocion (habitacion_id,servicios_id,precio,descripcion) values(?,?,?,?)");
                    System.out.println("BBBB");  
                    ps2.setInt(1,id);
                    ps2.setInt(2, id_servicio);
                    ps2.setDouble(3, Double.parseDouble(jTPrecioPromocion.getText())); 
                    ps2.setString(4,jTDescripcion.getText());
                    ps2.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null, " REGISTRO EXITOSO!");
                }else if(!promocion.isSelected()){
                    ps2=(PreparedStatement) conexion.prepareStatement("insert into habitacion (num_habitacion,vivienda_id,disp_habitaciones,promocion) values(?,?,?,?)");
                    System.out.println("BBBB");  
                    ps2.setInt(1,Integer.parseInt(jTNumeroHabitacion.getText()));
                    ps2.setInt(2, id_vivienda);
                    if(jcSI.isSelected()){
                          ps2.setInt(3,1);
                    }else if(jcNO.isSelected()){
                        ps2.setInt(3,0);
                    }
                  
                    ps2.setInt(4,0);
                    ps2.executeUpdate();
                    JOptionPane.showMessageDialog(null, " REGISTRO EXITOSO!");
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
         
            System.out.println("hola");
        }else  if(promocion.isSelected()){
                
            
             if(!jTNumeroHabitacion.getText().isEmpty()&&(jcSI.isSelected()||jcNO.isSelected())&&!jComboBox1.getSelectedItem().toString().isEmpty()&&!jTPrecioPromocion.getText().isEmpty()&&!jTDescripcion.getText().isEmpty()){
            Conexion conect= new Conexion();
            Connection conexion=(Connection) conect.getconection();             
            PreparedStatement ps=null,ps2=null;
            ResultSet rs=null;
            int id = 0,id_servicio = 0;
            try {
                if(promocion.isSelected()){
                    System.out.println("BBBB");
                    System.out.println(id_vivienda);
                    ps2=(PreparedStatement) conexion.prepareStatement("insert into habitacion (num_habitacion,vivienda_id,disp_habitaciones,promocion) values(?,?,?,?)");
                    System.out.println("AAA");  
                    ps2.setString(1,jTNumeroHabitacion.getText());
                    ps2.setInt(2, id_vivienda);
                     if(jcSI.isSelected()){
                          ps2.setInt(3,1);
                    }else if(jcNO.isSelected()){
                        ps2.setInt(3,0);
                    }
                    ps2.setInt(4,1);
                    ps2.executeUpdate();
                     System.out.println("CCC");  
                    ps2= (PreparedStatement) conexion.prepareStatement("select id_habitacion from habitacion where num_habitacion=? and vivienda_id=?");
                    ps2.setInt(1,Integer.parseInt(jTNumeroHabitacion.getText()));
                    ps2.setInt(2,id_vivienda);
                    rs=ps2.executeQuery();
                    if(rs.next())
                    {
                        id=rs.getInt("id_habitacion");
                    }
                     System.out.println("DDDD");  
                     ps2= (PreparedStatement) conexion.prepareStatement("select id_servicio from servicio where nombre=?");
                    ps2.setString(1,jComboBox1.getSelectedItem().toString());
                    rs=ps2.executeQuery();
                    if(rs.next())
                    {
                        id_servicio=rs.getInt("id_servicio");
                    }
                    
                     ps2=(PreparedStatement) conexion.prepareStatement("insert into promocion (habitacion_id,servicios_id,precio,descripcion) values(?,?,?,?)");
                    System.out.println("BBBB");  
                    ps2.setInt(1,id);
                    ps2.setInt(2, id_servicio);
                    ps2.setDouble(3, Double.parseDouble(jTPrecioPromocion.getText())); 
                    ps2.setString(4,jTDescripcion.getText());
                    ps2.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null, " REGISTRO EXITOSO!");
                }else if(!promocion.isSelected()){
                    ps2=(PreparedStatement) conexion.prepareStatement("insert into habitacion (num_habitacion,vivienda_id,disp_habitaciones,promocion) values(?,?,?,?)");
                    System.out.println("BBBB");  
                    ps2.setInt(1,Integer.parseInt(jTNumeroHabitacion.getText()));
                    ps2.setInt(2, id_vivienda);
                    if(jcSI.isSelected()){
                          ps2.setInt(3,1);
                    }else if(jcNO.isSelected()){
                        ps2.setInt(3,0);
                    }
                  
                    ps2.setInt(4,0);
                    ps2.executeUpdate();
                    JOptionPane.showMessageDialog(null, " REGISTRO EXITOSO!");
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
         
            System.out.println("hola");
        }
    
        llenarTabla2();
        
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jcSIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcSIKeyReleased
         jTNumeroHabitacion.setBackground(Color.white);
    }//GEN-LAST:event_jcSIKeyReleased

    private void jcNOKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcNOKeyReleased
        jTNumeroHabitacion.setBackground(Color.white);
    }//GEN-LAST:event_jcNOKeyReleased

    private void promocionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_promocionActionPerformed
        jButton1.setEnabled(false);
    }//GEN-LAST:event_promocionActionPerformed

    private void jTPrecioPromocionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPrecioPromocionKeyReleased
        validar4();
    }//GEN-LAST:event_jTPrecioPromocionKeyReleased

    private void jTDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTDescripcionKeyReleased
        validar4();
    }//GEN-LAST:event_jTDescripcionKeyReleased

    private void jTNumeroHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNumeroHabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNumeroHabitacionActionPerformed

    private void jcSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcSIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcSIActionPerformed

    private void jcSIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcSIMouseClicked
        validar2();
        validar3();        // TODO add your handling code here:
    }//GEN-LAST:event_jcSIMouseClicked

    private void jcNOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcNOMouseClicked
        validar2();
        validar3();        // TODO add your handling code here:
    }//GEN-LAST:event_jcNOMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(promocion.isSelected()){
           if(!jTNumeroHabitacion.getText().isEmpty()&&(jcSI.isSelected()||jcNO.isSelected())&&!jComboBox1.getSelectedItem().toString().isEmpty()&&!jTPrecioPromocion.getText().isEmpty()&&!jTDescripcion.getText().isEmpty()){
            Conexion conect= new Conexion();
            Connection conexion=(Connection) conect.getconection();
            String id=null;
            com.mysql.jdbc.PreparedStatement ps=null,ps2=null,ps3=null;
            ResultSet rs=null;
            try {
                ps2=(com.mysql.jdbc.PreparedStatement) conexion.prepareStatement("delete from promocion where habitacion_id=?");
                ps2.setInt(1,num2);
                ps2.execute();
                
                 ps2=(com.mysql.jdbc.PreparedStatement) conexion.prepareStatement("delete from habitacion where id_habitacion=?");
                ps2.setInt(1,num2);
                ps2.execute();
                JOptionPane.showMessageDialog(null, "LOCAL ELIMINADO CORRECTAMENTE");                
                // TODO add your handling code here:
            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR DE ELIMINAR !\nMALA CONEXION");
            }finally {  try{ps.close();} catch (Exception e){}
            try{ps2.close();} catch (Exception e){}
            try{ps3.close();} catch (Exception e){}
            try{rs.close();} catch (Exception e){}
            {
                try{conexion.close();} catch (Exception e){}                    
            }
            }
        }else {JOptionPane.showMessageDialog(null, "ERROR DE ELIMINAR !\nREVISE QUE LOS CAMPOS ESTEN LLENADOS CORRECTAMENTE.");} 
        }else if(!promocion.isSelected()){
             if(!jTNumeroHabitacion.getText().isEmpty()&&(jcSI.isSelected()||jcNO.isSelected())){
            Conexion conect= new Conexion();
            Connection conexion=(Connection) conect.getconection();
            String id=null;
            com.mysql.jdbc.PreparedStatement ps=null,ps2=null,ps3=null;
            ResultSet rs=null;
            try {
                ps2=(com.mysql.jdbc.PreparedStatement) conexion.prepareStatement("delete from habitacion where id_habitacion=?");
                ps2.setInt(1,num2);
                ps2.execute();
                JOptionPane.showMessageDialog(null, " ELIMINADO CORRECTAMENTE");                
                // TODO add your handling code here:
            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR DE ELIMINAR !\nMALA CONEXION");
            }finally {  try{ps.close();} catch (Exception e){}
            try{ps2.close();} catch (Exception e){}
            try{ps3.close();} catch (Exception e){}
            try{rs.close();} catch (Exception e){}
            {
                try{conexion.close();} catch (Exception e){}                    
            }
            }
        }else {JOptionPane.showMessageDialog(null, "ERROR DE ELIMINAR !\nREVISE QUE LOS CAMPOS ESTEN LLENADOS CORRECTAMENTE.");} 
        }
        llenarTabla2();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        login l=new login();
        l.setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        editAnfitrion a = new editAnfitrion();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTDescripcion;
    private javax.swing.JTextField jTNumeroHabitacion;
    private javax.swing.JTextField jTPrecioPromocion;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbRegistrarse;
    private javax.swing.JCheckBox jcNO;
    private javax.swing.JCheckBox jcSI;
    private javax.swing.JTextField jtPrecio;
    private javax.swing.JTextField jtUbicacion;
    private javax.swing.JRadioButton promocion;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tabla1;
    // End of variables declaration//GEN-END:variables
}