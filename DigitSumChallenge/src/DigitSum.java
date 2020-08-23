public class DigitSum {

    public static int sumDigits(int number) {

//        if (number < 10)
//            return -1;

        int temp = number < 0 ? -number : number;
        int sum = 0;

        do {
            sum += temp - ((temp / 10) * 10);
            temp /= 10;
        } while (temp != 0);

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumDigits(-123));
    }
}
