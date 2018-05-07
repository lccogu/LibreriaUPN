package Formulario;

import claseConectar.conectar;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultasBoletas extends javax.swing.JInternalFrame {

    public ConsultasBoletas() {
        initComponents();
        cargartodasBoletas();
      
       
    }
     void cargartodasBoletas()
    {
        DefaultTableModel tabla= new DefaultTableModel();
        String []titulos={"NUMERO","COD. CLIENTE","TOTAL A PAGAR","FECHA"};
        tabla.setColumnIdentifiers(titulos);
        this.tbboletas.setModel(tabla);
        String consulta= "SELECT * FROM boleta";
        String []Datos= new String [4];
        try {
            Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(consulta);
            while(rs.next())
            {
                Datos[0]=rs.getString("num_bol");
                Datos[1]=rs.getString("cod_cli");
                Datos[2]=rs.getString("pre_tot");
                Datos[3]=rs.getString("fecha");
                
                
                tabla.addRow(Datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasBoletas.class.getName()).log(Level.SEVERE, null, ex);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbboletas = new javax.swing.JTable();

        mnver.setText("Ver Detalle");
        mnver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnverActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnver);

        mneliminar.setText("mneliminar");
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
        setTitle("CONSULTAS DE BOLETAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 94, Short.MAX_VALUE)
        );

        tbboletas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbboletas.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tbboletas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void mnverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnverActionPerformed

    int filasele= tbboletas.getSelectedRow();
    if(filasele==-1)
    {
        JOptionPane.showMessageDialog(null, "No Seleciono ninguna fila");
    }
    else
    {
           DetalleBoleta detalle = new DetalleBoleta();
    Principal.jdpescritorio.add(detalle);
    detalle.toFront();
    detalle.setVisible(true);
        String numbol=tbboletas.getValueAt(filasele, 0).toString();
        String cod=tbboletas.getValueAt(filasele, 1).toString();
        
        String total=tbboletas.getValueAt(filasele, 2).toString();
        String fecha=tbboletas.getValueAt(filasele, 3).toString();
        DetalleBoleta.txtfac.setText(numbol);
        DetalleBoleta.txtcod.setText(cod);
        
         DetalleBoleta.txttot.setText(total);
         DetalleBoleta.txtfecha.setText(fecha);
        DefaultTableModel model = (DefaultTableModel) DetalleBoleta.tbdetalle.getModel();
        String ver="SELECT * FROM detalleboleta WHERE num_bol='"+numbol+"'";
        String []datos= new String[5]   ;
        try {
                Statement st = cn.createStatement();
                ResultSet rs= st.executeQuery(ver);
                while(rs.next())
                {
                    datos[0]=rs.getString("cod_pro");
                    datos[1]=rs.getString("des_pro");
                    datos[2]=rs.getString("cant_pro");
                    datos[3]=rs.getString("pre_unit");
                    datos[4]=rs.getString("pre_venta");
                    model.addRow(datos);
                    
                }
                DetalleBoleta.tbdetalle.setModel(model);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasBoletas.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        
        
        
  
    }
}//GEN-LAST:event_mnverActionPerformed

private void mneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mneliminarActionPerformed
// TODO add your handling code here:
    int fila=tbboletas.getSelectedRow();
    if(fila>=0)
    {
        String cod=tbboletas.getValueAt(fila, 0).toString();
            try {
                PreparedStatement pst = cn.prepareStatement("DELETE FROM boleta WHERE num_bol='"+cod+"'");
                pst.executeUpdate();
                cargartodasBoletas();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasBoletas.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    else
    {
        JOptionPane.showMessageDialog(this, "Seleccione alguna fila");
    }
}//GEN-LAST:event_mneliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mneliminar;
    private javax.swing.JMenuItem mnver;
    public static javax.swing.JTable tbboletas;
    // End of variables declaration//GEN-END:variables
conectar cc= new conectar();
Connection cn = cc.conexion();
}
