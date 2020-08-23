public class Car extends Vehicle {

    private int wheels;
    private int doors;
    private int gears;
    private boolean isManual;

    private int currentGear;

    public Car(String name, int weight, int wheels, int doors, int gears, boolean isManual) {
        super(name, weight);
        this.wheels = wheels;
        this.doors = doors;
        this.gears = gears;
        this.isManual = isManual;
        this.currentGear = 1;
    }

    public void changeGear(int gear) {
        currentGear = gear;

        if (currentGear == -1)
            System.out.println("Changed gear to reverse.");
        else
            System.out.println("Changed gear to " + currentGear);
    }

    public void changeVelocity(int velocity){

        if(velocity < 0)
            velocity = -velocity;

        move(velocity, getCurrentDirection());

    }


}
