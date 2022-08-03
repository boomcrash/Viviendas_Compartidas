/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author alexm
 */
public class Conexion {
    Connection conexion=null;
    public static final String URL="jdbc:mysql://38.17.53.118:13096/viviendas?autoReconnet=true&useSSL=false";
    public static final String USUARIO="admin";
    public static final String CONTRASEÑA="dzFoOkre";
    
    public Conexion() {
       
    }
        
    public Connection getconection()
{
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            conexion=(Connection) DriverManager.getConnection(URL,USUARIO,CONTRASEÑA);
            System.out.println("conectado");
        } catch (ClassNotFoundException ex) {
            System.err.println("ERROR, "+ex);
            }       
        catch (SQLException ex) 
        {
            System.err.println("ERROR, "+ex);
        }
        return conexion;
}
}
