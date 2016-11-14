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
public class MonNienChe {
    private int kiHocSo;
    ArrayList<MonHoc> dsMonNC; 

    public int getKiHocSo() {
        return kiHocSo;
    }

    public void setKiHocSo(int kiHocSo) {
        this.kiHocSo = kiHocSo;
    }

    public void themMonNC(MonHoc MH){
       this.dsMonNC.add(MH);
    }
    public void xoaMonNC(MonHoc MH){
        this.dsMonNC.remove(MH);
    }
}
