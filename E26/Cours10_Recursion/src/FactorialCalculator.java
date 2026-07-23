import java.math.BigInteger;

public class FactorialCalculator {
    // calculate factorials with a long
    public static long factorial(long n) {
        if (n <= 1){
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // calculate factorials with a BigInteger
    public static BigInteger factorial(BigInteger n) {
        if (n.compareTo(BigInteger.ONE) <= 0) {
            return BigInteger.ONE;
        } else {
            return n.multiply(
                    factorial(n.subtract(BigInteger.ONE)));
        }
    }

    public static void main(String[] args) {
        // calculate factorials of 0 through 21
        for (int counter = 0; counter <= 21; counter++) {
            System.out.printf("%d! = %d%n", counter, factorial(counter));
        }

        // calculate factorials of 0 through 50 with BigInteger
        for (int counter = 0; counter <= 50; counter++) {
            System.out.printf("%d! = %d%n", counter, factorial(BigInteger.valueOf(counter)));
        }
    }
}
