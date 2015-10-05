/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ftp;

/**
 *
 * @author g41
 */
public class Uruchom {
    public static void main(String args[]) {
        try{
            Formularz f = new Formularz(args[0]);
        }catch(Exception e){
            Formularz f = new Formularz("nick");
            
        }
    
    }
    
}
