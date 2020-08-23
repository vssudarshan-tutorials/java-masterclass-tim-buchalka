import java.util.ArrayList;

public class Branch {

    private String branchId;
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String branchId, String name) {
        this.branchId = branchId;
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void showBranchMenu(String name, int option) {

        do {
            System.out.println("\nWelcome to " + this.name + " branch (ID = " + this.branchId + ") of " + name + " Bank");


            if (option == -1) {
                System.out.println("Press:" +
                        "\n\t0. To Return to Main Menu." +
                        "\n\t1. To Add New Customer." +
                        "\n\t2. To Show All Customer." +
                        "\n\t3. To Select a Customer." +
                        "\n\t4. To Add Transaction to a Customer." +
                        "\n\t5. To Show Transactions of a Customer.");

                option = HumanMachineInteraction.enterOption(ConstantValues.branchFunctionOptionsArray);
                selectBranchOption(option);
                if (option != 0) {
                    HumanMachineInteraction.continueMessage();
                    option = -1;
                }
            } else {

                selectBranchOption(option);
                option = 0;
            }
        } while (!(option == ConstantValues.EXIT_OPTION));
    }


    private void selectBranchOption(int option) {

        switch (option) {

            case ConstantValues.EXIT_OPTION:
                exitMessage();
                break;

            case ConstantValues.ADD_OPTION:
                addNewCustomer();
                break;

            case ConstantValues.SHOW_ALL_OPTION:
                showCustomerList();
                break;

            case ConstantValues.SELECT_OPTION:
                selectCustomer();
                break;

            case ConstantValues.BRANCH_ADD_TRANSACTION:
                addTransactionValue();
                break;
            case ConstantValues.BRANCH_SHOW_TRANSACTION:
                showTransactions();
        }

    }

    private ArrayList<Customer> searchCustomerFromBank() {
        ArrayList<Customer> customerArrayList;

        System.out.println("Customer Information:");

        do {
            String customerId = HumanMachineInteraction.enterId();

            customerArrayList = searchCustomer(ConstantValues.SEARCH_ID, customerId);

        } while (customerArrayList == null);

        return customerArrayList;
    }

    private void addTransactionValue() {

        if (customers.size() != 0)
            selectCustomer(searchCustomerFromBank(), ConstantValues.ADD_OPTION);
        else {
            System.out.println("-----------------------");
            System.out.println("0 customer(s) found.");
        }
    }

    private void showTransactions() {

        if (customers.size() != 0)
            selectCustomer(searchCustomerFromBank(), ConstantValues.SHOW_ALL_OPTION);
        else {
            System.out.println("-----------------------");
            System.out.println("0 customer(s) found.");
        }
    }


    private void exitMessage() {
        System.out.println("Thank you for using " + name + " Branch. Returning to Main Menu.");
    }

    private void addNewCustomer() {

        String customerId = HumanMachineInteraction.enterId();
        String name = HumanMachineInteraction.enterName();
        String transactionValue;
        do {
            transactionValue = HumanMachineInteraction.enterTransactionValue();
        } while (!(Double.parseDouble(transactionValue) > 0));

        Customer customer = new Customer(customerId, name, Double.parseDouble(transactionValue));

        if (!searchCustomer(customer)) {
            customers.add(customer);
            addNewMessage(customer);
        }else
            addNewMessage(null);
    }

    private void showCustomerList() {
        printCustomerList(this.customers);
    }


    private void selectCustomer() {

        if (customers.size() != 0) {
            ArrayList<Customer> customerList = searchCustomer();

            if (customerList != null) {

                System.out.println("Do you want to go to the Customer menu? (y/n)");
                if (HumanMachineInteraction.enterYesNo()) {

                    selectCustomer(customerList, -1);


                } else
                    System.out.println("Returning to Branch Menu...");
            }
        }else
            System.out.println(name +" has no customers.");
    }

    private void selectCustomer(ArrayList<Customer> customerList, int option) {

        boolean flag = true;
        String customerId = customerList.get(0).getCustomerId();
        do {
            if (customerList.size() > 1) {
                customerId = HumanMachineInteraction.enterId();
            }

            for (Customer element : customerList)
                if (element.getCustomerId().equals(customerId)) {
                    element.showCustomerMenu(this.name, this.branchId, option);
                    flag = false;
                    break;
                }

            if (flag) {
                printCustomerList(null);
                HumanMachineInteraction.continueMessage();
                printCustomerList(customerList);
            }
        } while (flag);

    }

    private ArrayList<Customer> searchCustomer() {

        System.out.println("Enter Customer Id or Customer Name:");

        String value;
        do {
            value = HumanMachineInteraction.scanner.nextLine();
            if (HumanMachineInteraction.isValidId(value)) {
                return searchCustomer(ConstantValues.SEARCH_ID, value);

            } else if (HumanMachineInteraction.isValidName(value)) {
                return searchCustomer(ConstantValues.SEARCH_NAME, value);

            } else
                HumanMachineInteraction.notValidMessage();

        } while (true);

    }

    private boolean searchCustomer(Customer customer) {

        return customers.contains(customer);
    }

    private ArrayList<Customer> searchCustomer(int searchByToken, String value) {

        ArrayList<Customer> searchList = new ArrayList<>();

        switch (searchByToken) {

            case ConstantValues.SEARCH_ID:

                for (Customer element : customers)
                    if (element.getCustomerId().equals(value)) {
                        searchList.add(element);
                    }
                break;

            case ConstantValues.SEARCH_NAME:
                for (Customer element : customers)
                    if (element.getName().equals(value)) {
                        searchList.add(element);
                    }
        }

        if (searchList.size() == 0) {
            printCustomerList(null);
            return null;
        } else
            printCustomerList(searchList);
        return searchList;
    }

    private void printCustomerList(ArrayList<Customer> customers) {
        int i = 1;

        if (customers != null) {
            System.out.println("");
            System.out.println("Customer List");
            System.out.println("-----------------------");

            for (Customer element : customers)
                System.out.println("Customer " + i++ + ". " + "ID: " + element.getCustomerId() +
                        "\tName: " + element.getName());
            if (customers.size() != 0)
                System.out.println("-----------------------");
            System.out.println(customers.size() + " customer(s) found.");

        } else {
            System.out.println("-----------------------");
            System.out.println("0 customer(s) found.");
        }
    }


    private void addNewMessage(Customer customer) {

        if (customer != null) {
            System.out.println("Successfully added customer. Number of customers is " + customers.size());
        } else {
            System.out.println("Could not add. Customer already present.");
        }

    }

    public boolean equals(Object o) {

        if (!(o instanceof Branch))
            return false;
        else {
            Branch branch = (Branch) o;

            return branch.getBranchId().equals(branchId);
        }
    }

    public String getBranchId() {
        return branchId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
