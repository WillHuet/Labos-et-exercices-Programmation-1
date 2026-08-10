import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.swap;

public class SelectionSortTest {
    public static void selectionSort(int[] data){
        // loop over data.lenght - 1 element
        for (int i = 0; i < data.length - 1; i++){
            int smallest = i; // first index of remaining array

            // loop to find the index of smallest element
            for (int index = i + 1; index < data.length; index++){
                if(data[index] < data[smallest]){
                    smallest = index;
                }
            }

            swap(data, i, smallest); // swap smallest element into position
            printPass(data, i + 1, smallest);
        }
    }

    private static void printPass(int[] data, int pass, int index) {
        System.out.printf("after pass %2d: ", pass);

        for(int i = 0; i < index; i++){
            System.out.printf("%d ", data[i]);
        }

        System.out.printf("%d* ", data[index]);

        for (int i = index + 1; i < data.length; i++){
            System.out.printf("%d ", data[i]);
        }

        System.out.printf("%n               ");

        for (int j = 0; j < pass; j++){
            System.out.print("-- ");
        }
        System.out.println();
    }

    private static void swap(int[] data, int first, int second) {
        int temporary = data[first];
        data[first] = data[second];
        data[second] = temporary;
    }

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();

        int[] data = random.ints(10, 10, 91).toArray();

        System.out.printf("Unsorted array: %s%n%n", Arrays.toString(data));
        selectionSort(data);
        System.out.printf("%nSorted array: %s%n", Arrays.toString(data));
    }
}
