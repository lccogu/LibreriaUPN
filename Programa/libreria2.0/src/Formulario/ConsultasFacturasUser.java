package Formulario;

import claseConectar.conectar;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.*;
import javax.swing.JOptionPane;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class ConsultasFacturasUser extends javax.swing.JInternalFrame {

    public ConsultasFacturasUser() {
        initComponents();
        cargartodasfacturas();
        this.setLocation(25, 15);
        jDateChooser1.setEnabled(false);

    }

    void cargartodasfacturas() {
        DefaultTableModel tabla = new DefaultTableModel();
        String[] titulos = {"NUMERO", "COD. CLIENTE", "RUC CLIENTE", "SUBTOTAL", "IGV", "TOTAL", "FECHA"};
        tabla.setColumnIdentifiers(titulos);
        this.tbfacturas.setModel(tabla);
        String consulta = "SELECT * FROM factura";
        String[] Datos = new String[7];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                Datos[0] = rs.getString("num_fac");
                Datos[1] = rs.getString("cod_cli");
                Datos[2] = rs.getString("ruc_cli");
                Datos[3] = rs.getString("subtotal");
                Datos[4] = rs.getString("igv");
                Datos[5] = rs.getString("total");
                Datos[6] = rs.getString("fec_fac");

                tabla.addRow(Datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnver = new javax.swing.JMenuItem();
        mneliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        rdbnnumero = new javax.swing.JRadioButton();
        rdbbnfecha = new javax.swing.JRadioButton();
        rdbntodos = new javax.swing.JRadioButton();
        txtnumero = new javax.swing.JTextField();
        btnbuscador = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbfacturas = new javax.swing.JTable();

        mnver.setText("Ver Detalle");
        mnver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnverActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnver);

        mneliminar.setText("Eliminar");
        mneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mneliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mneliminar);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("CONSULTA DE FACTURAS");

        buttonGroup1.add(rdbnnumero);
        rdbnnumero.setSelected(true);
        rdbnnumero.setText("Mostrar  por Nº:");
        rdbnnumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbnnumeroActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbbnfecha);
        rdbbnfecha.setText("Mostrar por Fecha");
        rdbbnfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbbnfechaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbntodos);
        rdbntodos.setText("Mostrar todas:");
        rdbntodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbntodosActionPerformed(evt);
            }
        });

        btnbuscador.setText("BUSCAR");
        btnbuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscadorActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ayuda.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdbnnumero)
                                .addGap(27, 27, 27)
                                .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdbbnfecha)
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addComponent(btnbuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rdbntodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rdbnnumero))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rdbbnfecha)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdbntodos))
                    .addComponent(btnbuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        tbfacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbfacturas.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tbfacturas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        setBounds(0, 0, 674, 308);
    }// </editor-fold>//GEN-END:initComponents

private void btnbuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscadorActionPerformed

    String num = txtnumero.getText();

    String consulta = "";
    if (rdbnnumero.isSelected() == true) {
        consulta = "SELECT * FROM factura WHERE num_fac='" + num + "'";
    }
    if (rdbbnfecha.isSelected() == true) {
        Date fecha = jDateChooser1.getDate();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
        String fec = "" + formatofecha.format(fecha);
        consulta = "SELECT * FROM factura WHERE fec_fac='" + fec + "'";
    }
    if (rdbntodos.isSelected() == true) {
        consulta = "SELECT * FROM factura ";
    }
    DefaultTableModel tabla = new DefaultTableModel();
    String[] titulos = {"NUMERO", "COD. CLIENTE", "RUC CLIENTE", "SUBTOTAL", "IGV", "TOTAL", "FECHA"};
    tabla.setColumnIdentifiers(titulos);
    this.tbfacturas.setModel(tabla);

    String[] Datos = new String[7];
    try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(consulta);
        while (rs.next()) {
            Datos[0] = rs.getString("num_fac");
            Datos[1] = rs.getString("cod_cli");
            Datos[2] = rs.getString("ruc_cli");
            Datos[3] = rs.getString("subtotal");
            Datos[4] = rs.getString("igv");
            Datos[5] = rs.getString("total");
            Datos[6] = rs.getString("fec_fac");

            tabla.addRow(Datos);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
    }


}//GEN-LAST:event_btnbuscadorActionPerformed

private void rdbnnumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbnnumeroActionPerformed
// TODO add your handling code here:
    if (rdbnnumero.isSelected() == true) {
        txtnumero.setEnabled(true);
        txtnumero.requestFocus();
        jDateChooser1.setDate(null);
        jDateChooser1.setEnabled(false);

    }
}//GEN-LAST:event_rdbnnumeroActionPerformed

