package algorithms.sort;

import java.util.Arrays;

public class InsertionSort implements Displayable{
    private int[] arrayForSort;

    public InsertionSort(int[] arrayForSort) {
        this.arrayForSort = arrayForSort;
    }

    /**
     * Sort array via insertion algorithm
     * Working better on partly sorted arrays
     */
    public void sort() {
        int inBound;
        int outBound;

        for (outBound = 1; outBound < arrayForSort.length; outBound++) {
            int tempValue = arrayForSort[outBound];
            inBound = outBound;
            while (inBound > 0 && arrayForSort[inBound - 1] >= tempValue) {
                arrayForSort[inBound] = arrayForSort[--inBound];
            }
            arrayForSort[inBound] = tempValue;
        }
    }

    @Override
    public void display() {
        System.out.println(Arrays.toString(arrayForSort));
    }
}
