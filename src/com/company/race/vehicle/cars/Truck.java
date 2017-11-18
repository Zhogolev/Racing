package com.company.race.vehicle.cars;

import com.company.race.vehicle.Vehicle;
/**
 * Class for keeping info about Truck type veh
 * special param - weight
 * */
public class Truck extends Vehicle{
    /**
     * weight
     * */
    private int weight;

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString(){
        return  hashCode() + ") TYPE: TRUCK " + "SPEED: " + this.getSpeed() + " WEIGHT: " + weight;
    }

    public Truck(int weight,int speed, int chanceToPiercedTheTire) {

        setChanceToPiercedTheTire(chanceToPiercedTheTire);
        setSpeed(speed);
        setWeight(weight);

    }
}
