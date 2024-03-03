/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.util.Arrays;

/**
 *
 * @author admin
 */
public class FilePath {

    public String filePath;

    public FilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getPath() {
        File f = new File(filePath);
        return f.getParent();
    }

    public String getFileName() {
        File f = new File(filePath);
        String fileName = f.getName();
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex == -1) {
            return fileName;
        } else {
            return fileName.substring(0, dotIndex);
        }
    }

    public String getExtension() {
        File f = new File(filePath);
        String fileName = f.getName();
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex == -1) {
            return "No extention";
        } else {
            return fileName.substring(dotIndex + 1);
        }
    }

    public String getDisk() {
        File f = new File(filePath);

        return f.toPath().getRoot().toString();
    }

    public String[] getFolders() {
        File f = new File(filePath);
        if (f.getParent() == null) {
            return new String[]{};
        }
        String[] folder = f.getParent().split("\\\\");
        return folder;
    }

    public void displayInfo() {
        System.out.println("Disk driver: " + getDisk());
        System.out.println("Path to folder: " + getPath());
        System.out.println("File name: " + getFileName());
        System.out.println("File extension: " + getExtension());
        System.out.println("Folders" + Arrays.toString(getFolders()));
    }

    public static void main(String[] args) {
        FilePath f = new FilePath("C:\\Windows\\sHaha\\test.txt");
        System.out.println(Arrays.toString(f.getFolders()));

    }
}
