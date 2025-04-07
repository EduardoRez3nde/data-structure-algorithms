package com.datastructure.sorting;

import static com.datastructure.sorting.util.SortUtil.less;

public class MergeSort implements SortingAlgorithm{

    private Comparable[] aux;

    public MergeSort() { }

    @Override
    public  <T extends Comparable<T>> T[] sort(T[] unsorted) {
        aux = new Comparable[unsorted.length];
        doSort(unsorted, 0, unsorted.length - 1);
        return unsorted;
    }

    private <T extends Comparable<T>> void doSort(T[] unsorted, int left, int right) {
        if (left < right) {
            int mid = (left + right) >>> 1; // O mesmo que (left + right) / 2
            doSort(unsorted, left, mid);
            doSort(unsorted, mid + 1, right);
            merge(unsorted, left, mid, right);
        }
    }

    @SuppressWarnings("unchecked")
    private <T extends Comparable<T>> void merge(T[] unsorted, int left, int mid, int right) {

        int i = left;
        int j = mid + 1;
        System.arraycopy(unsorted, left, aux, left, right + 1 - left);

        for (int k = left; k <= right; k++) {
            if (j > right)
                unsorted[k] = (T) aux[i++];
            else if (i > mid)
                unsorted[k] = (T) aux[j++];
            else if (less(aux[i], aux[j]))
                unsorted[k] = (T) aux[i++];
            else
                unsorted[k] = (T) aux[j++];
        }
    }

}
