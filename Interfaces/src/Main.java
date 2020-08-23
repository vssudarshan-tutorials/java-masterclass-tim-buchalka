import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ISaveable playerCharacter = new PlayerCharacter();
        ISaveable monster = new Monster();

        assetReadWrite(playerCharacter);
        assetReadWrite(monster);

    }

private static void assetReadWrite(ISaveable asset){
    List<String> characterValues;
    characterValues = readValues();
    asset.loadData(characterValues);
    System.out.println(asset.saveData());
    System.out.println(asset);
}



    public static List<String> readValues() {
       List<String> values = new ArrayList<String>();
        boolean quit = false;
        int index = 0;

        System.out.print("Enter name: ");
        String value = enterValue(false);
        values.add(index, value);
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit && index < 6) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter value: ");
                    value =enterValue(true);
                    values.add(++index, value);
                    break;
            }
        }
        return values;
    }

    private static String enterValue(boolean isNumber) {

        String value;
        int intValue = 0;
        boolean isValid = false;

        do {
            value = scanner.nextLine();

            if (isNumber) {
                try {
                    intValue = Integer.parseInt(value);
                    isValid = true;
                } catch (NumberFormatException ignore) {
                }

            } else {
                return value;
            }


        } while (!isValid);

        return Integer.toString(intValue);

    }
}