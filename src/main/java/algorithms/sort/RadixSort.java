package algorithms.sort;

import java.util.Arrays;

public class RadixSort {
    private int[] arrayForSort;

    public RadixSort(int[] arrayForSort) {
        this.arrayForSort = arrayForSort;
    }

    /**
     * Sort array via Radix sort algorithm
     */
    public void sort() {
        int digitPlace = 1;
        int maxElement = getMaxElement(arrayForSort);
        int[] result = new int[arrayForSort.length];
        while (maxElement / digitPlace > 0) {
            int[] count = new int[10];
            Arrays.fill(count, 0);

            for (int i = 0; i < arrayForSort.length; i++) {
                count[arrayForSort[i] / digitPlace % 10]++;
            }

            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }

            for (int i = arrayForSort.length - 1; i >= 0; i--) {
                result[--count[arrayForSort[i] / digitPlace % 10]] = arrayForSort[i];
            }

            for (int i = 0; i < arrayForSort.length; i++) {
                arrayForSort[i] = result[i];
            }
            digitPlace *= 10;
        }
    }

    /**
     * Returns max element in array
     * @param arrayForSort array
     * @return max element
     */
    private int getMaxElement(int[] arrayForSort) {
        int max = arrayForSort[0];
        for (int i = 0; i < arrayForSort.length; i++) {
            if (arrayForSort[i] > max) {
                max = arrayForSort[i];
            }
        }
        return max;
    }

    /**
     * Display array
     */
    public void display() {
        System.out.println(Arrays.toString(arrayForSort));
    }
}
