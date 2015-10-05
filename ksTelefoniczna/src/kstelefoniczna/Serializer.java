/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kstelefoniczna;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author g41
 */
public class Serializer{
   
   public ArrayList<Adres> serializer_wczytanie(){
      ArrayList<Adres> adr;
       try{
          
                   String fileName = formularz.fileName;
		   FileInputStream file = new FileInputStream(fileName);
		   ObjectInputStream is = new ObjectInputStream(file);
                   adr = (ArrayList<Adres>) is.readObject();
		   is.close();
		   return adr;
 
	   }catch(Exception ex){
		   System.out.println("Blad odczytu listy");
		   return null;
	   } 
   }
    

    
  public void serializer_zapisz(Adres adres, ArrayList list) {  
      Adres adr = adres;
      System.out.println(adr);
      ArrayList lista = list;
      lista.add(adr);
      
       
      
      try{
        String fileName = formularz.fileName;
		FileOutputStream file = new FileOutputStream(fileName);
		ObjectOutputStream os = new ObjectOutputStream(file);   
		os.writeObject(lista);             
		os.close();
		System.out.println("Zapisano");
 
	   }catch(Exception ex){
		   System.out.println("Zapis nie powiodl sie");
	   }
  }

	public void serializer_zapisz( ArrayList list) {  
		 // Adres adr = new Adres("Nowy", "Plik", 0);
		  
		  ArrayList lista = new ArrayList();
		  //lista.add(adr);
		  
		try{
				String fileName = formularz.fileName;
				FileOutputStream file = new FileOutputStream(fileName);
				ObjectOutputStream os = new ObjectOutputStream(file);   
				os.writeObject(lista);             
				os.close();
				System.out.println("Zapisano");
	 
		}catch(Exception ex){
			System.out.println("Zapis nie powiodl sie");
		}
	}
  
  
    void serializer_zapisz() {
    }
    
    
    
}
