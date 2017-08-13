package main;

import sort.RecursiveArrayMergeSorter;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class RecursiveArrayMain {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number_of_elements = in.nextInt();

        int[] numbers = IntStream
                .rangeClosed(1, number_of_elements)
                .map(i -> in.nextInt())
                .toArray();


        RecursiveArrayMergeSorter sorter = new RecursiveArrayMergeSorter();

        sorter.sort(numbers);

        System.out.println("Result of recursive merge sort on an array: ");
        System.out.println(Arrays.toString(numbers));
    }
}
