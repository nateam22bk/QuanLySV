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
       FileKhoaVien fileKhoaVien = new FileKhoaVien();
      /* ArrayList<KhoaVien> list = new ArrayList<>();
       KhoaVien khoaVien = new KhoaVien("CNTT","Vien Cong Nghe Thong Tin", new ArrayList<SinhVien>(), new ArrayList<LopHoc>(), new ArrayList<>());
       list.add(khoaVien);
       fileKhoaVien.ghiFileKhoaVien(list); */
      ArrayList<KhoaVien> list = new ArrayList<>();
      list = fileKhoaVien.docFileKhoaVien();
        for (int i=0; i< list.size(); i++){
            if (list.get(i).getMaKhoaVien().equals("CNTT")){
                ArrayList<LopHoc> listLopHoc = list.get(i).getDsLopHoc();
                for (int j = 0; j< listLopHoc.size(); j++){
                    if (listLopHoc.get(i) instanceof LopTinChi){
                        System.out.println(listLopHoc.get(i).getMaLop());
                    }
                }
            }
        }
    }
}
