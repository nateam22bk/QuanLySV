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
public class MonTinChi extends MonHoc {

    ArrayList<MonHoc> dsMonDK;
    private int soTinChi;

    public MonTinChi(ArrayList<MonHoc> dsMonDK, String maVien, String tenMon, String maMon, int soTinChi, ArrayList<DiemMonHoc> dsDiem, ArrayList<SinhVien> dsSinhVien, int heSoCK) {
        super(maVien, tenMon, maMon, dsDiem, dsSinhVien, heSoCK);
        this.dsMonDK = dsMonDK;
        this.soTinChi = soTinChi;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    public ArrayList<MonHoc> getDsMonDK() {
        return dsMonDK;
    }

    public void setDsMonDK(ArrayList<MonHoc> dsMonDK) {
        this.dsMonDK = dsMonDK;
    }

    public void themMonDK(MonHoc MH) {
        this.dsMonDK.add(MH);
    }

    public void xoaMonDK(MonHoc MH) {
        this.dsMonDK.remove(MH);
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
            }catch(Exception e){
                return false;
            }

        }
        return false;
    }

}
