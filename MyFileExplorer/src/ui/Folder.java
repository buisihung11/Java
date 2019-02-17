package ui;


import java.io.File;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Windows 18
 */
public class Folder {
    protected ArrayList<File> fileList;
//search File (String name)
    
    public File getFile(String name){
        for (File file : fileList) {
            if(file.getName().equals(name))
            return file;
        }
        return null;
    }
    
    protected File file ;

    public Folder(File file) {
        this.fileList = new ArrayList<>();
        this.file = file;
    }
    
    
    
    public Folder(ArrayList<File> fileList,File file) {
        this.fileList = fileList;
        this.file = file;
    }

    public ArrayList<File> getFileList() {
        return fileList;
    }

    public void setFileList(ArrayList<File> fileList) {
        this.fileList = fileList;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    
    
    @Override
    public String toString() {
        return file.getName();//To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