private void rdbbnfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbbnfechaActionPerformed
// TODO add your handling code here:
    if (rdbbnfecha.isSelected() == true) {
        jDateChooser1.setEnabled(true);
        txtnumero.setEnabled(false);
        txtnumero.setText("");

    }
}//GEN-LAST:event_rdbbnfechaActionPerformed

private void rdbntodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbntodosActionPerformed
// TODO add your handling code here:
    if (rdbntodos.isSelected() == true) {
        jDateChooser1.setEnabled(false);
        jDateChooser1.setDate(null);
        txtnumero.setText("");
        txtnumero.setEnabled(false);
        cargartodasfacturas();
    }


}//GEN-LAST:event_rdbntodosActionPerformed

private void mnverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnverActionPerformed
// TODO add your handling code here:
    int filasele = tbfacturas.getSelectedRow();
    if (filasele == -1) {
        JOptionPane.showMessageDialog(null, "No Seleciono ninguna fila");
    } else {
        DetalleFacturaUser detalle = new DetalleFacturaUser();
        PrincipalUser.jdpescritorio.add(detalle);
        detalle.toFront();
        detalle.setVisible(true);
        String numfac = tbfacturas.getValueAt(filasele, 0).toString();
        String cod = tbfacturas.getValueAt(filasele, 1).toString();
        String ruc = tbfacturas.getValueAt(filasele, 2).toString();
        String subtotal = tbfacturas.getValueAt(filasele, 3).toString();
        String igv = tbfacturas.getValueAt(filasele, 4).toString();
        String total = tbfacturas.getValueAt(filasele, 5).toString();
        String fecha = tbfacturas.getValueAt(filasele, 6).toString();
        DetalleFacturaUser.txtfac.setText(numfac);
        DetalleFacturaUser.txtcod.setText(cod);
        DetalleFacturaUser.txtruc.setText(ruc);
        DetalleFacturaUser.txtsub.setText(subtotal);
        DetalleFacturaUser.txtigv.setText(igv);
        DetalleFacturaUser.txttot.setText(total);
        DetalleFacturaUser.txtfecha.setText(fecha);
        DefaultTableModel model = (DefaultTableModel) DetalleFacturaUser.tbdetalle.getModel();
        String ver = "SELECT * FROM detallefactura WHERE num_fac='" + numfac + "'";
        String[] datos = new String[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(ver);
            while (rs.next()) {
                datos[0] = rs.getString("cod_pro");
                datos[1] = rs.getString("des_pro");
                datos[2] = rs.getString("cant_pro");
                datos[3] = rs.getString("pre_unit");
                datos[4] = rs.getString("pre_tot");
                model.addRow(datos);

            }
            DetalleFacturaUser.tbdetalle.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasFacturasUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}//GEN-LAST:event_mnverActionPerformed

private void mneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mneliminarActionPerformed
// TODO add your handling code here:

JOptionPane.showMessageDialog(this, "Entrar como administrador", "Error!", JOptionPane.ERROR_MESSAGE);

//    int fila = tbfacturas.getSelectedRow();
//    if (fila >= 0) {
//        String cod = tbfacturas.getValueAt(fila, 0).toString();
//        try {
//            PreparedStatement pst = cn.prepareStatement("DELETE FROM factura WHERE num_fac='" + cod + "'");
//            pst.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(ConsultasBoletas.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        cargartodasfacturas();
//
//    } else {
//        JOptionPane.showMessageDialog(this, "Seleccione alguna fila");
//    }
}//GEN-LAST:event_mneliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null,
                "Para realizar una consulta de las facturas puede"
                + "\n" + "escoger tres opciones :"
                + "\n" + ""
                + "\n" + "1.- Buscar por el codigo de la factura"
                + "\n" + "2.- Buscar por la fecha con el calendario"
                + "\n" + "3.- Mostrar todas las facturas ");

    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscador;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mneliminar;
    private javax.swing.JMenuItem mnver;
    private javax.swing.JRadioButton rdbbnfecha;
    private javax.swing.JRadioButton rdbnnumero;
    private javax.swing.JRadioButton rdbntodos;
    public static javax.swing.JTable tbfacturas;
    private javax.swing.JTextField txtnumero;
    // End of variables declaration//GEN-END:variables
conectar cc = new conectar();
    Connection cn = cc.conexion();

}
