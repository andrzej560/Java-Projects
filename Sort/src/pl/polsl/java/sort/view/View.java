package pl.polsl.java.sort.view;

import java.util.ArrayList;

/**
 * Class which is responsible for presenting informations in console.
 *   
 * 
 * @author Andrzej Kowol
 * @version 1.0
 */
public class View {
    
    /**
     * Information about how many arguments user entered with start of application.
     * 
     * @param howMany Number of elements.
     */
    public void printStart(int howMany){
        System.out.println("You entered "+ howMany + " arguments");  
    }
    
    /**
     * Information with question about number of integers which will be input from console.
     * 
     */
    public void printQuestion(){
        System.out.println("How many numbers do you want to write?");
    }
    
    /**
     * Information about number of line with inputted element.
     * 
     * @param i Number of inputted element.
     */
    public void printInput(int i){
        System.out.print("Input numer no. " + i +": ");
    }
    
    /**
     * Information about type of error. Method is used in case of throwing exceptions.
     * 
     * @param type Type of error.
     */
    public void printError(int type){
       
        System.out.print("Error: ");
        switch (type) {
            case 1:
                System.out.println("you entered inappropriate value. Value is now set to 0.");
                break;
            case 2:
                System.out.println("you entered inappropriate value. End of reading this part of data.");
                break;
            case 3: 
                System.out.println("array is empty.");
                break;
        }
    }
    
    /**
     * Method which is responsible for printing array on screen.
     * 
     * @param array Array with integers.
     */
    public void printArray(ArrayList<Integer> array) {
        System.out.println("Your numbers: ");
        for (int i =0; i<array.size();i++){
            System.out.print(array.get(i) + " ");
        }
        System.out.println();
    }
}
