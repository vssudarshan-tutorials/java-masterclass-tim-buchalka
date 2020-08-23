public class LargestPrime {

    public static int getLargestPrime(int number){

        if(number <= 1 )
            return -1;

        int largestPrime = number;

        for(int i = 2; i <= number / 2; i++)
            if(number % i == 0) {
                boolean isPrime = true;
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if(isPrime)
                    largestPrime = i;
            }
        return largestPrime;
    }


    public static void main(String[] args) {
        System.out.println(getLargestPrime(16));
    }
}
