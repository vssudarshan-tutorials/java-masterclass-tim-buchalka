import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //quit ---done
        //add contact ---done
        // modify contact ---done
        //search contact ---done
        //delete contact
        //print all contacts ---done

        MobilePhone mobilePhone = new MobilePhone();
        int option;


        do {

            printFunctions();
            option = enterOption(ConstantValues.functionOptionList);
            selectFunction(option, mobilePhone);

        } while (option != ConstantValues.EXIT_OPTION_VALUE);

        scanner.close();
    }


    public static void selectFunction(int option, MobilePhone mobilePhone) {

        switch (option) {

            case 1:
                searchContact(mobilePhone);
                break;
            case 2:
                addContact(mobilePhone);
                break;
            case 3:
                modifyContact(mobilePhone);
                break;
            case 4:
                deleteContact(mobilePhone);
                break;
            case 5:
                showContact(mobilePhone);
                break;
            case ConstantValues.EXIT_OPTION_VALUE:
                System.out.println("Exiting...");
                System.exit(0);
        }
        continueMessage();
    }

    public static Contact createContact(String name, String phoneNumber) {

        return MobilePhone.createContact(name, phoneNumber);
    }

    public static void searchContact(MobilePhone mobilePhone) {
        int option;
        printSearchOptions();
        option = enterOption(ConstantValues.searchOptionList);
        searchContact(option, mobilePhone);
    }

    public static void searchContact(int option, MobilePhone mobilePhone) {

        String value;

        switch (option) {
            case ConstantValues.TOKEN_NAME:
                value = enterName();
                mobilePhone.searchContact(option, value);
                break;

            case ConstantValues.TOKEN_PHONE_NUMBER:
                value = enterPhoneNumber();
                mobilePhone.searchContact(option, value);
                break;

            case 3:
                Contact contact = createContact(enterName(), enterPhoneNumber());
                mobilePhone.searchContact(contact);
        }

    }

    public static void addContact(MobilePhone mobilePhone) {

        String name, phoneNumber;

        System.out.println("Enter contact details to add.");
        name = enterName();
        phoneNumber = enterPhoneNumber();

        Contact contact = createContact(name, phoneNumber);
        boolean wasAdded = addContact(contact, mobilePhone);

        if (!wasAdded) {
            System.out.println("Do you want to update the contact? (y/n)");
            if (enterYesNo())
                modifyContact(contact, mobilePhone);
        }

    }

    public static boolean addContact(Contact contact, MobilePhone mobilePhone) {
        return mobilePhone.addContact(contact);
    }

    public static void modifyContact(MobilePhone mobilePhone) {

        System.out.println("Enter contact to modify.");
        String name = enterName();
        String phoneNumber = enterPhoneNumber();

        Contact contact = createContact(name, phoneNumber);

        boolean isPresent = mobilePhone.searchContact(contact);

        if (!isPresent) {
            System.out.println("Do you want to add the contact? (y/n)");
            if (enterYesNo())
                addContact(contact, mobilePhone);
        } else
            modifyContact(contact, mobilePhone);
    }


    public static void modifyContact(Contact oldContact, MobilePhone mobilePhone) {

        printModifyOptions();
        int option = enterOption(ConstantValues.modifyOptionList);

        System.out.println("Enter new values.");

        String newName = "";
        String newPhoneNumber = "";

        switch (option) {

            case ConstantValues.TOKEN_NAME:
                newName = enterName();
                break;
            case ConstantValues.TOKEN_PHONE_NUMBER:
                newPhoneNumber = enterPhoneNumber();
                break;
            case 3:
                newName = enterName();
                newPhoneNumber = enterPhoneNumber();
        }

        Contact newContact = createContact(newName, newPhoneNumber);
        mobilePhone.modifyContact(oldContact, newContact);
    }

    public static void deleteContact(MobilePhone mobilePhone) {

        System.out.println("Enter contact Name or Phone Number to delete:");
        ArrayList<Contact> contact;
        int token;
        String value;
        do {
            value = scanner.nextLine();
            if (isValidPhoneNumber(value)) {
                token = ConstantValues.TOKEN_PHONE_NUMBER;
                contact = mobilePhone.deleteContact(ConstantValues.TOKEN_PHONE_NUMBER, value);
                break;
            } else if (isValidName(value)) {
                token = ConstantValues.TOKEN_NAME;
                contact = mobilePhone.deleteContact(ConstantValues.TOKEN_NAME, value);
                break;
            } else
                notValidEntryMessage();
        } while (true);

        if (contact != null) {
            System.out.println("Do you want to delete all contacts? (y/n)");

            if (enterYesNo())
                mobilePhone.deleteContact(contact);
            else {
                String name = "";
                String phoneNumber = "";
                System.out.println("Enter more information for the contact to be deleted. Type exit to return to Main Menu.");

                switch (token) {

                    case ConstantValues.TOKEN_NAME:
                        phoneNumber = enterPhoneNumber();
                        name = value;
                        break;
                    case ConstantValues.TOKEN_PHONE_NUMBER:
                        name = enterName();
                        phoneNumber = value;
                        break;
                }

                if (!phoneNumber.toLowerCase().equals("exit") && !name.toLowerCase().equals("exit"))
                    mobilePhone.deleteContact(createContact(name, phoneNumber));
                else
                    System.out.println("Returning to Main Menu...");
            }
        }

    }


    public static void showContact(MobilePhone mobilePhone) {
        mobilePhone.printContacts();
    }

    public static boolean enterYesNo() {

        do {
            String selection = scanner.nextLine();
            if (selection.toLowerCase().equals("y")) {
                return true;
            } else if (selection.toLowerCase().equals("n"))
                return false;
        } while (true);
    }

    public static int enterOption(int[] optionList) {
        boolean isValidSearchOption = false;
        int option = -1;

        do {

            enterOptionMessage();
            try {
                option = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException exception) {
                notValidEntryMessage();
                scanner.reset();
                continue;
            }
            if (!(isValidSearchOption = isValidOption(option, optionList)))
                notValidEntryMessage();

        } while (!isValidSearchOption);

        return option;
    }

    public static String enterPhoneNumber() {
        boolean isValid;
        String phoneNumber;

        do {
            enterPhoneNumberMessage();
            phoneNumber = scanner.nextLine();

            if (!(isValid = isValidPhoneNumber(phoneNumber)))
                notValidEntryMessage();

        } while (!isValid);

        return phoneNumber;
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
            notValidEntryMessage();

        return isValid;
    }


    public static boolean isValidOption(int option, int[] optionList) {

        for (int element : optionList)
            if (option == element)
                return true;

        return false;
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {

        try {
            Long.parseLong(phoneNumber);
        } catch (NumberFormatException exception) {

            return false;
        }

        return true;
    }


    public static void printFunctions() {

        System.out.println("Press:");

        System.out.println("\t1. To Search Contacts" +
                "\n\t2. To Add New Contact" +
                "\n\t3. To Modify Contact" +
                "\n\t4. To Delete Contact" +
                "\n\t5. To Show Contacts" +
                "\n\t6. To Exit");
    }

    public static void printSearchOptions() {

        System.out.println("Press:"
                + "\n\t1. To search by Name" +
                "\n\t2. To search by Phone Number" +
                "\n\t3. To search by both");
    }

    public static void printModifyOptions() {

        System.out.println("Press:"
                + "\n\t1. To modify Name" +
                "\n\t2. To modify Phone Number" +
                "\n\t3. To modify both");
    }

    private static void notValidEntryMessage() {

        System.out.println("Not a valid value. Please try again.");
    }

    public static void enterOptionMessage() {
        System.out.println("Please Enter Option: ");

    }

    public static void continueMessage() {
        System.out.println("-----------------------");
        System.out.println("Press enter to continue.");
        scanner.reset();
        scanner.nextLine();
    }

    public static void enterNameMessage() {
        System.out.println("Please Enter Name: ");


    }

    public static void enterPhoneNumberMessage() {
        System.out.println("Please Enter Phone Number: ");


    }


}