package com.example.myprogram;

import com.example.series.Series;

public class Main {

    public static void main(String[] args) {

        System.out.println(Series.nSum(-10));
        System.out.println(Series.factorial(-10));
        for(int i = 0; i <= 10; i++)
        System.out.println(Series.fibonacci(i));


    }
}
