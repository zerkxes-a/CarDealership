package com.pluralsight;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    static Scanner input = new Scanner(System.in);
    static ArrayList<Vehicle> inventory = new ArrayList<>();
    public static ArrayList <Vehicle> loadVehicles(){
        //USE ARRAY LIST TO READ FROM INVENTORY.CSV
        try {
            FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList<Vehicle> dealership = new ArrayList<>();
            String input;
            //ignores first line from inventory.csv
            while ((input = bufferedReader.readLine()) != null) {
                if (input.startsWith("D")) {
                    continue;
                }

                //READS FROM INVENTORY.CSV TO SORT IN DIFFERENT WAYS
                String[] items = input.split(" \\| ");
                int vin = Integer.parseInt(items[0]);
                int year = Integer.parseInt(items[1]);
                String make = items[2];
                String model = items[3];
                String vehicleType = items[4];
                String color = items[5];
                int odometer = Integer.parseInt(items[6]);
                double price = Double.parseDouble(items[7]);

                inventory.add(new Vehicle(vin, year, make, model, vehicleType, color,odometer,price));
                 }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //TODO METHOD SETUP, BUILD LATER MAY


    public static void getVehiclesByPrice(){

    }
    public static void getVehiclesByMake(){

    }
    public static void getVehiclesByYear(){

    }
    public static void getVehiclesByColor(){

    }
    public static void getVehiclesByMileage(){

    }
    public static void getVehiclesByType(){

    }
    public static void getAllVehicles() throws IOException {
        displayAllEntries();
    }
    //WRITES VEHICLE INFO INTO CSV FILE
    public static void addVehicle() {
        System.out.println("Please enter new vehicle information: ");
        System.out.print("What is the cars VIN number: ");
        int vin = input.nextInt();
        System.out.print("What is the Year of the Car: ");
        int year = input.nextInt();
        System.out.print("What brand/make is the car: ");
        String make = input.nextLine();
        System.out.print("What is the Model type of the car: ");
        String model = input.nextLine();
        System.out.print("What class of car is it(SUV, Car, Truck, Hatchback): ");
        String vehicleType = input.nextLine();
        System.out.print("What is the Color: ");
        String color = input.nextLine();
        System.out.print("What is the Odometer Reading: ");
        int odometer = input.nextInt();
        System.out.print("What is the Price");
        double price = input.nextDouble();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/inventory.csv", true))) {
            //takes in new supplied Vehicle info  and writes to inventory.csc as strings

            bufferedWriter.write(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price).toString());
            // CLOSES OUT WRITER AUTOMATICALLY HERE
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void removeVehicle(){

    }
    public static void displayAllEntries() throws IOException {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("src/main/resources/inventory.csv");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String input;
        //ignores first line from transactions.csv
        while ((input = bufferedReader.readLine()) != null) {
            if (input.startsWith("D")) {
                continue;
            }
        System.out.println("-- Showing All Current Vehicles in Inventory --");;
        System.out.println("vin | year | make | model | vehicleType | color | odometer | price");

        for (Vehicle dealership : inventory) {
            System.out.println();
        }
        }
    }
}
