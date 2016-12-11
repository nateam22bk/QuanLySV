/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicureinterface;

import dataaccesslayer.FileBangDiem;
import dataaccesslayer.FileKhoaVien;
import entity.DiemMonHoc;
import entity.KhoaVien;
import entity.LopHoc;
import entity.LopTinChi;
import entity.MonHoc;
import entity.MonTinChi;
import entity.SinhVien;
import entity.SinhVienTinChi;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tu
 */
public class KetQuaHocTapGUI extends javax.swing.JFrame {

    /**
     * Creates new form KetQuaHocTapGUi
     */
    public static SinhVien sv;
    DefaultTableModel defaultTableModelMonHoc;
    DefaultTableModel defaultTableModelKetQua;
    DefaultTableModel defaultTableModelMHTichLuy;
    DefaultTableModel defaultTableModelMHNoDK;
    
    public KetQuaHocTapGUI() {
        this.setVisible(true);
        this.setTitle("Bảng điểm cá nhân");
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initTable();
        initContents();
    }
    
    public void initTable(){
        defaultTableModelKetQua = new DefaultTableModel();
        defaultTableModelMonHoc = new DefaultTableModel();
        defaultTableModelMHNoDK = new DefaultTableModel();
        defaultTableModelMHTichLuy = new DefaultTableModel();
        
        defaultTableModelMonHoc.addColumn("Mã MH");
        defaultTableModelMonHoc.addColumn("Têm MH");
        defaultTableModelMonHoc.addColumn("Số TC");
        defaultTableModelMonHoc.addColumn("Điểm GK");
        defaultTableModelMonHoc.addColumn("Điểm CK");
        defaultTableModelMonHoc.addColumn("Trung bình");
        
        defaultTableModelMHNoDK.addColumn("Mã MH");
        defaultTableModelMHNoDK.addColumn("Têm MH");
        defaultTableModelMHNoDK.addColumn("Số TC");
        defaultTableModelMHNoDK.addColumn("Điểm GK");
        defaultTableModelMHNoDK.addColumn("Điểm CK");
        defaultTableModelMHNoDK.addColumn("Trung bình");
        
        defaultTableModelMHTichLuy.addColumn("Mã MH");
        defaultTableModelMHTichLuy.addColumn("Têm MH");
        defaultTableModelMHTichLuy.addColumn("Số TC");
        defaultTableModelMHTichLuy.addColumn("Điểm GK");
        defaultTableModelMHTichLuy.addColumn("Điểm CK");
        defaultTableModelMHTichLuy.addColumn("Trung bình");
        
        defaultTableModelKetQua.addColumn("Học kì");
        defaultTableModelKetQua.addColumn("Số Tín Chỉ ĐK");
        defaultTableModelKetQua.addColumn("Số Tín Chỉ Nợ ĐK");
        defaultTableModelKetQua.addColumn("Điểm GPA");
        defaultTableModelKetQua.addColumn("Điểm CPA");
        
        tbDiemTrungBinh.setModel(defaultTableModelKetQua);
        tbMonHocDK.setModel(defaultTableModelMonHoc);
        tbMHTichLuy.setModel(defaultTableModelMHTichLuy);
        tbMHNoDK.setModel(defaultTableModelMHNoDK);
        
    }
    
