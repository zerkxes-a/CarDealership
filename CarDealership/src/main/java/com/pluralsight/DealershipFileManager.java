package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DealershipFileManager {

   public static void getDealership() {
       String name = null;
       try {
           FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
           BufferedReader bufferedReader = new BufferedReader(fileReader);
           ArrayList<Dealership> dealerships = new ArrayList<>();
           String firstLine = bufferedReader.readLine();
           if (firstLine != null) {
               String[] values = firstLine.split("\\|");
               name = values[0];
               String address = values[1];
               String phone = values[2];
               dealerships.add(new Dealership(name, address, phone));
           }

       } catch (IOException e) {
           throw new RuntimeException(e);
       }
       System.out.println("Dealership name: " + name);
   }
   public static void saveDealership(){

   }
}
