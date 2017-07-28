package algorythms.sort;

import java.util.List;

/**
 * Bubble Sort class
 * Main behaviour - sort of Collection via Bubble sort algorithm
 */
public class BubbleSort {
    List<Integer> arrayList;

    public BubbleSort(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    /**
     * Sorts array list given on creation via bubble search:
     *
     * Moves biggest element n times(where n is length of collection)
     * from array to the end by swapping it with other elements
     *
     * @return sorted List
     */
    public List<Integer> sortArray() {
        int innerIndex;
        int outerIndex;
        for (outerIndex = arrayList.size() - 1; outerIndex > 1; outerIndex--) {
            for (innerIndex = 0; innerIndex < outerIndex; innerIndex++) {
                if (arrayList.get(innerIndex) > arrayList.get(innerIndex + 1)) {
                    swapElements(innerIndex, innerIndex + 1);
                }
            }
        }

        return arrayList;
    }

    /**
     * Swaps two element in list
     * @param firstIndex index of first element
     * @param secondIndex index of second element
     */
    private void swapElements(int firstIndex, int secondIndex) {
        int tempValue = arrayList.get(firstIndex);
        arrayList.set(firstIndex, arrayList.get(secondIndex));
        arrayList.set(secondIndex, tempValue);
    }

    /**
     * Display list in console
     */
    public void display() {
        System.out.println(arrayList.toString());
    }
}
