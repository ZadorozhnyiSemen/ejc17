package algorythms.sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortTest {
    private int[] arrayForSort;
    private MergeSort mergeSort;
    private int MAX_ELEMENTS = 100000;

    @Before
    public void setUp() {
        arrayForSort = new int[MAX_ELEMENTS];
        for (int i = 0; i < MAX_ELEMENTS - 1; i++) {
            arrayForSort[i] = (int) (Math.random() * 300);
        }
        mergeSort = new MergeSort(arrayForSort);
    }
    @Test
    public void testMergeSort() throws Exception {
        mergeSort.display();
        mergeSort.sort();
        for (int i = 1; i < arrayForSort.length - 1; i++) {
            if (arrayForSort[i - 1] > arrayForSort[i]) {
                fail("Merge sort working bad");
            }
        }
        mergeSort.display();
        assertTrue(true);
    }

}