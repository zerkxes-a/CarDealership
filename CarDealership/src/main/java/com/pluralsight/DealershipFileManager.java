package com.pluralsight;

import java.beans.FeatureDescriptor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DealershipFileManager {

   public static Dealership getDealership() {

       try {
           FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
           BufferedReader bufferedReader = new BufferedReader(fileReader);
           String input = bufferedReader.readLine();
           String[] items = input.split("\\|");
           String name = items[0];
           String address = items[1];
           String phone = items[2];
           Dealership dealership = new Dealership(name, address, phone);

           while ((input = bufferedReader.readLine()) != null) {
               items = input.split("\\|");
               int vin = Integer.parseInt(items[0]);
               int year = Integer.parseInt(items[1]);
               String make = items[2];
               String model = items[3];
               String vehicleType = items[4];
               String color = items[5];
               int odometer = Integer.parseInt(items[6]);
               double price = Double.parseDouble(items[7]);

               Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
               dealership.addVehicle(vehicle);
           }
           bufferedReader.close();
           return dealership;
       }
       catch (IOException e) {
           throw new RuntimeException(e);
       }
   }

   public static void saveDealership(Dealership dealership){
       try {
           FileWriter fileWriter = new FileWriter("src/main/resources/inventory.csv", false);
           fileWriter.write(dealership.toString());
           fileWriter.close();
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }
}
