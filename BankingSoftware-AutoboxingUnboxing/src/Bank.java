import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name, ArrayList<Branch> branches) {
        this.name = name;
        this.branches = branches;
    }


    public void printMainMenu() {

        System.out.println("Welcome to " + name + " bank.");

        System.out.println("Press:" +
                "\n\t0. To Exit." +
                "\n\t1. To Add New Branch." +
                "\n\t2. To Show All Branches." +
                "\n\t3. To Select a Branch." +
                "\n\t4. To Add a Customer to a Branch." +
                "\n\t5. To Show All Customers of a Branch." +
                "\n\t6. To Add a Transaction for a Customer."
        );
    }

    private ArrayList<Branch> searchBranch() {

        ArrayList<Branch> branchArrayList;

        System.out.println("\nBranch Information Needed.");
        System.out.println("---------------------------");

        do {
            String branchId = HumanMachineInteraction.enterId();

            branchArrayList = searchBranch(ConstantValues.SEARCH_ID, branchId);

        } while (branchArrayList == null);

        return branchArrayList;
    }

    public void addCustomer() {
        if (branches.size() != 0)
            selectBranch(searchBranch(), ConstantValues.ADD_OPTION);
        else
            System.out.println("\n" + name + " Bank has no branches.");
    }

    public void showCustomers() {
        if (branches.size() != 0) {
            ArrayList<Branch> branch = searchBranch();
            int i = 0, j = 0;
            if (branch.get(0).getCustomers().size() != 0) {
                System.out.println("-----------------------");
                System.out.println("Customer List");
                System.out.println("-----------------------");
                for (Customer element : branch.get(0).getCustomers()) {
                    System.out.println("Customer " + ++i + ". ID: " + element.getCustomerId() + "\tName: " + element.getName());
                    System.out.println("Do you want to see transaction details? (y/n)");
                    if (HumanMachineInteraction.enterYesNo())
                        for (Double transaction : element.getTransactions())
                            System.out.println("Transaction " + (++j) + ". " + transaction.doubleValue());

                    if (i != branch.get(0).getCustomers().size())
                        System.out.println("-----------------------");

                }
            } else
                System.out.println("\n" + branch.get(0).getName() + " Branch of " + name + " Bank has no customer.");
        } else
            System.out.println("\n" + name + " Bank has no branches.");
    }

    public void addTransactionValue() {
        if (branches.size() != 0)
            selectBranch(searchBranch(), ConstantValues.BRANCH_ADD_TRANSACTION);
        else
            System.out.println("\n" + name + " Bank has no branches.");
    }


    public void exitMessage() {
        System.out.println("Thank you for using " + name + " Bank. Exiting...");
    }

    public void addNewBranch() {

        String branchId = HumanMachineInteraction.enterId();
        String name = HumanMachineInteraction.enterName();
        Branch branch = new Branch(branchId, name);

        if (!searchBranch(branch)) {
            branches.add(branch);
            addNewMessage(branch);
        } else
            addNewMessage(null);


    }

    public void showBranchList() {
        printBranchList(this.branches);
    }

    public void selectBranch(ArrayList<Branch> branchList, int option) {

        boolean flag = true;
        String branchId = branchList.get(0).getBranchId();
        do {
            if (branchList.size() > 1) {
                branchId = HumanMachineInteraction.enterId();
            }

            for (Branch element : branchList)
                if (element.getBranchId().equals(branchId)) {
                    element.showBranchMenu(this.name, option);
                    flag = false;
                    break;
                }

            if (flag) {
                printBranchList(null);
                HumanMachineInteraction.continueMessage();
                printBranchList(branchList);
            }
        } while (flag);

    }

    private boolean searchBranch(Branch branch) {

        return branches.contains(branch);
    }

    public ArrayList<Branch> searchBranch(int searchByToken, String value) {

        ArrayList<Branch> searchList = new ArrayList<>();

        switch (searchByToken) {

            case ConstantValues.SEARCH_ID:

                for (Branch element : branches)
                    if (element.getBranchId().equals(value)) {
                        searchList.add(element);
                    }
                break;

            case ConstantValues.SEARCH_NAME:
                for (Branch element : branches)
                    if (element.getName().equals(value)) {
                        searchList.add(element);
                    }
        }

        if (searchList.size() == 0) {
            printBranchList(null);
            return null;
        } else
            printBranchList(searchList);
        return searchList;
    }

    private void printBranchList(ArrayList<Branch> branches) {
        int i = 1;

        if (branches != null) {
            System.out.println("");
            System.out.println("Branch List");
            System.out.println("-----------------------");

            for (Branch element : branches)
                System.out.println("Branch " + i++ + ". " + "ID: " + element.getBranchId() +
                        "\tName: " + element.getName());
            if (branches.size() != 0)
                System.out.println("-----------------------");
            System.out.println(branches.size() + " branch(es) found.");

        } else {
            System.out.println("-----------------------");
            System.out.println("0 branch(es) found.");
        }
    }


    private void addNewMessage(Branch branch) {

        if (branch != null) {
            System.out.println("Successfully added branch. Number of branches is " + branches.size());
        } else {
            System.out.println("Could not add. Branch already present.");
        }

    }

    public String getName() {
        return name;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }
}


