package algorythms.sort;

import java.util.Arrays;

public class MergeSort implements Displayable{
    private int[] arrayForSort;
    private int[] arrayHelper;

    public MergeSort(int[] arrayForSort) {
        this.arrayForSort = arrayForSort;
        this.arrayHelper = new int[arrayForSort.length];
    }

    /**
     * Calls for recursive merge sort method
     */
    public void sort() {
        recursiveMergeSort(0, arrayForSort.length - 1);
    }

    /**
     * Splits recursively array by half and merges them back in sorted order
     * @param leftBound left bound of an array
     * @param rightBound right bound of an array
     */
    private void recursiveMergeSort(int leftBound, int rightBound) {
        if (leftBound < rightBound) {
            int middleIndex = leftBound + (rightBound - leftBound) / 2;
            recursiveMergeSort(leftBound, middleIndex);
            recursiveMergeSort(middleIndex + 1, rightBound);
            mergeArrays(leftBound, middleIndex, rightBound);
        }
    }

    /**
     * Merges two arrays together by taking and placing min elements
     * first
     * @param leftBound left bound of an array
     * @param middleIndex index from where second part begins
     * @param rightBound right bound of an array
     */
    private void mergeArrays(int leftBound, int middleIndex, int rightBound) {
        for (int i = leftBound; i <= rightBound; i++) {
            arrayHelper[i] = arrayForSort[i];
        }
        int i = leftBound;
        int j = middleIndex + 1;
        int k = leftBound;
        while (i <= middleIndex && j <= rightBound) {
            if (arrayHelper[i] <= arrayHelper[j]) {
                arrayForSort[k] = arrayHelper[i];
                i++;
            } else {
                arrayForSort[k] = arrayHelper[j];
                j++;
            }
            k++;
        }

        while (i <= middleIndex) {
            arrayForSort[k] = arrayHelper[i];
            k++;
            i++;
        }
    }

    @Override
    public void display() {
        System.out.println(Arrays.toString(arrayForSort));
    }
}
