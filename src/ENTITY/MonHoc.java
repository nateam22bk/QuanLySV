package ENTITY;
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
public class MonHoc implements Serializable{
    private String maVien;
    private String tenMon;
    private String maMon;
    ArrayList<DiemMonHoc> dsDiem;
    ArrayList<SinhVien> dsSinhVien;

    public String getMaVien() {
        return maVien;
    }

    public void setMaVien(String maVien) {
        this.maVien = maVien;
    }

    public ArrayList<SinhVien> getDsSinhVien() {
        return dsSinhVien;
    }

    public void setDsSinhVien(ArrayList<SinhVien> dsSinhVien) {
        this.dsSinhVien = dsSinhVien;
    }

    public MonHoc(String maVien, String tenMon, String maMon, ArrayList<DiemMonHoc> dsDiem,ArrayList<SinhVien> dsSinhVien) {
        this.maVien = maVien;
        this.tenMon = tenMon;
        this.maMon = maMon;
        this.dsDiem = dsDiem;
        this.dsSinhVien = dsSinhVien;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public ArrayList<DiemMonHoc> getDsDiem() {
        return dsDiem;
    }

    public void setDsDiem(ArrayList<DiemMonHoc> dsDiem) {
        this.dsDiem = dsDiem;
    }

    
    public void inTT (MonHoc MH){
        System.out.println("Ten mon: "+this.tenMon+"\nMa mon: "+this.maMon);
    }
    
    public void themSinhVien(SinhVien SV){
        this.dsSinhVien.add(SV);
    }
    
    public void xoaSinhVien(SinhVien SV){
        this.dsSinhVien.remove(SV);
    }
    
    public void themDiem(DiemMonHoc Diem){
        this.dsDiem.add(Diem);
    }
    
    public void xoaDiem(DiemMonHoc Diem){
        this.dsDiem.remove(Diem);
    }
    
}
