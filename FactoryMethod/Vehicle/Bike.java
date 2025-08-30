package FactoryMethod.Vehicle;

public class Bike implements VehicleInterface{
    @Override
     public void drive()
     {
        System.out.println("Now driving a Bike");
     }
}
