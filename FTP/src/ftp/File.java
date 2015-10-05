/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ftp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author g41
 */
public class File {
    public static String pobierz(){
        String www="";
        ///System.out.println("Odswiezenie");
                try {
                      URL url = new URL("http://www.dudeski.host-hermer.pl/file.txt");
                      BufferedReader in = new BufferedReader(
                      new InputStreamReader(url.openStream()));

                      String inputLine;
                      while ((inputLine = in.readLine()) != null){
                          www+=inputLine;
                          //System.out.println(inputLine);
                      }
                      
                      in.close();    
                       return www;
                
                }
                catch(Exception ex) {
                    System.out.println("Blad pobrania");
                    return null;
                }
               
        
    }
    
    
    public static void tworz(String s){
        try{
        PrintWriter writer = new PrintWriter("file.txt", "UTF-8");
        writer.println(s);
      
        writer.close();}catch(Exception e){System.out.println("Błąd");}
        
        
    }
    
    public static void historia(String s){
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Historia.txt", true)))) {
            out.println(s);
        }catch (IOException e) {
        //exception handling left as an exercise for the reader
        }
        
    }
}
