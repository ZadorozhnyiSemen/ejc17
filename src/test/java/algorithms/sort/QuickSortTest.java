package algorithms.sort;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QuickSortTest {

    private List<Integer> arrayForSort;
    private QuickSort quickSort;

    @Before
    public void setUp() {
        arrayForSort = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            arrayForSort.add((int) (Math.random() * 10000));
        }

        quickSort = new QuickSort(arrayForSort);
    }

    @Test
    public void testQuickSort() throws Exception {
        quickSort.display();
        quickSort.sortArray();
        for (int i = 1; i < arrayForSort.size() - 1; i++) {
            if (arrayForSort.get(i - 1) > arrayForSort.get(i)) {
                fail("Quick sort working bad :(");
            }
        }
        quickSort.display();
        assertTrue(true);
    }
}