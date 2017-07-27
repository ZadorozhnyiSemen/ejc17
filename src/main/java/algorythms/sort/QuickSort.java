package algorythms.sort;

import java.util.List;

public class QuickSort {
    List<Integer> arrayList;

    public QuickSort(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public void sortArray() {
        recursiveQuickSort(0, arrayList.size() - 1);
    }

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

    private int partition(int leftBound, int rightBound, Integer pivot) {
        int leftCursor = leftBound - 1;
        int rightCursor = rightBound + 1;
        while (true) {
            while (leftCursor < rightBound && arrayList.get(++leftCursor) < pivot) {}

            while (rightCursor > leftBound && arrayList.get(--rightCursor) > pivot) {}

            if (leftCursor >= rightCursor) {
                break;
            } else {
                swapElements(leftCursor, rightCursor);
            }
        }
        return leftCursor;
    }

    private void swapElements(int firstIndex, int secondIndex) {
        int tempValue = arrayList.get(firstIndex);
        arrayList.set(firstIndex, arrayList.get(secondIndex));
        arrayList.set(secondIndex, tempValue);
    }

    public void display() {
        System.out.println(arrayList.toString());
    }
}
