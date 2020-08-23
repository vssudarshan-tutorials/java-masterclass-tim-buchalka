import java.util.Scanner;

public class Input {
    public static Scanner scanner = new Scanner(System.in);
    public static int[] optionList = {0, 1, 2, 3, 4, 5, 6, 7};

    public static int enterOption(int[] optionsArray) {

        boolean isValidSearchOption;
        int option;

        do {
            enterOptionMessage();
            option = scanner.nextInt();
            scanner.nextLine();
            if (!(isValidSearchOption = isValidOption(option, optionsArray)))
                notValidMessage();

        } while (!isValidSearchOption);

        return option;
    }


    public static int enterIndex() {
        boolean isValid;
        String index;

        do {
            enterSongNumberMessage();
            index = scanner.nextLine();

            if (!(isValid = isValidIndex(index)))
                notValidMessage();

        } while (!isValid);

        return Integer.valueOf(index);
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

    public static boolean isValidIndex(String index) {

        try {
            Integer.parseInt(index);
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
        System.out.println("Please Enter Song Name: ");


    }

    private static void enterSongNumberMessage() {
        System.out.println("Please Enter Song Number: ");


    }

    public static void continueMessage() {
        System.out.println("-----------------------");
        System.out.println("Press enter to continue.");
        scanner.reset();
        scanner.nextLine();
    }

}
