/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicureinterface;

import dataaccesslayer.FileKhoaVien;
import entity.DiemMonHoc;
import entity.KhoaVien;
import entity.MonHoc;
import entity.MonNienChe;
import entity.MonTinChi;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tu
 */
public class QuanLyDiemGUI extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyDiemGUI
     */
    DefaultComboBoxModel<String> boxModelKhoaVien;
    DefaultComboBoxModel<String> boxModelMonHoc;
    DefaultTableModel tableModelBangDiem;
    ArrayList<MonHoc> listMonHoc;

    public QuanLyDiemGUI() {
        this.setVisible(true);
        this.setTitle("Quản lý điểm học tập");
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComboBoxKhoaVien();
        initComboBoxMonHoc();
        initBangDiem();
        rdTinChi.setSelected(true);
        showBangDiem();
    }

    public void initBangDiem() {
        tableModelBangDiem = new DefaultTableModel();
        tableModelBangDiem.addColumn("MSSV");
        tableModelBangDiem.addColumn("Tên SV");
        tableModelBangDiem.addColumn("Điểm GK");
        tableModelBangDiem.addColumn("Điểm CK");
        tableModelBangDiem.addColumn("Trung Bình");

        tbBangDiem.setModel(tableModelBangDiem);
    }

    public void initComboBoxKhoaVien() {
        boxModelKhoaVien = new DefaultComboBoxModel<>();
        FileKhoaVien fileKhoaVien = new FileKhoaVien();
        ArrayList<KhoaVien> listKhoaVien = new ArrayList<>();
        ArrayList<MonHoc> listMonHoc = new ArrayList<>();
        listKhoaVien = fileKhoaVien.docFileKhoaVien();
        for (KhoaVien khoaVien : listKhoaVien) {
            boxModelKhoaVien.addElement(khoaVien.getTenVien());
        }

        cbKhoaVien.setModel(boxModelKhoaVien);
    }

    public void initComboBoxMonHoc() {
        boxModelMonHoc = new DefaultComboBoxModel<>();
        FileKhoaVien fileKhoaVien = new FileKhoaVien();
        ArrayList<KhoaVien> listKhoaVien = new ArrayList<>();
        listKhoaVien = fileKhoaVien.docFileKhoaVien();
        listMonHoc = new ArrayList<>();

        for (KhoaVien khoaVien : listKhoaVien) {
            if (khoaVien.getTenVien().equals(cbKhoaVien.getSelectedItem().toString())) {
                listMonHoc = khoaVien.getDsMonHoc();
            }
        }

        for (MonHoc monHoc : listMonHoc) {
            if (rdTinChi.isSelected()) {
                if (monHoc instanceof MonTinChi) {
                    boxModelMonHoc.addElement(monHoc.getTenMon());
                }
            } else {
                if (monHoc instanceof MonNienChe) {
                    boxModelMonHoc.addElement(monHoc.getTenMon());
                }
            }

        }
        cbMonHoc.setModel(boxModelMonHoc);
    }

    public void showBangDiem() {
        tableModelBangDiem.setNumRows(0);
        ArrayList<DiemMonHoc> bangDiem = new ArrayList<>();
        if (rdTinChi.isSelected()) {
            for (MonHoc monHoc : listMonHoc) {
                if (monHoc.getTenMon().equals(cbMonHoc.getSelectedItem().toString())) {
                    if (monHoc instanceof MonTinChi) {
                        bangDiem = monHoc.getDsDiem();
                    }
                }
            }
        } else {
            for (MonHoc monHoc : listMonHoc) {
                if (monHoc.getTenMon().equals(cbMonHoc.getSelectedItem().toString())) {
                    if (monHoc instanceof MonNienChe) {
                        bangDiem = monHoc.getDsDiem();
                    }
                }
            }
        }
        for (DiemMonHoc diemMonHoc : bangDiem) {
            Vector<String> data = new Vector<>();
            data.add(diemMonHoc.getSinhVien().getMaSV());
            data.add(diemMonHoc.getSinhVien().getHoTen());
            data.add(String.valueOf(diemMonHoc.getDienGiuaKy()));
            data.add(String.valueOf(diemMonHoc.getDiemCuoiKy()));
            data.add(String.valueOf(diemMonHoc.getDiemTB()));
            tableModelBangDiem.addRow(data);
        }
    }

    public void luuDiem() {

        // Kiểm tra xem bảng điểm có dữ liệu chưa
        if (tbBangDiem.getRowCount() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Chưa load dữ liệu và nhập điểm !");
            return;
        }

        FileKhoaVien fileKhoaVien = new FileKhoaVien();
        ArrayList<KhoaVien> listKhoaVien = new ArrayList<>();

        listKhoaVien = fileKhoaVien.docFileKhoaVien();

        int kvIndex = 0; // Lưu vị trí của khoa viện
        int mhIndex = 0; // Lưu vị trí của môn học

        for (int i = 0; i < listKhoaVien.size(); i++) {
            if (listKhoaVien.get(i).getTenVien().equals(cbKhoaVien.getSelectedItem().toString())) {
                kvIndex = i;
                listMonHoc = listKhoaVien.get(i).getDsMonHoc();
                break;
            }
        }

        if (rdTinChi.isSelected()) {
            for (int i = 0; i < listMonHoc.size(); i++) {
                if (listMonHoc.get(i).getTenMon().equals(cbMonHoc.getSelectedItem().toString())) {
                    if (listMonHoc.get(i) instanceof MonTinChi) {
                        mhIndex = i;
                        break;
                    }
                }
            }
        } else {
            for (int i = 0; i < listMonHoc.size(); i++) {
                if (listMonHoc.get(i).getTenMon().equals(cbMonHoc.getSelectedItem().toString())) {
                    if (listMonHoc.get(i) instanceof MonNienChe) {
                        mhIndex = i;
                        break;
                    }
                }
            }
        }

        ArrayList<Vector<String>> bangDiem = new ArrayList<>();
        for (int i = 0; i < tbBangDiem.getRowCount(); i++) {
            Vector<String> data = new Vector<>();
            data = (Vector<String>) tableModelBangDiem.getDataVector().elementAt(i);
            bangDiem.add(data);
        }
        if (listKhoaVien.get(kvIndex).getDsMonHoc().get(mhIndex).nhapDiem(bangDiem)) {
            JOptionPane.showMessageDialog(rootPane, "Đã lưu điểm !");
            fileKhoaVien.ghiFileKhoaVien(listKhoaVien);
            return;
        } else {
            JOptionPane.showMessageDialog(rootPane, "Điểm nhập vào không hợp lệ !");
            return;
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnThoat = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBangDiem = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        cbKhoaVien = new javax.swing.JComboBox<>();
        btnNhapDiem = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        cbMonHoc = new javax.swing.JComboBox<>();
        btnLoadDuLieu = new javax.swing.JButton();
        rdTinChi = new javax.swing.JRadioButton();
        rdNienChe = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jPanel2.setBackground(new java.awt.Color(255, 253, 160));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/bk.jpg"))); // NOI18N

        btnThoat.setBackground(new java.awt.Color(254, 254, 254));
        btnThoat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/logout-512.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("QUẢN LÝ ĐIỂM HỌC TẬP MÔN HỌC");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(75, 75, 75)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel1)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnThoat)
                .addComponent(jLabel2))
        );

        jPanel5.setBackground(new java.awt.Color(254, 254, 254));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bảng điểm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        tbBangDiem.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbBangDiem);

        jPanel3.setBackground(new java.awt.Color(254, 254, 254));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Khoa Viện", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        cbKhoaVien.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbKhoaVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbKhoaVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKhoaVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbKhoaVien, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(cbKhoaVien, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnNhapDiem.setBackground(new java.awt.Color(254, 254, 254));
        btnNhapDiem.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnNhapDiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/Ok-PNG-File.png"))); // NOI18N
        btnNhapDiem.setText("Lưu điểm");
        btnNhapDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapDiemActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(254, 254, 254));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Môn Học", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        cbMonHoc.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbMonHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbMonHoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(cbMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        btnLoadDuLieu.setBackground(new java.awt.Color(254, 254, 254));
        btnLoadDuLieu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnLoadDuLieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/connect-icon.png"))); // NOI18N
        btnLoadDuLieu.setText("Load Dữ Liệu");
        btnLoadDuLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadDuLieuActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdTinChi);
        rdTinChi.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        rdTinChi.setText("Hệ Tín Chỉ");
        rdTinChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdTinChiActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdNienChe);
        rdNienChe.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        rdNienChe.setText("Hệ Niên Chế");
        rdNienChe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNienCheActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnNhapDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLoadDuLieu)
                        .addGap(85, 85, 85)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdTinChi)
                            .addComponent(rdNienChe))))
                .addGap(34, 34, 34))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNhapDiem)
                        .addComponent(btnLoadDuLieu))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(rdTinChi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdNienChe)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void cbKhoaVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKhoaVienActionPerformed
        // TODO add your handling code here:
        initComboBoxMonHoc();
    }//GEN-LAST:event_cbKhoaVienActionPerformed

    private void btnLoadDuLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadDuLieuActionPerformed
        // TODO add your handling code here:
        showBangDiem();
    }//GEN-LAST:event_btnLoadDuLieuActionPerformed

    private void btnNhapDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapDiemActionPerformed
        // TODO add your handling code here:
        luuDiem();
    }//GEN-LAST:event_btnNhapDiemActionPerformed

    private void rdTinChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdTinChiActionPerformed
        // TODO add your handling code here:
        initComboBoxMonHoc();
    }//GEN-LAST:event_rdTinChiActionPerformed

    private void rdNienCheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNienCheActionPerformed
        // TODO add your handling code here:
        initComboBoxMonHoc();
    }//GEN-LAST:event_rdNienCheActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyDiemGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyDiemGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyDiemGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyDiemGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyDiemGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoadDuLieu;
    private javax.swing.JButton btnNhapDiem;
    private javax.swing.JButton btnThoat;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbKhoaVien;
    private javax.swing.JComboBox<String> cbMonHoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdNienChe;
    private javax.swing.JRadioButton rdTinChi;
    private javax.swing.JTable tbBangDiem;
    // End of variables declaration//GEN-END:variables
}
