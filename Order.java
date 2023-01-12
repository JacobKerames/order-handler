/*

Name: Jacob Kerames

Project Name: CSC400 - Portfolio Project

Project Purpose: Handle orders for an online retailer

Algorithm Used: A queue is used to store the orders, and the quick sort and
comparators are used to sort the arrays in descending order by name and order
number.

Program Inputs: The program allows for input of customer last names, order numbers,
and total costs. It also requires input of a choice for user menu interaction.

Program Outputs: The program outputs the orders in the queue, twice. Once sorted
by the customers' last names and the other sorted by order number.

Program Limitations: The program does not have features for interacting with other
systems, like inventory or shipping systems.

Program Errors: The program contains error handling and input validation for
invalid input.

*/

import java.util.Queue;
import java.util.LinkedList;

class Order {
    // Queue to hold the orders
    private Queue<Order> orders;

    // Queue constructor
    public Order() {
        orders = new LinkedList<>();
    }

    // Order constructor
    public Order(String lastName, int orderNumber, double totalCost) {
        this.lastName = lastName;
        this.orderNumber = orderNumber;
        this.totalCost = totalCost;
    }

    // Add an order to the queue
    public void addOrder(String lastName, int orderNumber, double totalCost) {
        orders.add(new Order(lastName, orderNumber, totalCost));
    }

    // Remove the order from the queue
    public void removeOrder(int orderNumber) {
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                orders.remove(order);
                break;
            }
        }
    }

    // Get the queue of orders
    public Queue<Order> getOrders() {
        return orders;
    }

    // Order detail fields
    private String lastName;
    private int orderNumber;
    private double totalCost;

    // Get last name
    public String getLastName() {
        return lastName;
    }

    // Get order number
    public int getOrderNumber() {
        return orderNumber;
    }

    // Get total cost
    public double getTotalCost() {
        return totalCost;
    }

    // Check if an order number exists in the queue
    public boolean checkOrderNumberExists(int orderNumber) {
        if (orders.isEmpty()) {
            return false;
        }
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                return true;
            }
        }
        return false;
    }
}
