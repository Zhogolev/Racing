package com.company.race;

import com.company.race.vehicle.Vehicle;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
/**
 * Race .
 * Contain info about current lap, before start
 *
 * */
public class Race {
    /**
     * Array of vehical
     *
     * @see Vehicle
     *
     * * */
    private List<Vehicle> recaersCar;
    /**
     * Lap distance
     * */
    private double distanceRace;
    /**
     * Path to config file RaceConfig.json
     * */
    private String path;

    public Race(String path) {

        this.path = path;
    }
    /**
     *  By default path = "com/company/resources/RaceConfig.json"
     * */
    public Race() {

        this.path = "com/company/resources/RaceConfig.json";
    }
    /**
     * init Race configuration
     * getting racers list
     * and info about lap
     * */
    public void init() throws FileNotFoundException {
        this.recaersCar = new ArrayList <Vehicle>();

        RaceFileReader raceReader = new RaceFileReader(this.path);
        raceReader.execute();

        raceReader.setInfoAboutRacers();
        this.recaersCar = raceReader.setInfoAboutRacers();

        raceReader.setInfoAboutRace();
        this.distanceRace = raceReader.setInfoAboutRace();

        System.out.println("===========ABOUT RACE==========");
        System.out.println("RACE DISTANCE: "+ this.distanceRace);

        for (Vehicle car:recaersCar) {
            System.out.println(car.toString());
        }
    }
    /**
     * Start a race
     * */
    public  void start(){
        System.out.println("============LOG RACE===========");
        long sartTime = System.currentTimeMillis() + 3000;
        /**delay 3sec to init all threads*/

        /**
         * List of threads
         * */
        List<VehicleMoves> vehicleMoves = new ArrayList <VehicleMoves>();

        for (Vehicle vehicle:recaersCar) {
            vehicle.setRoundTime(0.);
            vehicle.setCurrentDistance(0.);
            VehicleMoves localmove = new VehicleMoves(vehicle, sartTime,distanceRace);
            vehicleMoves.add(localmove);
            localmove.start();
        }

        /**
         * Wait for all threads
         * */
        for (VehicleMoves vm:vehicleMoves) {
            try {
                vm.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        /**
         * Output results the race
         * */
        System.out.println("===========RACE RESULTS==========");

        for (Vehicle vehical :recaersCar){
            System.out.println(vehical.hashCode() + " TIME:" + vehical.getRoundTime());
        }
    }

}

