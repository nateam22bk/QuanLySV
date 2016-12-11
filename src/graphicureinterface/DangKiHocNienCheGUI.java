/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicureinterface;

import dataaccesslayer.FileKhoaVien;
import entity.KhoaVien;
import entity.LopHoc;
import entity.LopNienChe;
import entity.MonHoc;
import entity.MonNienChe;
import entity.SinhVien;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tu
 */
public class DangKiHocNienCheGUI extends javax.swing.JFrame {

    /**
     * Creates new form DangKiHocNienCheGUI
     */
    public static SinhVien sv;
    public static int hocKi;
    DefaultTableModel defaultTableModelDanhSachMH;

    public DangKiHocNienCheGUI() {
        this.setVisible(true);
        this.setTitle("Dang ki hoc");
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initTable();
        showDataTableMonHoc();
        this.lbHocKi.setText(String.valueOf(hocKi));
    }
    
    public ArrayList<String> getMaMH(){
        ArrayList<String> maMH = new ArrayList<>();
        for (int i = 0; i< tbDanhSachMH.getRowCount(); i++){
            Vector<String> dataRow = (Vector<String>) defaultTableModelDanhSachMH.getDataVector().elementAt(i);
            maMH.add(dataRow.get(0));
        }
        return maMH;
    }
    
    public void dangKi(){
        FileKhoaVien fileKhoaVien = new FileKhoaVien();
        ArrayList<KhoaVien> listKhoaVien = new ArrayList<>();
        ArrayList<MonHoc> listMonHoc = new ArrayList<>();
        ArrayList<LopHoc> listLopHoc = new ArrayList<>();
        
        listKhoaVien = fileKhoaVien.docFileKhoaVien();
        
        int kvIndex = 0;
        int lhIndex = 0;
        
        for (int i = 0; i< listKhoaVien.size(); i++){
            if (listKhoaVien.get(i).getTenVien().equals(sv.getTenVien())){
                listLopHoc = listKhoaVien.get(i).getDsLopHoc();
                listMonHoc = listKhoaVien.get(i).getDsMonHoc();
                kvIndex = i;
            }
        }
        
        for (int i = 0; i< listLopHoc.size(); i++){
            if (listLopHoc.get(i) instanceof LopNienChe){
                if (listLopHoc.get(i).getTenLop().equals(sv.getTenLop())){
                    lhIndex = i;
                }
            }
        }
        
        ArrayList<String> dsMaMH = new ArrayList<>();
        dsMaMH = getMaMH();
        for (String maMH : dsMaMH) {
            System.out.println(maMH);
            for (int i = 0; i< listKhoaVien.get(kvIndex).getDsMonHoc().size(); i++){
                if (listKhoaVien.get(kvIndex).getDsMonHoc().get(i).getMaMon().equals(maMH)){
                    if (listKhoaVien.get(kvIndex).getDsMonHoc().get(i) instanceof MonNienChe){
                        if (listKhoaVien.get(kvIndex).getDsLopHoc().get(lhIndex).dangKiHocTapChoSV(sv.getMaSV(), listKhoaVien.get(kvIndex).getDsMonHoc().get(i), listKhoaVien.get(kvIndex), hocKi)){
                            JOptionPane.showMessageDialog(rootPane, "Dang Ki thanh cong");
                            fileKhoaVien.ghiFileKhoaVien(listKhoaVien);
                            return;
                        }else{
                            JOptionPane.showMessageDialog(rootPane, "Dang ki khong thanh cong !");
                        }
                    }
                }
            }
        }
    }

    public void initTable() {
        defaultTableModelDanhSachMH = new DefaultTableModel();
        defaultTableModelDanhSachMH.addColumn("Mã MH");
        defaultTableModelDanhSachMH.addColumn("Tên MH");
        defaultTableModelDanhSachMH.addColumn("Đơn vị HT");
        defaultTableModelDanhSachMH.addColumn("Hoc kì");
        
        tbDanhSachMH.setModel(defaultTableModelDanhSachMH);
    }
    
    public void showDataTableMonHoc(){
        FileKhoaVien fileKhoaVien = new FileKhoaVien();
        ArrayList<KhoaVien> listKhoaVien = new ArrayList<>();
        ArrayList<MonHoc> listMonHoc = new ArrayList<>();
        
        listKhoaVien = fileKhoaVien.docFileKhoaVien();
        
        for (KhoaVien khoaVien : listKhoaVien) {
            if (khoaVien.getTenVien().equals(listKhoaVien.get(0).getTenVien())){
                listMonHoc = khoaVien.getDsMonHoc();
            }
        }
        
        for (MonHoc monHoc : listMonHoc) {
            if (monHoc instanceof MonNienChe){
                MonNienChe monNienChe = (MonNienChe)monHoc;
                if (monNienChe.getKiHocSo() == hocKi){
                    Vector<String> dataRow = new Vector();
                    dataRow.add(monNienChe.getMaMon());
                    dataRow.add(monNienChe.getTenMon());
                    dataRow.add(String.valueOf(monNienChe.getDonViHocTrinh()));
                    dataRow.add(String.valueOf(monNienChe.getKiHocSo()));
                    defaultTableModelDanhSachMH.addRow(dataRow);
                }
            }
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnThoat = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDanhSachMH = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        lbHocKi = new javax.swing.JLabel();
        btnDangKi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jPanel2.setBackground(new java.awt.Color(246, 255, 123));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bk.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("ĐĂNG KÍ HỌC TẬP");

        btnThoat.setBackground(new java.awt.Color(254, 254, 254));
        btnThoat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logout-512.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(75, 75, 75)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThoat)
                    .addComponent(jLabel2)))
        );

        jPanel3.setBackground(new java.awt.Color(254, 254, 254));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách môn học", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        tbDanhSachMH.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbDanhSachMH);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(10, 0, 255));
        jLabel3.setText("Học kì số : ");

        lbHocKi.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        lbHocKi.setText("hk");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(lbHocKi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbHocKi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnDangKi.setBackground(new java.awt.Color(254, 254, 254));
        btnDangKi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnDangKi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/addNew.png"))); // NOI18N
        btnDangKi.setText("Đăng Kí");
        btnDangKi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnDangKi)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnDangKiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKiActionPerformed
        // TODO add your handling code here:
        dangKi();
    }//GEN-LAST:event_btnDangKiActionPerformed

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
            java.util.logging.Logger.getLogger(DangKiHocNienCheGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangKiHocNienCheGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangKiHocNienCheGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangKiHocNienCheGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangKiHocNienCheGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangKi;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbHocKi;
    private javax.swing.JTable tbDanhSachMH;
    // End of variables declaration//GEN-END:variables
}
