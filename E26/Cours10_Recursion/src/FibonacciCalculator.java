import java.math.BigInteger;

public class FibonacciCalculator {
    private static BigInteger TWO = BigInteger.valueOf(2);

    //recursie declaration of method fibonacci
    public static BigInteger fibonacci(BigInteger n) {
        if(n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)) {
            return n;
        } else {
            return fibonacci(n.subtract(BigInteger.ONE)).add(
                    fibonacci(n.subtract(TWO)));
        }
    }

    public static void main(String[] args) {
        // calculate factorials of 0 through 21
        for (int counter = 0; counter <= 40; counter++) {
            System.out.printf("Fibonacci of %d is: %d%n", counter, fibonacci(BigInteger.valueOf(counter)));
        }
    }
}
