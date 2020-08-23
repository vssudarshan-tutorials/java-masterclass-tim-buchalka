public class Strings {

    public static void main (String[] args){

        String myString = "Hi there!";
        System.out.println(myString);
        myString = myString + " Are you alright?";
        System.out.println(myString);
        myString = myString + " Yes \u0041\u0042\u0045!";
        System.out.println(myString);
        boolean b = true;
        int i = 9;
        myString = i + "";
        System.out.println(myString);

    }
}
