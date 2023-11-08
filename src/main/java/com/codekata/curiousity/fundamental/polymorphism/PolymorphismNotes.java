package com.codekata.curiousity.fundamental.polymorphism;

import com.codekata.curiousity.fundamental.polymorphism.models.VehicleModel;
import com.codekata.curiousity.fundamental.polymorphism.models.CarModel;
import com.codekata.curiousity.fundamental.polymorphism.models.MotorbikeModel;

/**
 * The type Polymorphism notes.
 */
public class PolymorphismNotes {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        VehicleModel vehicleModel = new VehicleModel();
        vehicleModel.startEngine("vehicle"); // Before OVERRIDE the method in the parent class

        CarModel carModel = new CarModel();
        carModel.startEngine("car"); //OVERRIDE means update the code comes from the parent

        MotorbikeModel motorbike = new MotorbikeModel();  // OVERLOAD means method can be same name with different parameter
        motorbike.startEngine("motorbike");         // String parameter
        motorbike.startEngine(2);                     // int parameter

        /** Output :
         *  vehicle engine started!
         *  car engine started! and it has four tires
         *  motorbike engine started! and it has two tires
         *  vehicle engine started! and it has 2 tires
         */
    }
}
