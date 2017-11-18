package com.company.race;

import com.company.race.vehicle.Vehicle;

import java.util.Date;
import java.util.Random;


/**
 * Thread with racing car
 * */
public class VehicleMoves extends Thread {
    /**
     * Racing car
     * */
    private Vehicle vehicle;
    /**
     * Contain global start time for each car
     * */
    private Date startTime;
    /**
     * Lap distance
     * */
    private double distanceRace;

    public VehicleMoves(Vehicle vehicle, long startTime,double distanceRace) {
        this.vehicle = vehicle;
        this.startTime =  new Date(startTime);
        this.distanceRace = distanceRace;

    }

    @Override
    public void run() {
        while (startTime.after(new Date())) {
            /**
             * All racing car will start a race in one time
             * */}
        int chance = vehicle.getChanceToPiercedTheTire();
        /**
         *while car's current position
         * is not a end of lap
         * car doing a step
         * */
        while (distanceRace > vehicle.getCurrentDistance()) {
            /**
             * if car chance to be broken less than
             * random chance on a step ,  car keep
             * moving else - doing a pit-stop
             * */
            if (chance <= new Random().nextInt(100)) {
                vehicle.nextMove(distanceRace, 0.1); //time magic, приращение времени за которое оцениваем движ.
            } else {
                vehicle.nextPitStop();
            }
        }

    }
}
