/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBA;

import ENTITY.DiemMonHoc;
import ENTITY.KhoaVien;
import ENTITY.LopTinChi;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author tu
 */
public class FileBangDiem {
    File f = new File("BANGDIEM.DAT");
    
    public  void ghiFileBangDiem(java.util.ArrayList<DiemMonHoc> list){
        try {
            if(!(f.exists()))
                f.createNewFile();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(list);
            oos.close();
        }catch(Exception e){
            return;
        }
    }
    
    public java.util.ArrayList<DiemMonHoc> docFileBangDiem(){
        java.util.ArrayList<DiemMonHoc> list = new java.util.ArrayList<>();
        try {
            if (!(f.exists()))
                return list;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            list = (java.util.ArrayList<DiemMonHoc>)ois.readObject();
            ois.close();
        }catch (Exception e){
            return list;
        }
        return list;
    }
    
    public static void main(String[] args) {
        java.util.ArrayList<DiemMonHoc> diem = new FileBangDiem().docFileBangDiem();
        System.out.println(diem.get(0).toString());
    }
}
