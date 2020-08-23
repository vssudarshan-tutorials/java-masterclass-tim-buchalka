public class Hamburger {

    private int burgerCode;
    private String burgerName;
    private Bread bread;
    private Additions[] baseAdditions;

    public Hamburger() {
        this(new Bread(ConstantValues.breadList[0], ConstantValues.breadPriceList[0]), "Hamburger", ConstantValues.HAMBURGER_CODE);
    }

    protected Hamburger(Bread bread, String burgerName, int burgerCode, int baseAdditionSize) {
        this.bread = bread;
        this.burgerName = burgerName;
        this.burgerCode = burgerCode;
        baseAdditions = new Additions[baseAdditionSize];
    }

    protected Hamburger(Bread bread, String burgerName, int burgerCode) {
        this(bread, burgerName, burgerCode, ConstantValues.MAX_BASE_ADDITIONS);
    }
    /* Create an Additions entry in the Additions object array and return the sorted Additions array*/

    private int loadAdditions(int additionCode, Additions[] additions) {

        int index = Search.retrieveAdditionsInfo(additionCode, ConstantValues.additionCodeList);

        int insertLocation = firstNullOccurrence(additions);


        additions[insertLocation] = new Additions(ConstantValues.additionCodeList[index], ConstantValues.additionNameList[index], ConstantValues.additionPriceList[index]);

        return sortAdditions(additions, additionCode, insertLocation);
    }

    /* return the index of the first empty location in the Additions array */

    private int firstNullOccurrence(Additions[] additions) {
        int index = 0;

        while (additions[index] != null)
            index++;

        return index;
    }

    /*Selection sorting algorithm to sort the Additions array in ascending order */
    /*Invoked every time a new Additions entry is made to the Additions array. */
    /* return the new position of the newly added Additions object in the sorted array. */

    private int sortAdditions(Additions[] additions, int additionCode, int originalLocation) {
        int index = originalLocation;
        int limit = firstNullOccurrence(additions);

        for (int i = 0; i < limit - 1; i++) {

            if (additions[i] == null)
                break;
            int indexOfMin = i;

            for (int j = i + 1; j < limit; j++) {
                if (additions[j] == null)
                    break;
                if (additions[indexOfMin].getAdditionCode() > additions[j].getAdditionCode()) {
                    indexOfMin = j;
                }
            }

            if (indexOfMin != i) {
                int code = additions[indexOfMin].getAdditionCode();
                String name = additions[indexOfMin].getName();
                int quantity = additions[indexOfMin].getQuantity();
                double price = additions[indexOfMin].getPrice();

                additions[indexOfMin].setAdditionCode(additions[i].getAdditionCode());
                additions[indexOfMin].setName(additions[i].getName());
                additions[indexOfMin].setQuantity(additions[i].getQuantity());
                additions[indexOfMin].setPrice(additions[i].getPrice());

                additions[i].setAdditionCode(code);
                additions[i].setName(name);
                additions[i].setQuantity(quantity);
                additions[i].setPrice(price);

                if (code == additionCode)
                    index = i;
            }
        }
        return index;
    }

    /* Simple Binary search algorithm to search for an Additions entry in the Additions array. */
    /*Return the position of the entry in the Additions array */

    private int searchAdditions(int additionsCode, Additions[] additions) {

        int limit = firstNullOccurrence(additions);
        int index;
        int start = 0;

        for (; start <= limit; ) {
            index = (start + limit) / 2;
            if (additions[index] == null)
                break;
            if (additionsCode == additions[index].getAdditionCode())
                return index;
            else if (additionsCode < additions[index].getAdditionCode()) {
                limit = index - 1;
            } else
                start = index + 1;
        }
        return -1;
    }

    /* Create a new Additions entry or modify quantity of existing Additions entry.*/

    protected int addAdditions(int additionCode, int quantity, Additions[] additions) {

        int index = 0;

        if (additions[index] == null || (index = searchAdditions(additionCode, additions)) == -1)
            index = loadAdditions(additionCode, additions);
        return additions[index].add(quantity);

    }

    /* Overriding function with implementation in different burger types */
    protected int addAdditions(int additionCode, int quantity, boolean hasMoreAdditions) {
        return addAdditions(additionCode, quantity, this.baseAdditions);
    }

    /* Exposed method for adding Additions to the burger. */

    public int addAddition(int additionCode, int quantity) {

        switch (getBurgerCode()) {

            case ConstantValues.HAMBURGER_CODE:
                if (Search.isValidCode(additionCode, ConstantValues.baseAdditionCodeList))
                    return addAdditions(additionCode, quantity, false);
                break;

            case ConstantValues.HEALTHY_BURGER_CODE:
                if (Search.isValidCode(additionCode, ConstantValues.baseAdditionCodeList))
                    return addAdditions(additionCode, quantity, false);

                else if (Search.isValidCode(additionCode, ConstantValues.healthyAdditionCodeList))
                    return addAdditions(additionCode, quantity, true);
                break;

            case ConstantValues.DELUXE_BURGER_CODE:
                return addAdditions(additionCode, quantity, false);
        }
        return -1;
    }

    /*Return the sum of total chargeable amount for Additions */

    protected double calculator(Additions[] additions) {

        double totalAdditionsPrice = 0;

        for (Additions addition : additions)
            if (addition != null)
                totalAdditionsPrice += addition.chargeableAmount();

        return totalAdditionsPrice;
    }

    /*Return total price of burger. */

    public double getChargeableAmount() {

        return this.bread.getPrice() + calculator(this.baseAdditions);
    }

    /* Print to console the information pertaining to Additions in the specified format.*/

    protected void displayAdditionDetails(Additions[] additions) {

        for (Additions addition : additions)
            if (addition != null)
                System.out.println("Topping Name: " + addition.getName() + " Quantity: " + addition.getQuantity() +
                        " Unit Price: " + addition.getPrice() + " Total: " + addition.chargeableAmount());

    }

    /* Print to console the bread information. */

    protected void displayBreadDetails() {

        System.out.println("Charges for " + burgerName + " are as follows:\n" +
                "Bread Type: " + bread.getName() + " Price: " + bread.getPrice());
    }

    /*Print complete details of burger in the console. */

    public void showSplitUp() {
        displayBreadDetails();
        displayAdditionDetails(this.baseAdditions);
    }

    /*Getters. */

    public Bread getBread() {
        return bread;
    }

    public Additions[] getBaseAdditions() {
        return baseAdditions;
    }

    public String getBurgerName() {
        return burgerName;
    }

    public int getBurgerCode() {
        return burgerCode;
    }
}


