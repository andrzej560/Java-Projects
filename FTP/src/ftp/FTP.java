/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ftp;
//package net.codejava.ftp;
 
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
 
public class FTP {
 
    private static final int BUFFER_SIZE = 4096;
 
    public static void tworz() {
        String ftpUrl = "ftp://%s:%s@%s/%s;type=i";
        String host = "YOUR HOST NAME";
        String user = "YOUR USER NAME";
        String pass = "YOUR PASSWORD";
        String filePath = "file.txt"; // do edycji
        String uploadPath = "public_html/file.txt"; // do edycji
 
        ftpUrl = String.format(ftpUrl, user, pass, host, uploadPath);
        System.out.println("Upload URL: ");
 
        try {
            URL url = new URL(ftpUrl);
            URLConnection conn = url.openConnection();
            OutputStream outputStream = conn.getOutputStream();
            FileInputStream inputStream = new FileInputStream(filePath);
 
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
 
            inputStream.close();
            outputStream.close();
 
            System.out.println("File uploaded");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}