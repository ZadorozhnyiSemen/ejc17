package algorithms.sort;

import java.util.List;

public class QuickSort {
    private List<Integer> arrayList;

    public QuickSort(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    /**
     * Calls for recursive Quick Sort method on full array length
     */
    public void sortArray() {
        recursiveQuickSort(0, arrayList.size() - 1);
    }

    /**
     * Recursive method for quick sort - divides array(Collection) by partition and
     * applies itself on its 'left' and 'right' part until array size is not = 0
     * @param leftBound left bound of array to sort
     * @param rightBound right bound of array to sort
     */
    private void recursiveQuickSort(int leftBound, int rightBound) {
        if (rightBound - leftBound <= 0) {
            return;
        } else {
            int pivot = arrayList.get(rightBound);
            int partitionIndex = partition(leftBound, rightBound, pivot);
            recursiveQuickSort(leftBound, partitionIndex - 1);
            recursiveQuickSort(partitionIndex + 1, rightBound);
        }
    }

    /**
     * Looks for partition element in array
     * Swaps values smaller than pivot to the left side of an array
     * and bigger values - to the right
     * Moves partition in the end to place where it will be in final sorted array
     * @param leftBound left bound of array
     * @param rightBound right bound of array
     * @param pivot pivot value (usually last value of element in array)
     * @return partition index
     */
    private int partition(int leftBound, int rightBound, Integer pivot) {
        int leftCursor = leftBound - 1;
        int rightCursor = rightBound;
        while (true) {
            while (arrayList.get(++leftCursor) < pivot) {}

            while (rightCursor > 0 && arrayList.get(--rightCursor) > pivot) {}

            if (leftCursor >= rightCursor) {
                break;
            } else {
                swapElements(leftCursor, rightCursor);
            }
        }
        swapElements(leftCursor, rightBound);
        return leftCursor;
    }

    /**
     * Swap two elements in array(Collection)
     * @param firstIndex
     * @param secondIndex
     */
    private void swapElements(int firstIndex, int secondIndex) {
        int tempValue = arrayList.get(firstIndex);
        arrayList.set(firstIndex, arrayList.get(secondIndex));
        arrayList.set(secondIndex, tempValue);
    }

    /**
     * Display collection in console
     */
    public void display() {
        System.out.println(arrayList.toString());
    }
}
