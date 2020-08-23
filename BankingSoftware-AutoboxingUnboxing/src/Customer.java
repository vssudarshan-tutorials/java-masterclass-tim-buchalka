import java.util.ArrayList;

public class Customer {

    private String customerId;
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String customerId, String name, Double transactionValue) {
        this.customerId = customerId;
        this.name = name;
        this.transactions = new ArrayList<>();
        transactions.add(transactionValue);
    }

    public void showCustomerMenu(String name, String branchId, int option) {

        do {
            System.out.println("Customer " + this.name + " (ID = " + this.customerId + ") from " + name + " Branch (ID = " + branchId + ")");


            if (option == -1) {
                System.out.println("Press:" +
                        "\n\t0. To Return to Branch Menu." +
                        "\n\t1. To Add Transaction." +
                        "\n\t2. To Show Transactions.");

                option = HumanMachineInteraction.enterOption(ConstantValues.branchFunctionOptionsArray);
                selectCustomerOption(option);
                if (option != 0) {
                    HumanMachineInteraction.continueMessage();
                    option = -1;
                }
            } else {
                selectCustomerOption(option);
                option = 0;
            }
        } while (!(option == ConstantValues.EXIT_OPTION));
    }

    private void selectCustomerOption(int option) {

        switch (option) {

            case ConstantValues.EXIT_OPTION:
                exitMessage();
                break;

            case ConstantValues.ADD_OPTION:
                addNewTransaction();
                break;

            case ConstantValues.SHOW_ALL_OPTION:
                showTransactions();
                break;
        }

    }

    private void exitMessage() {
        System.out.println("Returning to Branch Menu.");
    }

    private void addNewTransaction() {

        String transactionValue = HumanMachineInteraction.enterTransactionValue();
        transactions.add(Double.valueOf(transactionValue));
        addNewMessage();
    }

    private void showTransactions() {
        printTransactionList(this.transactions);
    }

    private void printTransactionList(ArrayList<Double> transactions) {
        int i = 1;

        if (transactions != null) {
            System.out.println("");
            System.out.println("Transaction List");
            System.out.println("-----------------------");

            for (Double element : transactions)
                System.out.println("Transaction " + i++ + ". " + "Amount: " + element);
            if (transactions.size() != 0)
                System.out.println("-----------------------");
            System.out.println(transactions.size() + " transaction(s) found.");

        } else
            System.out.println("0 transaction(s) found.");
    }


    private void addNewMessage() {
        System.out.println("Successfully added transaction. Number of transactions done is " + transactions.size());
    }

    public boolean equals(Object o) {

        if (!(o instanceof Customer))
            return false;
        else {
            Customer customer = (Customer) o;

            return customer.getCustomerId().equals(customerId);
        }
    }


    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
