/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DBA.FileKhoaVien;
import ENTITY.KhoaVien;
import ENTITY.LopHoc;
import ENTITY.LopTinChi;
import ENTITY.MonHoc;
import ENTITY.MonTinChi;
import ENTITY.SinhVien;
import ENTITY.SinhVienTinChi;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tu
 */
public class DangKiHocGUI extends javax.swing.JFrame {

    /**
     * Creates new form DangKiHocGUI
     */
    public static int hocKi = 1;
    public static SinhVien sv; // Lấy thông tin sinh viên từ SinhVienGUI
    DefaultTableModel defaultTableModelTraCuu;
    DefaultTableModel defaultTableModelMonHocDK;
    DefaultComboBoxModel<String> boxModelVien;
    FileKhoaVien fileKhoaVien;
    public DangKiHocGUI() {
        this.setVisible(true);
        this.setTitle("Đăng kí môn học");
        initComponents();
        initTable();
        initComboBox();
        showDataTraCuu();
        lbHocKi.setText(String.valueOf(hocKi));
    }
    
    // KHởi tạo bảng
    public void initTable(){
        defaultTableModelMonHocDK = new DefaultTableModel();
        defaultTableModelTraCuu = new DefaultTableModel();
        
        defaultTableModelMonHocDK.addColumn("Mã môn học");
        defaultTableModelMonHocDK.addColumn("Tên môn học");
        defaultTableModelMonHocDK.addColumn("Số Tín Chỉ");
        
        defaultTableModelTraCuu.addColumn("Mã môn học");
        defaultTableModelTraCuu.addColumn("Tên môn học");
        defaultTableModelTraCuu.addColumn("Số Tín Chỉ");
        
        tbMonHocDK.setModel(defaultTableModelMonHocDK);
        tbTraCuu.setModel(defaultTableModelTraCuu);
    }
    
    //Khởi tạo ComboBox Khoa Viện
    public void initComboBox(){
        boxModelVien = new DefaultComboBoxModel<>();
        fileKhoaVien  = new FileKhoaVien();
        ArrayList<KhoaVien> listKhoaVien = new ArrayList<>();
        listKhoaVien = fileKhoaVien.docFileKhoaVien();
        
        for (KhoaVien khoaVien : listKhoaVien) {
            boxModelVien.addElement(khoaVien.getTenVien());
        }
        cbKhoaVien.setModel(boxModelVien);
    }
    
    // Đổ dữ liệu cho bảng tra cứu
    public void showDataTraCuu(){
        defaultTableModelTraCuu.setNumRows(0);
        fileKhoaVien = new FileKhoaVien();
        ArrayList<KhoaVien> listKhoaVien = new ArrayList<>();
        listKhoaVien = fileKhoaVien.docFileKhoaVien();
        ArrayList<MonHoc> listMonHoc  = new ArrayList<>();
        
        for (KhoaVien khoaVien : listKhoaVien) {
            if (khoaVien.getTenVien().equals(cbKhoaVien.getSelectedItem().toString())){
                listMonHoc = khoaVien.getDsMonHoc();
            }
        }
        
        for (MonHoc monHoc : listMonHoc) {
            if (monHoc instanceof MonTinChi){
                MonTinChi monHocTC = (MonTinChi)monHoc;
                Vector<String> data = new Vector<>();
                
                data.add(monHocTC.getMaMon());
                data.add(monHocTC.getTenMon());
                data.add(String.valueOf(monHocTC.getSoTinChi()));
                defaultTableModelTraCuu.addRow(data);
            }
        }
    }
    
    // Thêm môn học vào danh sách môn đăng kí
    public void themMonDK(){
        Vector<String> dataRow = new Vector<>();
        dataRow = (Vector<String>) defaultTableModelTraCuu.getDataVector().elementAt(tbTraCuu.getSelectedRow());
        defaultTableModelMonHocDK.addRow(dataRow);
    }
    
    // Xóa môn học trong bảng danh sách đăng kí
    public void xoaMonHocDK(){
        defaultTableModelMonHocDK.removeRow(tbMonHocDK.getSelectedRow());
    }
    
