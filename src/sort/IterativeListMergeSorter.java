package sort;

import java.util.ArrayList;
import java.util.List;

public class IterativeListMergeSorter {

    public void sort(List<Integer> numbers) {
        if (numbers != null && 1 < numbers.size()) {
            List<Integer> left = new ArrayList<>(numbers.subList(0, numbers.size() / 2));
            List<Integer> right = new ArrayList<>(numbers.subList(numbers.size() / 2, numbers.size()));

            sort(left);
            sort(right);
            merge(numbers, left, right);
        }
    }

    private void merge(List<Integer> numbers, List<Integer> left, List<Integer> right) {
        int leftInd = 0;
        int rightInd = 0;
        for (int k = 0; k < numbers.size(); k++) {
            if (leftIsSmallerOrRightIsEmpty(left, right, leftInd, rightInd)) {
                numbers.set(k, left.get(leftInd));
                leftInd++;
            } else {
                numbers.set(k, right.get(rightInd));
                rightInd++;
            }
        }
    }

    private boolean leftIsSmallerOrRightIsEmpty(List<Integer> left, List<Integer> right, int leftInd, int rightInd) {
        return rightInd == right.size() || leftInd != left.size() &&  left.get(leftInd) < right.get(rightInd);
    }

}
