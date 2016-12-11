package entity;

import java.util.*;
import entity.KhoaVien;
import entity.MonHoc;
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kaiser GX
 */
public class SinhVienTinChi extends SinhVien implements Serializable {

    private float diemCPA;
    private int soTinChiTL;
    private int soTinChiTD;
    private boolean totNghiep;
    ArrayList<MonHoc> dsMonDangKi = new ArrayList<>();
    ArrayList<MonHoc> dsMonNoDangKi = new ArrayList<>();
    ArrayList<MonHoc> dsMonTichLuy = new ArrayList<>();

    public SinhVienTinChi(ArrayList<MonHoc> dsMonDangKi, String MSSV, String hoTen, Date ngaySinh, String queQuan) {
        super(MSSV, hoTen, ngaySinh, queQuan);
        this.dsMonDangKi = dsMonDangKi;
    }

    public boolean isTotNghiep() {
        return totNghiep;
    }

    public void setTotNghiep(boolean totNghiep) {
        this.totNghiep = totNghiep;
    }

    public int getSoTinChiTD() {
        return soTinChiTD;
    }

    public ArrayList<MonHoc> getDsMonDangKi() {
        return dsMonDangKi;
    }

    public ArrayList<MonHoc> getDsMonNoDangKi() {
        return dsMonNoDangKi;
    }

    public ArrayList<MonHoc> getDsMonTichLuy() {
        return dsMonTichLuy;
    }

    public void setSoTinChiTD(int soTinChiTD) {
        this.soTinChiTD = soTinChiTD;
    }

    public void setDsMonDangKi(ArrayList<MonHoc> dsMonDangKi) {
        this.dsMonDangKi = dsMonDangKi;
    }

    public void setDsMonNoDangKi(ArrayList<MonHoc> dsMonNoDangKi) {
        this.dsMonNoDangKi = dsMonNoDangKi;
    }

    public void setDsMonTichLuy(ArrayList<MonHoc> dsMonTichLuy) {
        this.dsMonTichLuy = dsMonTichLuy;
    }

    public float getDiemCPA() {
        return diemCPA;
    }

    public void setDiemCPA(float diemCPA) {
        this.diemCPA = diemCPA;
    }

    public int getSoTinChiTL() {
        return soTinChiTL;
    }

    public void setSoTinChiTL(int soTinChiTL) {
        this.soTinChiTL = soTinChiTL;
    }

    public boolean dangKyMon(MonHoc monHoc, KhoaVien khoaVien) {
        MonTinChi monTinChi = (MonTinChi) monHoc;
        if ((soTinChiTL + monTinChi.getSoTinChi()) <= khoaVien.getSoTCMax()) {
            int k = 0; // Đếm số môn học điều kiện đã học
            ArrayList<MonHoc> listMonDK = new ArrayList<>();
            listMonDK = monTinChi.getDsMonDK();
            for (MonHoc monHoc1 : dsMonTichLuy) {
                if (monHoc1.getMaMon().equals(monHoc.getMaMon())){
                    return false;
                }
            }
            if (listMonDK.size() == 0) {

                if (monHoc.getLaMonTuChon() == 1) {
                    monHoc.setLaMonTuChon(0);
                    if (soTinChiTD <= khoaVien.getSoTCTC()) {
                        soTinChiTD = soTinChiTD + monTinChi.getSoTinChi();
                        dsMonDangKi.add(monHoc);
                        monHoc.getDsSinhVien().add(this);
                        this.soTinChiTL += monTinChi.getSoTinChi();
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    dsMonDangKi.add(monHoc);
                    monHoc.getDsSinhVien().add(this);
                    this.soTinChiTL += monTinChi.getSoTinChi();
                    return true;
                }

            }
            for (MonHoc monHoc1 : listMonDK) {
                for (MonHoc monHoc2 : dsMonTichLuy) {
                    if (monHoc1.getMaMon().equals(monHoc2.getMaMon())) {
                        k++;
                    }
                }
            }

            if (k == listMonDK.size()) {
                if (monHoc.getLaMonTuChon() == 1) {
                    monHoc.setLaMonTuChon(0);
                    if (soTinChiTD <= khoaVien.getSoTCTC()) {
                        soTinChiTD = soTinChiTD + monTinChi.getSoTinChi();
                        dsMonDangKi.add(monHoc);
                        monHoc.getDsSinhVien().add(this);
                        this.soTinChiTL += monTinChi.getSoTinChi();
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    dsMonDangKi.add(monHoc);
                    monHoc.getDsSinhVien().add(this);
                    this.soTinChiTL += monTinChi.getSoTinChi();
                    return true;
                }

            }
            return false;
        }
        return false;
    }

    /**
     *
     */
    @Override
    public void inTT() {
        super.inTT();
        System.out.println("So tin chi tich luy: " + this.soTinChiTL);
    }

    @Override
    public void xetTotNghiep(KhoaVien KV) {
        if (this.soTinChiTL >= KV.getSoTCTN()) {
            this.setTotNghiep(true);
        }
    }

    @Override
    public void capNhatTrangThaiMH() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for (int i = 0; i< dsMonDangKi.size(); i++){
            MonHoc monHoc = dsMonDangKi.get(i);
            ArrayList<DiemMonHoc> bangDiem = new ArrayList<>();
            bangDiem = monHoc.getDsDiem();
            for (DiemMonHoc diemMonHoc : bangDiem) {
                if (diemMonHoc.getSinhVien().getMaSV().equals(this.getMaSV())){
                    if (diemMonHoc.getDiemCuoiKy() >=4.0f){
                        dsMonTichLuy.add(dsMonDangKi.get(i));
                        dsMonDangKi.remove(i);
                    }else {
                        dsMonNoDangKi.add(dsMonDangKi.get(i));
                        dsMonDangKi.remove(i);
                    }
                }
            }
        }
    }

}
