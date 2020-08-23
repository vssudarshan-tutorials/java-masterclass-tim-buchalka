public class Main {



    public static void main(String[] args) {


        int[] userInputBurgerCode = {1, 2, 3, 4};
        int[] userInputAdditionCode = {6, 1, 4};
        int[] userInputAdditionQuantity = {10, 5, 11};
        Hamburger burger;
        for (int i = 0; i < userInputBurgerCode.length; i++) {

            System.out.println("TEST" + (i + 1));
            if ((burger = selectBurger(userInputBurgerCode[i])) != null) {

                System.out.println("Burger Selected is " + burger.getBurgerName());

                int result;
                for (int j = 0; j < userInputAdditionCode.length; j++) {
                    result = burger.addAddition(userInputAdditionCode[j], userInputAdditionQuantity[j]);

                    if (result == -1) {
                        System.out.println("Error cannot add. Exiting...");

                    }
                    System.out.println("Total Bill:");
                    burger.showSplitUp();
                    System.out.println("Total Charge: " + burger.getChargeableAmount());
                }
            } else System.out.println("Invalid Burger Option. Exiting...");
        }
    }


    public static Hamburger selectBurger(int burgerCode) {

        if (Search.isValidCode(burgerCode, ConstantValues.burgerCodeList))

            switch (burgerCode) {
                case ConstantValues.HAMBURGER_CODE:
                    return new Hamburger();
                case ConstantValues.HEALTHY_BURGER_CODE:
                    return new HealthyHamburger();
                case ConstantValues.DELUXE_BURGER_CODE:
                    return new DeluxeHamburger();
            }

        return null;
    }


}
