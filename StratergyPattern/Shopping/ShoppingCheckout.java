package StratergyPattern.Shopping;//crt pckg but showing sme errrs bt rning crtly
 
interface DiscountStrategy {
    double apply(double amount);
}


class NoDiscount implements DiscountStrategy {
    @Override
    public double apply(double amount) {
        return amount; 
    }
}

class PercentageDiscount implements DiscountStrategy {
    private double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double apply(double amount) {
        return amount - (amount * (percentage / 100));
    }
}

class FlatDiscount implements DiscountStrategy {
    private double flatAmount;

    public FlatDiscount(double flatAmount) {
        this.flatAmount = flatAmount;
    }

    @Override
    public double apply(double amount) {
        double discountedAmount = amount - flatAmount;
        return discountedAmount > 0 ? discountedAmount : 0; 
    }
}


class Checkout {
    private DiscountStrategy discountStrategy;

    public Checkout(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateBill(double amount) {
        return discountStrategy.apply(amount);
    }
}

public class ShoppingCheckout {

    public static void main(String[] args) {
        double amount = 100.0;

        Checkout checkout = new Checkout(new NoDiscount());
        System.out.println("No Discount: " + checkout.calculateBill(amount));

        checkout.setDiscountStrategy(new PercentageDiscount(10)); // 10% discount
        System.out.println("10% Discount: " + checkout.calculateBill(amount));

        checkout.setDiscountStrategy(new FlatDiscount(15)); // Flat 15 off
        System.out.println("Flat 15 Discount: " + checkout.calculateBill(amount));
    }
}


