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
    private SinhVien sinhVien;
    private float dienGiuaKy;
    private float heSoGK;
    private float diemCuoiKy;
    private float hesoCK;
    private String diemMonHoc;
    private String tenMon;

    public DiemMonHoc(SinhVien sinhVien, float dienGiuaKy, float heSoGK, float hesoCK, String diemMonHoc, String tenMon) {
        this.sinhVien = sinhVien;
        this.dienGiuaKy = dienGiuaKy;
        this.heSoGK = heSoGK;
        this.hesoCK = hesoCK;
        this.diemMonHoc = diemMonHoc;
        this.tenMon = tenMon;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
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
