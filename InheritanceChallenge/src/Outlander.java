public class Outlander extends Car {

    private int roadServiceMonths;

    public Outlander(int roadServiceMonths) {
        super("Outlander", 500, 4, 4, 6, false);
        this.roadServiceMonths = roadServiceMonths;
    }


    public void accelerate(int rate) {
        int velocity = getCurrentVelocity() + rate;

        if (velocity == 0) {
            stop();
            changeGear(1);
        } else {
            if (velocity < 0)
                changeGear(-1);
            else if (velocity <= 10)
                changeGear(1);
            else if (velocity <= 40)
                changeGear(2);
            else if (velocity <= 80)
                changeGear(3);
            else if (velocity <= 120)
                changeGear(4);
            else if (velocity <= 160)
                changeGear(5);
            changeVelocity(velocity);
        }

    }

}
