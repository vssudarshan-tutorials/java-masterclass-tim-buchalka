public class FirstLastDigitSum {

    public static int sumFirstAndLastDigit(int number){

        if(number < 0)
            return -1;

        int sum = number % 10;
        int temp = number / 10;

        while(temp / 10 != 0){
            temp /= 10;
        }

       return sum + temp;
    }

    public static void main(String[] args) {
        System.out.println(sumFirstAndLastDigit(1));
    }

}
