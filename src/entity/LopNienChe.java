/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
      this.dsLopNC.add((SinhVienNienChe) SV);
          setSoSV(getSoSV() + 1);
      }
    }

    @Override
    public void xoaSV(String MSSV) {
      for (int i = 0; i< dsLopNC.size(); i++){
             if (dsLopNC.get(i).getMaSV().equals(MSSV)){
                 dsLopNC.remove(i);
                 setSoSV(getSoSV() - 1);
             }
         }
    }

    @Override
    public void xoaSV(SinhVien sv) {
        super.xoaSV(sv); //To change body of generated methods, choose Tools | Templates.
        dsLopNC.remove(sv);
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

    @Override
    public boolean dangKiHocTapChoSV(String MSSV, MonHoc monHoc, KhoaVien khoaVien, int hocKi) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       for (int i = 0; i< dsLopNC.size(); i++){
           if (dsLopNC.get(i).getMaSV().equals(MSSV)){
               if (dsLopNC.get(i).dangKiMon(monHoc)){
                   DiemMonHoc diemMonHoc = new DiemMonHoc(dsLopNC.get(i), monHoc.getHeSoCK(), monHoc.getTenMon(), hocKi);
                   monHoc.getDsDiem().add(diemMonHoc);
                   monHoc.getDsSinhVien().add(dsLopNC.get(i));
                   return true;
               }
           }
       }
       return false;
    }

    @Override
    public void capNhatTrangThaiMHChoSV(String MSSV) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for (int i = 0; i< dsLopNC.size(); i++){
            if (dsLopNC.get(i).getMaSV().equals(MSSV)){
                dsLopNC.get(i).capNhatTrangThaiMH();
            }
        }
    }

    @Override
    public boolean xetTotNghiepChoSV(String MSSV, KhoaVien khoaVien) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       for (int i = 0; i< dsLopNC.size(); i++){
           if (dsLopNC.get(i).getMaSV().equals(MSSV)){
               dsLopNC.get(i).xetTotNghiep(khoaVien);
               if (dsLopNC.get(i).isTotNghiep()){
                   return true;
               }
               return false;
           }
       }
       return false;
    }
    
}
