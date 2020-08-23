package com.Tutorial;

public class Main {

    public static void main(String[] args) {

        double firstDouble = 20D;
        double secondDouble = 80D;
        double result = (firstDouble + secondDouble)*100D;
        double remainder =  result % 40D;
        boolean isZero = (remainder == 0D) ? true : false;

        System.out.println("isZero is " + isZero);

        if (!isZero)
            System.out.print("got a remainder");

    }
}
