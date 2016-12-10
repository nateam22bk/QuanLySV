/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;

import entity.DiemMonHoc;
import entity.KhoaVien;
import entity.LopHoc;
import entity.LopTinChi;
import entity.MonHoc;
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
       /// SinhVien sv = new SinhVienNienChe(new ArrayList<MonHoc>(), "20145167", "Nguyen Thi Mai Lan", dateFormat.parse("01/05/20014"), "Thai Binh");
        //listKhoaVien.get(0).getDsLopHoc().get(2).themSV(sv);
        //new FileKhoaVien().ghiFileKhoaVien(listKhoaVien);
        LopTinChi lopTinChi = (LopTinChi)listKhoaVien.get(0).getDsLopHoc().get(0);
        System.out.println(listKhoaVien.get(0).getSoTCTN());
    }
}
