package pl.polsl.java.sort.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import pl.polsl.java.sort.model.*;
import pl.polsl.java.sort.view.*;

/**
 * Main class of application.
 * 
 * 
 * @author Andrzej Kowol
 * @version 1.0
 */
public class Controller {
    
    
    /**
     * Main method of sort application. 
     * 
     * 
     * @param args Arguments which will be used for sorting. Only integers are acceptable.
     */  
    public static void main(String[] args){
        BubbleSort bubbleSort = new BubbleSort();
        View view = new View();
        Scanner input = new Scanner(System.in);
        int count;
        String clean; //to clean Scanner
        ArrayList<Integer>  array = new ArrayList<Integer> ();
        
        view.printStart(args.length);
        
         if (args.length>0){
            
            for (int i=0; i<args.length ;i++){
                try{
                    array.add(Integer.parseInt(args[i])); //only integers are acceptable
                }catch(NumberFormatException e){
                    view.printError(2);  
                    break;
                }
            }
        }
         
         
        view.printQuestion();
        try{
            count = input.nextInt();
            clean = input.nextLine();
        }catch(InputMismatchException e){
            view.printError(1);
            count = 0;
        }
        
        if (count<0){ // in case if user entered negative number
                view.printError(1);
                count = 0; 
            }
        
        
        
        if (count>0){
            
            for (int i=0;i<count;i++){
                view.printInput(i+1);
                try{
                    
                    array.add(input.nextInt()); //only integers are acceptable
                    clean = input.nextLine();
                }catch(InputMismatchException e){
                    view.printError(2);   
                    break;
                }
            }
        }
            
        if (array.size()>=1){
            view.printArray(array); //show array before sorting
            bubbleSort.sort(array);
            view.printArray(array); //show array after sorting
        }else{
            view.printError(3); //if array is empty
        }
    input.close(); //closing Scanner
    }
}
