package sort;

import java.util.LinkedList;
import java.util.List;

public class RecursiveListMergeSorter {

    public void sort(List<Integer> numbers) {
        if (numbers != null && 1 < numbers.size()) {
            List<Integer> left = new LinkedList<>(numbers.subList(0, numbers.size() / 2));
            List<Integer> right = new LinkedList<>(numbers.subList(numbers.size() / 2, numbers.size()));

            sort(left);
            sort(right);
            merge(numbers, left, right);
        }
    }

    private void merge(List<Integer> numbers, List<Integer> left, List<Integer> right) {
        if (!numbers.isEmpty()) {
            if (leftIsSmallerOrRightIsEmpty(left, right)) {
                numbers.set(0, left.remove(0));
                merge(numbers.subList(1,numbers.size()), left, right);
            } else {
                numbers.set(0, right.remove(0));
                merge(numbers.subList(1,numbers.size()), left, right);
            }
        }
    }

    private boolean leftIsSmallerOrRightIsEmpty(List<Integer> left, List<Integer> right) {
        return right.isEmpty() || !left.isEmpty() &&  left.get(0) < right.get(0);
    }


}
