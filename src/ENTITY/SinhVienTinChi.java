package ENTITY;
import java.util.*;
import ENTITY.KhoaVien;
import ENTITY.MonHoc;
import java.io.Serializable;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kaiser GX
 */
public class SinhVienTinChi extends SinhVien implements Serializable{
   private float diemCPA;
   private int soTinChiTL;
   private boolean totNghiep;
   private int soTinChiDK = this.soTinChiBB+this.soTinChiTD;
   private int soTinChiBB;
   private int soTinChiTD;
   ArrayList<MonHoc> dsMonDK; //Mon hoc dang ky ki nay.
   ArrayList<MonHoc> dsMonTL; //Mon hoc da qua.

    public SinhVienTinChi(float diemCPA, int soTinChiTL, boolean totNghiep, int soTinChiBB, int soTinChiTD, ArrayList<MonHoc> dsMon, String MSSV, String hoTen, Date ngaySinh, String queQuan) {
        super(MSSV, hoTen, ngaySinh, queQuan);
        this.diemCPA = diemCPA;
        this.soTinChiTL = soTinChiTL;
        this.totNghiep = totNghiep;
        this.soTinChiBB = soTinChiBB;
        this.soTinChiTD = soTinChiTD;
        this.dsMonDK = dsMon;
    }

    public int getSoTinChiBB() {
        return soTinChiBB;
    }

    public void setSoTinChiBB(int soTinChiBB) {
        this.soTinChiBB = soTinChiBB;
    }

    public int getSoTinChiTD() {
        return soTinChiTD;
    }

    public void setSoTinChiTD(int soTinChiTD) {
        this.soTinChiTD = soTinChiTD;
    }
    public SinhVienTinChi(ArrayList<MonHoc> dsMon, String MSSV, String hoTen, Date ngaySinh, String queQuan) {
        super(MSSV, hoTen, ngaySinh, queQuan);
        this.dsMonDK = dsMon;
    }    
    
    

    public boolean isTotNghiep() {
        return totNghiep;
    }

    public void setTotNghiep(boolean totNghiep) {
        this.totNghiep = totNghiep;
    }

    public ArrayList<MonHoc> getDsMonDK() {
        return dsMonDK;
    }

    public void setDsMonDK(ArrayList<MonHoc> dsMon) {
        this.dsMonDK = dsMon;
    }

    

    public float getDiemCPA() {
        return diemCPA;
    }

    public void setDiemCPA(float diemCPA) {
        this.diemCPA = diemCPA;
    }

    public int getSoTinChiTL() {
        return soTinChiTL;
    }

    public void setSoTinChiTL(int soTinChiTL) {
        this.soTinChiTL = soTinChiTL;
    }
    public boolean dangKyMon(MonTinChi MH, KhoaVien KV){
        if(KV.dsMonHoc.contains(MH) && KV.dsSinhVien.contains(this) && (MH.getSoTinChi() + this.soTinChiDK)<=KV.getTC_DK_MAX() && this.dsMonTL.containsAll(MH.dsMonDK)){
            this.soTinChiBB = MH.getSoTinChi() + this.soTinChiBB;
            MH.themSinhVien(this);
            return true;
        }
        else
        if(!KV.dsMonHoc.contains(MH) && KV.dsSinhVien.contains(this) && (MH.getSoTinChi() + this.soTinChiDK)<=KV.getTC_DK_MAX() && this.dsMonTL.containsAll(MH.dsMonDK)){
            this.soTinChiTD = MH.getSoTinChi() + this.soTinChiTD;
            MH.themSinhVien(this);
            return true;
            }
        else
            return false;
    }
//    public boolean dangKyMon( MonHoc monHoc, KhoaVien khoaVien){
//        MonTinChi monTinChi = (MonTinChi)monHoc;
//        if ((soTinChiTL + monTinChi.getSoTinChi()) <= khoaVien.getSoTCTN()){
//            int k = 0; // Đếm số môn học điều kiện đã học
//            ArrayList<MonHoc> listMonDK = new ArrayList<>();
//            listMonDK = monTinChi.getDsMonDK();
//            if (listMonDK.size() == 0){
//                dsMon.add(monHoc);
//                monHoc.getDsSinhVien().add(this);
//                this.soTinChiTL += monTinChi.getSoTinChi();
//                return true;
//            }
//            for (MonHoc monHoc1 : listMonDK) {
//                for (MonHoc monHoc2 : dsMon) {
//                    if (monHoc1.getMaMon().equals(monHoc2.getMaMon())){
//                        k++;
//                    }
//                }
//            }
//            
//            if (k == listMonDK.size()){
//                dsMon.add(monHoc);
//                monHoc.getDsSinhVien().add(this);
//                this.soTinChiTL += monTinChi.getSoTinChi();
//                return true;
//            }
//            return false;
//        }
//        return false;
//    }
//   
//    /**
//     *
//     */
    @Override
    public void inTT() {
        super.inTT();
        System.out.println("So tin chi tich luy: "+this.soTinChiTL);
    }

    @Override
    public void xetTotNghiep(KhoaVien KV) {
        if(this.soTinChiTL >= KV.getSoTCTN() ){
            System.out.println("Da tot nghiep");
            this.setTotNghiep(true);
        }
    }
     
     
}
