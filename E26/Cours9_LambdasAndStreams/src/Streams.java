import java.security.SecureRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams {
    public static void classicLoop(){
        int total = 0;

        for (int i = 0; i <= 10; i++) {
            total += i;
        }

        System.out.println(total);
    }

    public static void rangeClosedStream(){
        // rangeClosed = create IntStream containing int elements 1,2,3,4,5,6,7,8,9,10
        System.out.printf("Sum of 1 through 10 is : %d%n",
                IntStream.rangeClosed(1, 10)
                        .sum());
        // method sum() = TERMINAL OPERATION that produces the sum of the stream's elements
        // count(), min(), max(), average(), summaryStatistics(), and reduce() all are TERMINAL OPERATIONS


        // sum the even integers from 2 through 20
        System.out.printf("Sum of the even ints from 2 through 20 is : %d%n",
                IntStream.rangeClosed(1, 10)                // 1...10
                        .map((int x) -> {return x * 2;})    // multiply by 2
                        .sum());                            // sum
        // (x) -> {return x * 2;}   (Eliminating a Lambda's Paramater Type(s))
        // (x) -> x * 2             (Simplifying the Lambda's Body)
        // x -> x * 2               (Simplifying the Lambda's Parameter List)
        // THEY ALL REPRESENT THE SAME RESULT
    }

    public static void streamsOperations(){
        System.out.printf("Sum of the even ints from 2 through 20 is : %d%n",
                IntStream.rangeClosed(1, 10)
                        /* MIDDLE OPERATIONS */
                        //.filter(predicate) = returns a stream containing only the elements that satisfy a condition (predicate)
                        //.distinct() = returns a stream containing only the unique elements - duplicates are eliminated
                        //.limit(maxSize) = returns a Stream with the specified number of elements from the beginning
                        //.map(mapper) = returns a Stream in which each of the original stream's elements is mapped to a new value (ex: school grades A,B,C,D,F on the grade obtained)
                        //.sorted() = returns a Stream in which the elements are in sorted order
                        //.forEach(action) = performs processing on erey element in the stream (ex: display each element)
                        /* TERMINAL OPERATIONS */
                        //.average() = returns the AVERAGE of the elements in a numeric Stream
                        //.count() = returns the NUMBER OF ELEMENTS in the Stream
                        //.max() || .min() = return the MAXIMUM / MINIMUM value in the Stream
                        //.reduce(int, BinaryInt) = reduces the elements of a collection to a SINGLE VALUE using an associative accumulation function
                        .sum());
    }

    public static void streamFilterMapReduce(){
        // sum the triples of the even integers from 2 though 10
        System.out.printf("Sum of the triples of the even ints from 2 through 10 is : %d%n",
                IntStream.rangeClosed(1, 10)                // 1...10
                        .filter(x -> x % 2 == 0)        // even ints
                        .map(x -> x * 3)                // multiply by 3
                        .sum());                            // sum
    }

    public static void randomIntegers(){
        SecureRandom randomNumbers = new SecureRandom();

        // display 10 random integers on seperate lines
        System.out.println("Random numbers on separate lines:");
        randomNumbers.ints(10, 1, 7)
                .forEach(System.out::println);

        // display 10 random integers on the same line
        String numbers =
                randomNumbers.ints(10, 1, 7)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" "));
        System.out.printf("%nRandom numbers on one line: %s%n", numbers);
    }





    static void main(String[] args) {
        //classicLoop();
        //rangeClosedStream();
        //streamsOperations();
        randomIntegers();
    }
}

