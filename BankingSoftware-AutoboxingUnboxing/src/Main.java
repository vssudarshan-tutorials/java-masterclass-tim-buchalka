import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {

        //Bank
        //add branch ---done
        //show branches ---done
        //select a branch ---done
        //exit ---done

        //Branch
        //add customer ---done
        //show customer ---done
        //add transaction ---done
        //show transaction ---done

        ConstantValues.initialize();
        Bank bank = new Bank("Demo", ConstantValues.branchList);

        int option;
        do {
            bank.printMainMenu();
            option = HumanMachineInteraction.enterOption(ConstantValues.bankFunctionOptionsArray);
            selectFunction(option, bank);
        } while (option != ConstantValues.EXIT_OPTION);
    }

    public static void selectFunction(int option, Bank bank) {

        switch (option) {

            case ConstantValues.EXIT_OPTION:
                bank.exitMessage();
                System.exit(0);
                break;

            case ConstantValues.ADD_OPTION:
                bank.addNewBranch();
                break;

            case ConstantValues.SHOW_ALL_OPTION:
                bank.showBranchList();
                break;

            case ConstantValues.SELECT_OPTION:
                selectBranch(bank);
                break;

            case ConstantValues.BANK_ADD_CUSTOMER:
                bank.addCustomer();
                break;

            case ConstantValues.BANK_SHOW_CUSTOMER:
                bank.showCustomers();
                break;

            case ConstantValues.BANK_ADD_TRANSACTION:
                bank.addTransactionValue();
        }

        HumanMachineInteraction.continueMessage();
    }

    private static void selectBranch(Bank bank) {
        if (bank.getBranches().size() != 0) {
            ArrayList<Branch> branchList = searchBranch(bank);

            if (branchList != null) {

                System.out.println("Do you want to go to the branch menu? (y/n)");
                if (HumanMachineInteraction.enterYesNo()) {

                    bank.selectBranch(branchList, -1);


                } else
                    System.out.println("Returning to Main Menu...");
            }
        } else
            System.out.println(bank.getName() + " has no branches.");
    }

    private static ArrayList<Branch> searchBranch(Bank bank) {

        System.out.println("Enter Branch Id or Branch Name:");

        String value;
        do {
            value = HumanMachineInteraction.scanner.nextLine();
            if (HumanMachineInteraction.isValidId(value)) {
                return bank.searchBranch(ConstantValues.SEARCH_ID, value);

            } else if (HumanMachineInteraction.isValidName(value)) {
                return bank.searchBranch(ConstantValues.SEARCH_NAME, value);

            } else
                HumanMachineInteraction.notValidMessage();

        } while (true);

    }

}
