package pl.polsl.java.andrzej.kowol.book.model;

import java.util.LinkedList;

/**
 * Class which contains LinkedList in which addresses are. 
 * 
 * @author Andrzej Kowol
 * @version 1.0
 */
public class DataList {
    
     LinkedList<Data>  list = new  LinkedList<Data> ();
    
     /**
      * This method returns LinkedList.
      * 
      * @return list LinkedList<Data>
      */
     public  LinkedList<Data> getList(){
         return list;
     }
     
     /**
      * Method which removes all data
      */
     public void clear(){
         list.clear();
     }
     
     /**
      * Method which add address into list. It is possible if there are no empty
      * values and number is correct.
      * 
      * @param name First Name
      * @param lastName Last Name
      * @param number Phone Number
      * @return true if inserted data can be save into list
      */
     public boolean add(String name, String lastName, String number){
         if(name.equals("") || lastName.equals("") || number.equals("")){
             return false;
         }
         try{
            Data data = new Data(name, lastName, Integer.parseInt(number));
            list.add(data);
            return true;
         }catch(NumberFormatException e){
             return false;
         }
     }
}
