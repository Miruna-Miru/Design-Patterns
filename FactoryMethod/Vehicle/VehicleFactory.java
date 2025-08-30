package FactoryMethod.Vehicle;

public class VehicleFactory {
    public static void main(String args[])
    {
        VehicleInterface vf = VehicleFactory.createDrive("Bus");
        vf.drive();

    }

   public static VehicleInterface createDrive(String v)
   {
     if(v.equals("Bus"))
         return new Bus();
     else if(v.equals("Car"))
     return new Car();
     else if(v.equals("Bike"))
     return new Bike();
     return null;
   }

}
