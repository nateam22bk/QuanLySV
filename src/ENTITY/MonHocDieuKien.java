/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITY;                //KHONG DUNG DEN
import java.util.*;
/**
 *
 * @author Kaiser GX
 */
public class MonHocDieuKien {
    private MonHoc monDangKy;
    ArrayList<MonHoc> dsMonDK;

    public MonHocDieuKien(MonHoc monDangKy, ArrayList<MonHoc> dsMonDK) {
        this.monDangKy = monDangKy;
        this.dsMonDK = dsMonDK;
    }

    public MonHoc getMonDangKy() {
        return monDangKy;
    }

    public void setMonDangKy(MonHoc monDangKy) {
        this.monDangKy = monDangKy;
    }

    public ArrayList<MonHoc> getDsMonDK() {
        return dsMonDK;
    }

    public void setDsMonDK(ArrayList<MonHoc> dsMonDK) {
        this.dsMonDK = dsMonDK;
    }
    
    public void themMonDK(MonHoc MH){
        this.dsMonDK.add(MH);
    }
    
    public void xoaMonDK(MonHoc MH){
        this.dsMonDK.remove(MH);
    }
    
}
