package main;

import sort.IterativeListMergeSorter;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class IterativeListMain {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number_of_elements = in.nextInt();

        List<Integer> numbers = IntStream
                .rangeClosed(1, number_of_elements)
                .map(i -> in.nextInt())
                .boxed()
                .collect(toList());

        IterativeListMergeSorter sorter = new IterativeListMergeSorter();

        sorter.sort(numbers);

        System.out.println("Result of iterative merge sort on a list: ");
        System.out.println(numbers);
    }
}
