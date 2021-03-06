package entity;
import java.io.Serializable;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kaiser GX
 */
public abstract class LopHoc implements Serializable{
    private String maKhoaVien;
    private int maLop;
    private String tenLop;
    private int soSV;
    public static int SO_SV_MAX = 50;

    public LopHoc(String maKhoaVien, int maLop, String tenLop, int soSV) {
        this.maKhoaVien = maKhoaVien;
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.soSV = soSV;
    }
    
    

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    
    
    public String getMaKhoaVien() {
        return maKhoaVien;
    }

    public void setMaKhoaVien(String maKhoaVien) {
        this.maKhoaVien = maKhoaVien;
    }
    

    public int getMaLop() {
        return maLop;
    }

    public void setMaLop(int maLop) {
        this.maLop = maLop;
    }

    public int getSoSV() {
        return soSV;
    }

    public void setSoSV(int soSV) {
        this.soSV = soSV;
    }

    public static int getSO_SV_MAX() {
        return SO_SV_MAX;
    }

    public static void setSO_SV_MAX(int SO_SV_MAX) {
        LopHoc.SO_SV_MAX = SO_SV_MAX;
    }
   public  void themSV(SinhVien sv){
       
   }
   
   public void themSV(String MSSV){
       
   }
   
   public  void xoaSV(String MSSV){
       
   }
   
   public void xoaSV(SinhVien sv){
       
   }
   
   public abstract void capNhatSV(SinhVien sv, String MSSV);
   public abstract boolean dangKiHocTapChoSV(String MSSV, MonHoc monHoc, KhoaVien khoaVien, int hocKi);
   public abstract void capNhatTrangThaiMHChoSV(String MSSV);
   public abstract boolean xetTotNghiepChoSV(String MSSV, KhoaVien khoaVien);
}
