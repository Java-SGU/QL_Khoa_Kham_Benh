/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Forms;

import BLL.BLLPhongKham;
import DTO.DTOPhongKham;
import javax.swing.JOptionPane;

/**
 *
 * @author Documents
 */
public class SuaPhongKham extends javax.swing.JDialog {
    BLLPhongKham bllPK = new BLLPhongKham();
    int maPhongKham;
    /**
     * Creates new form SuaPhongKham
     * @param maPK
     */
    public SuaPhongKham(int maPK) {
        initComponents();
        LayThongTinPK(maPK);
        this.maPhongKham = maPK;
    }

    private void LayThongTinPK(int maPK){
        DTOPhongKham dtoPK = bllPK.layPhongKhamTheoMa(maPK);
        if(dtoPK != null){
            jtxtMaPK.setText(String.valueOf(dtoPK.getMapk()));
            jtxtTenPK.setText(dtoPK.getTenpk());
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

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtxtMaPK = new javax.swing.JTextField();
        jtxtTenPK = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jbtnLuu = new javax.swing.JButton();
        jbtnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 0));
        jLabel2.setText("SỬA PHÒNG KHÁM");

        jLabel1.setText("Mã phòng");

        jtxtMaPK.setEnabled(false);

        jLabel3.setText("Tên phòng");

        jbtnLuu.setText("Lưu");
        jbtnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLuuActionPerformed(evt);
            }
        });

        jbtnHuy.setText("Đóng");
        jbtnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtMaPK)
                            .addComponent(jtxtTenPK))))
                .addContainerGap(87, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbtnLuu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnHuy)
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtMaPK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtTenPK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnLuu)
                    .addComponent(jbtnHuy))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLuuActionPerformed
        try {
            if("".equals(KiemTra())){
                String tenpk = jtxtTenPK.getText().trim();
                DTOPhongKham dtoPK = new DTOPhongKham();
                dtoPK.setMapk(this.maPhongKham);
                dtoPK.setTenpk(tenpk);
                if(bllPK.SuaPhongKham(dtoPK))
                    JOptionPane.showMessageDialog(null, "Sửa thành công");
           }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jbtnLuuActionPerformed

    private void jbtnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnHuyActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtnHuyActionPerformed

    private String KiemTra(){
        String kq = "";
        if("".equals(jtxtTenPK.getText().trim()))
            kq += "Vui lòng nhập tên phòng khám";
        return kq;
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
            java.util.logging.Logger.getLogger(SuaPhongKham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuaPhongKham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuaPhongKham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuaPhongKham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new SuaPhongKham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbtnHuy;
    private javax.swing.JButton jbtnLuu;
    private javax.swing.JTextField jtxtMaPK;
    private javax.swing.JTextField jtxtTenPK;
    // End of variables declaration//GEN-END:variables
}
