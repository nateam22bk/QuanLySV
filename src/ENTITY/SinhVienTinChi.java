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

    public SinhVienTinChi(String MSSV, String hoTen, Date ngaySinh, String queQuan) {
        super(MSSV, hoTen, ngaySinh, queQuan);
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
    
    public boolean dangKyMon( MonTinChi monHoc, KhoaVien khoaVien){
        if ((soTinChiTL + monHoc.getSoTinChi()) <= khoaVien.getSoTCTN()){
            return true;
        }else {
            return false;
        }
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
