import java.util.Scanner;

public class InputCalculator {
    // Write your code here

    public static void inputThenPrintSumAndAverage() {

        Scanner scanNum = new Scanner(System.in);
        int sum = 0;
        long average;
        int count = 0;

        while (true) {

            if (scanNum.hasNextInt()) {

                sum += scanNum.nextInt();
                scanNum.nextLine();
                count++;

            } else {
                average = Math.round((double) sum / count);
                System.out.println("SUM = " + sum + " AVG = " + average);
                break;

            }


        }


        scanNum.close();
    }

    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }

}
