/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author Kaiser GX
 */
public class DiemMonHoc implements Serializable{
    private SinhVien sinhVien;
    private float dienGiuaKy;
    private float diemCuoiKy;
    private float diemTB;
    private float hesoCK;
    private String tenMon;
    public int hocKi;

    public DiemMonHoc(SinhVien sinhVien, float hesoCK, String tenMon, int hocKi) {
        this.sinhVien = sinhVien;
        this.hesoCK = hesoCK;
        this.tenMon = tenMon;
        this.hocKi = hocKi;
    }

    public float getDiemTB() {
        return diemTB;
    }

    public void setDiemTB() {
        this.diemTB = (hesoCK/10f)*diemCuoiKy + ((10-hesoCK)/10f)*dienGiuaKy;
    }
    
    

    public int getHocKi() {
        return hocKi;
    }

    public void setHocKi(int hocKi) {
        this.hocKi = hocKi;
    }

    

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public float getHesoCK() {
        return hesoCK;
    }

    public void setHesoCK(float hesoCK) {
        this.hesoCK = hesoCK;
    }

    
    public float getDienGiuaKy() {
        return dienGiuaKy;
    }

    public void setDienGiuaKy(float dienGiuaKy) {
        this.dienGiuaKy = dienGiuaKy;
    }

    public float getDiemCuoiKy() {
        return diemCuoiKy;
    }

    public void setDiemCuoiKy(float diemCuoiKy) {
        this.diemCuoiKy = diemCuoiKy;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    @Override
    public String toString() {
        return sinhVien.getHoTen() + "   " + tenMon + " GK : " + dienGiuaKy + "  CK : "+ diemCuoiKy;
    }
    
    
}
