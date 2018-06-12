package claseConectar;

import java.sql.*;
import javax.swing.*;

public class conectar {

    Connection conect = null;

    public Connection conexion() {
        try {

            Class.forName("com.mysql.jdbc.Driver");
//            conect = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net/sql10239555", "sql10239555", "Bsdev1UmMs");
            conect = DriverManager.getConnection("jdbc:mysql://localhost/libro","root","root");
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,"Error "+e);
            JOptionPane.showMessageDialog(null, "CONEXION CON LA BASE DE DATOS FALLO !!"
                    + "\n" + "CAUSAS:"
                    + "\n" + "1.- Puerto de conexion incorrecto"
                    + "\n" + "2.- Nombre de base de datos incorrecta"
                    + "\n" + "3.- Usuario de base de datos incorrecto"
                    + "\n" + "4.- Password de base de datos incorreco", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        return conect;

    }
}
