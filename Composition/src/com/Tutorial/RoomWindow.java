package com.Tutorial;

public class RoomWindow {

    private int height;
    private int width;
    private String glassType;
    private String colour;

    public RoomWindow(int height, int width, String glassType, String colour) {
        this.height = height;
        this.width = width;
        this.glassType = glassType;
        this.colour = colour;
    }

    public void openWindow(boolean open){
        if(open)
            System.out.println("Opening the window...!");
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getGlassType() {
        return glassType;
    }

    public String getColour() {
        return colour;
    }


}
