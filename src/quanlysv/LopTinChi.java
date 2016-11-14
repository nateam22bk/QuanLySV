/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlysv;

import java.util.*;

/**
 *
 * @author Kaiser GX
 */
public class LopTinChi extends LopHoc{
    ArrayList<SinhVienTinChi> dsSinhVienTC;

    @Override
    public void themSV(SinhVien SV) {
        if(SV instanceof SinhVienTinChi)
            this.dsSinhVienTC.add((SinhVienTinChi)SV);
    }

    @Override
    public void xoaSV(SinhVien SV) {
        if(SV instanceof SinhVienTinChi)
            this.dsSinhVienTC.remove((SinhVienTinChi) SV);
    }

    
 
    
}
