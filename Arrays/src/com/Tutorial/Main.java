package com.Tutorial;

import java.util.Scanner;

public class Main {


    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here

        int[] a = {1, 2, 3, 4, 5};
        a = new int[]{1,2};

        System.out.println(average(a));
        System.out.println("How many numbers do you want to enter?\r");
        int size = scanner.nextInt();
        int[] integerArray = getIntegers(size);
        printInteger(integerArray);
//        for (int element : bubbleSortArray(integerArray))
//            System.out.println(element);

        for (int element : insertionSortArray(integerArray))
            System.out.println(element);


    }

    public static int[] getIntegers(int size) {

        int[] integerArray = new int[size];

        System.out.println("Enter " + size + " integers. \r");

        for (int i = 0; i < integerArray.length; i++)
            integerArray[i] = scanner.nextInt();

        return integerArray;
    }

    public static void printInteger(int[] integerArray) {

        for (int i = 0; i < integerArray.length; i++)
            System.out.println("Element " + i + " has value: " + integerArray[i]);
    }

    public static int[] bubbleSortArray(int[] integerArray) {

        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < integerArray.length; i++)
                if (integerArray[i] > integerArray[i - 1]) {
                    int temp = integerArray[i];
                    integerArray[i] = integerArray[i - 1];
                    integerArray[i - 1] = temp;
                    swapped = true;
                }
        } while (swapped);

        return integerArray;
    }

    public static int[] insertionSortArray(int[] integerArray) {


        for (int i = 1; i < integerArray.length; i++) {
            int temp = integerArray[i];
            int j = i - 1;

            while (j >= 0 && integerArray[j] < temp) {
                integerArray[j + 1] = integerArray[j];
                j--;
            }

            integerArray[j + 1] = temp;
        }
        return integerArray;
    }

    public static double average(int[] a) {

        int sum = 0;
        for (int b : a)
            sum += b;

        return (double) sum / a.length;

    }

}
