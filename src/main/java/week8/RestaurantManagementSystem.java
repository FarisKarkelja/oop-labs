package week8;

import java.util.*;

enum CuisineType {
    ITALIAN, CHINESE, MEXICAN, INDIAN, FRENCH
}

interface Billable {
    double applyDiscount(double discountRate);

    String getDescription();
}

abstract class MenuItem implements Billable {
    private String code;
    private String name;
    private double price;

    public MenuItem(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
    public double applyDiscount(double discountRate) {
        return price - (price * discountRate);
    }

    @Override
    public String getDescription() {
        return "Code: " + code + "\nName: " + name + "\nPrice: " + price;
    }
}

class Dish extends MenuItem {
    private CuisineType cuisineType;
    private String mainIngredient;

    public Dish(String code, String name, double price, CuisineType
            cuisineType, String mainIngredient) {
        super(code, name, price);
        this.cuisineType = cuisineType;
        this.mainIngredient = mainIngredient;
    }

    public CuisineType getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(CuisineType cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getMainIngredient() {
        return mainIngredient;
    }

    public void setMainIngredient(String mainIngredient) {
        this.mainIngredient = mainIngredient;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "\nCuisine Type: " +
                cuisineType + "\nMain Ingredient: " + mainIngredient;
    }
}

class Drink extends MenuItem {
    private double volume;

    public Drink(String code, String name, double price, double
            volume) {
        super(code, name, price);
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "\nVolume: " + volume;
    }
}

class TableReservation<T extends MenuItem & Billable> {
    private String reservationId;
    private Date reservationDate;
    private Map<T, Integer> orderedItems;
    private int tableNumber;

    public TableReservation(String reservationId, Date
            reservationDate, int tableNumber) {
        this.reservationId = reservationId;
        this.reservationDate = reservationDate;
        this.tableNumber = tableNumber;
        this.orderedItems = new HashMap<>();
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Map<T, Integer> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(Map<T, Integer> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public void addItemToOrder(T item, int quantity) {
        if (orderedItems.containsKey(item)) {
            orderedItems.put(item, orderedItems.get(item) + quantity);
        } else {
            orderedItems.put(item, quantity);
        }
    }

    public double calculateTotalAmount() {
        double totalPrice = 0;
        for (T item : orderedItems.keySet()) {
            double quantity = orderedItems.getOrDefault(item, 0);
            totalPrice += quantity * item.getPrice();
        }
        return totalPrice;
    }
}

class Customer {
    private String customerId;
    private String name;
    private String phoneNumber;
    private List<TableReservation<? extends MenuItem>> reservations;

    public Customer(String customerId, String name, String
            phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.reservations = new ArrayList<>();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<TableReservation<? extends MenuItem>>
    getReservations() {
        return reservations;
    }

    public void setReservations(List<TableReservation<? extends
            MenuItem>> reservations) {
        this.reservations = reservations;
    }

    public void addReservation(TableReservation<? extends MenuItem>
                                       reservation) {
        reservations.add(reservation);
    }
}

class Restaurant {
    private String restaurantName;
    private List<Customer> customers;
    private Map<String, MenuItem> menuItems;

    public Restaurant(String restaurantName) {
        this.restaurantName = restaurantName;
        this.customers = new ArrayList<>();
        this.menuItems = new HashMap<>();
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Map<String, MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(Map<String, MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addMenuItem(MenuItem item) {
        menuItems.put(item.getCode(), item);
    }

    public Customer getCustomer(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    public void displayMenu() {
        for (String item : menuItems.keySet()) {
            System.out.println(menuItems.get(item).getDescription());
        }
    }

    public double calculateTotalSales() {
        double totalRevenue = 0;
        for (Customer customer : customers) {
            for (TableReservation<? extends MenuItem> reservation :
                    customer.getReservations()) {
                totalRevenue += reservation.calculateTotalAmount();
            }
        }
        return totalRevenue;
    }
}

class MainCode {
    public static void main(String[] args) {
        Dish pizza = new Dish("D01", "Pizza Margherita", 12.99,
                CuisineType.ITALIAN, "Tomato, Mozzarella");
        Drink cola = new Drink("B01", "Cola", 2.50, 500);
        Restaurant restaurant = new Restaurant("Gourmet Bistro");
        restaurant.addMenuItem(pizza);
        restaurant.addMenuItem(cola);
        Customer customer = new Customer("C01", "John Doe",
                "123456789");
        TableReservation<Dish> dishReservation = new
                TableReservation<>("R01", new Date(), 5);
        dishReservation.addItemToOrder(pizza, 2);
        TableReservation<Drink> drinkReservation = new
                TableReservation<>("R02", new Date(), 5);
        drinkReservation.addItemToOrder(cola, 3);
        customer.addReservation(dishReservation);
        customer.addReservation(drinkReservation);
        restaurant.addCustomer(customer);
        restaurant.displayMenu();
        System.out.println("Total Revenue: $" +
                restaurant.calculateTotalSales());
    }
}