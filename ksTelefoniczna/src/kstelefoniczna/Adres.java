/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kstelefoniczna;

import java.io.Serializable;

/**
 *
 * @author g41
 */
public final class Adres implements Serializable{
    
    String nazwisko, imie;
    int telefon;
    
    public Adres(){
    }
    public Adres(String naz, String im, int tel){
        Ustaw(naz,im,tel);
    }
    
    public Adres(Adres adr){
        Ustaw(adr.nazwisko, adr.imie, adr.telefon);
    }
    
    
    void Ustaw(String naz, String im, int tel){
       this.nazwisko = naz;
       this.imie = im;
       this.telefon = tel;
    }
    
    Adres Pobierz(){
        Adres adr = new Adres();
        adr.nazwisko = nazwisko;
        adr.imie = imie;
        adr.telefon = telefon;
        return adr;
    }
    
    
}
