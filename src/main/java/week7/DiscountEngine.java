package week7;

import java.util.*;

@FunctionalInterface
interface DiscountStrategy {
    double applyDiscount(double price);
}

class Product {
    String name;
    double price;
    int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return "Name: " + name + "\nPrice: " + price + "\nQuantity: " + quantity;
    }
}

class DiscountEngine {
    public double applyDiscountStrategy(List<Product> products, DiscountStrategy strategy) {
        double totalPrice = 0.0;
        for (Product product : products) {
            double discountPrice = strategy.applyDiscount(product.getPrice());
            totalPrice += discountPrice * product.getQuantity();
        }
        return totalPrice;
    }
}

class Main {
    public static void main(String[] args) {
        DiscountStrategy percentageDiscount = (price) -> price * 0.45;
        DiscountStrategy fixedDiscount = (price) -> price - 0.30;
        DiscountStrategy bulkDiscount = (price) -> price * 0.85;
        DiscountStrategy mixedDiscount = (price) -> (price * 0.20) - 30;

        List<Product> products = new ArrayList<>();
        Collections.addAll(products,
                new Product("Headphones", 29.99, 1),
                new Product("Smartphone", 499.99, 2),
                new Product("Speaker", 154.99, 3)
        );

        DiscountEngine engine = new DiscountEngine();

        System.out.println("Percentage Discount:");
        System.out.println("Total price is: " + engine.applyDiscountStrategy(products, percentageDiscount));

        System.out.println("Fixed Discount:");
        System.out.println("Total price is: " + engine.applyDiscountStrategy(products, fixedDiscount));

        System.out.println("Bulk Discount:");
        System.out.println("Total price is: " + engine.applyDiscountStrategy(products, bulkDiscount));

        System.out.println("Mixed discounts:");
        System.out.println("Total price is: " + engine.applyDiscountStrategy(products, mixedDiscount));
    }
}