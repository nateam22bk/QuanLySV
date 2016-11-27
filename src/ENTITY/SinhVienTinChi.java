package ENTITY;
import java.util.*;
import ENTITY.KhoaVien;
import ENTITY.MonHoc;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kaiser GX
 */
public class SinhVienTinChi extends SinhVien {
   private int hocKi;
   private float diemCPA;
   private float diemGPA;
   private int soTinChiTL;
   private int soTinChiBB;
   private int soTinChiTD;
   private int soTinChiDK = this.soTinChiBB+this.soTinChiTD;
   private boolean totNghiep;
   ArrayList<MonHoc> dsMon;
   ArrayList<LopHoc> dsLopHoc;

    public int getSoTinChiBB() {
        return soTinChiBB;
    }

    public void setSoTinChiBB(int soTinChiBB) {
        this.soTinChiBB = soTinChiBB;
    }

    public int getSoTinChiTD() {
        return soTinChiTD;
    }

    public void setSoTinChiTD(int soTinChiTD) {
        this.soTinChiTD = soTinChiTD;
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

    public ArrayList<LopHoc> getDsLopHoc() {
        return dsLopHoc;
    }

    public void setDsLopHoc(ArrayList<LopHoc> dsLopHoc) {
        this.dsLopHoc = dsLopHoc;
    }

    public int getHocKi() {
        return hocKi;
    }

    public void setHocKi(int hocKi) {
        this.hocKi = hocKi;
    }

    public float getDiemCPA() {
        return diemCPA;
    }

    public void setDiemCPA(float diemCPA) {
        this.diemCPA = diemCPA;
    }

    public float getDiemGPA() {
        return diemGPA;
    }

    public void setDiemGPA(float diemGPA) {
        this.diemGPA = diemGPA;
    }

    public int getSoTinChiTL() {
        return soTinChiTL;
    }

    public void setSoTinChiTL(int soTinChiTL) {
        this.soTinChiTL = soTinChiTL;
    }
    
    /*public void dangKyMon(SinhVienTinChi SV, MonTinChi MH, KhoaVien KV){
        if(KV.dsMonHoc.contains(MH) && KV.dsSinhVien.contains(SV) && (MH.getSoTinChi() + this.soTinChiDK)<=KV.getSO_TC_MAX() && SV.dsMon.containsAll(MH.dsMonDK)){
            this.soTinChiBB = MH.getSoTinChi() + this.soTinChiBB;
            MH.themSinhVien(SV);
        }
        else
        if(!KV.dsMonHoc.contains(MH) && KV.dsSinhVien.contains(SV) && (MH.getSoTinChi() + this.soTinChiDK)<=KV.getSO_TC_MAX() && SV.dsMon.containsAll(MH.dsMonDK)){
            this.soTinChiTD = MH.getSoTinChi() + this.soTinChiTD;
            MH.themSinhVien(SV);
            }
        else
            System.out.println("Dang ky mon that bai");
       
    } */
   
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
