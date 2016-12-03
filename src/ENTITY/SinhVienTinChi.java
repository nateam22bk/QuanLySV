package ENTITY;
import java.util.*;
import ENTITY.KhoaVien;
import ENTITY.MonHoc;
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
public class SinhVienTinChi extends SinhVien implements Serializable{
   private float diemCPA;
   private int soTinChiTL;
   private boolean totNghiep;
   ArrayList<MonHoc> dsMon;

    public SinhVienTinChi(ArrayList<MonHoc> dsMon, String MSSV, String hoTen, Date ngaySinh, String queQuan) {
        super(MSSV, hoTen, ngaySinh, queQuan);
        this.dsMon = dsMon;
    }    
    
    

    public boolean isTotNghiep() {
        return totNghiep;
    }

    public void setTotNghiep(boolean totNghiep) {
        this.totNghiep = totNghiep;
    }

    public ArrayList<MonHoc> getDsMon() {
        return dsMon;
    }

    public void setDsMon(ArrayList<MonHoc> dsMon) {
        this.dsMon = dsMon;
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
    
    public boolean dangKyMon( MonHoc monHoc, KhoaVien khoaVien){
        MonTinChi monTinChi = (MonTinChi)monHoc;
        if ((soTinChiTL + monTinChi.getSoTinChi()) <= khoaVien.getSoTCTN()){
            int k = 0; // Đếm số môn học điều kiện đã học
            ArrayList<MonHoc> listMonDK = new ArrayList<>();
            listMonDK = monTinChi.getDsMonDK();
            if (listMonDK.size() == 0){
                dsMon.add(monHoc);
                monHoc.getDsSinhVien().add(this);
                this.soTinChiTL += monTinChi.getSoTinChi();
                return true;
            }
            for (MonHoc monHoc1 : listMonDK) {
                for (MonHoc monHoc2 : dsMon) {
                    if (monHoc1.getMaMon().equals(monHoc2.getMaMon())){
                        k++;
                    }
                }
            }
            
            if (k == listMonDK.size()){
                dsMon.add(monHoc);
                monHoc.getDsSinhVien().add(this);
                this.soTinChiTL += monTinChi.getSoTinChi();
                return true;
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
        System.out.println("So tin chi tich luy: "+this.soTinChiTL);
    }

    @Override
    public void xetTotNghiep(KhoaVien KV) {
        if(this.soTinChiTL >= KV.getSoTCTN() ){
            System.out.println("Da tot nghiep");
            this.setTotNghiep(true);
        }
    }
     
     
}
