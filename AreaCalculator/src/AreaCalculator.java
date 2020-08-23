public class AreaCalculator {

        public static double area(double radius){

            if(radius < 0)
                return -1.0;

            return Math.PI * radius * radius;

        }

        public static double area(double x, double y){

            if(x < 0 || y <0)
                return -1.0;

            return x * y;

        }

    public static void main(String[] args) {

        System.out.println(area(10,11));
        System.out.println(area(10,-11));
        System.out.println(area(-10,11));
        System.out.println(area(-1));
        System.out.println(area(10));
    }




}
