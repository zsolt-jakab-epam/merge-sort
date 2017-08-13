package sort;

import java.util.Arrays;

public class RecursiveArrayMergeSorter {

    public void sort(int[] numbers) {

        if (numbers != null && 1 < numbers.length) {
            int[] left = Arrays.copyOfRange(numbers, 0, numbers.length / 2);
            int[] right = Arrays.copyOfRange(numbers, numbers.length / 2, numbers.length);

            sort(left);
            sort(right);
            merge(numbers, left, right,  0, 0);
        }

    }

    private void merge(int[] numbers, int[] left, int[] right, int leftInd, int rightInd) {
        int numbersInd = leftInd + rightInd;
        if(numbersInd < numbers.length) {
            if (leftIsSmallerOrRightIsEmpty(left, right, leftInd, rightInd)) {
                numbers[numbersInd] = left[leftInd];
                merge(numbers, left, right, ++leftInd, rightInd);
            } else {
                numbers[numbersInd] = right[rightInd];
                merge(numbers, left, right, leftInd, ++rightInd);
            }
        }
    }

    private boolean leftIsSmallerOrRightIsEmpty(int[] left, int[] right, int leftInd, int rightInd) {
        return rightInd == right.length || (leftInd < left.length &&  left[leftInd] < right[rightInd]);
    }
}
