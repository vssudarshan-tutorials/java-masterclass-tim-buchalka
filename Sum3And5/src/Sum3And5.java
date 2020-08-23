public class Sum3And5 {

    public static void main(String[] args) {

        long sum = 0;
        int count = 0;
        for (int i = 1; i <= 10000; i++){
            if(i % 3 == 0 && i % 5 == 0) {
                System.out.println("Found Number " + i);
                sum += i;
                count++;
                if(count == 5) {
                    System.out.println("Sum is " + sum);
                    break;
                }
            }
        }




    }




}
