import java.util.Scanner;

public class MinElementChallenge {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter number of values to search.\r");
        int count = scanner.nextInt();
        scanner.nextLine(); //clear \r not required since no nextLine after this.
        int[] array = readIntegers(count);


        System.out.println("Array is:");
        printArray(array);
        System.out.println("\nMinimum value entered is: " + findMin(array) + "\n");
        reverseArray(array);
        System.out.println("\nReversed Array is:");
        printArray(array);

        array = resizeArray(array,2);

        System.out.println(array[6]);
        printArray(array);
    }

    public static int[] readIntegers(int count) {

        int[] array = new int[count];

        System.out.println("Enter " + count + " values: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
            scanner.nextLine(); //clear \r not required since no nextLine after this.
        }
        return array;
    }

    public static int findMin(int[] array) {

        int min = array[0];

        for (int element : array)
            if (min > element)
                min = element;

        return min;
    }

    public static void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1)
                System.out.print(", ");
        }
        System.out.println("\n");

    }


    public static void reverseArray(int[] array) {


        for (int i = 0; i < array.length / 2; i++) {

            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }

        System.out.println("Array Reversed.");

    }

    public static int[] resizeArray(int[] array, int n){

        int[] newArray = new int[array.length + n];

        for(int i = 0; i < array.length; i++)
            newArray[i] = array[i];

        return newArray;

    }


}
