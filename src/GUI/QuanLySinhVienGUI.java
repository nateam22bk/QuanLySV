/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DBA.FileKhoaVien;
import ENTITY.KhoaVien;
import ENTITY.LopHoc;
import ENTITY.LopNienChe;
import ENTITY.LopTinChi;
import ENTITY.SinhVien;
import ENTITY.SinhVienNienChe;
import ENTITY.SinhVienTinChi;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tu
 */
public class QuanLySinhVienGUI extends javax.swing.JFrame {

    /**
     * Creates new form QuanLySinhVienGUI
     */
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    FileKhoaVien fileKhoaVien;
    ArrayList<KhoaVien> listKhoaVien;
    ArrayList<LopHoc> listLopHoc;
    DefaultComboBoxModel<String> boxModelKhoaVien;
    DefaultComboBoxModel<String> boxModelLopHoc;
    DefaultTableModel tableModelSinhVien;
    public QuanLySinhVienGUI() {
        this.setVisible(true);
        this.setTitle("Quản lý thông tin sinh viên");
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComboBoxKhoaVien();
        boxModelLopHoc = new DefaultComboBoxModel<>();
        cbLopHoc.setModel(boxModelLopHoc);
        rdTinChi.setSelected(true);
        initComboBoxKhoaVien();
        initTableSinhVien();
        showDataBoxLopHoc();
        showDataSinhVien();
    }
    
    public void initTableSinhVien(){
        tableModelSinhVien = new DefaultTableModel();
        tableModelSinhVien.addColumn("Mã số");
        tableModelSinhVien.addColumn("Họ tên");
        tableModelSinhVien.addColumn("Ngày sinh");
        tableModelSinhVien.addColumn("Quê quán");
        
        tbSinhVien.setModel(tableModelSinhVien);
        
    }
    
    public void initComboBoxKhoaVien(){
        boxModelKhoaVien = new DefaultComboBoxModel<>();
        cbKhoaVien.setModel(boxModelKhoaVien);
        fileKhoaVien = new FileKhoaVien();
        listKhoaVien = new ArrayList<>();
        listKhoaVien = fileKhoaVien.docFileKhoaVien();
        for (KhoaVien khoaVien : listKhoaVien) {
            boxModelKhoaVien.addElement(khoaVien.getTenVien());
        }
    }
    
    public void showDataBoxLopHoc(){
        cbLopHoc.setMaximumRowCount(0);
        String tenVien = cbKhoaVien.getSelectedItem().toString();
        listLopHoc = new ArrayList<>();
        for(KhoaVien khoaVien : listKhoaVien){
            if (khoaVien.getTenVien().equals(tenVien)){
                listLopHoc = khoaVien.getDsLopHoc();
            }
        }
        
        if (rdTinChi.isSelected()){
            for(LopHoc lopHoc : listLopHoc){
                if (lopHoc instanceof LopTinChi){
                    boxModelLopHoc.addElement(lopHoc.getTenLop());
                }
            }
        }else {
            for (LopHoc lopHoc : listLopHoc){
                if (lopHoc instanceof LopNienChe){
                    boxModelLopHoc.addElement(lopHoc.getTenLop());
                }
            }
    }
    }
    
