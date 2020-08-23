import java.util.Scanner;

public class ReadUserInputChallenge {

    public static void main(String[] args) {

        Scanner scanNum = new Scanner(System.in);

        System.out.println("Enter 10 Numbers.");

        int sum = 0;

        /*FOR IMPLEMENTATION OF THE CODE */

//        for (int count = 1; count <= 10;) {
//
//            System.out.println("Enter number #" + count + ":");
//
//            if (scanNum.hasNextInt()) {
//                sum += scanNum.nextInt();
//                count++;
//            }
//            else {
//                System.out.println("Invalid Value.");
//            }
//
//            scanNum.nextLine();
//        }

        /*WHILE IMPLEMENTATION OF THE CODE */

        int count = 1;

        while (count <= 10) {
           System.out.println("Enter number #" + count + ":");

           if (scanNum.hasNextInt()) {
            sum += scanNum.nextInt();
            count++;
            }else{
             System.out.println("Invalid Value.");
            }
            scanNum.nextLine(); // handle \r
        }

        System.out.println("Sum of the 10 numbers is " + sum);
        scanNum.close();

    }


}
