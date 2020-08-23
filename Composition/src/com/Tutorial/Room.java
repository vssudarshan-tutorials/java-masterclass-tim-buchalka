package com.Tutorial;

public class Room {

    private Door door;
    private RoomWindow window;
    private Table table;

    public Room(Door door, RoomWindow window, Table table) {
        this.door = door;
        this.window = window;
        this.table = table;
    }

    public void lookAround(){
        door.knockDoor(true);
        window.openWindow(true);
        table.lookAtTable(true);
    }


//    public Door getDoor() {
//        return door;
//    }
//
//    public RoomWindow getWindow() {
//        return window;
//    }
//
//    public Table getTable() {
//        return table;
//    }

}
