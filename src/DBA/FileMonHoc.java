/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBA;

import ENTITY.KhoaVien;
import ENTITY.MonHoc;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author tu
 */
public class FileMonHoc {
    File f = new File("MONHOC.DAT");
    public  void ghiFileMonHoc(ArrayList<MonHoc> list){
        try {
            if(!(f.exists()))
                f.createNewFile();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(list);
            oos.close();
        }catch(Exception e){
            
        }
    }
    
    public ArrayList<MonHoc> docFileMonHoc(){
        ArrayList<MonHoc> list = new ArrayList<>();
        try {
            if (!(f.exists()))
                return list;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            list = (ArrayList<MonHoc>)ois.readObject();
            ois.close();
        }catch (Exception e){
            
        }
        return list;
    }
}
