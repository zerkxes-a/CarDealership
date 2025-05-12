package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    static Scanner input = new Scanner(System.in);
    static DealershipFileManager dealershipFileManager = new DealershipFileManager();
    //         DATA TYPE           VARIABLE                    VALUE
    private Dealership dealership;

    public static void main(String[] args) {
        display();
    }

    public static void display() {
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
                    displayVehicles();
            }
        }

    }

    private static void init() {
        DealershipFileManager.getDealership();
    }

    private static void displayVehicles(){
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


    private static void processGetByPriceRequest(){

    }
    private static void processGetByMakeModelRequest(){

    }
    private static void processGetByYearRequest(){

    }
    private static void processGetByColorRequest(){

    }
    private static void processGetByMileageRequest(){

    }
    private static void processGetByVehicleTypeRequest(){

    }
    private static void processGetAllVehiclesRequest(){
        
    }
    private static void processAddVehicleRequest(){

    }
    private static void processRemoveVehicleRequest(){

    }
}
