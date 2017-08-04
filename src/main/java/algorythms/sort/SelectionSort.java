package algorythms.sort;

import java.util.Arrays;

public class SelectionSort {
    private int[] arrayForSort;

    public SelectionSort(int[] arrayForSort) {
        this.arrayForSort = arrayForSort;
    }

    /**
     * Sort array via Selection sort algorithm: <br>
     * N times going through an array and every time picks <br>
     * smallest element and places it to the beginning of the array
     */
    public void sort() {
        int min;
        int outBound;
        int inBound;

        for (outBound = 0; outBound < arrayForSort.length; outBound++) {
            min = outBound;
            for (inBound = outBound + 1; inBound < arrayForSort.length; inBound++) {
                if (arrayForSort[inBound] < arrayForSort[min]) {
                    min = inBound;
                }
            }
            swap(min, outBound);
        }
    }

    /**
     * Swap two element in array
     * @param first
     * @param second
     */
    private void swap(int first, int second) {
        int tempValue = arrayForSort[first];
        arrayForSort[first] = arrayForSort[second];
        arrayForSort[second] = tempValue;
    }

    /**
     * Print array in console
     */
    public void display() {
        System.out.println(Arrays.toString(arrayForSort));
    }
}
