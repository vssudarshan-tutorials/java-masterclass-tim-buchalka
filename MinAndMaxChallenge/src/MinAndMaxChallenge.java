import java.util.Scanner;

public class MinAndMaxChallenge {


    public static void main(String[] args) {

        Scanner scanNum = new Scanner(System.in);
        int min = 0, max = 0;
        boolean isFirst = true;

        while (true) {
            System.out.println("Enter number: ");
            if (scanNum.hasNextInt()) {

                int num = scanNum.nextInt();
                scanNum.nextLine(); // handle return key

                if (isFirst) {
                    min = max = num;
                    isFirst = false;
                } else if (num < min)
                    min = num;
                else if (num > max)
                    max = num;

            } else
                break;

        }

        System.out.println("Minimum Value Entered is " + min);
        System.out.println("Maximum Value Entered is " + max);
        scanNum.close();

    }


}
