 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITY;

import java.util.Date;

/**
 *
 * @author Kaiser GX
 */
public abstract class SinhVien {
    private int MSSV;
    private String hoTen;
    private Date ngaySinh;
    private String queQuan;
    private String tenVien;

    public String getTenVien() {
        return tenVien;
    }

    public void setTenVien(String tenVien) {
        this.tenVien = tenVien;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getQueQuan() {
        return queQuan;
    }
    

    public int getMSSV() {
        return MSSV;
    }

    public void setMSSV(int MSSV) {
        this.MSSV = MSSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
    public void inTT(){
        System.out.println("Ten sinh vien: "+ this.hoTen);
    };
    public abstract void xetTotNghiep(KhoaVien KV);
}
