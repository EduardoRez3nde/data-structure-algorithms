import sorting.Sort;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        final List<Integer> original = Arrays.asList(5, 20, 1, 8, 2, 9);

        // Cópia para insertion sort
        List<Integer> insertionList = new ArrayList<>(original);
        Sort.insertionSort(insertionList);
        System.out.print("Insertion Sort: ");
        insertionList.forEach(x -> System.out.printf("%d ", x));
        System.out.print("\n\n");

        // Cópia para merge sort
        List<Integer> mergeList = new ArrayList<>(original);
        Sort.mergeSort(mergeList);
        System.out.print("Merge Sort: ");
        mergeList.forEach(x -> System.out.printf("%d ", x));
        System.out.print("\n\n");
    }
}