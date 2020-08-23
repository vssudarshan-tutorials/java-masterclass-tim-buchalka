import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void invalidOptionMessage() {
        System.out.println("Invalid Option.Try Again.");
    }

    public static void serviceOptionMessage() {
        System.out.println("Services Available:\n1.Deposit.\n2.Withdraw.\n3.Exit.\nEnter Option: ");
    }

    public static void invalidAmountMessage() {
        System.out.println("Invalid Amount. Try Again!");
    }

    public static void exitMessage() {
        System.out.println("Thank You for using our services! Exiting...");
    }

    public static String optionTitle(int option) {

        switch (option) {
            case 1:
                return "Deposit";
            case 2:
                return "Withdraw";
            default:
                return "";
        }
    }

    public static void callService(int option, BankAccount account) {

        boolean successStatus = false;

        while (true) {
            System.out.println("Current Balance: " + account.getBalance() + "\nEnter " + optionTitle(option) + " Amount: ");

            if (scanner.hasNextLong()) {
                long amount = scanner.nextLong();
                if (amount >= 0) {
                    switch (option) {
                        case 1:
                            account.deposit(amount);
                            successStatus = true;
                            break;
                        case 2:
                            if (account.canWithdraw(amount)) {
                                account.withdraw(amount);
                                successStatus = true;
                            } else
                                System.out.println("Insufficient Balance!");
                            break;
                    }
                    if (successStatus)
                        break;
                }
            }

            invalidAmountMessage();
            scanner.nextLine();
        }
        System.out.println("Current Balance: " + account.getBalance());
    }


    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        boolean quit = false;

        while (!quit) {
            serviceOptionMessage();

            int option = 4;
            option = scanner.nextInt();
            scanner.nextLine(); // handle return key

            switch (option) {
                case 3:
                    exitMessage();
                    quit = true;
                    break;

                case 1:
                case 2:
                    callService(option, account);
                    break;

                default:
                    invalidOptionMessage();
            }

        }

        scanner.close();
    }
}

