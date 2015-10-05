package pl.polsl.andrzej.kowol.sort.view;

import java.util.ArrayList;

/**
 * Class which is responsible for presenting informations in console.
 *   
 * @author Andrzej Kowol
 * @version 2.0
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
                System.out.println("in array there must be at least two elements.");
                break;
        }
    }
    
    /**
     * Method which is responsible for printing array on screen. Used only if there are at least
     * two elements in the array.
     * 
     * @param array Array with integers.
     */
    public void printArray(ArrayList<Integer> array) {
        if (array.size()>=2){
            System.out.println("Your numbers: ");
            for (int element: array){
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    
    /**
     * Information about SortType. One message ask user to write value, other message
     * is information about sort type.
     * 
     * @param i Number of message.
     * @param choose If parameter equals true, sort type is ascending. If false, descending.
     */
    public void printSortType(int i, boolean choose){
        switch(i){
            case 1: 
                System.out.println("Choose your sort type, write ASC for ascending of DESC for descending");
                break;
            case 2:
                if (choose){
                    System.out.println("Ascending");
                }else{
                    System.out.println("Descending");
                }
                break;
        }
    }
}
