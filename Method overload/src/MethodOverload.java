public class MethodOverload {

   public static double calcFeetAndInchesToCentimeter(double inches){

       if(inches < 0.0)
           return -1.0;

       return  inches * 2.54;

   }

    public static double calcFeetAndInchesToCentimeter(double feet, double inches){

        if(feet < 0.0 || inches < 0.0 || inches >= 12.0)
            return -1.0;
        return calcFeetAndInchesToCentimeter(feet * 12.0 + inches);
    }

    public static void main(String[] args) {

        System.out.println(calcFeetAndInchesToCentimeter(120.0));
        System.out.println(calcFeetAndInchesToCentimeter(5.0,11.0));


    }


}
