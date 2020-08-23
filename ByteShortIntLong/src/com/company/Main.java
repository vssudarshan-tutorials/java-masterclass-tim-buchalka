package com.company;

import java.sql.Wrapper;

public class Main {

    public static void main(String[] args) {

        byte b = 8;
        short s = 16;
        int i= 32;
        long l = 50_000L + 10L * (b + s + i);
        System.out.println(l);

    }
}
