package com.company.race.vehicle;

import java.util.Random;

/**
 * Contain general params about vehicle
 * And how it moving
 * */
public class Vehicle {
    /**
     * Vehicle speed
     * */
    private int speed;
    /**
     * Chance to pierced the tire
     * */
    private int chanceToPiercedTheTire;
    /***
     * Lap time
     */
    private double roundTime;
    /**
     * Current distance frome start
     * */
    private double currentDistance;

    private int id;

    public void setCurrentDistance(double currentDistance) { this.currentDistance = currentDistance; }

    public double getCurrentDistance() {
        return currentDistance;
    }

    public void setRoundTime(double roundTime) {
        this.roundTime = roundTime;
    }

    public double getRoundTime() { return roundTime; }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setChanceToPiercedTheTire(int chanceToPiercedTheTire) {
        this.chanceToPiercedTheTire = chanceToPiercedTheTire;
    }

    public int getSpeed() {
        return speed;
    }

    public int getChanceToPiercedTheTire() {
        return chanceToPiercedTheTire;
    }


    public Vehicle() {
        this.id = this.hashCode();
        this.roundTime = 0.;
        this.currentDistance = 0.;
    }
    /**
     * Take minimal from
     * remaining distance
     * and (speed * (delta time))
     * @param distance lap distance,
     * @param time delta time
     * */
    public void nextMove(double distance,double time){

        if(speed == 0){
            speed = 1;
        }
        /**
         * Chose minimal distance
         *
         * */
        double minDistance = Math.min(speed * time , distance - currentDistance);

        this.currentDistance += minDistance;
        this.roundTime += minDistance/speed;

        int delayTime = (int)(time * 1000);

        try {
            Thread.sleep(delayTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * Method that realize a pit-stop
     * with random pause to repair a tier
     * */
    public void nextPitStop(){

        int randomTimeDalay = 1 +  new Random().nextInt(3);

        this.roundTime += randomTimeDalay;

        System.out.println("BROKEN " + id + " TIME FOR PIT STOP " + randomTimeDalay  +" SEC");

        try {
            Thread.sleep(randomTimeDalay * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
