/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITY;

import java.util.*;

/**
 *
 * @author Kaiser GX
 */
public class LopTinChi extends LopHoc{
    ArrayList<SinhVienTinChi> dsSinhVienTC;

    public void themSV(SinhVienTinChi SV) {
        this.dsSinhVienTC.add((SinhVienTinChi)SV);
    }

    public void xoaSV(SinhVienTinChi SV) {
       this.dsSinhVienTC.remove((SinhVienTinChi) SV);
    }
  
}
