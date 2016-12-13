/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicureinterface;

import dataaccesslayer.FileKhoaVien;
import entity.DiemMonHoc;
import entity.KhoaVien;
import entity.LopHoc;
import entity.LopNienChe;
import entity.MonHoc;
import entity.MonNienChe;
import entity.SinhVien;
import entity.SinhVienNienChe;
import static graphicureinterface.KetQuaHocTapTinChiGUI.sv;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tu
 */
public class KetQuaHocTapNienCheGUI extends javax.swing.JFrame {

    /**
     * Creates new form KetQuaHocTapNienCheGUI
     */
    public static SinhVien sv;

    DefaultTableModel tableModelDSMHDangKi;
    DefaultTableModel tableModelDSMHTruot;
    DefaultTableModel tableModelDSMHQua;
    DefaultTableModel tableModelDiemTB;

    public KetQuaHocTapNienCheGUI() {
        this.setVisible(true);
        this.setTitle("Kết quả học tập");
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initTable();
        initContentsOfTalble();
        
    }
    
    public void initContentsOfTalble(){
        showMHDaDat();
        showMHDangKi();
        showMHTruot();
    }

    public void initTable() {
        tableModelDSMHDangKi = new DefaultTableModel();
        tableModelDSMHQua = new DefaultTableModel();
        tableModelDSMHTruot = new DefaultTableModel();
        tableModelDiemTB = new DefaultTableModel();

        tableModelDSMHDangKi.addColumn("Mã MH");
        tableModelDSMHDangKi.addColumn("Tên MH");
        tableModelDSMHDangKi.addColumn("Số ĐVHT");
        tableModelDSMHDangKi.addColumn("Điểm GK");
        tableModelDSMHDangKi.addColumn("Điểm CK");
        tableModelDSMHDangKi.addColumn("Trung Bình");

        tableModelDSMHQua.addColumn("Mã MH");
        tableModelDSMHQua.addColumn("Tên MH");
        tableModelDSMHQua.addColumn("Số ĐVHT");
        tableModelDSMHQua.addColumn("Điểm GK");
        tableModelDSMHQua.addColumn("Điểm CK");
        tableModelDSMHQua.addColumn("Trung Bình");

        tableModelDSMHTruot.addColumn("Mã MH");
        tableModelDSMHTruot.addColumn("Tên MH");
        tableModelDSMHTruot.addColumn("Số ĐVHT");
        tableModelDSMHTruot.addColumn("Điểm GK");
        tableModelDSMHTruot.addColumn("Điểm CK");
        tableModelDSMHTruot.addColumn("Trung Bình");
        
        tableModelDiemTB.addColumn("Tổng số MH");
        tableModelDiemTB.addColumn("Số MH chưa qua");
        tableModelDiemTB.addColumn("Điểm Trung Bình");

        tbDanhSachMHDangKi.setModel(tableModelDSMHDangKi);
        tbDanhSachMHDat.setModel(tableModelDSMHQua);
        tbDanhSachMHTruot.setModel(tableModelDSMHTruot);
        tbDiemTrungBinh.setModel(tableModelDiemTB);

    }
    
    
    public ArrayList<SinhVienNienChe> getListSV(){
        FileKhoaVien fileKhoaVien = new FileKhoaVien();
        ArrayList<KhoaVien> listKhoaVien = new ArrayList<>();
        ArrayList<LopHoc> listLopHoc = new ArrayList<>();
        ArrayList<SinhVienNienChe> listSV = new ArrayList<>();

        listKhoaVien = fileKhoaVien.docFileKhoaVien();

        for (KhoaVien khoaVien : listKhoaVien) {
            if (khoaVien.getTenVien().equals(sv.getTenVien())) {
                listLopHoc = khoaVien.getDsLopHoc();
                break;
            }
        }

        for (LopHoc lopHoc : listLopHoc) {
            if (lopHoc.getTenLop().equals(sv.getTenLop())) {
                if (lopHoc instanceof LopNienChe) {
                    LopNienChe lopNienChe = (LopNienChe) lopHoc;
                    listSV = lopNienChe.getDsLopNC();
                    break;
                }
            }
        }
        return listSV;
    }
    
