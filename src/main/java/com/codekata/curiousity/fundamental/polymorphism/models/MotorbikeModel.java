package com.codekata.curiousity.fundamental.polymorphism.models;

/**
 * The type Motorbike model.
 */
public class MotorbikeModel extends VehicleModel{

    @Override
    public void startEngine(String vehicle) {
        System.out.println(vehicle + " engine started! and it has two tires");
    }

    /**
     * Start engine.
     *
     * @param tire the tire
     */
    public void startEngine(int tire) {
        System.out.println("vehicle engine started! and it has " + tire + " tires");
    }
}
