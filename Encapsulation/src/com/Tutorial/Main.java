package com.Tutorial;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Printer printer = new Printer(50, true);

        System.out.println(printer.printPages(20) + " sheets printed." + " Total sheets used until now is " + printer.getPagePrinted());

        printer.fillToner(50);
        System.out.println("Toner level is now " + printer.getTonerLevel());

        Printer printer1 = new Printer(50, true);


        System.out.println(printer1.printPages(5) + " sheets printed." + " Total sheets used until now is " + printer1.getPagePrinted());
        System.out.println(printer1.printPages(3) + " sheets printed." + " Total sheets used until now is " + printer1.getPagePrinted());


        printer1.fillToner(20);
        System.out.println("Toner level is now " + printer1.getTonerLevel());
    }





}
