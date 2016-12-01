/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DBA.FileKhoaVien;
import ENTITY.KhoaVien;
import ENTITY.MonHoc;
import ENTITY.MonNienChe;
import ENTITY.MonTinChi;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tu
 */
public class QuanLyMonHocGUI extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyMonHocGUI
     */
    DefaultComboBoxModel<String> boxModelKhoaVien;
    DefaultTableModel defaultTableModelMonHoc;
    DefaultTableModel defaultTableModelMHDieuKien;
    public QuanLyMonHocGUI() {
        this.setVisible(true);
        this.setTitle("Quản lý môn học");
        initComponents();
        initComboBoxKhoaVien();
        initTableMonHocDieuKien();
        rdTinChi.setSelected(true);
        showDataMonHoc();
    }
    
    public void initTableMonHocDieuKien(){
        defaultTableModelMHDieuKien = new DefaultTableModel();
        defaultTableModelMHDieuKien.addColumn("Mã Môn Học");
        defaultTableModelMHDieuKien.addColumn("Tên Môn Học");
        defaultTableModelMHDieuKien.addColumn(" Số Tín Chỉ");
        
        tbMonHocDK.setModel(defaultTableModelMHDieuKien);
    }
    
    public void showDataMonHoc(){
        defaultTableModelMonHoc = new DefaultTableModel();
        if(rdTinChi.isSelected()){
            defaultTableModelMonHoc = new DefaultTableModel();
            defaultTableModelMonHoc.addColumn("Mã Môn Học");
            defaultTableModelMonHoc.addColumn("Tên Môn Học");
            defaultTableModelMonHoc.addColumn("Số Tín Chỉ");
            
            tbDanhSachMonHoc.setModel(defaultTableModelMonHoc);
            
            FileKhoaVien fileKhoaVien = new FileKhoaVien();
            ArrayList<KhoaVien> listKhoaVien = fileKhoaVien.docFileKhoaVien();
            ArrayList<MonHoc> listMonHoc = new ArrayList<>();
            for (KhoaVien khoaVien : listKhoaVien) {
                if(khoaVien.getTenVien().equals(cbKhoaVien.getSelectedItem().toString())){
                    listMonHoc = khoaVien.getDsMonHoc();
                }
            }
            
            for (MonHoc monHoc : listMonHoc) {
                if (monHoc instanceof MonTinChi){
                    MonTinChi monTC = (MonTinChi)monHoc;
                    Vector<String> data = new Vector<>();
                    data.add(monTC.getMaMon());
                    data.add(monTC.getTenMon());
                    data.add(String.valueOf(monTC.getSoTinChi()));
                    defaultTableModelMonHoc.addRow(data);
                }
            }
            
        }else {
            defaultTableModelMonHoc = new DefaultTableModel();
            defaultTableModelMonHoc.addColumn("Mã Môn Học");
            defaultTableModelMonHoc.addColumn("Tên Môn Học");
            defaultTableModelMonHoc.addColumn("Đơn vị học trình");
            defaultTableModelMonHoc.addColumn("Học Kì");
            
            tbDanhSachMonHoc.setModel(defaultTableModelMonHoc);
            
            FileKhoaVien fileKhoaVien = new FileKhoaVien();
            ArrayList<KhoaVien> listKhoaVien = fileKhoaVien.docFileKhoaVien();
            ArrayList<MonHoc> listMonHoc = new ArrayList<>();
            for (KhoaVien khoaVien : listKhoaVien) {
                if(khoaVien.getTenVien().equals(cbKhoaVien.getSelectedItem().toString())){
                    listMonHoc = khoaVien.getDsMonHoc();
                }
            }  
            
            for (MonHoc monHoc : listMonHoc) {
                if (monHoc instanceof MonNienChe){
                    MonNienChe monNienChe = (MonNienChe)monHoc;
                    Vector<String> data = new Vector<>();
                    data.add(monNienChe.getMaMon());
                    data.add(monNienChe.getTenMon());
                    data.add(String.valueOf(monNienChe.getDonViHocTrinh()));
                    data.add(String.valueOf(monNienChe.getKiHocSo()));
                    defaultTableModelMonHoc.addRow(data);
                }
            }
            
        }
    }
    
    
    // Lấy dữ liệu từ file đổ vào ComboBox
    void initComboBoxKhoaVien(){
        boxModelKhoaVien = new DefaultComboBoxModel<>();
        FileKhoaVien fileKhoaVien = new FileKhoaVien();
        ArrayList<KhoaVien> listKhoaVien = fileKhoaVien.docFileKhoaVien();
        
        for (int i = 0; i< listKhoaVien.size(); i++){
            KhoaVien khoaVien = listKhoaVien.get(i);
            boxModelKhoaVien.addElement(khoaVien.getTenVien());
        }
        
        cbKhoaVien.setModel(boxModelKhoaVien);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cbKhoaVien = new javax.swing.JComboBox<>();
        rdTinChi = new javax.swing.JRadioButton();
        rdNienChe = new javax.swing.JRadioButton();
        btnThemMonHoc = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoaLopHoc = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDanhSachMonHoc = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbMonHocDK = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jPanel3.setBackground(new java.awt.Color(244, 255, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/bk.jpg"))); // NOI18N

        btnClose.setBackground(new java.awt.Color(254, 254, 254));
        btnClose.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/logout-512.png"))); // NOI18N
        btnClose.setText("Thoát");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel2.setText("QUẢN LÝ MÔN HỌC");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(265, 265, 265)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnClose)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(254, 254, 254));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bảng Điều Khiển", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(1, 1, 1))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Khoa Viện", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        cbKhoaVien.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbKhoaVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbKhoaVien, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbKhoaVien, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonGroup1.add(rdTinChi);
        rdTinChi.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        rdTinChi.setText("Môn Tín Chỉ");
        rdTinChi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdTinChiMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdNienChe);
        rdNienChe.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        rdNienChe.setText("Môn Niên Chế");
        rdNienChe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdNienCheMouseClicked(evt);
            }
        });

        btnThemMonHoc.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThemMonHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/addNew.png"))); // NOI18N
        btnThemMonHoc.setText("Thêm Môn Học");
        btnThemMonHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMonHocActionPerformed(evt);
            }
        });

        btnCapNhat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/updateNew.png"))); // NOI18N
        btnCapNhat.setText("Cập Nhật Môn Học");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnXoaLopHoc.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnXoaLopHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/file_delete50x50.png"))); // NOI18N
        btnXoaLopHoc.setText("Xóa Lớp Học");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoaLopHoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rdTinChi)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdNienChe)
                    .addComponent(btnThemMonHoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCapNhat, btnThemMonHoc, btnXoaLopHoc});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdTinChi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdNienChe)
                .addGap(18, 18, 18)
                .addComponent(btnThemMonHoc)
                .addGap(44, 44, 44)
                .addComponent(btnCapNhat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoaLopHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        jPanel5.setBackground(new java.awt.Color(254, 254, 254));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách môn học", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        tbDanhSachMonHoc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbDanhSachMonHoc.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbDanhSachMonHoc.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDanhSachMonHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDanhSachMonHocMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbDanhSachMonHoc);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(254, 254, 254));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách môn học điều kiện", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        tbMonHocDK.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbMonHocDK.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbMonHocDK);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(61, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemMonHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMonHocActionPerformed
        // TODO add your handling code here:
        themMonHoc();
    }//GEN-LAST:event_btnThemMonHocActionPerformed

    private void rdTinChiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdTinChiMouseClicked
        // TODO add your handling code here:
        showDataMonHoc();
    }//GEN-LAST:event_rdTinChiMouseClicked

    private void rdNienCheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdNienCheMouseClicked
        // TODO add your handling code here:
        showDataMonHoc();
    }//GEN-LAST:event_rdNienCheMouseClicked

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void tbDanhSachMonHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDanhSachMonHocMouseClicked
        // TODO add your handling code here:
        showMonHocDieuKien();
    }//GEN-LAST:event_tbDanhSachMonHocMouseClicked

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        updateMH();
        
    }//GEN-LAST:event_btnCapNhatActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyMonHocGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyMonHocGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyMonHocGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyMonHocGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyMonHocGUI().setVisible(true);
            }
        });
    }
    
    void updateMH(){
        
        FileKhoaVien fileKhoaVien = new FileKhoaVien();
        ArrayList<KhoaVien> listKhoaVien = fileKhoaVien.docFileKhoaVien();
        String maVien = null;
        for (KhoaVien khoaVien : listKhoaVien) {
            if (khoaVien.getTenVien().equals(cbKhoaVien.getSelectedItem().toString())){
                maVien = khoaVien.getMaKhoaVien();
            }
        }
        
        if (rdTinChi.isSelected()){
            CapNhatMonHocTinChiGUI.dataRow = (Vector<String>) defaultTableModelMonHoc.getDataVector().elementAt(tbDanhSachMonHoc.getSelectedRow());
            CapNhatMonHocTinChiGUI.maVien = maVien;
            new CapNhatMonHocTinChiGUI();
        }else {
            
    }
        
  }
    
    public void themMonHoc(){
        String tenVien = cbKhoaVien.getSelectedItem().toString();
        FileKhoaVien fileKhoaVien = new FileKhoaVien();
        ArrayList<KhoaVien> listKhoaVien = fileKhoaVien.docFileKhoaVien();
        
        if (rdTinChi.isSelected()){
            for (KhoaVien khoaVien : listKhoaVien) {
                if (khoaVien.getTenVien().equals(tenVien)){
                    ThemMonTinChiGUI.maVien = khoaVien.getMaKhoaVien();
                }
            }
            new ThemMonTinChiGUI();
        }else {
            for (KhoaVien khoaVien : listKhoaVien) {
                if (khoaVien.getTenVien().equals(tenVien)){
                    ThemMonNienCheGUI.maVien = khoaVien.getMaKhoaVien();
                }
            }
            new ThemMonNienCheGUI();
        }
    }
    
    
    // Đổ dữ liệu cho bảng môn học điều kiện khi một môn học được chọn từ bảng môn học
    public void showMonHocDieuKien(){
        if (rdNienChe.isSelected()){
            return;
        }
        defaultTableModelMHDieuKien.setRowCount(0);
        Vector<String> dataRow = (Vector<String>) defaultTableModelMonHoc.getDataVector().elementAt(tbDanhSachMonHoc.getSelectedRow());
        
        FileKhoaVien fileKhoaVien = new FileKhoaVien();
        ArrayList<KhoaVien> listKhoaVien = fileKhoaVien.docFileKhoaVien();
        ArrayList<MonHoc> listMonHoc = new ArrayList<>();
        ArrayList<MonHoc> listMonDieuKien = new ArrayList<>();
        
        for (KhoaVien khoaVien : listKhoaVien){
            if (khoaVien.getTenVien().equals(cbKhoaVien.getSelectedItem().toString())){
                listMonHoc = khoaVien.getDsMonHoc();
            }
        }
        
        for (MonHoc monHoc : listMonHoc) {
            if (monHoc.getMaMon().equals(dataRow.get(0))){
                if (monHoc instanceof MonTinChi){
                    MonTinChi monTinChi = (MonTinChi)monHoc;
                    listMonDieuKien = monTinChi.getDsMonDK();
                }
            }
        }
        if (listMonDieuKien.size() < 1){
            return;
        }
        
        for (MonHoc monHoc : listMonDieuKien) {
            MonTinChi monTC = (MonTinChi)monHoc;
            Vector<String> data = new Vector<>();
            data.add(monTC.getMaMon());
            data.add(monTC.getTenMon());
            data.add(String.valueOf(monTC.getSoTinChi()));
            defaultTableModelMHDieuKien.addRow(data);
        }
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnThemMonHoc;
    private javax.swing.JButton btnXoaLopHoc;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbKhoaVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rdNienChe;
    private javax.swing.JRadioButton rdTinChi;
    private javax.swing.JTable tbDanhSachMonHoc;
    private javax.swing.JTable tbMonHocDK;
    // End of variables declaration//GEN-END:variables
}
