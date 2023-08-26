/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package onlinereservationsystem;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author kali-i
 */
public class CancellationForm extends javax.swing.JFrame {

    /**
     * Creates new form CancellationForm
     */
    
    public static String id="";
    public static ArrayList <String> list_;
    
    public CancellationForm() {
        initComponents();
        list_=DatabaseClass.getPNRsBySubstring(id);
        
        for(String i:list_){
            this.jComboBox1.addItem(i);
        }
         if(this.jComboBox1.getItemCount() != 0){
             this.UpdateData(this.jComboBox1.getSelectedItem().toString());
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

        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel5.setText("Train Name :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(28, 298, 190, 19);

        jLabel7.setText("Class Type :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(28, 387, 150, 19);

        jLabel6.setText("Train Number :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(28, 344, 180, 19);

        jLabel8.setText("Origin :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(28, 208, 150, 19);

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(623, 417, 111, 39);

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel1.setText("Online Cancellation Form");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(280, 19, 212, 22);

        jLabel9.setText("Destination :");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(28, 255, 180, 19);

        jLabel3.setText("Full Name :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(28, 119, 160, 19);

        jLabel10.setText("Journey Date :");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(28, 427, 160, 19);

        jLabel4.setText("Contact :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(28, 162, 180, 19);

        jLabel11.setText("jLabel11");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(243, 119, 210, 19);

        jLabel12.setText("jLabel12");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(243, 162, 220, 19);

        jLabel13.setText("jLabel13");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(243, 208, 210, 19);

        jLabel14.setText("jLabel14");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(243, 255, 210, 19);

        jLabel15.setText("jLabel15");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(243, 298, 230, 19);

        jLabel16.setText("jLabel16");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(243, 344, 230, 19);

        jLabel17.setText("jLabel17");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(243, 387, 230, 19);

        jLabel18.setText("jLabel18");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(243, 427, 200, 19);

        jButton3.setText("Confirm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(494, 417, 111, 39);

        jLabel2.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        jLabel2.setText("Select your PNR Number to cancel Reservation");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(460, 120, 320, 19);

        jLabel20.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        jLabel20.setText("Your Reserved Seats");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(550, 80, 150, 17);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.removeAllItems();
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(489, 160, 240, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.hide();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

       if(this.jComboBox1.getItemCount() != 0){
        int choice = JOptionPane.showConfirmDialog(
            null,
            "Are You Confirmed to Cancel your Ticket?",
            "Confirmation",
            JOptionPane.YES_NO_OPTION
        );

      if(choice==0){
          DatabaseClass.deleteRecordsWithSubstring(this.jComboBox1.getSelectedItem().toString());
          JOptionPane.showMessageDialog(
            null,                   // Parent component (null for default frame)
            "Ticket Cancelled Succesfully", // Message content
            "Done",          // Dialog title
            JOptionPane.INFORMATION_MESSAGE // Message type
        );
          
          this.hide();
      }
        }else{
            
                       JOptionPane.showMessageDialog(
            null,                   
            "You have not selected any PNR Number", 
            "Error",         
            JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
        this.UpdateData(this.jComboBox1.getSelectedItem().toString());        
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
 System.exit(0); //        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    
    public void UpdateData(String query){
        
        String data=DatabaseClass.fetchMatchingRecords(query);
        String [] result=data.split(",");      
        this.jLabel11.setText(result[1]);
        this.jLabel12.setText(result[2]);
        this.jLabel13.setText(result[3]);
        this.jLabel14.setText(result[4]);
        this.jLabel15.setText(result[5]);
        this.jLabel16.setText(result[6]);
        this.jLabel17.setText(result[7]);
        this.jLabel18.setText(result[8]);
       
                        
    }
    
    
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
            java.util.logging.Logger.getLogger(CancellationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CancellationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CancellationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CancellationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CancellationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
