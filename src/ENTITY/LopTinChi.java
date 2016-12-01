/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITY;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Kaiser GX
 */
public class LopTinChi extends LopHoc implements Serializable{
    ArrayList<SinhVienTinChi> dsSinhVienTC;

    public ArrayList<SinhVienTinChi> getDsSinhVienTC() {
        return dsSinhVienTC;
    }

    public void setDsSinhVienTC(ArrayList<SinhVienTinChi> dsSinhVienTC) {
        this.dsSinhVienTC = dsSinhVienTC;
    }
    
    

    public LopTinChi(String maKhoaVien, int maLop, String tenLop, int soSV, ArrayList<SinhVienTinChi> dsSinhVienTC) {
        super(maKhoaVien, maLop, tenLop, soSV);
        this.dsSinhVienTC = dsSinhVienTC;
    }

    @Override
    public void themSV(SinhVien sv) {
        if(sv instanceof SinhVienTinChi){
            this.dsSinhVienTC.add((SinhVienTinChi) sv);
            setSoSV(getSoSV()+1);
        }
    }

    @Override
    public void xoaSV(SinhVien sv) {
         if(sv instanceof SinhVienTinChi){
            this.dsSinhVienTC.remove((SinhVienTinChi) sv);
            setSoSV(getSoSV()-1);
        }
    }
  
}
