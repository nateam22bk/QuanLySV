
import quanlysv.SinhVien;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kaiser GX
 */
public abstract class LopHoc {
    private String maLop;
    public static int SO_SV_MAX =144;
    public SinhVien danhSachSV[] = new SinhVien[SO_SV_MAX];

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public static int getSO_SV_MAX() {
        return SO_SV_MAX;
    }

    public static void setSO_SV_MAX(int SO_SV_MAX) {
        LopHoc.SO_SV_MAX = SO_SV_MAX;
    }
    
    public abstract void themSV(SinhVien SV);
    public abstract void xoaSV(SinhVien SV);
    
}
