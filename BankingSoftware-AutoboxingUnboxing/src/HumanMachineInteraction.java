import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanMachineInteraction {

    public static Scanner scanner = new Scanner(System.in);

    public static boolean enterYesNo() {
        do {
            String selection = scanner.nextLine();
            if (selection.toLowerCase().equals("y")) {
                return true;
            } else if (selection.toLowerCase().equals("n"))
                return false;
        } while (true);
    }

    public static int enterOption(int[] optionsArray) {

        boolean isValidSearchOption = false;
        int option = -1;

        do {
            enterOptionMessage();
            try {
                option = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException exception) {
                notValidMessage();
                scanner.reset();
                continue;
            }
            if (!(isValidSearchOption = isValidOption(option, optionsArray)))
                notValidMessage();

        } while (!isValidSearchOption);

        return option;
    }

    public static String enterId() {
        boolean isValid;
        String Id;

        do {
            enterIdMessage();
            Id = scanner.nextLine();

            if (!(isValid = isValidId(Id)))
                notValidMessage();

        } while (!isValid);

        return Id;
    }

    public static String enterName() {
        String name;
        boolean isValid = true;

        do {
            enterNameMessage();
            name = scanner.nextLine();
            isValid = isValidName(name);
        } while (!isValid);

        return name;
    }

    public static String enterTransactionValue() {
        boolean isValid;
        String transactionValue;

        do {
            enterTransactionValueMessage();
            transactionValue = scanner.nextLine();

            if (!(isValid = isValidTransactionValue(transactionValue)))
                notValidMessage();

        } while (!isValid);

        return transactionValue;
    }

    private static boolean isValidOption(int option, int[] optionsArray) {

        for (int element : optionsArray)
            if (option == element)
                return true;

        return false;
    }

    public static boolean isValidName(String name) {
        boolean isValid = true;

        if (name.toCharArray()[0] == ' ') {
            isValid = false;
        } else
            for (int i = 0; i < name.toCharArray().length - 1; i++)
                if (name.toCharArray()[i] == ' ' && name.toCharArray()[i + 1] == ' ') {
                    isValid = false;
                    break;
                }

        if (!isValid)
            notValidMessage();

        return isValid;
    }

    public static boolean isValidId(String id) {

        try {
            Long.parseLong(id);
        } catch (NumberFormatException exception) {

            return false;
        }

        return true;
    }


    public static boolean isValidTransactionValue(String id) {

        try {
            Double.parseDouble(id);
        } catch (NumberFormatException exception) {

            return false;
        }

        return true;
    }

    private static void enterOptionMessage() {

        System.out.print("\nPlease enter your choice: ");
    }

    public static void notValidMessage() {

        System.out.println("\nNot a valid value. Please try again.");
    }


    private static void enterNameMessage() {
        System.out.println("Please Enter Name: ");


    }

    private static void enterIdMessage() {
        System.out.println("Please Enter Id: ");


    }

    private static void enterTransactionValueMessage() {
        System.out.println("Please Enter Transaction Value: ");


    }

    public static void continueMessage() {
        System.out.println("-----------------------");
        System.out.println("Press enter to continue.");
        scanner.reset();
        scanner.nextLine();
    }

}
