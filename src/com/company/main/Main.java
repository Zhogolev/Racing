package com.company.main;

import com.company.race.Race;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        startRace();

    }


    public static void startRace() {
        Race race = new Race();

        try {

            race.init();
            race.start();

        } catch (FileNotFoundException e) {

            System.out.println("ERROR RACE INITALIZE, CHEK CONFIG FILE");
            return;
        }

        while (getAnsear()) {
            race.start();
        }
    }

    public static boolean getAnsear(){

        System.out.print("ONE MORE LAP? [Y]: ");
        Scanner in = new Scanner(System.in);
        String answear = in.nextLine();
        return answear.toUpperCase().equals("Y");
    }
}

