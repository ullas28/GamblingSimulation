package com.bridgelabz.Gambling;

import java.util.Random;
import java.util.Scanner;

public class GamblingGame {

    /*UC1
     * As a Gambler, would start with a stake of $100 every day and bet $1 every game.*/

    public static final int STAKE = 100; // GAMBLER starts with stake of $100
    public static final int BETVALUE = 1; //Gambler bets one dollar each game

    static int newStake = STAKE;

    static int[] winCountArr = new int[30];
    static int[] looseCountArr = new int[30];
    static String[] day = new String[30];

    static int[] emptyArr = new int [30];
    static int luckyDayCount = 0;
    static int unluckyDayCount = 0;
    static int play;

    /*UC2
     * As a Gambler make $1 bet so either win or loose $1*/

    public static void winLoose(int r) {
        int winCount = 0;
        int looseCount = 0;
        Random random = new Random();
        while (true) {
            int j = random.nextInt(2);
            if (j == BETVALUE) {

                System.out.println("Gambler Wins!");
                newStake++;
                System.out.println("New Amount Inhand: " + newStake);

                /*UC3 gambler resigns if he earns 50$ profit
                 * As a Calculative Gambler if won or lost 50% of the stake, would resign for the day*/

                if (newStake == 150) {
                    day[r] = "Won";
                    System.out.println("Gambler resigns as he wins 50% more of his stake");
                    System.out.println();
                    winCountArr[r]=newStake - STAKE;
                    newStake = STAKE;
                    break;
                }
            } else {

                System.out.println("Gambler Loose!");
                newStake--;
                System.out.println("New Amount Inhand: " + newStake);

                /*UC3 gambler resigns if he loses 50$
                 *As a Calculative Gambler if won or lost 50% of the stake, would resign for the day*/

                if (newStake == 50) {
                    day[r] = "Lost";
                    System.out.println("Gambler resigns as he looses 50%  of his stake");
                    System.out.println();
                    System.out.println("Day: " + (r+1) + " Lost: "+newStake);
                    looseCountArr[r]=newStake - STAKE;
                    newStake = STAKE;
                    break;
                }
           }


        }
    }
    //UC4- After 20 days of playing every day would like to know the total amount won or lost.
    //AFTER UC5 Changed 20 days to 30 days
    void monthGame () {
        for (int day = 0; day < 30; day++) {
            System.out.println("Day " + (day + 1) + " Game starts!");// Beginning of the game
            winLoose(day);
            System.out.println("Game Ends for today!");// End of the game
            System.out.println();
        }
    }
    /* UC5 - Each month would like to know the days won and lost and by how much.*/
    void showWinLossCount(){
        for(int i=0;i<30;i++){
            if(winCountArr[i]==50) {
                System.out.println("Day: " + (i + 1) + " Total Win count: " + (++luckyDayCount) + " Won by " + winCountArr[i]);
            }else
            System.out.println("Day: "+(i+1)+ " Total Loose count: "+ (++unluckyDayCount) + " Lost by " + looseCountArr[i]);
        }
    }

    /*UC6 - Would also like to know my luckiest day where I won maximum and my unluckiest day where I lost maximum*/

    void luckydays() {
        for (int i = 0; i < 30; i++) {
            if (winCountArr[i]==50){
                System.out.println("Day" + (i + 1 ) +" won " + winCountArr[i] +" is a Lucky day");
            }
            else
                System.out.println("Day" + (i + 1 ) + " Lost " + looseCountArr[i] +" is a Unlucky day");
        }
    }
    public static void main (String[]args){

            System.out.println("Welcome to Gambling Simulation Problem.");

            Random rand = new Random();
            int j = rand.nextInt(2);
            GamblingGame gmg = new GamblingGame();
            gmg.monthGame();
            gmg.showWinLossCount();
            gmg.luckydays();
            /*UC7 - If won would like to continue playing next month or stop Gambling*/
        do{
            if(luckyDayCount>unluckyDayCount){
                luckyDayCount = 0;
                unluckyDayCount = 0;
                winCountArr = looseCountArr = emptyArr;
                System.out.println("You are doing great this month! Would you try next month too? ");
                System.out.println("Yes? Enter 1 or press any key to quit...");
                Scanner sc = new Scanner(System.in);
                play = sc.nextInt();
                if(play==1) {
                    gmg.monthGame();
                    gmg.showWinLossCount();
                    gmg.luckydays();
                }

            }else{
                System.out.println("You are out of luck and money this month! Better try Gambling later when you have enough money");
                break;
            }

        }while(play==1);
        }
    }

