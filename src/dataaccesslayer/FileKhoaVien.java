/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;

import entity.DiemMonHoc;
import entity.KhoaVien;
import entity.LopHoc;
import entity.LopNienChe;
import entity.LopTinChi;
import entity.MonHoc;
import entity.MonNienChe;
import entity.SinhVien;
import entity.SinhVienNienChe;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<KhoaVien> listKhoaVien = new FileKhoaVien().docFileKhoaVien();
        
        LopNienChe lopNienChe = (LopNienChe)listKhoaVien.get(0).getDsLopHoc().get(1);
        System.out.println(lopNienChe.getDsLopNC().get(2).getDsMonDangKi().size());
    }
}
