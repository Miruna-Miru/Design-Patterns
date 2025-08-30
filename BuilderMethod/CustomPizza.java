package BuilderMethod;

public class CustomPizza {
    public static void main(String[] args) {
        PizzaBuilder thinPizza = new PizzaBuilder();
        thinPizza.setDough("Thin").setSauce("Tomato").setTopping("Panner");
        System.out.println(thinPizza);
        PizzaBuilder spicyPizza = new PizzaBuilder();
        spicyPizza.setDough("Thin").setSauce("Shezwan").setTopping("Panner");
        System.out.println(spicyPizza);
        PizzaBuilder noCrust = new PizzaBuilder();
        noCrust.setSauce("Tomato").setTopping("Panner");
        System.out.println(noCrust);
    }
}

class PizzaBuilder{
    private String dough, sauce, toppings;
    public PizzaBuilder setDough(String d)
    {
        this.dough=d;
        return this;
    }
    
    public PizzaBuilder setSauce(String s)
    {
        this.sauce=s;
        return this;
    }
    public PizzaBuilder setTopping(String t)
    {
        this.toppings=t;
        return this;
    }
    @Override
    public String toString(){
       return "Pizza is "+dough+", "+sauce+", "+toppings;
    }
}