    public void showMHTichLuy(){
        defaultTableModelMHTichLuy.setNumRows(0);
        FileKhoaVien fileKhoaVien = new FileKhoaVien();
        ArrayList<KhoaVien> listKhoaVien = fileKhoaVien.docFileKhoaVien();
        ArrayList<LopHoc> listLopHoc = new ArrayList<>();
        ArrayList<SinhVienTinChi> listSV = new ArrayList<>();
        ArrayList<MonHoc> listMonHoc = new ArrayList<>();
        defaultTableModelMonHoc.setNumRows(0);
        for (KhoaVien khoaVien : listKhoaVien) {
            if (khoaVien.getTenVien().equals(sv.getTenVien())){
                listLopHoc = khoaVien.getDsLopHoc();
            }
        }
        
        for (LopHoc lopHoc : listLopHoc) {
            if (lopHoc.getTenLop().equals(sv.getTenLop())){
                if (lopHoc instanceof LopTinChi){
                    LopTinChi lopTinChi = (LopTinChi)lopHoc;
                    listSV = lopTinChi.getDsSinhVienTC();
                }
            }
        }
        for (SinhVienTinChi sinhVienTinChi : listSV) {
            if (sinhVienTinChi.getMaSV().equals(sv.getMaSV())){
                listMonHoc = sinhVienTinChi.getDsMonTichLuy();
            }
        }
        for (MonHoc monHoc : listMonHoc) {
            MonTinChi monTinChi = null;
            if (monHoc instanceof MonTinChi){
                monTinChi = (MonTinChi)monHoc;
            }
            Vector<String> data = new Vector<>();
            data.add(monTinChi.getMaMon());
            data.add(monTinChi.getTenMon());
            data.add(String.valueOf(monTinChi.getSoTinChi()));
            ArrayList<DiemMonHoc> bangDiem = monHoc.getDsDiem();
            for (DiemMonHoc diemMonHoc : bangDiem) {
                if(diemMonHoc.getSinhVien().getMaSV().equals(sv.getMaSV())){
                    data.add(String.valueOf(diemMonHoc.getDienGiuaKy()));
                    data.add(String.valueOf(diemMonHoc.getDiemCuoiKy()));
                    data.add(String.valueOf(diemMonHoc.getDiemTB()));
                }
            }
            defaultTableModelMHTichLuy.addRow(data);
        }
        
    }
    
    public void showMHNoDK(){
        defaultTableModelMHNoDK.setNumRows(0);
        FileKhoaVien fileKhoaVien = new FileKhoaVien();
        ArrayList<KhoaVien> listKhoaVien = fileKhoaVien.docFileKhoaVien();
        ArrayList<LopHoc> listLopHoc = new ArrayList<>();
        ArrayList<SinhVienTinChi> listSV = new ArrayList<>();
        ArrayList<MonHoc> listMonHoc = new ArrayList<>();
        defaultTableModelMonHoc.setNumRows(0);
        for (KhoaVien khoaVien : listKhoaVien) {
            if (khoaVien.getTenVien().equals(sv.getTenVien())){
                listLopHoc = khoaVien.getDsLopHoc();
            }
        }
        
        for (LopHoc lopHoc : listLopHoc) {
            if (lopHoc.getTenLop().equals(sv.getTenLop())){
                if (lopHoc instanceof LopTinChi){
                    LopTinChi lopTinChi = (LopTinChi)lopHoc;
                    listSV = lopTinChi.getDsSinhVienTC();
                }
            }
        }
        for (SinhVienTinChi sinhVienTinChi : listSV) {
            if (sinhVienTinChi.getMaSV().equals(sv.getMaSV())){
                listMonHoc = sinhVienTinChi.getDsMonNoDangKi();
            }
        }
        for (MonHoc monHoc : listMonHoc) {
            MonTinChi monTinChi = null;
            if (monHoc instanceof MonTinChi){
                monTinChi = (MonTinChi)monHoc;
            }
            Vector<String> data = new Vector<>();
            data.add(monTinChi.getMaMon());
            data.add(monTinChi.getTenMon());
            data.add(String.valueOf(monTinChi.getSoTinChi()));
            ArrayList<DiemMonHoc> bangDiem = monHoc.getDsDiem();
            for (DiemMonHoc diemMonHoc : bangDiem) {
                if(diemMonHoc.getSinhVien().getMaSV().equals(sv.getMaSV())){
                    data.add(String.valueOf(diemMonHoc.getDienGiuaKy()));
                    data.add(String.valueOf(diemMonHoc.getDiemCuoiKy()));
                    data.add(String.valueOf(diemMonHoc.getDiemTB()));
                }
            }
            defaultTableModelMHNoDK.addRow(data);
        }
    }
    public void showBangDiemTB(){
        
    }
    
