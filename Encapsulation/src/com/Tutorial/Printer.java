package com.Tutorial;

public class Printer {

    private double tonerLevel;
    private int pagePrinted;
    private boolean isDuplex;

    public Printer(int tonerLevel, boolean isDuplex) {

        if (tonerLevel >= 0 && tonerLevel <= 100)
            this.tonerLevel = tonerLevel;
        else {
            System.out.println("Invalid Value! Toner level set to 0.");
            this.tonerLevel = -1;
        }


        this.pagePrinted = 70;
        this.isDuplex = isDuplex;
    }

    public double fillToner(double tonerAmount) {
        if (tonerAmount <= 100 && tonerAmount > 0)

            if (tonerLevel + tonerAmount <= 100)
                tonerLevel += tonerAmount;
            else
                return -1;
        else
            return -1;

        return tonerLevel;
    }


    public int printPages(int pages) {

        int sheetsUsed = pages;

        if (this.isDuplex) {
            System.out.println("In Duplex Mode...");
            sheetsUsed =  (pages / 2) + (pages % 2);
        }
        else
            System.out.println("In Normal Mode...");

        pagePrinted += sheetsUsed;
        System.out.println("Pages printed!");
        return sheetsUsed;
    }


    public double getTonerLevel() {
        return tonerLevel;
    }

    public int getPagePrinted() {
        return pagePrinted;
    }

    public boolean isDuplex() {
        return isDuplex;
    }
}
