public class NumberToWords {

    public static int reverse(int num){

        int temp = 0;

        while(num != 0){
            temp = (temp * 10) + (num % 10);
            num = num / 10;
        }
        return temp;
    }

    public static int getDigitCount(int num){

        if(num < 0)
            return -1;
        else
           if(num == 0)
                return 1;

        int count = 0;
        for (; num != 0; count++)
            num /= 10;

        return count;

    }

    public static void numberToWords(int number){

        if(number < 0)
            System.out.println("Invalid Value");
        else{

            int temp = number;
            System.out.print(temp + " = ");

            int digitCount = getDigitCount(temp);
            temp = reverse(temp);

            while(temp != 0 || digitCount != 0){

                switch(temp % 10){
                    case 0:
                        System.out.print("Zero ");
                        break;
                    case 1:
                        System.out.print("One ");
                        break;
                    case 2:
                        System.out.print("Two ");
                        break;
                    case 3:
                        System.out.print("Three ");
                        break;
                    case 4:
                        System.out.print("Four ");
                        break;
                    case 5:
                        System.out.print("Five ");
                        break;
                    case 6:
                        System.out.print("Six ");
                        break;
                    case 7:
                        System.out.print("Seven ");
                        break;
                    case 8:
                        System.out.print("Eight ");
                        break;
                    case 9:
                        System.out.print("Nine ");
                        break;
                }
                digitCount--;
                temp /= 10;
            }
        }
    }

    public static void main(String[] args) {
        numberToWords(0);
    }


}
