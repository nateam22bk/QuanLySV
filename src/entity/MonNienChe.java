/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
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

    @Override
    public void nhapDiem(ArrayList<Vector<String>> bangDiem) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for(int i = 0; i< dsDiem.size(); i++){
            dsDiem.get(i).setDienGiuaKy(Float.parseFloat(bangDiem.get(i).get(2)));
            dsDiem.get(i).setDiemCuoiKy(Float.parseFloat(bangDiem.get(i).get(3)));
            dsDiem.get(i).setDiemTB();
        }
    }
}
