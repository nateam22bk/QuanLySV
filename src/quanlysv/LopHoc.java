package quanlysv;
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
public abstract class LopHoc {
    private int maLop;
    ArrayList<SinhVien> dsSinhVien;
    private int soSV;
    public static int SO_SV_MAX;
    

    public int getMaLop() {
        return maLop;
    }

    public void setMaLop(int maLop) {
        this.maLop = maLop;
    }

    public ArrayList<SinhVien> getDsSinhVien() {
        return dsSinhVien;
    }

    public void setDsSinhVien(ArrayList<SinhVien> dsSinhVien) {
        this.dsSinhVien = dsSinhVien;
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
    
    public abstract void themSV(SinhVien SV);
    public abstract void xoaSV(SinhVien SV);
   
}
