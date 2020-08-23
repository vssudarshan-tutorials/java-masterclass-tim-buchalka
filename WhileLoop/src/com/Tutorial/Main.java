package com.Tutorial;

public class Main {

    public static boolean isEvenNumber(int num){

        return num > 2 && num % 2 == 0;

    }


    public static void main(String[] args) {

        System.out.println(isEvenNumber(8));

        int num = 4, limit = 20, count = 0;

        while(num < limit){

//               if(isEvenNumber(num)) {
//                   System.out.println("Found Even Number " + num);
//                    count++;
//                    if(count >= 5)
//                        break;
//               }
            num++;
            if(!isEvenNumber(num))
                continue;

                System.out.println("Found Even Number " + num);
                if(++count >= 5)
                    break;

       }

        System.out.println("Total Even Numbers Found " + count);

    }
}
