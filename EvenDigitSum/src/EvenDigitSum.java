public class EvenDigitSum {

    public static int getEvenDigitSum(int number){

        if(number < 0)
            return -1;

        int sum = 0;
        int temp = number;

        while(temp != 0){

            if((temp % 10) % 2 == 0)
                sum += temp % 10;

            temp /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(2));
    }

}
