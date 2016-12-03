/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITY;
import java.util.*;
/**
 *
 * @author Kaiser GX
 */
public class MonNienChe extends MonHoc{
    private int kiHocSo;
    private int donViHocTrinh;

    public MonNienChe(int kiHocSo, String maVien, String tenMon, String maMon, int donViHocTrinh, ArrayList<DiemMonHoc> dsDiem, ArrayList<SinhVien> dsSinhVien, int heSoCK) {
        super(maVien, tenMon, maMon, dsDiem, dsSinhVien, heSoCK);
        this.kiHocSo = kiHocSo;
        this.donViHocTrinh = donViHocTrinh;
    }

    public int getDonViHocTrinh() {
        return donViHocTrinh;
    }

    public void setDonViHocTrinh(int donViHocTrinh) {
        this.donViHocTrinh = donViHocTrinh;
    }

    public int getKiHocSo() {
        return kiHocSo;
    }

    public void setKiHocSo(int kiHocSo) {
        this.kiHocSo = kiHocSo;
    }
}
