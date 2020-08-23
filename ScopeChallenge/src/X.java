public class X {

    private int x = 0;

    static {
        int a = 10;
a=0;

    }

    public void x() {
       
        String x;

        do {
            System.out.println("Enter Number\n");
            x = Main.x.nextLine();
        } while (!x(x));

        x(Integer.parseInt(x));
    }

    public boolean x(String x) {


        try {
            Integer.parseInt(x);
        } catch (NumberFormatException e) {

            System.out.println("Illegal");
            return false;
        }

        return true;
    }


    public void x(int x) {

        while (this.x <= 12) {
            System.out.println(x + " x " + this.x + " = " + x * this.x++);
        }
    }


}
