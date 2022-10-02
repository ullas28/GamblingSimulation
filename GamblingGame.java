package com.bridgelabz.Gambling;

import java.util.Random;

public class GamblingGame {
    
    /*UC1
    * As a Gambler, would start with a stake of $100 every day and bet $1 every game.*/

    public static final int STAKE = 100; // GAMBLER starts with stake of $100
    public static final int BETVALUE = 1; //Gambler bets one dollar each game

    /*UC2
    * As a Gambler make $1 bet so either win or loose $1*/

    public static void winLoose(int r, int BETVALUE){

        if (r == BETVALUE){
            System.out.println("Gambler Wins!");
        }

        else{
            System.out.println("Gambler Loose!");

        }
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Gambling Simulation Problem.");

        Random rand = new Random();
        int r = rand.nextInt(2);
        winLoose(r,BETVALUE);
        }
    }
