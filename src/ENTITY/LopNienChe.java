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

    public ArrayList<SinhVienNienChe> getDsLopNC() {
        return dsLopNC;
    }

    public void setDsLopNC(ArrayList<SinhVienNienChe> dsLopNC) {
        this.dsLopNC = dsLopNC;
    }
    
    

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
    public void xoaSV(String MSSV) {
      for (int i = 0; i< dsLopNC.size(); i++){
             if (dsLopNC.get(i).getMaSV().equals(MSSV)){
                 dsLopNC.remove(i);
             }
         }
    }

    @Override
    public void capNhatSV(SinhVien sv, String MSSV) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for (int i = 0; i< dsLopNC.size(); i++){
            if (dsLopNC.get(i).getMaSV().equals(MSSV)){
                dsLopNC.get(i).setMaSV(sv.getMaSV());
                dsLopNC.get(i).setHoTen(sv.getHoTen());
                dsLopNC.get(i).setNgaySinh(sv.getNgaySinh());
                dsLopNC.get(i).setQueQuan(sv.getQueQuan());
            }
        }
    }

//    @Override
//    public void dangKiHocTap(String MSSV, MonHoc monHoc, KhoaVien khoaVien, int hocKi) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
}
