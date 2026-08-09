import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class LinearSearchTest {
    public static int linearSearch(int[] data, int searchKey){
        for(int i = 0; i < data.length; i++){
            if(data[i] == searchKey){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SecureRandom random = new SecureRandom();

        // create array and populate
        int[] data = random.ints(10, 10, 91).toArray();

        System.out.printf("%s%n%n", Arrays.toString(data)); // display array

        // get input from user
        System.out.print("Enter number to search (-1 to quit): ");
        int searchInt = input.nextInt();

        // repeatedly input an integer; -1 terminates the program
        while (searchInt != -1){
            int position = linearSearch(data, searchInt);

            if (position == -1){    // not found
                System.out.printf("%d was not found%n%n", searchInt);
            }
            else {  // found
                System.out.printf("%d was found in position %d%n%n", searchInt, position);
            }

            //a get input from user (repeat)
            System.out.print("Enter number to search (-1 to quit): ");
            searchInt = input.nextInt();
        }
    }

}
