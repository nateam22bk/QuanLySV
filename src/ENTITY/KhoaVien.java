/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITY;
import java.io.Serializable;
import java.util.*;
/**
 *
 * @author Kaiser GX
 */
public class KhoaVien implements Serializable{
    private String maKhoaVien;
    private String tenVien;
    public ArrayList<SinhVien> dsSinhVien;
    public ArrayList<LopHoc> dsLopHoc;
    public ArrayList<MonHoc> dsMonHoc;
    public static int SO_TC_TN;

    public void setMaKhoaVien(String maKhoaVien) {
        this.maKhoaVien = maKhoaVien;
    }

    public String getMaKhoaVien() {
        return maKhoaVien;
    }

    public static int getSO_TC_TN() {
        return SO_TC_TN;
    }

    public static void setSO_TC_TN(int SO_TC_TN) {
        KhoaVien.SO_TC_TN = SO_TC_TN;
    }

    public String getTenVien() {
        return tenVien;
    }

    public void setTenVien(String tenVien) {
        this.tenVien = tenVien;
    }

    public KhoaVien(String maKhoaVien, String tenVien, ArrayList<SinhVien> dsSinhVien, ArrayList<LopHoc> dsLopHoc, ArrayList<MonHoc> dsMonHoc) {
        this.tenVien = tenVien;
        this.dsSinhVien = dsSinhVien;
        this.dsLopHoc = dsLopHoc;
        this.dsMonHoc = dsMonHoc;
        this.maKhoaVien = maKhoaVien;
    }


    public ArrayList<SinhVien> getDsSinhVien() {
        return dsSinhVien;
    }

    public void setDsSinhVien(ArrayList<SinhVien> dsSinhVien) {
        this.dsSinhVien = dsSinhVien;
    }

    public ArrayList<LopHoc> getDsLopHoc() {
        return dsLopHoc;
    }

    public void setDsLopHoc(ArrayList<LopHoc> dsLopHoc) {
        this.dsLopHoc = dsLopHoc;
    }

    public ArrayList<MonHoc> getDsMonHoc() {
        return dsMonHoc;
    }

    public void setDsMonHoc(ArrayList<MonHoc> dsMonHoc) {
        this.dsMonHoc = dsMonHoc;
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
    
}
