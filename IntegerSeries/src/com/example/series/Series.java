package com.example.series;

public class Series {

    public static long nSum(int n) {

        if (n == 0)
            return n;
        if (n < 0)
            n = -n;

        return n + nSum(--n);
    }


    public static long factorial(int n) {

        if (n == 0)
            return 1;

        if (n < 0)
            n = -n;

        return n * factorial(--n);
    }

    public static long fibonacci(int n) {

        long sum = 0, newSum = 1, oldSum = 0;
        
        for (int i = 1; i <= n; i++) {

            sum = newSum + oldSum;
            newSum = oldSum;
            oldSum = sum;
        }
        return sum;
    }


}
