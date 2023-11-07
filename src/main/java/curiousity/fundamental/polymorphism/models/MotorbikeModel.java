package curiousity.fundamental.polymorphism.models;

public class MotorbikeModel extends VehicleModel{

    @Override
    public void startEngine(String vehicle) {
        System.out.println(vehicle + " engine started! and it has two tires");
    }

    public void startEngine(int tire) {
        System.out.println("vehicle engine started! and it has " + tire + " tires");
    }
}
