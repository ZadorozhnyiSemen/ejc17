package algorythms.sort;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> arrayListForBubbleSort = new ArrayList<>(10);
        ArrayList<Integer> arrayListForQuickSort = new ArrayList<>(100);
        int[] arrayForRadixSort = new int[]{22, 1, 234, 1245, 42, 51, 616, 666};
        int[] arrayForSelectionSort = new int[]{7,6,5,4,3,2,21,6};

        for (int i = 0; i < 25; i++) {
            arrayListForBubbleSort.add((int) (Math.random() * 1000));
            arrayListForQuickSort.add((int) (Math.random() * 100));
        }
        System.out.println("Bubble sort: ");
        BubbleSort bubbleSort = new BubbleSort(arrayListForBubbleSort);
        System.out.println("Original array");
        bubbleSort.display();
        bubbleSort.sortArray();
        System.out.println("After Bubble sort");
        bubbleSort.display();

        System.out.println();

        System.out.println("Quick sort: ");
        QuickSort quickSort = new QuickSort(arrayListForQuickSort);
        System.out.println("Original array");
        quickSort.display();
        quickSort.sortArray();
        System.out.println("After Quick sort");
        quickSort.display();

        System.out.println();

        System.out.println("Radix sort: ");
        RadixSort radixSort = new RadixSort(arrayForRadixSort);
        System.out.println("Original array");
        radixSort.display();
        radixSort.sort();
        System.out.println("After Radix sort");
        radixSort.display();

        System.out.println();

        System.out.println("Selection sort: ");
        SelectionSort selectionSort = new SelectionSort(arrayForSelectionSort);
        System.out.println("Original array");
        selectionSort.display();
        selectionSort.sort();
        System.out.println("After Selection sort");
        selectionSort.display();
    }
}
