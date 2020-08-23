package com.Tutorial;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Table table = new Table(2,5,2, "Oak", "Dark Brown");
        RoomWindow window = new RoomWindow(3,2, "Tinted", "blue");
        Door door = new Door(7, 3, "Plastic", "White");

        Room room = new Room(door, window, table);

//        room.getDoor().knockDoor(true);
//        room.getTable().lookAtTable(true);
//        room.getWindow().openWindow(true);

        room.lookAround();

    }
}
