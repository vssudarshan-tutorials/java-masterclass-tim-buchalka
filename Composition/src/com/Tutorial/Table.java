package com.Tutorial;

public class Table {

    private int height;
    private int length;
    private int width;
    private String material;
    private String colour;

    public Table(int height, int length, int width, String material, String colour) {
        this.height = height;
        this.length = length;
        this.width = width;
        this.material = material;
        this.colour = colour;
    }

    public void lookAtTable(boolean look){

        if(look)
            System.out.println("It's a nice " + colour + " coloured " + material + " table!");
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public String getMaterial() {
        return material;
    }

    public String getColour() {
        return colour;
    }


}
