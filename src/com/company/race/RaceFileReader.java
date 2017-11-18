package com.company.race;

import com.company.json.JSONArray;
import com.company.json.JSONObject;
import com.company.race.vehicle.Vehicle;
import com.company.race.vehicle.cars.Bike;
import com.company.race.vehicle.cars.Car;
import com.company.race.vehicle.cars.Truck;
import com.sun.org.apache.bcel.internal.util.ClassLoader;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Using for getting data from config file
 */
public class RaceFileReader {
    /**
     *  Contain path to raceconfig  file
     */
    private String path;
    /**
     * Contain data from config file
     */
    private String jsonString;


        /**
         * Constructor with the path to config file {@link #jsonString}
         * @param path to file
         */
        public RaceFileReader(String path){
            jsonString = "";
            this.path = path;
        }
        /**
         * Getting data from file {@link #path}
         * For getting object used  {@link #setInfoAboutRacers()} и {@link #setInfoAboutRace}
         * */
        public void  execute() throws FileNotFoundException {


            ClassLoader cl = new ClassLoader();
            System.out.println(path);
            String localPath = cl.getResource(path).toString();

            localPath = localPath.replaceAll("file:/","");
            File file = new File(localPath);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;

            try {
                while ((line = bufferedReader.readLine()) != null)
                    jsonString += line;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /**Get parametrs about racers from @jsonString
         * @return vehicles
         *
         * @see #execute()
         *
         * */
        public List<Vehicle> setInfoAboutRacers(){
           /**
            * Create mew array of vehicles
            * to return
            * */
           List<Vehicle> vehicles = new ArrayList <Vehicle>();
          /**
           * Get JSON object like HashMap from string
           * */
           JSONObject jsonObject = new JSONObject(jsonString);
           /**
            * Get array of JSON object. Will be converted to simple array of J.L.O
            * */
           JSONArray lvehicles =  jsonObject.getJSONArray("vehicles");
           /**
            * Current array.
            * */
           List <Object> listVehicles = lvehicles.toList();

           for (Object vehicle:listVehicles)
               try {
                   /**
                    * Convert an Obj to hashmap
                    * */
                   HashMap hmpVehicle =  (HashMap) vehicle;
                   /**
                    *  Getting general information
                    * */
                   String type = hmpVehicle.get("type").toString();
                   int speed = Integer.parseInt(hmpVehicle.get("speed").toString());
                   int chance = Integer.parseInt(hmpVehicle.get("chance").toString());
                   /**
                    * Creating special types of vehicles
                    *
                    * @see Car
                    * @see Truck
                    * @see Bike
                    * */
                   switch (type.toUpperCase()) {
                       case "CAR":

                           int people =  Integer.parseInt(hmpVehicle.get("special").toString());

                           vehicles.add(new Car(people, speed, chance));

                           break;

                       case "TRUCK":

                           int weight = Integer.parseInt(hmpVehicle.get("special").toString());

                           vehicles.add(new Truck(weight, speed, chance));

                           break;

                       case "BIKE":

                           String sidecar = hmpVehicle.get("special").toString();

                           vehicles.add(new Bike(sidecar, speed, chance));

                           break;

                   }
               } catch (Exception ex) {/**skip any way */}
            return  vehicles;
        }
    /**
     * getting info from @jsonString
     * about race
     *
     * @see #execute()
     *
     * */
    public  double setInfoAboutRace(){

        JSONObject jsonObject = new JSONObject(jsonString);
        return Double.valueOf(jsonObject.get("distance").toString());

    }

}