    public void showMHTruot(){
        tableModelDSMHTruot.setNumRows(0);
        
        ArrayList<SinhVienNienChe> listSV = new ArrayList<>();
        ArrayList<MonHoc> listMonHoc = new ArrayList<>();
        listSV = getListSV();
        
        for (SinhVienNienChe sinhVienNienChe : listSV) {
            if (sinhVienNienChe.getMaSV().equals(sv.getMaSV())) {
                listMonHoc = sinhVienNienChe.getDsMonTruot();
                break;
            }
        }

        ArrayList<Vector<String>> listRowData = new ArrayList<>();

        for (MonHoc monHoc : listMonHoc) {
            MonNienChe monNienChe = null;
            if (monHoc instanceof MonNienChe) {
                monNienChe = (MonNienChe) monHoc;
            }
            ArrayList<DiemMonHoc> bangDiem = new ArrayList<>();
            bangDiem = monHoc.getDsDiem();

            Vector<String> dataRow = new Vector<>();
            dataRow.add(monHoc.getMaMon());
            dataRow.add(monHoc.getTenMon());
            dataRow.add(String.valueOf(monNienChe.getDonViHocTrinh()));
            for (DiemMonHoc diemMonHoc : bangDiem) {
                if (diemMonHoc.getSinhVien().getMaSV().equals(sv.getMaSV())) {
                    dataRow.add(String.valueOf(diemMonHoc.getDienGiuaKy()));
                    dataRow.add(String.valueOf(diemMonHoc.getDiemCuoiKy()));
                    dataRow.add(String.valueOf(diemMonHoc.getDiemTB()));
                    break;
                }
                
            }
            listRowData.add(dataRow);
        }
        for (Vector<String> vector : listRowData) {
            tableModelDSMHTruot.addRow(vector);
        }
    }
    
    public void showMHDaDat(){
        tableModelDSMHQua.setNumRows(0);

       
        ArrayList<MonHoc> listMonHoc = new ArrayList<>();
        ArrayList<SinhVienNienChe> listSV = new ArrayList<>();
        
        listSV = getListSV();
        
        for (SinhVienNienChe sinhVienNienChe : listSV) {
            if (sinhVienNienChe.getMaSV().equals(sv.getMaSV())) {
                listMonHoc = sinhVienNienChe.getDsMonDaQua();
            }
        }

        ArrayList<Vector<String>> listRowData = new ArrayList<>();

        for (MonHoc monHoc : listMonHoc) {
            MonNienChe monNienChe = null;
            if (monHoc instanceof MonNienChe) {
                monNienChe = (MonNienChe) monHoc;
            }
            ArrayList<DiemMonHoc> bangDiem = new ArrayList<>();
            bangDiem = monHoc.getDsDiem();

            Vector<String> dataRow = new Vector<>();
            dataRow.add(monHoc.getMaMon());
            dataRow.add(monHoc.getTenMon());
            dataRow.add(String.valueOf(monNienChe.getDonViHocTrinh()));
            for (DiemMonHoc diemMonHoc : bangDiem) {
                if (diemMonHoc.getSinhVien().getMaSV().equals(sv.getMaSV())) {
                    dataRow.add(String.valueOf(diemMonHoc.getDienGiuaKy()));
                    dataRow.add(String.valueOf(diemMonHoc.getDiemCuoiKy()));
                    dataRow.add(String.valueOf(diemMonHoc.getDiemTB()));
                    break;
                }
                
            }
            listRowData.add(dataRow);
        }
        for (Vector<String> vector : listRowData) {
            tableModelDSMHQua.addRow(vector);
        }
    }

