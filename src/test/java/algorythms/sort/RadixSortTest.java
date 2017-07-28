package algorythms.sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RadixSortTest {
    private int[] arrayForSort;
    private RadixSort radixSort;
    private int MAX_ELEMENTS = 100;

    @Before
    public void setUp() {
        arrayForSort = new int[MAX_ELEMENTS];
        for (int i = 0; i < MAX_ELEMENTS - 1; i++) {
            arrayForSort[i] = (int) (Math.random() * 1000);
        }
        radixSort = new RadixSort(arrayForSort);
    }
    @Test
    public void testRadixSort() throws Exception {
        radixSort.display();
        radixSort.sort();
        for (int i = 1; i < arrayForSort.length - 1; i++) {
            if (arrayForSort[i - 1] > arrayForSort[i]) {
                fail("Radix sort is broken");
            }
        }
        radixSort.display();
        assertTrue(true);
    }

}