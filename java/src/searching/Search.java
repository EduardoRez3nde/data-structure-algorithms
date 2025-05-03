package searching;

import java.util.List;

public class Search {

    public static <T extends Comparable<T>> Integer binarySearchIterative(final List<T> list, final T key) {

        int low = 0;
        int height = list.size() - 1;

        while (low <= height) {

            int mid = (low + height) / 2;

            if (key.compareTo(list.get(mid)) == 0)
                return mid;

            if (key.compareTo(list.get(mid)) < 0)
                height = mid - 1;

            if (key.compareTo(list.get(mid)) > 0)
                low = mid + 1;
        }
        return null;
    }
}
