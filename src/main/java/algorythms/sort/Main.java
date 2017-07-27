package algorythms.sort;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(10);
        ArrayList<Integer> arrayListForQuickSort = new ArrayList<>(100);
        arrayList.add(4);
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(5);
        arrayList.add(1);
        arrayList.add(6);
        arrayList.add(14);
        arrayList.add(5);

        for (int i = 0; i < 25; i++) {
            arrayList.add((int) (Math.random() * 1000));
            arrayListForQuickSort.add((int) (Math.random() * 100));
        }

        BubbleSort bubbleSort = new BubbleSort(arrayList);
        bubbleSort.display();
        bubbleSort.sortArray();
        bubbleSort.display();

        QuickSort quickSort = new QuickSort(arrayListForQuickSort);
        quickSort.display();
        quickSort.sortArray();
        quickSort.display();
    }
}
