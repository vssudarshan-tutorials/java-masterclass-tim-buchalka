package com.Tutorial;

public class Main {

    public static void main(String[] args) {
        // write your code here

        int i = 0;

        while (i < 5) {
            Car car = selectCar();
            System.out.println("\nCar Selected is " + car.getName() + "\nCylinders: " + car.getNumberOfCylinders());
            car.startEngine();
            car.accelerate();
            car.brake();
            i++;
        }


    }


    public static Car selectCar() {

        switch ((int) (Math.random() * 3) + 1) {

            case 1:
                return new Maruti800();
            case 2:
                return new Porche();
            case 3:
                return new Reva();
            default:
                return null;
        }
    }

}


class Car {

    private String name;
    private int numberOfCylinders;
    private int numberOfWheels;
    private boolean hasEngine;

    public Car(String name, int numberOfCylinders) {
        this.name = name;
        this.numberOfCylinders = numberOfCylinders;
        this.numberOfWheels = 4;
        this.hasEngine = true;
    }

    public void startEngine() {

        System.out.println("Ignition on...");
    }

    public void accelerate() {
        System.out.println("Speeding up...");
    }

    public void brake() {
        System.out.println("Slowing down...");
    }

    public String getName() {
        return name;
    }

    public int getNumberOfCylinders() {
        return numberOfCylinders;
    }
}


class Maruti800 extends Car {

    public Maruti800() {
        super("Maruti800", 4);
    }

    @Override
    public void startEngine() {
        System.out.println("The steady sound of a well maintained vehicle.");
    }

    @Override
    public void accelerate() {
        System.out.println("Steadily speeding up.");
    }

    @Override
    public void brake() {
        System.out.println("Smooth deceleration.");
    }
}


class Porche extends Car {

    public Porche() {
        super("Porche", 6);
    }

    @Override
    public void startEngine() {
        System.out.println("The low rumble of a beast");
    }

    @Override
    public void accelerate() {
        System.out.println("The beast awakens.");
    }

    @Override
    public void brake() {
        System.out.println("Taming the beast.");
    }

    public void camo() {
        System.out.println("Camouflage On.");
    }

}

class Reva extends Car{

    public Reva(){
        super("Reva", 0);
    }

}