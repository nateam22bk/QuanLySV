 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Kaiser GX
 */
public abstract class SinhVien implements Serializable{
    private String maSV;
    private String hoTen;
    private Date ngaySinh;
    private String queQuan;
    private String tenVien;
    private String tenLop;

    public SinhVien(String MSSV, String hoTen, Date ngaySinh, String queQuan) {
        this.maSV = MSSV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }
    
    

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

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
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
    public abstract void capNhatTrangThaiMH();
}
