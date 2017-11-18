package com.company.race.vehicle.cars;

import com.company.race.vehicle.Vehicle;
/**
 * Class for keeping info about bike wehicle
 * has sidecar
 * */

public class Bike extends Vehicle {
    /**
     *  sidecar
     * */
    private String sidecar;

    public void setSetSidecar(String setSidecar) {
        this.sidecar = setSidecar;
    }

    public String getSetSidecar() {
        return sidecar;
    }

    @Override
    public String toString(){

        return hashCode()  + ") TYPE: BIKE  " + "SPEED: " + this.getSpeed() + " SIDECAR: " + sidecar.toUpperCase();
    }

    public Bike(String hasSidecar,int speed, int chanceToPiercedTheTire) {

        setChanceToPiercedTheTire(chanceToPiercedTheTire);
        setSpeed(speed);

        setSetSidecar(hasSidecar);

    }
}
