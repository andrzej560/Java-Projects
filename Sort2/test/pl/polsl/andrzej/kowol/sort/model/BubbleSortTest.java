package pl.polsl.andrzej.kowol.sort.model;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import pl.polsl.andrzej.kowol.sort.exception.NothingToSortException;
import pl.polsl.andrzej.kowol.sort.model.BubbleSort;


public class BubbleSortTest {

    private BubbleSort bubbleSort;
    private ArrayList<Integer> array;
    private ArrayList<Integer> testArray;

    public BubbleSortTest() {
    }
    
    @Before
    public void setUp() {
        bubbleSort = new BubbleSort();
        array = new ArrayList<Integer>();
        testArray = new ArrayList<Integer>();
        array.add(31);
        array.add(12);
        array.add(18);
    }
    
    @After
    public void tearDown() {
        bubbleSort = null;
        array = null;
        testArray = null;
    }
    
    @Test
    public void testOneItem() {
        array.add(1);
        assertEquals(4,array.size());
    }
    
    @Test
    public void testAscSort() throws NothingToSortException{
        bubbleSort.sort(array, true);
        testArray.add(12);
        testArray.add(18);
        testArray.add(31);
        assertEquals(array,testArray);
    }
    
    @Test
    public void testDescSort() throws NothingToSortException{
        bubbleSort.sort(array, false);
        testArray.add(31);
        testArray.add(18);
        testArray.add(12);
        assertEquals(array,testArray);
    }
    
}