    public void initContents(){
        defaultTableModelMonHoc.setNumRows(0);
        FileKhoaVien fileKhoaVien = new FileKhoaVien();
        ArrayList<KhoaVien> listKhoaVien = fileKhoaVien.docFileKhoaVien();
        ArrayList<LopHoc> listLopHoc = new ArrayList<>();
        ArrayList<SinhVienTinChi> listSV = new ArrayList<>();
        ArrayList<MonHoc> listMonHoc = new ArrayList<>();
        defaultTableModelMonHoc.setNumRows(0);
        for (KhoaVien khoaVien : listKhoaVien) {
            if (khoaVien.getTenVien().equals(sv.getTenVien())){
                listLopHoc = khoaVien.getDsLopHoc();
            }
        }
        
        for (LopHoc lopHoc : listLopHoc) {
            if (lopHoc.getTenLop().equals(sv.getTenLop())){
                if (lopHoc instanceof LopTinChi){
                    LopTinChi lopTinChi = (LopTinChi)lopHoc;
                    listSV = lopTinChi.getDsSinhVienTC();
                }
            }
        }
        for (SinhVienTinChi sinhVienTinChi : listSV) {
            if (sinhVienTinChi.getMaSV().equals(sv.getMaSV())){
                listMonHoc = sinhVienTinChi.getDsMonDangKi();
            }
        }
        for (MonHoc monHoc : listMonHoc) {
            MonTinChi monTinChi = null;
            if (monHoc instanceof MonTinChi){
                monTinChi = (MonTinChi)monHoc;
            }
            Vector<String> data = new Vector<>();
            data.add(monTinChi.getMaMon());
            data.add(monTinChi.getTenMon());
            data.add(String.valueOf(monTinChi.getSoTinChi()));
            ArrayList<DiemMonHoc> bangDiem = monHoc.getDsDiem();
            for (DiemMonHoc diemMonHoc : bangDiem) {
                if(diemMonHoc.getSinhVien().getMaSV().equals(sv.getMaSV())){
                    data.add(String.valueOf(diemMonHoc.getDienGiuaKy()));
                    data.add(String.valueOf(diemMonHoc.getDiemCuoiKy()));
                    data.add(String.valueOf(diemMonHoc.getDiemTB()));
                }
            }
            defaultTableModelMonHoc.addRow(data);
        }
        
        showMHNoDK();
        showMHTichLuy();
    }
    
    public void capNhatTrangThaiMH(){
        FileKhoaVien fileKhoaVien = new FileKhoaVien();
        ArrayList<KhoaVien> listKhoaVien = new ArrayList<>();
        listKhoaVien = fileKhoaVien.docFileKhoaVien();
        ArrayList<LopHoc> listLopHoc = new ArrayList<>();
        
        int kvIndex = 0;
        int lhIndex = 0;
        
        for (int i = 0; i< listKhoaVien.size(); i++){
            if (listKhoaVien.get(i).getTenVien().equals(sv.getTenVien())){
                kvIndex = i;
                listLopHoc = listKhoaVien.get(i).getDsLopHoc();
            }
        }
        
        for (int i = 0; i< listLopHoc.size(); i++){
            if (listLopHoc.get(i).getTenLop().equals(sv.getTenLop())){
                lhIndex = i;
            }
        }
        
        listKhoaVien.get(kvIndex).getDsLopHoc().get(lhIndex).capNhatTrangThaiMHChoSV(sv.getMaSV());
        fileKhoaVien.ghiFileKhoaVien(listKhoaVien);
        initContents();
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
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDiemTrungBinh = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMonHocDK = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbMHTichLuy = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbMHNoDK = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jPanel2.setBackground(new java.awt.Color(252, 254, 173));
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

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("BẢNG ĐIỂM CÁ NHÂN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(68, 68, 68)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 417, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2))
        );

        jPanel3.setBackground(new java.awt.Color(254, 254, 254));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Điểm trung bình", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        tbDiemTrungBinh.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbDiemTrungBinh);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(254, 254, 254));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Môn học đang đăng kí", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(254, 254, 254));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Môn học đã tích lũy", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        tbMHTichLuy.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbMHTichLuy);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(254, 254, 254));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Môn học nợ ĐK", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        tbMHNoDK.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tbMHNoDK);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton2.setBackground(new java.awt.Color(254, 254, 254));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Return.png"))); // NOI18N
        jButton2.setText("Cập nhật trạng thái môn học");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        capNhatTrangThaiMH();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(KetQuaHocTapGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KetQuaHocTapGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KetQuaHocTapGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KetQuaHocTapGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KetQuaHocTapGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tbDiemTrungBinh;
    private javax.swing.JTable tbMHNoDK;
    private javax.swing.JTable tbMHTichLuy;
    private javax.swing.JTable tbMonHocDK;
    // End of variables declaration//GEN-END:variables
}
