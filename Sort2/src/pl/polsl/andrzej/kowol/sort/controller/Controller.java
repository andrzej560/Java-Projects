package pl.polsl.andrzej.kowol.sort.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import pl.polsl.andrzej.kowol.sort.exception.*;
import pl.polsl.andrzej.kowol.sort.model.*;
import pl.polsl.andrzej.kowol.sort.view.*;

/**
 * Main class of application.
 * 
 * @author Andrzej Kowol
 * @version 2.0
 */
public class Controller {
    
    
    /**
     * Main method of sort application. 
     * 
     * @param args Arguments which will be used for sorting. Only integers are acceptable.
     */  
    public static void main(String[] args){
        BubbleSort bubbleSort = new BubbleSort();
        View view = new View();
        Scanner input = new Scanner(System.in);
        int count;
        String readLine; //to clean Scanner or read value
        ArrayList<Integer>  array = new ArrayList<Integer> ();
        final boolean defaultSortType = true; //default sorting value: true for ascending, false for descending
        boolean readSortType;
        
        view.printSortType(1, defaultSortType);
        readSortType = defaultSortType;
        readLine = input.nextLine();
        for(ChooseSortType choose : ChooseSortType.values()) {
            if(choose.toString().equalsIgnoreCase(readLine)){
                readSortType = choose.getValue(); //read value from enum
                break;
            }
        }
        view.printSortType(2, readSortType); 
        
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
            readLine = input.nextLine();
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
                    readLine = input.nextLine();
                }catch(InputMismatchException e){
                    view.printError(2);   
                    break;
                }
            }
        }
        
        
        view.printArray(array); //show array before sorting
        try{
            bubbleSort.sort(array,readSortType);
            view.printArray(array); //show array after sorting
        }catch(NothingToSortException e){
            view.printError(3); //if array is empty
        }
        input.close(); //closing Scanner
    }
}
