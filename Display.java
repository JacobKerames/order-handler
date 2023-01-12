
import java.util.Queue;
import java.util.Comparator;

class Display {
    private Order[] ordersByName;
    private Order[] ordersByNumber;

    // Display constructor
    public Display(Queue<Order> orders) {
        updateArrays(orders);
    }

    // Update the Order arrays
    public void updateArrays(Queue<Order> orders) {
        // Convert the orders queue to arrays
        ordersByName = orders.toArray(new Order[0]);
        ordersByNumber = orders.toArray(new Order[0]);

        // Create comparators for sorting by last name and order number
        Comparator<Order> nameComparator = (a, b) -> b.getLastName().toLowerCase().compareTo(a.getLastName().toLowerCase());
        Comparator<Order> numberComparator = (a, b) -> Integer.compare(b.getOrderNumber(), a.getOrderNumber());

        // Sort the arrays using the quick sort method and comparators
        quickSort(ordersByName, nameComparator, 0, ordersByName.length - 1);
        quickSort(ordersByNumber, numberComparator, 0, ordersByNumber.length - 1);
    }

    // Print the orders in the arrays
    public void printOrders() {
        System.out.printf("\n Orders by last name %n");
        System.out.printf("---------------------------------------------%n");
        System.out.printf("| %-15s | %-12s | %-10s |%n", "LAST NAME", "ORDER NUMBER", "TOTAL COST");
        System.out.printf("---------------------------------------------%n");
        for (Order order : ordersByName) {
            System.out.printf("| %-15s | %-12s | %-10s |%n", order.getLastName(), order.getOrderNumber(), String.format("$%.2f", order.getTotalCost()));
        }
        System.out.printf("---------------------------------------------%n\n");

        System.out.printf(" Orders by order number          %n");
        System.out.printf("---------------------------------------------%n");
        System.out.printf("| %-12s | %-15s | %-10s |%n", "ORDER NUMBER", "LAST NAME", "TOTAL COST");
        System.out.printf("---------------------------------------------%n");
        for (Order order : ordersByNumber) {
            System.out.printf("| %-12s | %-15s | %-10s |%n", order.getOrderNumber(), order.getLastName(), "$" + order.getTotalCost());
        }
        System.out.printf("---------------------------------------------%n");
    }

    // Quick sort algorithm
    private void quickSort(Order[] arr, Comparator<Order> comparator, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(arr, comparator, start, end);

            // Recursively sort the sub-arrays, given the pivot
            quickSort(arr, comparator, start, pivotIndex - 1);
            quickSort(arr, comparator, pivotIndex + 1, end);
        }
    }

    // Partition the array
    private int partition(Order[] arr, Comparator<Order> comparator, int start, int end) {
        // Find the median of three for the pivot index
        int pivotIndex = medianOfThree(arr, comparator, start, end);
        swap(arr, pivotIndex, end);

        int i = start - 1;
        for (int j = start; j <= end - 1; j++) {
            // Swap the current with the next in the lesser group if it is less than or equal to the pivot
            if (comparator.compare(arr[j], arr[end]) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }

        // Swap the pivot with the first in the grater group
        swap(arr, i + 1, end);
        return i + 1;
    }

    // Find the median of three for the pivot index
    private int medianOfThree(Order[] arr, Comparator<Order> comparator, int start, int end) {
        int middle = start + (end - start) / 2;

        // Compare and swap the first, middle, and end to find the median of three
        if (comparator.compare(arr[start], arr[middle]) > 0) {
            swap(arr, start, middle);
        }
        if (comparator.compare(arr[start], arr[end]) > 0) {
            swap(arr, start, end);
        }
        if (comparator.compare(arr[middle], arr[end]) > 0) {
            swap(arr, middle, end);
        }

        return middle;
    }

    // Swap two elements
    private void swap(Order[] arr, int i, int j) {
        Order temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}