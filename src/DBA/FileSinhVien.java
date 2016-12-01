/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBA;

import ENTITY.KhoaVien;
import ENTITY.SinhVien;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tu
 */
public class FileSinhVien {
    File f = new File("SINHVIEN.DAT");
    
    public  void ghiFileSinhVien(ArrayList<SinhVien> list){
        try {
            if(!(f.exists()))
                f.createNewFile();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(list);
            oos.close();
        }catch(Exception e){
            
        }
    }
    
    public ArrayList<SinhVien> docFileSinhVien(){
        ArrayList<SinhVien> list = new ArrayList<>();
        try {
            if (!(f.exists()))
                return list;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            list = (ArrayList<SinhVien>)ois.readObject();
            ois.close();
        }catch (Exception e){
            
        }
        return list;
    }
    
    public static void main(String[] args) {
        FileSinhVien fileSinhVien = new FileSinhVien();
        ArrayList<SinhVien> listSinhVien = fileSinhVien.docFileSinhVien();
        System.out.println(listSinhVien.get(0).getHoTen());
    }
}
