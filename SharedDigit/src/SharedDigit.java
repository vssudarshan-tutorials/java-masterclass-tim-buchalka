public class SharedDigit {

    public static boolean hasSharedDigit(int num1, int num2){

        if(num1 < 10 || num1 > 99 || num2 < 10 || num2 > 99 )
            return false;

        int temp1 = num1;
        int temp2 = num2;

        while(temp1 != 0){

            while(temp2 != 0){

                if(temp2 % 10 == temp1 % 10)
                    return true;

                temp2 /= 10;
            }

            temp2 = num2;
            temp1 /= 10;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasSharedDigit(12,13));
    }


}
