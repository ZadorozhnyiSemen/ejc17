package algorythms.sort;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BubbleSortTest {

    private List<Integer> arrayForSort;
    private BubbleSort bubbleSort;

    @Before
    public void initializeArray() {
        arrayForSort = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrayForSort.add((int) (Math.random() * 300));
        }

        bubbleSort = new BubbleSort(arrayForSort);
    }

    @Test
    public void testBubbleSort() throws Exception {
        bubbleSort.display();
        bubbleSort.sortArray();
        for (int i = 1; i < arrayForSort.size() - 1; i++) {
            if (arrayForSort.get(i - 1) > arrayForSort.get(i)) {
                fail("Bubble sort not working");
            }
        }
        bubbleSort.display();
        assertTrue(true);
    }
}