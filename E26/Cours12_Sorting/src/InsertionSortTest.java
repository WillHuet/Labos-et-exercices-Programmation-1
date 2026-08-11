import java.security.SecureRandom;
import java.util.Arrays;

public class InsertionSortTest {
    public static void insertionSort(int[] data){
        for (int next = 1; next < data.length; next++){
            int insert = data[next];
            int moveItem = next;

            while (moveItem > 0 && data[moveItem - 1] > insert){
                data[moveItem] = data[moveItem - 1];
                moveItem--;
            }

            data[moveItem] = insert;
            printPass(data, next, moveItem);
        }
    }

    private static void printPass(int[] data, int pass, int index) {
        System.out.printf("after pass %2d: ", pass);

        for(int i = 0; i < index; i++){
            System.out.printf("%d  ", data[i]);
        }

        System.out.printf("%d* ", data[index]);

        for (int i = index + 1; i < data.length; i++){
            System.out.printf("%d  ", data[i]);
        }

        System.out.printf("%n               ");

        for (int j = 0; j < pass; j++){
            System.out.print("--  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();

        int[] data = random.ints(10, 10, 91).toArray();

        System.out.printf("Unsorted array: %s%n%n", Arrays.toString(data));
        insertionSort(data);
        System.out.printf("%nSorted array: %s%n", Arrays.toString(data));
    }
}
