package Formulario;

import claseConectar.conectar;

import java.awt.Color;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Boleta extends javax.swing.JInternalFrame {

    public Boleta() {
        initComponents();
        this.setLocation(15, 15);
        txtfecha.setDisabledTextColor(Color.blue);
        txtfecha.setText(fechaact());

        txtcod.setDisabledTextColor(Color.blue);
        txtdire.setDisabledTextColor(Color.blue);
        txtdni.setDisabledTextColor(Color.blue);
        txtnomape.setDisabledTextColor(Color.blue);

        numeros();
    }

    void descontarstock(String codi, String can) {
        int des = Integer.parseInt(can);
        String cap = "";
        int desfinal;
        String consul = "SELECT * FROM producto WHERE  cod_pro='" + codi + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consul);
            while (rs.next()) {
                cap = rs.getString(4);
            }

        } catch (Exception e) {
        }
        desfinal = Integer.parseInt(cap) - des;
        String modi = "UPDATE producto SET Stock='" + desfinal + "' WHERE cod_pro = '" + codi + "'";
        try {
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
        } catch (Exception e) {
        }

    }

    void numeros() {

        String c = "";
        String SQL = "select max(num_bol) from boleta";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString(1);
            }
            if (c == null) {
                txtnumbol.setText("00000001");
            } else {
                int j = Integer.parseInt(c);
                GenerarNumero gen = new GenerarNumero();
                gen.generar(j);
                txtnumbol.setText(gen.serie());
            }

        } catch (SQLException ex) {
            Logger.getLogger(Boleta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void calcular() {
        String pre;
        String can;
        double igv = 0;
        double total = 0;
        double subtotal = 0;
        double precio;
        int cantidad;
        double imp = 0.0;

        for (int i = 0; i < tbdetbol.getRowCount(); i++) {
            pre = tbdetbol.getValueAt(i, 2).toString();
            can = tbdetbol.getValueAt(i, 3).toString();
            precio = Double.parseDouble(pre);
            cantidad = Integer.parseInt(can);
            imp = precio * cantidad;
            subtotal = subtotal + imp;

            tbdetbol.setValueAt(Math.rint(imp * 100) / 100, i, 4);

        }

        txttotal.setText("" + Math.rint(subtotal * 100) / 100);

    }

    void boleta() {
        String InsertarSQL = "INSERT INTO boleta(num_bol,cod_cli,pre_tot,fecha) VALUES (?,?,?,?)";
        String numbol = txtnumbol.getText();
        String codcli = txtcod.getText();

        String total = txttotal.getText();
        String fecha = txtfecha.getText();
        try {
            PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            pst.setString(1, numbol);
            pst.setString(2, codcli);
            pst.setString(3, total);
            pst.setString(4, fecha);

            int n = pst.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Los datos se guardaron correctamente");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void detalleboleta() {
        for (int i = 0; i < tbdetbol.getRowCount(); i++) {
            String InsertarSQL = "INSERT INTO detalleboleta(num_bol,cod_pro,des_pro,cant_pro,pre_unit,pre_venta) VALUES (?,?,?,?,?,?)";
            String numbol = txtnumbol.getText();
            String codpro = tbdetbol.getValueAt(i, 0).toString();
            String despro = tbdetbol.getValueAt(i, 1).toString();
            String cantpro = tbdetbol.getValueAt(i, 3).toString();
            String preunit = tbdetbol.getValueAt(i, 2).toString();
            String importe = tbdetbol.getValueAt(i, 4).toString();

            try {
                PreparedStatement pst = cn.prepareStatement(InsertarSQL);
                pst.setString(1, numbol);
                pst.setString(2, codpro);
                pst.setString(3, despro);
                pst.setString(4, cantpro);
                pst.setString(5, preunit);
                pst.setString(6, importe);

                pst.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static String fechaact() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatofecha.format(fecha);

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbdetbol = new javax.swing.JTable();
        btncalcular = new javax.swing.JButton();
        btnven = new javax.swing.JButton();
        txttotal = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtnumbol = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtnomape = new javax.swing.JTextField();
        btnclientes = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtdni = new javax.swing.JTextField();
        txtcod = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtdire = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnproductos = new javax.swing.JButton();

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
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("BOLETA");

        tbdetbol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCION", "PRECIO UNITARIO", "CANTIDAD", "PRECIO VENTA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbdetbol);

        btncalcular.setText("REALIZAR CALCULO");
        btncalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalcularActionPerformed(evt);
            }
        });

        btnven.setText("REALIZAR VENTA");
        btnven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvenActionPerformed(evt);
            }
        });

        jLabel20.setText("Total:");

        txtnumbol.setEnabled(false);
        txtnumbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumbolActionPerformed(evt);
            }
        });

        jLabel8.setText("Nº de boleta");

        txtnomape.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtnomape.setEnabled(false);

        btnclientes.setText("Buscar");
        btnclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclientesActionPerformed(evt);
            }
        });

        jLabel9.setText("Señor(es):");

        txtfecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtfecha.setEnabled(false);
        txtfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaActionPerformed(evt);
            }
        });

        jLabel12.setText("Fecha:");

        jLabel10.setText("DNI:");

        txtdni.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtdni.setEnabled(false);
        txtdni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdniActionPerformed(evt);
            }
        });

        txtcod.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtcod.setEnabled(false);

        jLabel11.setText("Cod.Cliente");

        jLabel13.setText("Direccion:");

        txtdire.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtdire.setEnabled(false);
        txtdire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdireActionPerformed(evt);
            }
        });

        jLabel14.setText("Productos:");

        btnproductos.setText("BUSCAR");
        btnproductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproductosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btncalcular, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnven, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(txtdire, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(btnproductos)
                                .addGap(99, 99, 99))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)))
                        .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtnumbol, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtnomape, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnclientes, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnumbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnomape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnclientes)
                    .addComponent(jLabel9))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtfecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(btnproductos)
                            .addComponent(jLabel13)
                            .addComponent(txtdire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btncalcular)
                        .addGap(18, 18, 18)
                        .addComponent(btnven, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void txtfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechaActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtfechaActionPerformed

private void txtdireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtdireActionPerformed

private void txtdniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdniActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtdniActionPerformed

private void btncalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcularActionPerformed
// TODO add your handling code here:
    if (tbdetbol.getRowCount() < 1) {
        JOptionPane.showMessageDialog(this, "ingrese algun producto");
    } else {
        calcular();
    }

}//GEN-LAST:event_btncalcularActionPerformed

