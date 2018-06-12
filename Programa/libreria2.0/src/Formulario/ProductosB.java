package Formulario;

import claseConectar.conectar;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.*;

public class ProductosB extends javax.swing.JInternalFrame {

    DefaultTableModel tabla;

    public ProductosB() {
        initComponents();
        cargarlistaproductos("");

    }

    String comparar(String cod) {
        String cant = "";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM producto WHERE cod_pro='" + cod + "'");
            while (rs.next()) {
                cant = rs.getString(4);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    void cargarlistaproductos(String dato) {
        String[] Titulo = {"Codigo", "Descripcion", "Precio", "Stock"};
        tabla = new DefaultTableModel(null, Titulo);
        String[] Registro = new String[4];
        String mostrar = "SELECT * FROM producto WHERE CONCAT (cod_pro,'',descripcion) LIKE '%" + dato + "%'";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registro[0] = rs.getString("cod_pro");
                Registro[1] = rs.getString("Descripcion");
                Registro[2] = rs.getString("precio");
                Registro[3] = rs.getString("Stock");
                tabla.addRow(Registro);
            }
            tbprod.setModel(tabla);
        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnenviar = new javax.swing.JMenuItem();
        txtprod = new javax.swing.JTextField();
        btnmostrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbprod = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        mnenviar.setText("Enviar a Boleta");
        mnenviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnenviarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnenviar);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("PRODUCTOS");

        txtprod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprodKeyReleased(evt);
            }
        });

        btnmostrar.setText("Mostrar todo");
        btnmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmostrarActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscar Productos");

        tbprod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbprod.setComponentPopupMenu(jPopupMenu1);
        jScrollPane2.setViewportView(tbprod);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ayuda.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(txtprod, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(btnmostrar))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnmostrar)
                    .addComponent(txtprod, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void txtprodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprodKeyReleased
// TODO add your handling code here:
    cargarlistaproductos(txtprod.getText());
}//GEN-LAST:event_txtprodKeyReleased

private void btnmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmostrarActionPerformed
// TODO add your handling code here:
    cargarlistaproductos("");
}//GEN-LAST:event_btnmostrarActionPerformed

private void mnenviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnenviarActionPerformed
// TODO add your handling code here:
    try {
        DefaultTableModel tabladet = (DefaultTableModel) Boleta.tbdetbol.getModel();
        String[] dato = new String[5];

        int fila = tbprod.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "No  ha seleccionado ningun registro");
        } else {
            String codins = tbprod.getValueAt(fila, 0).toString();
            String desins = tbprod.getValueAt(fila, 1).toString();
            String preins = tbprod.getValueAt(fila, 2).toString();
            int c = 0;
            int j = 0;
            String cant = JOptionPane.showInputDialog("ingrese cantidad");
            if ((cant.equals("")) || (cant.equals("0"))) {
                JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
            } else {
                int canting = Integer.parseInt(cant);
                int comp = Integer.parseInt(comparar(codins));
                if (canting > comp) {
                    JOptionPane.showMessageDialog(null, "Usted no cuenta con el stock apropiado", "Error!", JOptionPane.ERROR_MESSAGE);
                } else {
                    for (int i = 0; i < Boleta.tbdetbol.getRowCount(); i++) {
                        Object com = Boleta.tbdetbol.getValueAt(i, 0);
                        if (codins.equals(com)) {
                            j = i;
                            Boleta.tbdetbol.setValueAt(cant, i, 3);
                            c = c + 1;

                        }

                    }
                    if (c == 0) {

                        dato[0] = codins;
                        dato[1] = desins;
                        dato[2] = preins;
                        dato[3] = cant;

                        tabladet.addRow(dato);

                        Boleta.tbdetbol.setModel(tabladet);

                    }
                }

            }

        }
    } catch (Exception e) {
    }
}//GEN-LAST:event_mnenviarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(null,
                "Seleccione un producto del catalogo."
                + "\n" + "Para ello haga click derecho en cada fila y se "
                + "\n" + "enviara los datos en la bota llenandose de "
                + "\n" + "manera autoamtica.");
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnmostrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem mnenviar;
    private javax.swing.JTable tbprod;
    private javax.swing.JTextField txtprod;
    // End of variables declaration//GEN-END:variables
conectar cc = new conectar();
    Connection cn = cc.conexion();
}
