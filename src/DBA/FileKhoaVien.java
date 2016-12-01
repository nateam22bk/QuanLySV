/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBA;

import ENTITY.KhoaVien;
import ENTITY.LopHoc;
import ENTITY.LopTinChi;
import ENTITY.SinhVien;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.text.html.parser.Entity;

/**
 *
 * @author tu
 */
public class FileKhoaVien {
    File f = new File("KHOAVIEN.DAT");
    
    public  void ghiFileKhoaVien(ArrayList<KhoaVien> list){
        try {
            if(!(f.exists()))
                f.createNewFile();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(list);
            oos.close();
        }catch(Exception e){
            
        }
    }
    
    public ArrayList<KhoaVien> docFileKhoaVien(){
        ArrayList<KhoaVien> list = new ArrayList<>();
        try {
            if (!(f.exists()))
                return list;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            list = (ArrayList<KhoaVien>)ois.readObject();
            ois.close();
        }catch (Exception e){
            
        }
        return list;
    }
    
    public static void main(String[] args) {
        ArrayList<KhoaVien> listKhoaVien = new FileKhoaVien().docFileKhoaVien();
        LopTinChi lopTinChi = (LopTinChi)listKhoaVien.get(0).getDsLopHoc().get(0);
        System.out.println(lopTinChi.getDsSinhVienTC().get(1).getHoTen());
    }
}