private void btnclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclientesActionPerformed
// TODO add your handling code here:
    ClientesB cli = new ClientesB();
    Principal.jdpescritorio.add(cli);
    cli.toFront();
    cli.setVisible(true);
}//GEN-LAST:event_btnclientesActionPerformed

private void btnproductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproductosActionPerformed
// TODO add your handling code here:
    try {
        ProductosB pro = new ProductosB();
        Principal.jdpescritorio.add(pro);
        pro.toFront();
        pro.setVisible(true);

    } catch (Exception e) {
    }
}//GEN-LAST:event_btnproductosActionPerformed

private void btnvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvenActionPerformed
// TODO add your handling code here:
    if ((txtcod.getText().equals("")) || (txttotal.getText().equals(""))) {
        JOptionPane.showMessageDialog(this, "Ingrese cliente, producto o realice operacion");
    } else {
        String capcod = "", capcan = "";
        for (int i = 0; i < Boleta.tbdetbol.getRowCount(); i++) {
            capcod = Boleta.tbdetbol.getValueAt(i, 0).toString();
            capcan = Boleta.tbdetbol.getValueAt(i, 3).toString();
            descontarstock(capcod, capcan);

        }
        boleta();
        detalleboleta();
        txtcod.setText("");
        txtnomape.setText("");

        txtdni.setText("");
        txtdire.setText("");

        txttotal.setText("");

        DefaultTableModel modelo = (DefaultTableModel) tbdetbol.getModel();
        int a = tbdetbol.getRowCount() - 1;
        int i;
        for (i = a; i >= 0; i--) {
            modelo.removeRow(i);
        }
        numeros();
    }

}//GEN-LAST:event_btnvenActionPerformed

    private void txtnumbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumbolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumbolActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncalcular;
    private javax.swing.JButton btnclientes;
    private javax.swing.JButton btnproductos;
    private javax.swing.JButton btnven;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTable tbdetbol;
    public static javax.swing.JTextField txtcod;
    public static javax.swing.JTextField txtdire;
    public static javax.swing.JTextField txtdni;
    public static javax.swing.JTextField txtfecha;
    public static javax.swing.JTextField txtnomape;
    private javax.swing.JTextField txtnumbol;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
conectar cc = new conectar();
    Connection cn = cc.conexion();
}
