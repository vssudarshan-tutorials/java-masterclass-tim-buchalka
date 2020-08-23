public class FactorPrinter {

    public static boolean isInvalid(int number){

        return number < 1;

    }

    public static void printFactors(int number){

        if(isInvalid(number))
            System.out.print("Invalid Value");
        else {
            System.out.println("Factors are ");
            for (int i = 1; i <= number / 2; i++)
                if (number % i == 0)
                    System.out.print(i + ", ");

            System.out.println(number);
        }
    }


    public static void factorise(int number){

        if(isInvalid(number))
            System.out.print("Invalid Value");
        else {
            int temp = number;

            System.out.println("Factorisation is ");
            System.out.print(number + " = " + "1 x ");

            int[] a = new int[100];
            int j = 0;

            for (int i = 2; i <= number / 2; i++) {

                while (temp % i == 0) {
                    a[j] = i;
                    temp /= i;
                    j++;
                }
            }

            if (j == 0)
                System.out.print(number);
            else
                for (int i = 0; i < j; i++)
                    if (i != j - 1)
                        System.out.print(a[i] + " x ");
                   else
                        System.out.print(a[i]);
        }
    }

    public static void main(String[] args) {

        factorise(24);
        System.out.println("\n" + "*********");
        printFactors(24);
    }

}
