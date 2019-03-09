/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableDialog;

import DBCore.DBUtils;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Windows 18
 */
public class BoatDialog extends javax.swing.JDialog {

    Vector<String> header = new Vector<>();
    Vector data = null;
    
    boolean addNew = true;
    public BoatDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        header.add("BID");
        header.add("BName");
        header.add("Color");
        initComponents();
        initTable();
        setLocationRelativeTo(null);
    }

    
    
    private void initTable(){
        
        data = DBCore.DBUtils.loadBoats();
        DefaultTableModel dtm = new DefaultTableModel(data, header);
        this.boatTable.setModel(dtm);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        boatTable = new javax.swing.JTable();
        bidLbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        idText = new javax.swing.JTextPane();
        bnameLbl = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        nameTxt = new javax.swing.JTextPane();
        colorLbl = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        colorTxt = new javax.swing.JTextPane();
        btnAdd = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        boatTable.setModel(new javax.swing.table.DefaultTableModel(
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
        boatTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boatTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(boatTable);

        bidLbl.setText("bid");

        idText.setEditable(false);
        jScrollPane2.setViewportView(idText);

        bnameLbl.setText("bname");

        jScrollPane3.setViewportView(nameTxt);

        colorLbl.setText("color");

        jScrollPane4.setViewportView(colorTxt);

        btnAdd.setText("Add new");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addGap(107, 107, 107)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(429, 429, 429)
                                    .addComponent(bidLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(bnameLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(429, 429, 429)
                                .addComponent(colorLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane2))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnDelete)
                .addGap(158, 158, 158))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(352, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bidLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bnameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(colorLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnSave))))
                .addGap(44, 44, 44)
                .addComponent(btnDelete)
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boatTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boatTableMouseClicked
        // TODO add your handling code here:

        int index = boatTable.getSelectedRow();
        if(index != -1){
            addNew = false;
            Vector row = (Vector) data.get(index);
            idText.setText((String) row.get(0));
            nameTxt.setText((String) row.get(1));
            colorTxt.setText((String) row.get(2));
            idText.setEditable(false);

        }

    }//GEN-LAST:event_boatTableMouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        // TODO add your handling code here:
        addNew = true;
        idText.setEditable(true);
        idText.setText("");
        nameTxt.setText("");
        colorTxt.setText("");

    }//GEN-LAST:event_btnAddMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        // TODO add your handling code here:
            
        int bid ;
        try{
        bid = Integer.parseInt(idText.getText());
        }catch(NumberFormatException exception){
            JOptionPane.showMessageDialog(this, "Not valid id");
            return;
        }
        
        
        
        
        if(addNew)//insert
        try {
            Map<String,String> setList = new HashMap<>();
        
        setList.put(bidLbl.getText(), idText.getText());
        setList.put(bnameLbl.getText(), nameTxt.getText());
        setList.put(colorLbl.getText(), colorTxt.getText());
            if(DBUtils.insert(setList, "Boats") == 1) System.out.println("Insert success full");
            initTable();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Duplicate bid");
//            ex.printStackTrace();
        }
        else{
            Map<String,String> condiitionList = new HashMap<>();
            condiitionList.put(bidLbl.getText(), idText.getText());
            try {
                Map<String,String> setList = new HashMap<>();
                setList.put(bnameLbl.getText(), nameTxt.getText());
                setList.put(colorLbl.getText(), colorTxt.getText());
                if(DBUtils.update(setList, condiitionList) == 1) System.out.println("Update success full");
                initTable();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No updated ");
//                ex.printStackTrace();
            }
        }
            idText.setEditable(true);
        idText.setText("");
        nameTxt.setText("");
        colorTxt.setText("");
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        // TODO add your handling code here:

        int index = boatTable.getSelectedRow();
        if(index != -1){
            addNew = false;
            Vector row = (Vector) data.get(index);
            int id = Integer.parseInt((String) row.get(0));
            try {
                if(JOptionPane.showConfirmDialog(this, "Do you want to delete id " + id) == JOptionPane.OK_OPTION)
                    DBUtils.deleteBoat(id);
                else return;
                JOptionPane.showMessageDialog(this, "Delete success");
                initTable();
            } catch (SQLException ex) {
                
                JOptionPane.showMessageDialog(this, ex.getMessage());
//                ex.printStackTrace();
            }
        }

    }//GEN-LAST:event_btnDeleteMouseClicked

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
            java.util.logging.Logger.getLogger(BoatDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BoatDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BoatDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BoatDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BoatDialog dialog = new BoatDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bidLbl;
    private javax.swing.JLabel bnameLbl;
    private javax.swing.JTable boatTable;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel colorLbl;
    private javax.swing.JTextPane colorTxt;
    private javax.swing.JTextPane idText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane nameTxt;
    // End of variables declaration//GEN-END:variables
}
