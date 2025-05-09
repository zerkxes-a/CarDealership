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

            System.out.println("1)");
            System.out.println("2)  ");
            System.out.println("Option ");

            System.out.print("Please enter your number Selection here:  ");

            String choice = input.nextLine();
            switch (choice) {
                case "1":
                    break;
                case "2":
                    break;
            }
        }

    }

    private static void init() {
        DealershipFileManager.getDealership();
    }

    private static void displayVehicles(){
        
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
