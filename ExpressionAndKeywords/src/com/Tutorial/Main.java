package com.Tutorial;

public class Main {

    public static void displayHighScorePosition(String pName, int pos){

        System.out.println("Congratulations " + pName
                            + "! Your position is " + pos
                            + " on the High Score Table.");
    }

    public static int calculateHighScorePosition(int pScore){

        if(pScore >= 1000)
            return 1;
        else if(pScore >= 500)
            return 2;
        else if(pScore >= 100)
            return 3;

        return 4;
    }

    public static void main(String[] args) {

        String pName = "Ravi";

        int pScore = 1500;
        displayHighScorePosition(pName, calculateHighScorePosition(pScore));

        pScore = 900;
        displayHighScorePosition(pName, calculateHighScorePosition(pScore));

        pScore = 400;
        displayHighScorePosition(pName, calculateHighScorePosition(pScore));

        pScore = 50;
        displayHighScorePosition(pName, calculateHighScorePosition(pScore));
    }
}
