public class ForLoop {

    public static double calculateInterest(double amount, double rate){

        return amount * (rate / 100);
    }

    public static boolean isPrime(int num){

        if(num == 1 || num == 0)
            return false;

        for(int i = 2; i <= Math.sqrt(num); i++)
            if(num % i == 0)
                return false;

        return true;

    }



    public static void main(String[] args) {

        for( int i = 2; i <= 8; i++)
            System.out.println(calculateInterest(10000, i));

        System.out.println("______________________________");

        for( int i = 8; i >= 2; i--)
            System.out.println(String.format("%.2f",calculateInterest(10000, i)));

        System.out.println("____________________________________");

        int count = 0;
        for(int i = 10; i < 50; i++ ) {
            if (isPrime(i)) {
                System.out.println("Found Prime "+ i);
                count++;
                if (count == 3)
                    break;
            }
        }

    }


}
