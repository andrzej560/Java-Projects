package pl.polsl.java.sort.model;

import java.util.ArrayList;

/**
 * Data processing class with implemented bubble sort algorithm.
 * 
 * 
 * @author Andrzej Kowol
 * @version 1.0
 */
public class BubbleSort {

    /**
    * Method which sorts integers in array.
    * 
    * 
    * @param array Array with integers which will be sorted.
    * 
    */
    public void sort(ArrayList<Integer> array){
       
        if (array.size()>=2){//sorting is not necessary when there is only one element in the array
             int temp=0;
             for(int i = array.size()-1; i >= 0; i--) {
                for(int j = 0; j < i; j++) {
                    if(array.get(j) > array.get(j + 1)) {
                        temp = array.get(j); 
                        array.set(j, array.get(j+1)); //swap of elements
                        array.set(j+1, temp);
                    }
                }
            }
            
        }    
    }
    
}
