package com.pluralsight;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    static Scanner input = new Scanner(System.in);
    ArrayList<Vehicle> inventory = new ArrayList<>();

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


    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max){
       return inventory.stream().filter(vehicle -> vehicle.getPrice() <= max && vehicle.getPrice() >= min).collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<Vehicle> getVehiclesByMake(String make, String model){
        return inventory.stream().filter(vehicle -> make.equalsIgnoreCase(vehicle.getMake()) && model.equalsIgnoreCase(vehicle.getModel())).collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<Vehicle> getVehiclesByYear(int min, int max){
        return inventory.stream().filter(vehicle -> vehicle.getYear() <= max && vehicle.getYear() >= min).collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<Vehicle> getVehiclesByColor(String color){
        return inventory.stream().filter(vehicle -> color.equalsIgnoreCase(vehicle.getColor())).collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max){
        return inventory.stream().filter(vehicle -> vehicle.getOdometer() <= max && vehicle.getOdometer() >= min).collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<Vehicle> getVehiclesByType(String vehicleType){
        return inventory.stream().filter(vehicle -> vehicleType.equalsIgnoreCase(vehicle.getVehicleType())).collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }
    //WRITES VEHICLE INFO INTO CSV FILE
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
        DealershipFileManager.saveDealership(this);

    }
    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
        DealershipFileManager.saveDealership(this);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%s|%s|%s", name, address, phone));
        inventory.forEach(vehicle -> stringBuilder.append("\n").append(vehicle));
        return stringBuilder.toString();
    }
}
