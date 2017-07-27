package algorythms.sort;

import java.util.List;

public class BubbleSort {
    List<Integer> arrayList;

    public BubbleSort(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

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

    private void swapElements(int firstIndex, int secondIndex) {
        int tempValue = arrayList.get(firstIndex);
        arrayList.set(firstIndex, arrayList.get(secondIndex));
        arrayList.set(secondIndex, tempValue);
    }

    public void display() {
        System.out.println(arrayList.toString());
    }
}
