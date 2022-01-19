/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gsc;


import java.awt.HeadlessException;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author lutfilhadi
 */
public class FNB_Customer extends javax.swing.JFrame {
    public double subtotal = 0;
    int index = 0;
    private ImageIcon format = null;
    
    /**
     * Creates new form FNB_Customer
     */
    public FNB_Customer() {
        initComponents();
        Connect();
        LoadComboBox();
    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://db1.c1gfccwuxgzl.ap-southeast-1.rds.amazonaws.com:3306/cinema", "admin", "rotikeju");
                    } catch (ClassNotFoundException ex) {
            Logger.getLogger(FNB_Customer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FNB_Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void LoadComboBox(){
        try{
            pst = con.prepareStatement("SELECT * FROM fnb_products");
            rs = pst.executeQuery();
            while(rs.next()){
                String name = rs.getString("name");
                comboItem.addItem(name);
            }
            
        }catch(SQLException e){
            
        }
    }
    public void LoadImage(){
        try {
            byte[] imgdata = rs.getBytes("imageFile");
            format  = new ImageIcon(imgdata);
            Image mm = format.getImage();
            Image img2 = mm.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            ImageIcon image = new ImageIcon(img2);
            
            labelImage.setIcon(image);
        } catch (SQLException ex) {
            Logger.getLogger(FNB_Staff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelImage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboItem = new javax.swing.JComboBox<>();
        txtPrice = new javax.swing.JTextField();
        spinnerQty = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOrder = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnProceed = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        txtSubtotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel2.setText("Select:");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel3.setText("Price(RM):");

        comboItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                comboItemMouseEntered(evt);
            }
        });

        txtPrice.setEditable(false);
        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });

        spinnerQty.setModel(new javax.swing.SpinnerNumberModel(1, 0, null, 1));

        tableOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item", "Price(RM)", "Quantity", "Total Price(RM)"
            }
        )
        {
            public boolean isCellEditable(int row, int column)
            {
                return false;//This causes all cells to be not editable
            }
        }
    );
    jScrollPane1.setViewportView(tableOrder);

    btnAdd.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
    btnAdd.setText("Add to Cart");
    btnAdd.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAddActionPerformed(evt);
        }
    });

    btnProceed.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
    btnProceed.setText("Proceed to Payment");
    btnProceed.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnProceedActionPerformed(evt);
        }
    });

    btnRemove.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
    btnRemove.setText("Remove");
    btnRemove.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRemoveActionPerformed(evt);
        }
    });

    txtSubtotal.setEditable(false);
    txtSubtotal.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtSubtotalActionPerformed(evt);
        }
    });

    jLabel1.setText("Subtotal(RM):");

    jButton1.setText("Back");
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
            .addGap(64, 64, 64)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jButton1)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnAdd)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(comboItem, 0, 110, Short.MAX_VALUE)
                                        .addComponent(txtPrice))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(spinnerQty, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(75, 75, 75)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRemove)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnProceed, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addContainerGap(41, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(13, 13, 13)
            .addComponent(jButton1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addComponent(labelImage, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
            .addGap(27, 27, 27)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(comboItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spinnerQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRemove))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(btnAdd))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProceed, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(44, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void comboItemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboItemMouseEntered
        // TODO add your handling code here:
        String name = comboItem.getSelectedItem().toString();
        try{
           pst = con.prepareStatement("SELECT * FROM fnb_products WHERE name = '"+name+"'");
           rs = pst.executeQuery(); 
           
           if(rs.next()){
               String price = String.valueOf(rs.getDouble("unit_price"));
               txtPrice.setText(price);
               LoadImage();
           }
        }catch(SQLException e){
            
        }
    }//GEN-LAST:event_comboItemMouseEntered

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String name = comboItem.getSelectedItem().toString();
        try{
            pst = con.prepareStatement("SELECT * FROM fnb_products WHERE name = '"+name+"'");
            rs = pst.executeQuery();
            
            if(rs.next()){
                if((Integer)rs.getInt("qty") < (Integer)spinnerQty.getValue()){
                    JOptionPane.showMessageDialog(this, "Only " +(Integer)rs.getInt("qty")+
                            " available for selected item.");
                    if((Integer)rs.getInt("qty") == 0)
                        JOptionPane.showMessageDialog(this, "Selected item is unavailable.");
                }
		else if((Integer)spinnerQty.getValue()<1){
		    JOptionPane.showMessageDialog(null, "Invalid Quantity");
		}
                else{
                    String id = Integer.toString(rs.getInt("product_id"));
                    String price = txtPrice.getText();
                    String qty = spinnerQty.getValue().toString();
                    double total = Integer.parseInt(qty) * Double.parseDouble(price);
                    String totalPrice = Double.toString(total);
                    
                    String tableData[] = {id,name,price,qty,totalPrice};
        
                    DefaultTableModel tblModel = (DefaultTableModel)tableOrder.getModel();
                    tblModel.addRow(tableData);
        
                    this.subtotal += total;
                    txtSubtotal.setText(Double.toString(this.subtotal));
                    
                    int orderQty = Integer.parseInt(qty);
                    int currentQty = rs.getInt("qty");
                    int newQty = currentQty - orderQty;
                    String update = Integer.toString(newQty);
                    
                    pst = con.prepareStatement("UPDATE `cinema`.`fnb_products` SET `qty` = '"+update+"' WHERE name = '"+name+"'");
                    pst.execute();
		    
        
                }
            }
            
        }catch(HeadlessException | NumberFormatException | SQLException e){
            
        }
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnProceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProceedActionPerformed
        // TODO add your handling code here:
        int select = JOptionPane.showConfirmDialog(this,"Proceed to payment?", "Confirm",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        
        if(select == JOptionPane.YES_OPTION){
            try{
                pst = con.prepareStatement("INSERT INTO fnb_orders (amount)VALUES(?)");
                pst.setDouble(1, subtotal);
                
                pst.executeUpdate();
                
            }catch(SQLException e){
                Logger.getLogger(FNB_Customer.class.getName()).log(Level.SEVERE, null, e);
                
            }
	    try{
		PrintWriter prt = new PrintWriter(new FileOutputStream("fnb.txt"));
		int row = tableOrder.getRowCount();
		for(int i=0;i<row;i++){
		    prt.print(tableOrder.getModel().getValueAt(i,1).toString());
		    prt.print("\t-\t");
		    prt.print(tableOrder.getModel().getValueAt(i,3).toString());
		    prt.print("\n");
		}
		prt.close();
	    }catch(FileNotFoundException e){
		JOptionPane.showMessageDialog(null, e);
	    }
	    try{
		PrintWriter prt = new PrintWriter(new FileOutputStream("sub.txt"));
		prt.print(Double.toString(subtotal));
		prt.close();
	    }catch(FileNotFoundException e){
		JOptionPane.showMessageDialog(null, e);
	    }
            new Payment().setVisible(true);
            dispose();
                   
        }
    }//GEN-LAST:event_btnProceedActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tblModel = (DefaultTableModel) tableOrder.getModel();
        
        if(tableOrder.getSelectedRowCount() == 1){
            int row = tableOrder.getSelectedRow();
            String cell = tableOrder.getModel().getValueAt(row,0).toString();
            
            try{
                pst = con.prepareStatement("SELECT * FROM fnb_products WHERE product_id = '"+cell+"'");
                rs = pst.executeQuery();
                
                if(rs.next()){
                    int orderQty = Integer.parseInt(tableOrder.getModel().getValueAt(row,3).toString());
		    double subtract = Double.parseDouble(tableOrder.getModel().getValueAt(row,4).toString());
                    int currentQty = rs.getInt("qty");
                    int newQty = currentQty + orderQty;
		    this.subtotal = subtotal - subtract; 
		    subtotal = round(subtotal,2);
		    txtSubtotal.setText(Double.toString(subtotal));
                    String update = Integer.toString(newQty);
                
                    pst = con.prepareStatement("UPDATE `cinema`.`fnb_products` SET `qty` = '"+update+"' WHERE product_id = '"+cell+"'");
                    pst.execute();
		    
                }
                
            }catch(SQLException e){
                
            }
            tblModel.removeRow(tableOrder.getSelectedRow());
                     
        }
        else{
            if(tableOrder.getRowCount() == 0){
                JOptionPane.showMessageDialog(this,"Cart is empty.");
            }
            else{
                JOptionPane.showMessageDialog(this, "Please select item to remove.");
            }
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void txtSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubtotalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new SeatSelection().setVisible(true);
	dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FNB_Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FNB_Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FNB_Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FNB_Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FNB_Customer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnProceed;
    private javax.swing.JButton btnRemove;
    private javax.swing.JComboBox<String> comboItem;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelImage;
    private javax.swing.JSpinner spinnerQty;
    private javax.swing.JTable tableOrder;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtSubtotal;
    // End of variables declaration//GEN-END:variables

   public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    BigDecimal bd = BigDecimal.valueOf(value);
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
    }
}
