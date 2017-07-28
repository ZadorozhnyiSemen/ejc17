package algorythms.sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InsertionSortTest {
    private int[] arrayForSort;
    private InsertionSort insertionSort;
    private int MAX_ELEMENTS = 1000;

    @Before
    public void setUp() {
        arrayForSort = new int[MAX_ELEMENTS];
        for (int i = 0; i < MAX_ELEMENTS - 1; i++) {
            arrayForSort[i] = (int) (Math.random() * 300);
        }
        insertionSort = new InsertionSort(arrayForSort);
    }

    @Test
    public void sort() throws Exception {
        insertionSort.display();
        insertionSort.sort();
        for (int i = 1; i < arrayForSort.length - 1; i++) {
            if (arrayForSort[i - 1] > arrayForSort[i]) {
                fail("Insertion sort working bad");
            }
        }
        insertionSort.display();
        assertTrue(true);
    }

}