package pl.polsl.andrzej.kowol.sort.model;

import java.util.ArrayList;
import org.junit.*;
import pl.polsl.andrzej.kowol.sort.exception.NothingToSortException;


public class NothingToSortTest {
    
    private BubbleSort bubbleSort;
    private ArrayList<Integer> array;
    
    public NothingToSortTest() {
    }
    
    @Before
    public void setUp() {
        bubbleSort = new BubbleSort();
        array = new ArrayList<Integer>();
    }
    
    @After
    public void tearDown() {
        bubbleSort = null;
        array = null;
    }

    @Test(expected = NothingToSortException.class)
    public void nothingToSortTest() throws NothingToSortException{
        bubbleSort.sort(array, true);
    }
    
}
