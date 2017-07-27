package algorythms.sort;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BubbleSortTest {

    private List<Integer> unsortedArray;
    private List<Integer> sortedArray;
    private BubbleSort bubbleSort;

    @Before
    public void initializeArray() {
        unsortedArray = new ArrayList<>();
        unsortedArray.add(3);
        unsortedArray.add(1);
        unsortedArray.add(2);
        unsortedArray.add(12);
        unsortedArray.add(4);
        unsortedArray.add(8);
        unsortedArray.add(6);
        unsortedArray.add(5);

        sortedArray = new ArrayList<>();
        sortedArray.add(1);
        sortedArray.add(2);
        sortedArray.add(3);
        sortedArray.add(4);
        sortedArray.add(5);
        sortedArray.add(6);
        sortedArray.add(8);
        sortedArray.add(12);

        bubbleSort = new BubbleSort(unsortedArray);
    }

    @Test
    public void testBubbleSort() throws Exception {
        assertEquals("Bubble sort is working not as expected", sortedArray, bubbleSort.sortArray());
    }

}