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
public class MonHoc {
    private String tenMon;
    private String maMon;
    private int soTinChi;
    ArrayList<DiemMonHoc> dsDiem;
    ArrayList<LopHoc> dsLopHoc;
    ArrayList<SinhVien> dsSinhVien;

    public ArrayList<LopHoc> getDsLopHoc() {
        return dsLopHoc;
    }

    public void setDsLopHoc(ArrayList<LopHoc> dsLopHoc) {
        this.dsLopHoc = dsLopHoc;
    }

    public ArrayList<SinhVien> getDsSinhVien() {
        return dsSinhVien;
    }

    public void setDsSinhVien(ArrayList<SinhVien> dsSinhVien) {
        this.dsSinhVien = dsSinhVien;
    }

    public MonHoc(String tenMon, String maMon, int soTinChi, ArrayList<DiemMonHoc> dsDiem, ArrayList<LopHoc> dsLopHoc, ArrayList<SinhVien> dsSinhVien) {
        this.tenMon = tenMon;
        this.maMon = maMon;
        this.soTinChi = soTinChi;
        this.dsDiem = dsDiem;
        this.dsLopHoc = dsLopHoc;
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

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

   
    public ArrayList<DiemMonHoc> getDsDiem() {
        return dsDiem;
    }

    public void setDsDiem(ArrayList<DiemMonHoc> dsDiem) {
        this.dsDiem = dsDiem;
    }

    
    public void inTT (MonHoc MH){
        System.out.println("Ten mon: "+this.tenMon+"\nMa mon: "+this.maMon+"\nSo tin chi: "+this.soTinChi);
    }
    
    public void themSinhVien(SinhVien SV){
        this.dsSinhVien.add(SV);
    }
    
    public void xoaSinhVien(SinhVien SV){
        this.dsSinhVien.remove(SV);
    }
    
    public void themLopHoc(LopHoc LH){
        this.dsLopHoc.add(LH);
    }
     
    public void xoaLopHoc(LopHoc LH){
        this.dsLopHoc.remove(LH);
    }
    
    public void themDiem(DiemMonHoc Diem){
        this.dsDiem.add(Diem);
    }
    
    public void xoaDiem(DiemMonHoc Diem){
        this.dsDiem.remove(Diem);
    }
}
