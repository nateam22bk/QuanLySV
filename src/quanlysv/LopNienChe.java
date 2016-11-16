/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlysv;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class LopNienChe extends LopHoc{
    ArrayList<SinhVienNienChe> dsLopNC;
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
