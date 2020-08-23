public class MinutesToYearsDaysCalculator {

    public static final String INVALID_MESSAGE = "Invalid Value";
    public static final long MIN_IN_YEAR = 365 * 24 * 60;

    public static void printYearsAndDays(long minutes){

            if(minutes < 0)
                System.out.printf(INVALID_MESSAGE);
            else
                System.out.println(addZero(minutes) + " min = "
                                 + addZero(minutes / MIN_IN_YEAR) + " y and "
                                 + addZero((minutes % MIN_IN_YEAR) / (24 * 60) ) + " d");


    }

    public static String addZero(long s){

        if(s < 10)
        return "0" + s;

        return "" + s;
    }

    public static void main(String[] args) {

        printYearsAndDays(561600);
    }

}
