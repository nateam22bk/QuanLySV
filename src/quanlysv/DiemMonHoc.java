/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlysv;

/**
 *
 * @author Kaiser GX
 */
public class DiemMonHoc {
    private String tenSinhVien;
    private float dienGiuaKy;
    private float heSoGK;
    private float diemCuoiKy;
    private float hesoCK;
    private String diemMonHoc;
    private String tenMon;

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public float getHeSoGK() {
        return heSoGK;
    }

    public void setHeSoGK(float heSoGK) {
        this.heSoGK = heSoGK;
    }

    public float getHesoCK() {
        return hesoCK;
    }

    public void setHesoCK(float hesoCK) {
        this.hesoCK = hesoCK;
    }

    public DiemMonHoc(String tenSinhVien, float dienGiuaKy, float heSoGK, float diemCuoiKy, float hesoCK, String diemMonHoc, String tenMon) {
        this.tenSinhVien = tenSinhVien;
        this.dienGiuaKy = dienGiuaKy;
        this.heSoGK = heSoGK;
        this.diemCuoiKy = diemCuoiKy;
        this.hesoCK = hesoCK;
        this.diemMonHoc = diemMonHoc;
        this.tenMon = tenMon;
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

    public String getDiemMonHoc() {
        return diemMonHoc;
    }

    public void setDiemMonHoc(String diemMonHoc) {
        this.diemMonHoc = diemMonHoc;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }
    
}
