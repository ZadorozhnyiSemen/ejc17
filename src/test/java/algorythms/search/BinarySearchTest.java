package algorythms.search;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {
    private int[] sortedArray;
    private BinarySearch searchAlgorithm;

    @Before
    public void createIntArray() {
        sortedArray = new int[]{2, 4, 6, 7, 8, 12, 14, 16, 19, 24};
        searchAlgorithm = new BinarySearch(sortedArray);
    }

    @Test
    public void testGetElementNumber() throws Exception {
        assertEquals("Element number is incorrect", 10, searchAlgorithm.getElementNumber());
    }

    @Test
    public void testBinarySearch() throws Exception {
        assertEquals("Index of serching value is incorrect", 6, searchAlgorithm.find(14));
        assertNotEquals("Search logic is incorrect", 0, searchAlgorithm.find(4));
    }

}