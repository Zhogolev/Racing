package com.company.race.vehicle.cars;

import com.company.race.vehicle.Vehicle;
/**
 * Cat - type of Vehicle
 * */
public class Car extends Vehicle {
    /**
     * Peoples in a car
     * */
    int peoples;

    public void setPeoples(int peoples){
        this.peoples = peoples;
    }

    public int getPeoples() {
        return peoples;
    }

    @Override
    public String toString(){
       return hashCode() + ") TYPE: CAR   " + "SPEED: " + this.getSpeed() + " PEOPLES IN CAR: " + this.getPeoples();
    }

    public Car(int peoples,int speed, int chanceToPiercedTheTire) {

        setChanceToPiercedTheTire(chanceToPiercedTheTire);
        setSpeed(speed);
        setPeoples(peoples);

    }
}
