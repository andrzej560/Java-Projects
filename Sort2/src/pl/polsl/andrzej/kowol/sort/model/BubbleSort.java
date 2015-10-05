package pl.polsl.andrzej.kowol.sort.model;

import java.util.ArrayList;
import pl.polsl.andrzej.kowol.sort.exception.*;

/**
 * Data processing class with implemented bubble sort algorithm.
 * 
 * @author Andrzej Kowol
 * @version 2.0
 */
public class BubbleSort {

    /**
    * Method which swap elements in array.
    * 
    * @param array Array with integers which will be sorted.
    * @param index Index of element in array.
    */
    @BubbleSortAnnotation(info = "Method which swap elements in array", author = "Andrzej Kowol")
    private void swap(ArrayList<Integer> array, int index){
        int temp = array.get(index); 
        array.set(index, array.get(index+1)); //swap of elements
        array.set(index+1, temp);
    }
    
    
    /**
    * Method which sorts integers in array.
    * 
    * @param array Array with integers which will be sorted.
    * @param sortType Type of sorting. True for ascending, false for descending.
    * @throws NothingToSortException Exceptrion which is thrown when there are less than two integers in array.
    */
    @BubbleSortAnnotation(info = "Method which sorts integers in array", author = "Andrzej Kowol")
    public void sort(ArrayList<Integer> array, boolean sortType) throws NothingToSortException{
        
        if (array.size()<2){ //sorting is not necessary when there is only one or less elements in the array
            throw new NothingToSortException();
        }
        else{
             for(int i = array.size()-1; i >= 0; i--) {
                for(int j = 0; j < i; j++) {
                    if (sortType){
                        if(array.get(j) > array.get(j + 1)) {
                            this.swap(array,j);
                        }
                    }else{
                        if(array.get(j) < array.get(j + 1)) {
                            this.swap(array,j);
                        }
                    }
                }
            }    
        } 
    }   
}