    public void showMHDangKi() {
        tableModelDSMHDangKi.setNumRows(0);

        
        ArrayList<MonHoc> listMonHoc = new ArrayList<>();
        ArrayList<SinhVienNienChe> listSV = new ArrayList<>();
        
        listSV = getListSV();

        for (SinhVienNienChe sinhVienNienChe : listSV) {
            if (sinhVienNienChe.getMaSV().equals(sv.getMaSV())) {
                listMonHoc = sinhVienNienChe.getDsMonDangKi();
                break;
            }
        }

        ArrayList<Vector<String>> listRowData = new ArrayList<>();

        for (MonHoc monHoc : listMonHoc) {
            MonNienChe monNienChe = null;
            if (monHoc instanceof MonNienChe) {
                monNienChe = (MonNienChe) monHoc;
            }
            ArrayList<DiemMonHoc> bangDiem = new ArrayList<>();
            bangDiem = monHoc.getDsDiem();

            Vector<String> dataRow = new Vector<>();
            dataRow.add(monHoc.getMaMon());
            dataRow.add(monHoc.getTenMon());
            dataRow.add(String.valueOf(monNienChe.getDonViHocTrinh()));
            for (DiemMonHoc diemMonHoc : bangDiem) {
                if (diemMonHoc.getSinhVien().getMaSV().equals(sv.getMaSV())) {
                    dataRow.add(String.valueOf(diemMonHoc.getDienGiuaKy()));
                    dataRow.add(String.valueOf(diemMonHoc.getDiemCuoiKy()));
                    dataRow.add(String.valueOf(diemMonHoc.getDiemTB()));
                    break;
                }
                
            }
            listRowData.add(dataRow);
        }
        for (Vector<String> vector : listRowData) {
            tableModelDSMHDangKi.addRow(vector);
        }
    }
    
    // Hien thi bang diem trung binh
    public void showDiemTrungBinh(){
        ArrayList<SinhVienNienChe> listSV = new ArrayList<>();
        ArrayList<MonHoc> listMonHocDaQua = new ArrayList<>();
        ArrayList<MonHoc> listMonHocTruot = new ArrayList<>();
        
        listSV = getListSV();
        
        for (SinhVienNienChe sinhVienNienChe : listSV) {
            if (sinhVienNienChe.getMaSV().equals(sv.getMaSV())){
                listMonHocDaQua = sinhVienNienChe.getDsMonDaQua();
                listMonHocTruot = sinhVienNienChe.getDsMonTruot();
                break;
            }
        }
        
        int soMonQua = listMonHocDaQua.size();
        int soMonTruot = listMonHocTruot.size();
        
        float tongDiem = 0f;
        int tongDVHocTrinh = 0;
        
        for (MonHoc monHoc : listMonHocTruot) {
            MonNienChe monNienChe = (MonNienChe)monHoc;
            ArrayList<DiemMonHoc> bangDiem = new ArrayList<>();
            bangDiem = monHoc.getDsDiem();
            for (DiemMonHoc diemMonHoc : bangDiem) {
                if (diemMonHoc.getSinhVien().getMaSV().equals(sv.getMaSV())){
                    tongDiem += monNienChe.getDonViHocTrinh()*diemMonHoc.getDiemTB();
                    tongDVHocTrinh += monNienChe.getDonViHocTrinh();
                    break;
                }
            }
        }
        
        for (MonHoc monHoc : listMonHocDaQua) {
            MonNienChe monNienChe = (MonNienChe)monHoc;
            ArrayList<DiemMonHoc> bangDiem = new ArrayList<>();
            bangDiem = monHoc.getDsDiem();
            for (DiemMonHoc diemMonHoc : bangDiem) {
                if (diemMonHoc.getSinhVien().getMaSV().equals(sv.getMaSV())){
                    tongDiem += monNienChe.getDonViHocTrinh()*diemMonHoc.getDiemTB();
                    tongDVHocTrinh += monNienChe.getDonViHocTrinh();
                    break;
                }
            }
        }
        
        Vector<String> dataRow = new Vector<>();
        dataRow.add(String.valueOf(soMonQua+soMonTruot));
        dataRow.add(String.valueOf(soMonTruot));
        dataRow.add(String.valueOf(tongDiem/tongDVHocTrinh));
        
        tableModelDiemTB.addRow(dataRow);
        
    }
    

