package week8;

import java.util.*;

enum HoneyType {
    BAGREMOV, LIVADSKI
}

interface Sellable {
    double calculateDiscount(double discountRate);

    String getDescription();
}

abstract class Item implements Sellable {
    private String barcode;
    private String name;
    private double price;

    public Item(String barcode, String name, double price) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
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

    @Override
    public double calculateDiscount(double discountRate) {
        return price * discountRate;
    }

    @Override
    public String getDescription() {
        return "Barcode: " + barcode + "\nName: " + name + "\nPrice: " + price;
    }
}

class Milk extends Item {
    private double fat;

    public Milk(String barcode, String name, double price, double fat) {
        super(barcode, name, price);
        this.fat = fat;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "\nFat: " + fat;
    }
}

class Honey extends Item {
    private HoneyType honeyType;

    public Honey(String barcode, String name, double price, HoneyType
            honeyType) {
        super(barcode, name, price);
        this.honeyType = honeyType;
    }

    public HoneyType getHoneyType() {
        return honeyType;
    }

    public void setHoneyType(HoneyType honeyType) {
        this.honeyType = honeyType;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Honey type: " + honeyType;
    }
}

class Order<T extends Item & Sellable> {
    private String orderNo;
    private Date createdAt;
    private Map<T, Integer> items;

    public Order(String orderNo, Date createdAt) {
        this.orderNo = orderNo;
        this.createdAt = createdAt;
        this.items = new HashMap<>();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Map<T, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<T, Integer> items) {
        this.items = items;
    }

    public void addItem(T item, int quantity) {
        if (items.containsKey(item)) {
            items.put(item, items.get(item) + quantity);
        } else {
            items.put(item, quantity);
        }
    }

    public double calculateTotalAmount() {
        double totalPrice = 0;
        for (T item : items.keySet()) {
            double quantity = items.getOrDefault(item, 0);
            double price = quantity * item.getPrice();
            totalPrice += price;
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order Number: " + orderNo + "\nCreated at: " + createdAt;
    }
}

class Person {
    private String name;
    private int age;
    private List<Order<? extends Item>> orders;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Order<? extends Item>> getOrders() {
        return orders;
    }

    public void setOrders(List<Order<? extends Item>> orders) {
        this.orders = orders;
    }

    public void addOrder(Order<? extends Item> order) {
        orders.add(order);
    }
}

class Main {
    public static void main(String[] args) {
        Milk milk = new Milk("489ABC", "Meggle", 2.95, 8.0);
        Honey honey = new Honey("MMC900", "Podravka", 12.95, HoneyType.BAGREMOV);
        Date currentDate = new Date();
        Order<Milk> milkOrder = new Order<>("28D4", currentDate);
        Order<Honey> honeyOrder = new Order<>("MK4C", currentDate);
        milkOrder.addItem(milk, 2);
        honeyOrder.addItem(honey, 4);
        System.out.println("Milk Order Total: " + milkOrder.calculateTotalAmount());
        System.out.println("Honey Order Total: " + honeyOrder.calculateTotalAmount());
        System.out.println("Milk Discount: " + milk.calculateDiscount(0.1));
        System.out.println("Honey Discount: " + honey.calculateDiscount(0.2));
        Person person = new Person("John Doe", 48);
        person.addOrder(milkOrder);
        person.addOrder(honeyOrder);
        for (Order<? extends Item> order : person.getOrders()) {
            System.out.println(order);
            System.out.println("Total: " + order.calculateTotalAmount());
        }
    }
}