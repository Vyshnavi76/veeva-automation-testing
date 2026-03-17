package GrandTest;

import java.util.*;
import java.time.*;

// Item Class
class Item {
    String name;
    double price;
    int quantity;
    int reorderLevel;

    Item(String name, double price, int quantity, int reorderLevel) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.reorderLevel = reorderLevel;
    }
}

// Customer Class
class Customer {
    String name, address, phone, email;

    Customer(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
}

// Order Class
class Order {
    int orderId;
    Customer customer;
    Map<Item, Integer> items;
    double totalAmount;
    LocalDate date;

    Order(int orderId, Customer customer, Map<Item, Integer> items) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = items;
        this.date = LocalDate.now();
        calculateTotal();
    }

    void calculateTotal() {
        totalAmount = 0;
        for (Map.Entry<Item, Integer> e : items.entrySet()) {
            totalAmount += e.getKey().price * e.getValue();
        }
    }
}

public class Question7 {

   public static List<Item> items = new ArrayList<>();
   public static List<Customer> customers = new ArrayList<>();
   public static List<Order> orders = new ArrayList<>();
   public static int orderId = 1;

   public static Scanner sc = new Scanner(System.in);

    // Add Item
   public static void addItem() {
        System.out.print("Enter name: ");
        String name = sc.next();
        System.out.print("Enter price: ");
        double price = sc.nextDouble();
        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();
        System.out.print("Enter reorder level: ");
        int rl = sc.nextInt();

        items.add(new Item(name, price, qty, rl));
        System.out.println("Item added!");
    }

    // Add Customer
   public static void addCustomer() {
    	//System.out.print("Enter your choice");
        System.out.print("Enter name: ");
        String name = sc.next();
        System.out.print("Enter address: ");
        String addr = sc.next();
        System.out.print("Enter phone: ");
        String phone = sc.next();
        System.out.print("Enter email: ");
        String email = sc.next();

        customers.add(new Customer(name, addr, phone, email));
        System.out.println("Customer added!");
    }

    // Find Item
   public static Item findItem(String name) {
        for (Item i : items) {
            if (i.name.equalsIgnoreCase(name)) return i;
        }
        return null;
    }

    // Find Customer
   public static Customer findCustomer(String name) {
        for (Customer c : customers) {
            if (c.name.equalsIgnoreCase(name)) return c;
        }
        return null;
    }

    // Place Order
   public static void placeOrder() {
        System.out.print("Enter customer name: ");
        String cname = sc.next();

        Customer cust = findCustomer(cname);
        if (cust == null) {
            System.out.println("Customer not found!");
            return;
        }

        Map<Item, Integer> map = new HashMap<>();

        System.out.print("How many items: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter item name: ");
            String iname = sc.next();

            Item item = findItem(iname);
            if (item == null) {
                System.out.println("Item not found!");
                return;
            }

            if (item.quantity <= item.reorderLevel) {
                System.out.println("Item below reorder level!");
                return;
            }

            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();

            if (qty > item.quantity) {
                System.out.println("Not enough stock!");
                return;
            }

            item.quantity -= qty;
            map.put(item, qty);
        }

        Order o = new Order(orderId++, cust, map);
        orders.add(o);

        System.out.println("Order placed! ID: " + o.orderId + " Total: " + o.totalAmount);
    }

    // Search Item
   public static void searchItem() {
        System.out.print("Enter item name: ");
        String name = sc.next();
        Item i = findItem(name);

        if (i != null)
            System.out.println(i.name + " Price: " + i.price + " Qty: " + i.quantity);
        else
            System.out.println("Item not found");
    }

    // Orders by Customer
   public static void ordersByCustomer() {
        System.out.print("Enter customer name: ");
        String name = sc.next();

        for (Order o : orders) {
            if (o.customer.name.equalsIgnoreCase(name)) {
                System.out.println("Order ID: " + o.orderId + " Amount: " + o.totalAmount);
            }
        }
    }

    // Order by ID
   public static void getOrderById() {
        System.out.print("Enter order ID: ");
        int id = sc.nextInt();

        for (Order o : orders) {
            if (o.orderId == id) {
                System.out.println("Order Found → Amount: " + o.totalAmount + " Date: " + o.date);
            }
        }
    }

    // Highest & Lowest
   public static void highestLowest() {
        if (orders.size() == 0) return;

        Order max = Collections.max(orders, Comparator.comparing(o -> o.totalAmount));
        Order min = Collections.min(orders, Comparator.comparing(o -> o.totalAmount));

        System.out.println("Highest Order: " + max.totalAmount);
        System.out.println("Lowest Order: " + min.totalAmount);
    }

    // Orders by Date
   public static void ordersByDate(int days) {
        LocalDate now = LocalDate.now();
        for (Order o : orders) {
            if (o.date.isAfter(now.minusDays(days))) {
                System.out.println("Order ID: " + o.orderId + " Date: " + o.date);
            }
        }
    }

    // MAIN MENU
    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1.Add Item\n2.Add Customer\n3.Place Order\n4.Search Item\n5.Orders by Customer\n6.Order by ID\n7.Highest/Lowest\n8.Last Week\n9.Last Month\n10.Exit");

            System.out.print("enter your choice");
            
            int ch = sc.nextInt();

            switch (ch) {
                case 1: addItem(); break;
                case 2: addCustomer(); break;
                case 3: placeOrder(); break;
                case 4: searchItem(); break;
                case 5: ordersByCustomer(); break;
                case 6: getOrderById(); break;
                case 7: highestLowest(); break;
                case 8: ordersByDate(7); break;
                case 9: ordersByDate(30); break;
                case 10: System.exit(0);
                default: System.out.println("Invalid choice");
            }
        }
    }
}