    public void capNhatTrangThaiMH() {
        FileKhoaVien fileKhoaVien = new FileKhoaVien();
        ArrayList<KhoaVien> listKhoaVien = new ArrayList<>();
        listKhoaVien = fileKhoaVien.docFileKhoaVien();
        ArrayList<LopHoc> listLopHoc = new ArrayList<>();

        int kvIndex = 0;
        int lhIndex = 0;

        for (int i = 0; i < listKhoaVien.size(); i++) {
            if (listKhoaVien.get(i).getTenVien().equals(sv.getTenVien())) {
                kvIndex = i;
                listLopHoc = listKhoaVien.get(i).getDsLopHoc();
            }
        }

        for (int i = 0; i < listLopHoc.size(); i++) {
            if (listLopHoc.get(i).getTenLop().equals(sv.getTenLop())) {
                lhIndex = i;
            }
        }

        listKhoaVien.get(kvIndex).getDsLopHoc().get(lhIndex).capNhatTrangThaiMHChoSV(sv.getMaSV());
        fileKhoaVien.ghiFileKhoaVien(listKhoaVien);
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
        btnThoat = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDanhSachMHDangKi = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDanhSachMHTruot = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbDanhSachMHDat = new javax.swing.JTable();
        btnCapNhatTranThai = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbDiemTrungBinh = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jPanel2.setBackground(new java.awt.Color(254, 253, 132));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bk.jpg"))); // NOI18N

        btnThoat.setBackground(new java.awt.Color(254, 254, 254));
        btnThoat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logout-512.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
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
                .addGap(195, 195, 195)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel1)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnThoat)
                .addComponent(jLabel2))
        );

        jPanel3.setBackground(new java.awt.Color(254, 254, 254));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách đăng kí", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        tbDanhSachMHDangKi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbDanhSachMHDangKi);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(254, 254, 254));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách MH chưa qua", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        tbDanhSachMHTruot.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbDanhSachMHTruot);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(254, 254, 254));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách MH đã đạt", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        tbDanhSachMHDat.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbDanhSachMHDat);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCapNhatTranThai.setBackground(new java.awt.Color(254, 254, 254));
        btnCapNhatTranThai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnCapNhatTranThai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Return.png"))); // NOI18N
        btnCapNhatTranThai.setText("Cập nhật trạng thái môn học");
        btnCapNhatTranThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatTranThaiActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(254, 254, 254));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Điểm trung bình", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18), new java.awt.Color(255, 0, 0))); // NOI18N

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
        jScrollPane4.setViewportView(tbDiemTrungBinh);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCapNhatTranThai, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCapNhatTranThai)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnCapNhatTranThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatTranThaiActionPerformed
        // TODO add your handling code here:
        capNhatTrangThaiMH();
        initContentsOfTalble();
        showDiemTrungBinh();
    }//GEN-LAST:event_btnCapNhatTranThaiActionPerformed

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
            java.util.logging.Logger.getLogger(KetQuaHocTapNienCheGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KetQuaHocTapNienCheGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KetQuaHocTapNienCheGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KetQuaHocTapNienCheGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KetQuaHocTapNienCheGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhatTranThai;
    private javax.swing.JButton btnThoat;
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
    private javax.swing.JTable tbDanhSachMHDangKi;
    private javax.swing.JTable tbDanhSachMHDat;
    private javax.swing.JTable tbDanhSachMHTruot;
    private javax.swing.JTable tbDiemTrungBinh;
    // End of variables declaration//GEN-END:variables
}