    public void dangKiMonHoc(){
        fileKhoaVien = new FileKhoaVien();
        String tenVien = sv.getTenVien();
        String tenLop = sv.getTenLop();
        ArrayList<KhoaVien> listKhoaVien = new ArrayList<>();
        ArrayList<LopHoc> listLopHoc = new ArrayList<>();
        ArrayList<MonHoc> listMonHoc = new ArrayList<>();
        listKhoaVien = fileKhoaVien.docFileKhoaVien();
        int kvIndex = 0;
        int lhIndex = 0;
        
        for(int i = 0; i< listKhoaVien.size(); i++){
            if (listKhoaVien.get(i).getTenVien().equals(tenVien)){
                kvIndex = i;
                listMonHoc = listKhoaVien.get(i).getDsMonHoc();
            }
        }
        
        for (int i = 0; i< listLopHoc.size(); i++){
            if (listLopHoc.get(i).getTenLop().equals(tenLop)){
                if (listLopHoc.get(i) instanceof LopTinChi){
                    lhIndex = i;
                }
            }
        }
        
        ArrayList<String> listmaMHDK = new ArrayList<>();
        listmaMHDK = getListMH();
        
        for (String maMH : listmaMHDK) {
            for (int i = 0; i< listKhoaVien.get(kvIndex).getDsMonHoc().size(); i++){
                if (listKhoaVien.get(kvIndex).getDsMonHoc().get(i).getMaMon().equals(maMH)){
                    if (listKhoaVien.get(kvIndex).getDsMonHoc().get(i) instanceof MonTinChi){
                        listKhoaVien.get(kvIndex).getDsLopHoc().get(lhIndex).dangKiHocTap(sv.getMaSV(), listKhoaVien.get(kvIndex).getDsMonHoc().get(i), listKhoaVien.get(kvIndex), hocKi);
                    }
                }
            }
        }
        fileKhoaVien.ghiFileKhoaVien(listKhoaVien);
        
        JOptionPane.showMessageDialog(rootPane, "Đăng kí thành công !");
        
    }
    
    public ArrayList<String> getListMH(){
        ArrayList<String> maMH = new ArrayList<>();
        
        for (int i = 0; i< defaultTableModelMonHocDK.getRowCount(); i++){
            Vector<String> dataRow = (Vector<String>) defaultTableModelMonHocDK.getDataVector().elementAt(i);
            maMH.add(dataRow.get(0));
            //System.out.println(dataRow.get(1));
        }
        return maMH;
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
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        cbKhoaVien = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTraCuu = new javax.swing.JTable();
        btnThemMonDK = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMonHocDK = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnXoaMonDK = new javax.swing.JButton();
        btnDangKi = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lbHocKi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jPanel2.setBackground(new java.awt.Color(254, 250, 136));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/bk.jpg"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(254, 254, 254));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/logout-512.png"))); // NOI18N
        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel3.setText("ĐĂNG KÍ MÔN HỌC");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(167, 167, 167)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jLabel3))
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(254, 254, 254));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tra cứu môn học", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(254, 254, 254));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Khoa viện", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        cbKhoaVien.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbKhoaVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbKhoaVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbKhoaVienMouseClicked(evt);
            }
        });
        cbKhoaVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKhoaVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(cbKhoaVien, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbKhoaVien, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Mã môn học : ");

        btnTimKiem.setBackground(new java.awt.Color(254, 254, 254));
        btnTimKiem.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/search50x50.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");

        tbTraCuu.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbTraCuu.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbTraCuu);

        btnThemMonDK.setBackground(new java.awt.Color(254, 254, 254));
        btnThemMonDK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/add50x50.png"))); // NOI18N
        btnThemMonDK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMonDKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnTimKiem)
                        .addGap(77, 77, 77)
                        .addComponent(btnThemMonDK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimKiem)
                    .addComponent(btnThemMonDK))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(254, 254, 254));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đăng kí môn học", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

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
        jScrollPane2.setViewportView(tbMonHocDK);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 33, 255));
        jLabel4.setText("Danh sách môn đăng kí : ");

        btnXoaMonDK.setBackground(new java.awt.Color(254, 254, 254));
        btnXoaMonDK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/remove-icon-png-26.png"))); // NOI18N
        btnXoaMonDK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMonDKActionPerformed(evt);
            }
        });

        btnDangKi.setBackground(new java.awt.Color(254, 254, 254));
        btnDangKi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnDangKi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/addNew.png"))); // NOI18N
        btnDangKi.setText("Đăng kí");
        btnDangKi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(btnXoaMonDK, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDangKi, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoaMonDK)
                    .addComponent(btnDangKi))
                .addGap(60, 60, 60))
        );

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 44, 255));
        jLabel5.setText("Học Kì : ");

        lbHocKi.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        lbHocKi.setText("hk");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbHocKi)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbHocKi))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbKhoaVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKhoaVienActionPerformed
        // TODO add your handling code here:
         showDataTraCuu();
    }//GEN-LAST:event_cbKhoaVienActionPerformed

    private void cbKhoaVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbKhoaVienMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_cbKhoaVienMouseClicked

    private void btnThemMonDKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMonDKActionPerformed
        // TODO add your handling code here:
        themMonDK();
    }//GEN-LAST:event_btnThemMonDKActionPerformed

    private void btnXoaMonDKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMonDKActionPerformed
        // TODO add your handling code here:
        xoaMonHocDK();
    }//GEN-LAST:event_btnXoaMonDKActionPerformed

    private void btnDangKiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKiActionPerformed
        // TODO add your handling code here:
        dangKiMonHoc();
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
            java.util.logging.Logger.getLogger(DangKiHocGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangKiHocGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangKiHocGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangKiHocGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangKiHocGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangKi;
    private javax.swing.JButton btnThemMonDK;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoaMonDK;
    private javax.swing.JComboBox<String> cbKhoaVien;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbHocKi;
    private javax.swing.JTable tbMonHocDK;
    private javax.swing.JTable tbTraCuu;
    // End of variables declaration//GEN-END:variables
}
