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
    ArrayList<MonHoc> dsMon;

    public SinhVienNienChe(ArrayList<MonHoc> dsMon, String MSSV, String hoTen, Date ngaySinh, String queQuan) {
        super(MSSV, hoTen, ngaySinh, queQuan);
        this.dsMon = dsMon;
    }
    
    
    public float getDiem(){
    return diem;
    }
    public ArrayList<MonHoc> getMon(){
    return dsMon;
    }
    
    public boolean isTotNghiep(){
    return totNghiep;
    }
    
    public void setDiem(float diem){
    this.diem = diem;
    }

    public void setMon(ArrayList<MonHoc> dsMon){
     this.dsMon=dsMon;
    }
    
    public void setTotNghiep(boolean totNghiep){
    this.totNghiep=totNghiep;
    }
    
    public void dangKiMon(MonHoc monHoc){
        MonNienChe monNienChe = (MonNienChe)monHoc;
        dsMon.add(monNienChe);
    }
    
    @Override
    public void inTT() {
        super.inTT();
        //System.out.println("Ban dang hoc o ki:"+this.kiHocSo+"Voi diem trung binh la:"+this.diem);
    }
    @Override
    public void xetTotNghiep(KhoaVien KV) {
       if(KV.dsMonHoc.containsAll(this.dsMon)){ // Khi danh sách môn học của SV đủ so với yêu cầu của khoa thì có thể ra trường
        System.out.println("Da tot nghiep!");
        this.setTotNghiep(true);
       }
           
    }
}
