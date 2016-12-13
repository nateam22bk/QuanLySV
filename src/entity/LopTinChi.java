/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
    public void xoaSV(String MSSV) {
         for (int i = 0; i< dsSinhVienTC.size(); i++){
             if (dsSinhVienTC.get(i).getMaSV().equals(MSSV)){
                 dsSinhVienTC.remove(i);
                 setSoSV(getSoSV() - 1);
             }
         }
    }

    @Override
    public void xoaSV(SinhVien sv) {
        super.xoaSV(sv); //To change body of generated methods, choose Tools | Templates.
        dsSinhVienTC.remove(sv);
    }
    
    

    @Override
    public void capNhatSV(SinhVien sv, String MSSV) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for (int i = 0; i< dsSinhVienTC.size(); i++){
            if (dsSinhVienTC.get(i).getMaSV().equals(MSSV)){
                dsSinhVienTC.get(i).setMaSV(sv.getMaSV());
                dsSinhVienTC.get(i).setHoTen(sv.getHoTen());
                dsSinhVienTC.get(i).setNgaySinh(sv.getNgaySinh());
                dsSinhVienTC.get(i).setQueQuan(sv.getQueQuan());
            }
        }
    }

    @Override
    public boolean dangKiHocTapChoSV(String MSSV, MonHoc monHoc, KhoaVien khoaVien, int hocKi) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for(int i = 0; i< dsSinhVienTC.size(); i++){
           if (dsSinhVienTC.get(i).getMaSV().equals(MSSV)){
               if(dsSinhVienTC.get(i).dangKyMon(monHoc, khoaVien)){
                   DiemMonHoc diem = new DiemMonHoc(dsSinhVienTC.get(i), monHoc.getHeSoCK(), monHoc.getTenMon(), hocKi);
                   diem.setHesoCK(monHoc.getHeSoCK());
                   monHoc.getDsDiem().add(diem);
                   monHoc.getDsSinhVien().add(dsSinhVienTC.get(i));
                   return true;
               }
               return false;
           }
        }
        return false;
    }
    
    public void capNhatTrangThaiMHChoSV(String MSSV){
        for (int i = 0; i< dsSinhVienTC.size(); i++){
            if (dsSinhVienTC.get(i).getMaSV().equals(MSSV)){
                dsSinhVienTC.get(i).capNhatTrangThaiMH();
            }
        }
    }

    @Override
    public boolean xetTotNghiepChoSV(String MSSV, KhoaVien khoaVien) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for (int i = 0; i< dsSinhVienTC.size(); i++){
            if (dsSinhVienTC.get(i).getMaSV().equals(MSSV)){
                dsSinhVienTC.get(i).xetTotNghiep(khoaVien);
                if (dsSinhVienTC.get(i).isTotNghiep()){
                    return true;
                }
                return false;
            }
        }
        return false;
    }
  
}
