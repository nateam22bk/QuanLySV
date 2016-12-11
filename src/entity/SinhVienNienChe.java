/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Dell
 */
public class SinhVienNienChe extends SinhVien implements Serializable{
    private float diem;
    private boolean totNghiep;
    ArrayList<MonHoc> dsMonDangKi;
    ArrayList<MonHoc> dsMonDaQua;
    ArrayList<MonHoc> dsMonTruot;

    public SinhVienNienChe(String MSSV, String hoTen, Date ngaySinh, String queQuan) {
        super(MSSV, hoTen, ngaySinh, queQuan);
        this.dsMonDangKi = new ArrayList<>();
        this.dsMonDaQua = new ArrayList<>();
        this.dsMonTruot = new ArrayList<>();
    }
    
    
    public float getDiem(){
    return diem;
    }

    public ArrayList<MonHoc> getDsMonDangKi() {
        return dsMonDangKi;
    }

    public ArrayList<MonHoc> getDsMonDaQua() {
        return dsMonDaQua;
    }

    public ArrayList<MonHoc> getDsMonTruot() {
        return dsMonTruot;
    }

    public void setDsMonDangKi(ArrayList<MonHoc> dsMonDangKi) {
        this.dsMonDangKi = dsMonDangKi;
    }

    public void setDsMonDaQua(ArrayList<MonHoc> dsMonDaQua) {
        this.dsMonDaQua = dsMonDaQua;
    }

    public void setDsMonTruot(ArrayList<MonHoc> dsMonTruot) {
        this.dsMonTruot = dsMonTruot;
    }
    
    
    
    public boolean isTotNghiep(){
    return totNghiep;
    }
    
    public void setDiem(float diem){
    this.diem = diem;
    }

    
    
    public void setTotNghiep(boolean totNghiep){
    this.totNghiep=totNghiep;
    }
    
    public boolean dangKiMon(MonHoc monHoc){
        if (monHoc instanceof MonNienChe){
            MonNienChe monNienChe = (MonNienChe)monHoc;
            dsMonDangKi.add(monHoc);
            return true;
        }else {
            return false;
        }
    }
    
    @Override
    public void inTT() {
        super.inTT();
        //System.out.println("Ban dang hoc o ki:"+this.kiHocSo+"Voi diem trung binh la:"+this.diem);
    }
    @Override
    public void xetTotNghiep(KhoaVien KV) {
       
           
    }

    @Override
    public void capNhatTrangThaiMH() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
