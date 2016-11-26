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
public class LopNienChe extends LopHoc{
    ArrayList<SinhVienNienChe> dsLopNC;

    public LopNienChe(String maKhoaVien, int maLop, String tenLop, int soSV, ArrayList<SinhVienNienChe> dsLopNC) {
        super(maKhoaVien, maLop, tenLop, soSV);
        this.dsLopNC = dsLopNC;
    }
    @Override
    public void themSV(SinhVien SV) {
      if(SV instanceof SinhVienNienChe){
      this.dsLopNC.add((SinhVienNienChe) SV);}
    }

    @Override
    public void xoaSV(SinhVien SV) {
      if(SV instanceof SinhVienNienChe){
      this.dsLopNC.remove((SinhVienNienChe)SV);
      }
    }
    
}
