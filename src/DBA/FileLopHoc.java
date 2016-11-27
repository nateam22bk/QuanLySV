/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBA;

import ENTITY.LopHoc;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
public class FileLopHoc {
    File file = new File("LOPHOC.DAT");
    
    public void ghiFileLopHoc(ArrayList<LopHoc> list){
        if(!file.exists())
            try {
                file.createNewFile();
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(list);
                oos.close();
        } catch (IOException ex) {
            Logger.getLogger(FileLopHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public ArrayList<LopHoc> docFileLopHoc(){
        ArrayList<LopHoc> list = new ArrayList<>();
        ObjectInputStream ois  = null;
        try {
            
            if (!file.exists())
                return list;
            ois = new ObjectInputStream(new FileInputStream(file));
            list = (ArrayList<LopHoc>)ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileLopHoc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileLopHoc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileLopHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static void main(String[] args) {
        FileLopHoc fileLopHoc = new FileLopHoc();
        ArrayList<LopHoc> list = fileLopHoc.docFileLopHoc();
        for (int i = 0; i< list.size(); i++){
            System.out.println(list.get(i).getMaKhoaVien());
        }
    }
}