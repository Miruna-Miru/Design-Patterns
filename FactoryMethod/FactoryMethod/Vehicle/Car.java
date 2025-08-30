package FactoryMethod.Vehicle;

public class Car implements VehicleInterface{
    @Override
     public void drive()
     {
        System.out.println("Now driving a car");
     }
}
