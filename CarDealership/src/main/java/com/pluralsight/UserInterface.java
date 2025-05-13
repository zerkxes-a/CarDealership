package com.pluralsight;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class UserInterface {
    static Scanner input = new Scanner(System.in);
    static DealershipFileManager dealershipFileManager = new DealershipFileManager();
    //         DATA TYPE           VARIABLE                    VALUE
    private Dealership dealership;

    public void display(){
        init();

        System.out.println("Welcome to Dealership Management App: ");

        while (true) {

            System.out.println("Please choose from the following Options \n");

            System.out.println("1) Add Vehicle to Inventory");
            System.out.println("2) Remove Vehicle from Inventory");
            System.out.println("3) Vehicle Display Sorting Option");

            System.out.print("Please enter your number Selection here:  ");

            String choice = input.nextLine();
            switch (choice) {
                case "1":
                    processAddVehicleRequest();
                    break;
                case "2":
                    processRemoveVehicleRequest();
                    break;
                case "3":
                    try {
                        displayVehicles();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
            }
        }

    }

    private  void init() {
        dealership = DealershipFileManager.getDealership();
    }

    private  void displayVehicles() throws IOException {
        System.out.println("Please choose how you would like to display Vehicle info:\n ");

        System.out.println("1) Sort by Price ");
        System.out.println("2) Get Car by Make and Model");
        System.out.println("3) Get Cars by Year");
        System.out.println("4) Get Cars by Color");
        System.out.println("5) Get Cars by Mileage");
        System.out.println("6) Get Cars by Vehicle Type");
        System.out.println("7) Get all Vehicles in Inventory");

        System.out.print("Please enter your number Selection here:  ");
        String choice = input.nextLine();
        switch (choice) {
            case "1":
                processGetByPriceRequest();
                break;
            case "2":
                processGetByMakeModelRequest();
                break;
            case "3":
                processGetByYearRequest();
                break;
            case "4":
                processGetByColorRequest();
                break;
            case "5":
                processGetByMileageRequest();
                break;
            case "6":
                processGetByVehicleTypeRequest();
                break;
            case "7":
                processGetAllVehiclesRequest();
                break;

        }
    }


    private void processGetByPriceRequest(){
        System.out.print("Please enter the Max Price:  ");
        double maxPrice = input.nextDouble();
        input.nextLine();
        System.out.print("Please enter the Min Price:  ");
        double minPrice = input.nextDouble();
        input.nextLine();
        dealership.getVehiclesByPrice(minPrice,maxPrice).forEach(System.out::println);
    }
    private void processGetByMakeModelRequest(){
        System.out.print("Please enter the vehicle Manufacturer:  ");
        String make = input.nextLine();
        input.nextLine();
        System.out.print("Please enter the vehicle Model:  ");
        String model = input.nextLine();
        input.nextLine();
        dealership.getVehiclesByMake(make, model).forEach(System.out::println);
    }
    private void processGetByYearRequest(){
        System.out.print("Please enter the Min Year:  ");
        int minYear = input.nextInt();
        input.nextLine();
        System.out.print("Please enter the Max Year:  ");
        int maxYear = input.nextInt();
        input.nextLine();
        dealership.getVehiclesByYear(minYear,maxYear).forEach(System.out::println);
    }
    private void processGetByColorRequest(){
        System.out.print("Car Color: ");
        String colorChoice = input.nextLine();
        input.nextLine();
        dealership.getVehiclesByColor(colorChoice).forEach(System.out::println);
    }
    private void processGetByMileageRequest(){
        System.out.print("Please enter the Min Odomoter Reading:  ");
        int minOdometer = input.nextInt();
        input.nextLine();
        System.out.print("Please enter the Max Odometer Reading:  ");
        int maxOdometer = input.nextInt();
        input.nextLine();
        dealership.getVehiclesByMileage(minOdometer,maxOdometer).forEach(System.out::println);
    }
    private void processGetByVehicleTypeRequest(){
        System.out.print("Please enter a Vehicle Type: ");
        String typeChoice = input.nextLine();
        input.nextLine();
        dealership.getVehiclesByType(typeChoice).forEach(System.out::println);
    }
    private void processGetAllVehiclesRequest()  {
        dealership.getAllVehicles().forEach(System.out::println);

    }
    private void processAddVehicleRequest(){
        System.out.println("-Please enter Information to add a Car to the System-");
        System.out.print("Vin Number: ");
        int vin = input.nextInt();
        System.out.print("Year: ");
        int year = input.nextInt();
        input.nextLine();
        System.out.print("Make: ");
        String make = input.nextLine();
        System.out.print("Model: ");
        String model = input.nextLine();
        System.out.print("Vehicle Type: ");
        String vehicleType = input.nextLine();
        System.out.print("Color: ");
        String color = input.nextLine();
        System.out.print("Odometer Reading: ");
        int odometerReading = input.nextInt();
        System.out.print("Price: ");
        double price = input.nextDouble();
        input.nextLine();
        dealership.addVehicle(new Vehicle(vin, year, make, model, vehicleType, color, odometerReading, price));
    }
    private void processRemoveVehicleRequest(){

    }
}
