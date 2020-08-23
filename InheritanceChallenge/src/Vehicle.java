public class Vehicle {

    private String name;
    private int weight;

    private int currentDirection;
    private int currentVelocity;

    public Vehicle(String name, int weight) {
        this.name = name;
        this.weight = weight;
        currentDirection = 0;
        currentVelocity = 0;
    }


    public void steer(int direction) {
        currentDirection += direction;
        System.out.println("Steering at angle: " + currentDirection + " and velocity " + currentVelocity);
    }

    public void move(int velocity, int direction) {
        currentVelocity = velocity;
        currentDirection = direction;
        System.out.println("Moving at velocity: " + currentVelocity + " and angle: " + currentDirection);

    }

    public void stop() {
        currentVelocity = 0;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    public int getCurrentVelocity() {
        return currentVelocity;
    }
}
