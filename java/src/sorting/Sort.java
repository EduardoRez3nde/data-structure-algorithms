package sorting;

import java.util.ArrayList;
import java.util.List;

public class Sort {

    public static <T extends Comparable<? super T>> void insertionSort(final List<T> list) {

        for (int i = 1; i < list.size(); i++) {
            final T key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    public static <T extends Comparable<? super T>> void mergeSort(final List<T> list) {
        merge(list, 0, list.size() - 1);
    }

    private static <T extends Comparable<? super T>> void merge(final List<T> list, final int low, final int height) {

        if (low < height) {
            int mid = (low + height) / 2;
            merge(list, low, mid);
            merge(list, mid + 1, height);
            merging(list, low, mid, height);
        }
    }

    private static <T extends Comparable<? super T>> void merging(final List<T> list, final int low, final int mid, final int height) {

        int i = low;
        int j = mid + 1;
        final List<T> temp = new ArrayList<>();

        while (i <= mid && j <= height) {

            if (list.get(i).compareTo(list.get(j)) < 0)
                temp.add(list.get(i++));

            else temp.add(list.get(j++));
        }
        while (i <= mid)
            temp.add(list.get(i++));

        while (j <= height)
            temp.add(list.get(j++));

        for (i = 0; i < temp.size(); i++)
            list.set(low + i, temp.get(i));
    }
}
