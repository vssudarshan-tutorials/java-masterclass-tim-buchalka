package com.Tutorial;

import javax.swing.plaf.IconUIResource;

public class Door {

    private int height;
    private int width;
    private String material;
    private String colour;

    public Door(int height, int width, String material, String colour) {
        this.height = height;
        this.width = width;
        this.material = material;
        this.colour = colour;
    }

    public void knockDoor(boolean knock){

        if(knock)
            System.out.println("Knocking the door...!");

    }

    public int getHeight() {
        return height;
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
