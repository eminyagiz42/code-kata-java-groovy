package com.codekata.curiousity.fundamental.polymorphism.models;

/**
 * The type Car model.
 */
public class CarModel extends VehicleModel{

    @Override
    public void startEngine(String vehicle) {
        System.out.println(vehicle + " engine started! and it has four tires");
    }
}
