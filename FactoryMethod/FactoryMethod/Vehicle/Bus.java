package FactoryMethod.Vehicle;

public class Bus implements VehicleInterface  {
    @Override
     public void drive()
     {
        System.out.println("Now driving a Bus");
     }
}
