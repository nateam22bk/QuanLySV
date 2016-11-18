/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITY;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class SinhVienNienChe extends SinhVien {
    private int kiHocSo;
    private float diem;
    private boolean totNghiep;
    ArrayList<MonHoc> dsMon;
    ArrayList<LopHoc> dsLopNC;
    
    public int getKiHoc(){
    return kiHocSo;
    }
    public float getDiem(){
    return diem;
    }
    public ArrayList<MonHoc> getMon(){
    return dsMon;
    }
    public ArrayList<LopHoc> getLopNC(){
    return dsLopNC;
    }
    public boolean isTotNghiep(){
    return totNghiep;
    }
    public void setKiHoc(int kiHocSo){
    this.kiHocSo=kiHocSo;
    }
    public void setDiem(float diem){
    this.diem = diem;
    }

    public void setMon(ArrayList<MonHoc> dsMon){
     this.dsMon=dsMon;
    }
    public void setLop(ArrayList<LopHoc> dsLopNC){
    this.dsLopNC=dsLopNC;
    }
    public void setTotNghiep(boolean totNghiep){
    this.totNghiep=totNghiep;
    }
    public void dangkiMon(SinhVienNienChe SV, MonNienChe MC, KhoaVien KV){
      if(KV.dsMonHoc.contains(MC)&& KV.dsSinhVien.contains(SV)&& MC.getKiHocSo()==this.kiHocSo&& SV.dsMon.containsAll(MC.dsMonNC)) MC.themSinhVien(SV);
      else System.out.println("Dang ki mon that bai!");
    }
    @Override
    public void inTT() {
        super.inTT();
        System.out.println("Ban dang hoc o ki:"+this.kiHocSo+"Voi diem trung binh la:"+this.diem);
    }
    @Override
    public void xetTotNghiep(KhoaVien KV) {
       if(KV.dsMonHoc.containsAll(this.dsMon)){ // Khi danh sách môn học của SV đủ so với yêu cầu của khoa thì có thể ra trường
        System.out.println("Da tot nghiep!");
        this.setTotNghiep(true);
       }
           
    }
}
