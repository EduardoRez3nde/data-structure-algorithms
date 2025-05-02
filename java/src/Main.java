import sorting.Sort;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        final List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(10);
        list.add(1);
        list.add(23);
        Sort.insertionSort(list);

        list.forEach(x -> System.out.printf("%d ", x));
    }
}