class HealthyHamburger extends Hamburger {

    private Additions[] healthyAdditions;

    public HealthyHamburger() {
        super(new Bread(ConstantValues.breadList[1], ConstantValues.breadPriceList[1]), "Healthy Burger", ConstantValues.HEALTHY_BURGER_CODE);
        healthyAdditions = new Additions[ConstantValues.MAX_HEALTHY_ADDITIONS];
    }

    @Override
    protected int addAdditions(int additionCode, int quantity, boolean hasMoreAdditions) {

        if (hasMoreAdditions) {
            return super.addAdditions(additionCode, quantity, this.healthyAdditions);
        } else
            return super.addAdditions(additionCode, quantity, false);
    }


    @Override
    public double getChargeableAmount() {
        return super.getChargeableAmount() + calculator(this.healthyAdditions);
    }

    @Override
    public void showSplitUp() {
        super.showSplitUp();
        displayAdditionDetails(this.healthyAdditions);
    }

}

class DeluxeHamburger extends Hamburger {

    public DeluxeHamburger() {
        super(new Bread(ConstantValues.breadList[0], ConstantValues.breadPriceList[0]), "Deluxe Burger", ConstantValues.DELUXE_BURGER_CODE, ConstantValues.MAX_DELUXE_ADDITIONS);
        loadAdditions();
    }

    /* Preload Additions for the deluxe burger. */

    private void loadAdditions() {

        for (int i = 0; i < ConstantValues.deluxeAdditionCodeList.length; i++) {
            this.getBaseAdditions()[i] = new Additions(ConstantValues.deluxeAdditionCodeList[i], ConstantValues.deluxeAdditionNameList[i], ConstantValues.deluxeAdditionPriceList[i], 1);
            this.getBaseAdditions()[i].setQuantity(1);
        }
    }

    @Override
    protected int addAdditions(int additionCode, int quantity, boolean hasMoreAdditions) {
        return -1;
    }

}


