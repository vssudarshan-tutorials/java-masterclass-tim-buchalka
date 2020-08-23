import java.util.Scanner;

public class ReadInput {


    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter Year of Birth ");
        int yearOfBirth = scanner.nextInt();

        scanner.nextLine();  // handle next time character (return key)

        System.out.println("Enter name");
        String name = scanner.nextLine();

        System.out.println("Age is " + (2020 - yearOfBirth));
        scanner.close();
    }

}
