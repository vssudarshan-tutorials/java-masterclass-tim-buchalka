public class Palindrome {

    public static boolean isPalindrome(int number){

        if(number < 10 && number > -10)
            return false;

        int rNumber = 0;
        int temp = number;

        do {
            rNumber = (rNumber * 10) + (temp % 10);
            temp /= 10;
        } while(temp != 0);

        return rNumber == number;
    }

    public static void main(String[] args) {
        System.out.println("Palindrome status is " + isPalindrome(-1));
    }
}