    public void showDataSinhVien(){
        tableModelSinhVien.setNumRows(0);
        fileKhoaVien = new FileKhoaVien();
        listKhoaVien = fileKhoaVien.docFileKhoaVien();
        listLopHoc  = new ArrayList<>();
        LopHoc lopHoc = null;
        
        String tenVien = cbKhoaVien.getSelectedItem().toString();
        String tenLop = cbLopHoc.getSelectedItem().toString();
        
        int kvIndex = 0;
        int lhIndex = 0;
        for (int i = 0; i < listKhoaVien.size(); i++){
            if (listKhoaVien.get(i).getTenVien().equals(tenVien)){
                listLopHoc = listKhoaVien.get(i).getDsLopHoc();
            }
        }
        for (int i = 0;i< listLopHoc.size(); i++){
            if (listLopHoc.get(i).getTenLop().equals(tenLop)){
                lopHoc = listLopHoc.get(i);
            }
        }
        
        if (lopHoc instanceof LopTinChi){
            LopTinChi lopTinChi = (LopTinChi)lopHoc;
            ArrayList<SinhVienTinChi> listSV = lopTinChi.getDsSinhVienTC();
            for (SinhVienTinChi sinhVienTinChi : listSV) {
                Vector<String> data = new Vector<>();
                data.add(sinhVienTinChi.getMaSV());
                data.add(sinhVienTinChi.getHoTen());
                data.add(dateFormat.format(sinhVienTinChi.getNgaySinh()));
                data.add(sinhVienTinChi.getQueQuan());
                tableModelSinhVien.addRow(data);
            }
        }else{
            LopNienChe lopNienChe  = (LopNienChe)lopHoc;
            ArrayList<SinhVienNienChe> listSV = lopNienChe.getDsLopNC();
            for (SinhVienNienChe sinhVienNienChe : listSV) {
                Vector<String> data = new Vector<>();
                data.add(sinhVienNienChe.getMaSV());
                data.add(sinhVienNienChe.getHoTen());
                data.add(dateFormat.format(sinhVienNienChe.getNgaySinh()));
                data.add(sinhVienNienChe.getQueQuan());
                tableModelSinhVien.addRow(data);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        cbKhoaVien = new javax.swing.JComboBox<>();
        btnThemSV = new javax.swing.JButton();
        btnCapNhatSV = new javax.swing.JButton();
        btnXoaSV = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        cbLopHoc = new javax.swing.JComboBox<>();
        rdNienChe = new javax.swing.JRadioButton();
        rdTinChi = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSinhVien = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jPanel2.setBackground(new java.awt.Color(253, 254, 115));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/bk.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel2.setText("QUẢN LÝ SINH VIÊN");

        jButton1.setBackground(new java.awt.Color(254, 254, 254));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/logout-512.png"))); // NOI18N
        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(289, 289, 289)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel2)))
        );

        jPanel3.setBackground(new java.awt.Color(254, 254, 254));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bảng điều khiển", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(254, 254, 254));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Khoa Viện", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(254, 58, 58))); // NOI18N

        cbKhoaVien.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbKhoaVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbKhoaVien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbKhoaVien, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btnThemSV.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThemSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/addNew.png"))); // NOI18N
        btnThemSV.setText("Thêm Sinh Viên");
        btnThemSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSVActionPerformed(evt);
            }
        });

        btnCapNhatSV.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnCapNhatSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/updateNew.png"))); // NOI18N
        btnCapNhatSV.setText("Cập Nhật ");
        btnCapNhatSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatSVActionPerformed(evt);
            }
        });

        btnXoaSV.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnXoaSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/file_delete50x50.png"))); // NOI18N
        btnXoaSV.setText("Xóa");

        jPanel6.setBackground(new java.awt.Color(254, 254, 254));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lớp Học", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        cbLopHoc.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbLopHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonGroup1.add(rdNienChe);
        rdNienChe.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        rdNienChe.setText("Hệ Niên Chế");
        rdNienChe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdNienCheMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdTinChi);
        rdTinChi.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        rdTinChi.setText("Hệ Tín Chỉ");
        rdTinChi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdTinChiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbLopHoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdTinChi)
                            .addComponent(rdNienChe))
                        .addGap(0, 128, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbLopHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdTinChi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdNienChe)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCapNhatSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThemSV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btnThemSV)
                .addGap(33, 33, 33)
                .addComponent(btnCapNhatSV)
                .addGap(18, 18, 18)
                .addComponent(btnXoaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(254, 254, 254));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sinh viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        tbSinhVien.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbSinhVien);

        jPanel7.setBackground(new java.awt.Color(254, 254, 254));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm sinh viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 2, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        txtTimKiem.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btnTimKiem.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/search50x50.png"))); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Tên Sinh Viên :");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addGap(47, 47, 47)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiem)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnThemSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSVActionPerformed
        // TODO add your handling code here:
        themSinhVien();
        new ThemSinhVienGUI();
    }//GEN-LAST:event_btnThemSVActionPerformed

    private void rdTinChiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdTinChiMouseClicked
        // TODO add your handling code here:
        showDataSinhVien();
        showDataBoxLopHoc();
    }//GEN-LAST:event_rdTinChiMouseClicked

    private void btnCapNhatSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatSVActionPerformed
        // TODO add your handling code here:
        capNhatSinhVien();
        new CapNhatSinhVienGUI();
    }//GEN-LAST:event_btnCapNhatSVActionPerformed

    private void rdNienCheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdNienCheMouseClicked
        // TODO add your handling code here:
        showDataBoxLopHoc();
    }//GEN-LAST:event_rdNienCheMouseClicked

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
            java.util.logging.Logger.getLogger(QuanLySinhVienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLySinhVienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLySinhVienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLySinhVienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLySinhVienGUI().setVisible(true);
            }
        });
    }
    
    public void themSinhVien(){
        fileKhoaVien = new FileKhoaVien();
        listKhoaVien = fileKhoaVien.docFileKhoaVien();
        String tenVien = cbKhoaVien.getSelectedItem().toString();
        String tenLop = cbLopHoc.getSelectedItem().toString();
        
        ThemSinhVienGUI.tenVien = tenVien;
        ThemSinhVienGUI.tenLop = tenLop;
        
        for (int i = 0; i< listKhoaVien.size(); i++){
            if (listKhoaVien.get(i).equals(tenVien)){
                ThemSinhVienGUI.kvIndex = i;
                listLopHoc = listKhoaVien.get(i).getDsLopHoc();
            }
        }
        
        for (int i = 0; i< listLopHoc.size(); i++){
            if (listLopHoc.get(i).equals(tenLop)){
                ThemSinhVienGUI.lhIndex = i;
            }
        }
        
        if (rdTinChi.isSelected()){
            ThemSinhVienGUI.rdTinChi = 1;
        }else {
            ThemSinhVienGUI.rdTinChi = 0;
        }
    }
    
    public void capNhatSinhVien(){
        fileKhoaVien = new FileKhoaVien();
        listKhoaVien = fileKhoaVien.docFileKhoaVien();
        String tenVien = cbKhoaVien.getSelectedItem().toString();
        String tenLop = cbLopHoc.getSelectedItem().toString();
        
        CapNhatSinhVienGUI.tenVien = tenVien;
        CapNhatSinhVienGUI.tenLop = tenLop;
        
        for (int i = 0; i< listKhoaVien.size(); i++){
            if (listKhoaVien.get(i).equals(tenVien)){
                CapNhatSinhVienGUI.kvIndex = i;
                listLopHoc = listKhoaVien.get(i).getDsLopHoc();
            }
        }
        
        for (int i = 0; i< listLopHoc.size(); i++){
            if (listLopHoc.get(i).equals(tenLop)){
                CapNhatSinhVienGUI.lhIndex = i;
            }
        }
        
        if (rdTinChi.isSelected()){
            CapNhatSinhVienGUI.rdTinChi = 1;
        }else {
            CapNhatSinhVienGUI.rdTinChi = 0;
        }
        
        CapNhatSinhVienGUI.data = (Vector<String>) tableModelSinhVien.getDataVector().elementAt(tbSinhVien.getSelectedRow());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhatSV;
    private javax.swing.JButton btnThemSV;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoaSV;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbKhoaVien;
    private javax.swing.JComboBox<String> cbLopHoc;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdNienChe;
    private javax.swing.JRadioButton rdTinChi;
    private javax.swing.JTable tbSinhVien;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
