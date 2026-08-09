import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTest {
    // perform a binary search on the data
    public static int binarySearch(int[] data, int key) {
        int low = 0; // low end
        int high = data.length - 1; // high end
        int middle = (low + high + 1) / 2; // middle element
        int location = -1; //return value; -1 if not found

        do {
            System.out.print(remainingElements(data, low, high));

            // appends spaces for alignment
            for (int i = 0; i < middle; i++) {
                System.out.print("   ");
            }
            System.out.println(" * ");

            // if the element if found at the middle
            if (key == data[middle]) {
                location = middle;  //location is at current middle
            }
            else if (key < data[middle]) { // middle element is too high
                high = middle - 1;  // eliminate the higher half
            }
            else{   // middle element is too low
                low = middle + 1;   // eliminate the lower half
            }

            middle = (low + high + 1) / 2;
        } while ((low <= high) && (location == -1));

        return location;    // return location of search key
    }

    public static String remainingElements(int[] data, int low, int high) {
        StringBuilder temporary = new StringBuilder();

        // appends spaces for alignment
        for (int i = 0; i < low; i++) {
            temporary.append("   ");
        }

        // appends elements left in array
        for (int i = low; i <= high; i++) {
            temporary.append(data[i] + " ");
        }

        return String.format("%s%n", temporary);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SecureRandom random = new SecureRandom();

        // create array and populate
        int[] data = random.ints(15, 10, 91).toArray();
        System.out.printf("%s%n%n", Arrays.toString(data)); // display array

        System.out.print("Enter number to search (-1 to quit): ");
        int searchInt =  input.nextInt();

        while (searchInt != -1) {
            int location = binarySearch(data, searchInt);

            if (location == -1) {
                System.out.printf("%d was not found%n%n", searchInt);
            }
            else {
                System.out.printf("%d was found in position %d%n%n", searchInt, location);
            }

            System.out.print("Enter number to search (-1 to quit): ");
            searchInt = input.nextInt();
        }
    }
}
