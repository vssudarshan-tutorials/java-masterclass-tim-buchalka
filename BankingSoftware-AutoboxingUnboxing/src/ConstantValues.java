import java.util.ArrayList;

public class ConstantValues {


    public static final int EXIT_OPTION = 0;
    public static final int ADD_OPTION = 1;
    public static final int SHOW_ALL_OPTION = 2;
    public static final int SELECT_OPTION = 3;
    public static final int BANK_ADD_CUSTOMER = 4;
    public static final int BANK_SHOW_CUSTOMER = 5;
    public static final int BANK_ADD_TRANSACTION = 6;

    public static final int BRANCH_ADD_TRANSACTION = 4;
    public static final int BRANCH_SHOW_TRANSACTION = 5;

    public static final int SEARCH_ID = 1;
    public static final int SEARCH_NAME = 2;

    public static final int[] bankFunctionOptionsArray = {EXIT_OPTION, ADD_OPTION, SHOW_ALL_OPTION, SELECT_OPTION,
                                                          BANK_ADD_CUSTOMER, BANK_SHOW_CUSTOMER,
                                                          BANK_ADD_TRANSACTION};

    public static final int[] branchFunctionOptionsArray = {EXIT_OPTION, ADD_OPTION, SHOW_ALL_OPTION, SELECT_OPTION,
                                                            BRANCH_ADD_TRANSACTION, BRANCH_SHOW_TRANSACTION};

    public static ArrayList<Branch> branchList = new ArrayList<>();

    public static void initialize() {

//        char c = 97;
//        for (int i = 1; i < 5; i++, c++)
//            branchList.add(new Branch(Integer.valueOf(i).toString(), Character.valueOf(c).toString()));
//        branchList.add(new Branch("5", "b"));
    }


}
