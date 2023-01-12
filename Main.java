
import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // Create Order instance
        Order order = new Order();
        // Create Display instance
        Display display = new Display(order.getOrders());
        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        // Initialize variables for user input
        int choice = 0;
        String lastName = "";
        int orderNumber = 0;
        double totalCost = 0.0;

        // Add test orders
        order.addOrder("Smith", 1, 150.99);
        order.addOrder("Jones", 2, 200.50);
        order.addOrder("Johnson", 3, 100.75);
        order.addOrder("Williams", 4, 75.50);
        order.addOrder("Brown", 5, 300.00);
        order.addOrder("Moore", 6, 120.25);
        order.addOrder("Davis", 7, 125.50);
        order.addOrder("Miller", 8, 50.75);
        order.addOrder("Garcia", 9, 80.25);
        order.addOrder("Rodriguez", 10, 100.75);
        display.updateArrays(order.getOrders());

        // Program title
        System.out.println("Online Order Handler");
        boolean done = false;
        while (!done) {
            // Output menu options
            System.out.println("\n1. Add Order");
            System.out.println("2. Remove Order");
            System.out.println("3. Display Orders");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            // Get the menu choice
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a valid option number.");
                scanner.nextLine();
                continue;
            }

            // Handle the menu choice
            switch (choice) {
                case 1 -> {
                    // Add an order
                    boolean validInput = false;
                    while (!validInput) {
                        try {
                            // Get the customer's name
                            System.out.print("Enter customer last name: ");
                            lastName = scanner.nextLine();

                            // Get the order number
                            System.out.print("Enter order number: ");
                            orderNumber = scanner.nextInt();
                            scanner.nextLine();

                            // Check that the order number is available
                            boolean orderExist = order.checkOrderNumberExists(orderNumber);
                            while (orderExist) {
                                System.out.println("\nOrder number already in use.");
                                System.out.print("Enter a new order number: ");
                                orderNumber = scanner.nextInt();
                                scanner.nextLine();
                                orderExist = order.checkOrderNumberExists(orderNumber);
                            }

                            // Get the total cost
                            System.out.print("Enter total cost: ");
                            totalCost = scanner.nextDouble();

                            // Add order
                            order.addOrder(lastName, orderNumber, totalCost);
                            display.updateArrays(order.getOrders());
                            System.out.println("\nOrder added.");
                            validInput = true;
                            display.printOrders();
                        } catch (InputMismatchException e) {
                            System.out.println("\nInvalid input. Please enter valid order information.");
                            scanner.nextLine();
                        }
                    }
                }
                case 2 -> {
                    // Remove an order
                    boolean validInput = false;
                    while (!validInput) {
                        try {
                            // Get the order number of the order to remove
                            System.out.print("Enter order number: ");
                            orderNumber = scanner.nextInt();
                            scanner.nextLine();

                            // Attempt to remove the order
                            if (order.getOrders().isEmpty()) { // Check if the queue is empty
                                System.out.println("\nNo orders to remove.");
                            } else if (!order.checkOrderNumberExists(orderNumber)) { // Check if the specified order is in the queue
                                System.out.println("\nThere is no order with this order number.");
                            } else { // Remove order
                                order.removeOrder(orderNumber);
                                display.updateArrays(order.getOrders());
                                System.out.println("\nOrder removed.");
                            }
                            validInput = true;
                        } catch (InputMismatchException e) {
                            System.out.println("\nInvalid input. Please enter a valid order number.");
                            scanner.nextLine();
                        }
                    }
                }
                case 3 -> { display.printOrders(); } // Display orders
                case 4 -> {
                    // Exit the program
                    done = true;
                    System.out.println("\nExiting program.");
                }
                default -> {
                    // Handle invalid menu choice
                    System.out.println("\nInvalid input. Please enter a valid menu choice.");
                }
            }
        }
    }
}
