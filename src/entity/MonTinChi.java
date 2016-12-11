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
public class MonTinChi extends MonHoc{
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
    
    public void themMonDK(MonHoc MH){
        this.dsMonDK.add(MH);
    }
    
    public void xoaMonDK(MonHoc MH){
        this.dsMonDK.remove(MH);
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