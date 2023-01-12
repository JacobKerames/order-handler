# Order Handler

<img src="https://user-images.githubusercontent.com/108101472/212205243-d499e1dc-e8f9-494a-bf24-83ec595425a0.jpg" width="400">

This program is designed to handle the order list for an online retailer. The program contains three main classes:

## Order Class: 

This class is responsible for managing the orders. It uses a queue data structure to hold the orders in the order they were taken. The queue is implemented using a LinkedList, which has the following attributes:

  * `orders`: the queue that holds the orders
  * `orderNumber`: the order number of an order

and it has the following methods:

  * `addOrder(String lastName, int orderNumber, double totalCost)`: adds a new order to the queue. 
  
  The method takes in the customer's last name, order number, and order total cost as arguments and appends it to the queue as a custom object Order.
  
  * `removeOrder()`: removes an order from the queue based on the order number.
  * `getOrders()`: returns the current queue.
  * `checkOrderNumberExists(int orderNumber)`: checks if the order number already exists in the queue.

## Display Class: 

This class is responsible for displaying the orders, it stores a copy of the order queue in two arrays. Each array contains the orders queue, but one is sorted by name and the other is sorted by order number. The class uses comparators and the quick sort algorithm to sort the arrays.

  * `ordersByName`: an array sorted by customer's last name.
  * `numberSorted`: an array sorted by order number
  
and it has the following methods:

The median of three pivot strategy is a technique that improves the performance of quicksort by selecting the pivot as the median of three elements, i.e. the first, middle and last element in the array. This helps to avoid worst case scenario where the pivot is always the largest or smallest element in the array.

  * `medianOfThree(Order[] arr, Comparator<Order> comparator, int start, int end)`: median of three pivot strategy
  
Improves the performance of quicksort by selecting the pivot as the median of three elements, the first, middle and last element in the array. This helps to avoid worst case scenario where the pivot is always the largest or smallest element in the array.

  * `updateArrays(Queue<Order> orders)`: updates the `ordersByName` and `ordersByNumber` arrays with the latest queue passed as an argument. 
  
  The method sorts the `ordersByName` array by the customer's last name and the ordersByNumber array by the order number.
  
  * `printOrders()`: prints the contents of the `ordersByName` and `ordersByNumber` arrays to the console.
  
## Main Class: 

This class is responsible for handling the user inputs and it interacts with the Order and Display classes. The user is presented with a menu to add an order, remove an order, and display the order list from the queue.

  * `addOrder()`: prompts the user for the customer's last name, order number and order total cost, and calls the `addOrder()` method of the Order Class to add a new order to the queue.
  * `removeOrder()`: calls the `removeOrder()` method of the Order Class to remove an order from the queue based on the passed `orderNumber`.
  * `display.printOrders()`: calls the `printOrders()` method of the Display Class to print the contents of the nameSorted and numberSorted ArrayLists to the console.
  * `display.updateArrays(order.getOrders())`: updates the sort of the arrays. Used when an order is added or removed, or the orders are displayed.
  * `main(String[] args)`: the `main` method of the program, it presents the user with a menu of options and calls the appropriate methods based on the user's input.

The program starts by initializing an instance of the Order Class and Display Class, it also adds some test orders for demonstration purposes, then it enters into a while loop that keeps the program running until the user chooses to exit. It uses the Scanner class to get the user input, and it has also some error handling and input validation to handle any invalid inputs that the user might enter.
