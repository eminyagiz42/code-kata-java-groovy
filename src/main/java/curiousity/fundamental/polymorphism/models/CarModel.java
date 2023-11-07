package curiousity.fundamental.polymorphism.models;

public class CarModel extends VehicleModel{

    @Override
    public void startEngine(String vehicle) {
        System.out.println(vehicle + " engine started! and it has four tires");
    }
}
