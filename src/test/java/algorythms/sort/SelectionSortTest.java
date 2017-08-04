package algorythms.sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SelectionSortTest {
    private int[] arrayForSort;
    private  SelectionSort selectionSort;
    private int MAX_ELEMENT = 100;

    @Before
    public void setUp() {
        arrayForSort = new int[MAX_ELEMENT];
        for (int i = 0; i < MAX_ELEMENT - 1; i++) {
            arrayForSort[i] = (int) (Math.random() * 1000);
        }
        selectionSort = new SelectionSort(arrayForSort);
    }

    @Test
    public void sort() throws Exception {
        selectionSort.display();
        selectionSort.sort();
        for (int i = 1; i < arrayForSort.length - 1; i++) {
            if (arrayForSort[i - 1] > arrayForSort[i]) {
                fail("Selection sort working incorrectly");
            }
        }
        selectionSort.display();
        assertTrue(true);
    }
}