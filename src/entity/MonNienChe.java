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
public class MonNienChe extends MonHoc {

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
    public boolean nhapDiem(ArrayList<Vector<String>> bangDiem) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for (int i = 0; i < dsDiem.size(); i++) {
            String diemGiuaKiStr = bangDiem.get(i).get(2);
            String diemCuoiKiStr = bangDiem.get(i).get(3);
            Float diemGiuaKi = 0f;
            Float diemCuoiKi = 0f;
            try {
                diemGiuaKi = Float.parseFloat(diemGiuaKiStr);
                diemCuoiKi = Float.parseFloat(diemCuoiKiStr);
                dsDiem.get(i).setDienGiuaKy(diemGiuaKi);
                dsDiem.get(i).setDiemCuoiKy(diemCuoiKi);
                dsDiem.get(i).setDiemTB();
                return true;
            } catch (Exception e) {
                return false;
            }

        }
        return false;
    }

}
