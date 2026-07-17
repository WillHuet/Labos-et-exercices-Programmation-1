import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
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

    /*============
    DIAPO 50 -> 53
    ============*/
    public static void intStreamOperations(){
        int[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};

        //display original values
        System.out.print("Original values: ");
        System.out.println(
                IntStream.of(values)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")));

        // count, min, max, sum and average of the values
        System.out.printf("%nCount: %d%n", IntStream.of(values).count());
        System.out.printf("Min: %d%n",  IntStream.of(values).min().getAsInt());
        System.out.printf("Max: %d%n",  IntStream.of(values).max().getAsInt());
        System.out.printf("Sum: %d%n", IntStream.of(values).sum());
        System.out.printf("Average: %.2f%n", IntStream.of(values).average().getAsDouble());

        // sum of values with REDUCE method
        System.out.printf("%nProduct via reduce method: %d%n", IntStream.of(values)
            .reduce((x,y) -> x * y).getAsInt());

        // product of values with REDUCE method
        System.out.printf("Sum via reduce method: %d%n", IntStream.of(values)
                .reduce((x,y) -> x + y).getAsInt());

        // sum of squares of values with map and sum method
        System.out.printf("Sum of squares via map and sum method: %d%n%n", IntStream.of(values)
                .map(x -> x * x)
                .sum());

        // display elements in sorted order
        System.out.printf("%nValues displayed in sorted order: %s%n", IntStream.of(values)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    public static void arraysAndStreams(){
        Integer[] values = {2, 9, 5, 0, 3, 7, 1, 4, 8, 6};

        //display original values
        System.out.printf("Original values: %s%n", Arrays.asList(values));

        //sort values in ascending order with streams
        System.out.printf("Sorted values: %s%n",
                Arrays.stream(values)
                    .sorted()
                    .toList());

        // values greater than 4
        List<Integer> greaterThan4 =
                Arrays.stream(values)
                    .filter(value -> value > 4)
                    .collect(Collectors.toList());          // or .toList()
        System.out.printf("Values greater than 4: %s%n", greaterThan4);

        // values greater than 4 and then sorted
        System.out.printf("Values greater than 4 and then sorted: %s%n",
                Arrays.stream(values)
                        .filter(value -> value > 4)
                        .sorted()
                        .collect(Collectors.toList()));     // or .toList()

        // greaterThan4 List sorted with streams
        System.out.printf("Values greater than 4 (acsending with streams): %s%n",
                greaterThan4.stream()
                    .sorted()
                    .collect(Collectors.toList()));         // or .toList()
    }

    public static void arraysAndStreams2(){
        String[] strings = {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet"};

        //display original strings
        System.out.printf("Original strings: %s%n", Arrays.asList(strings));

        //strings in uppercase
        System.out.printf("Strings in uppercase: %s%n",
                Arrays.stream(strings)
                        .map(String::toUpperCase)
                        .toList());

        //strings less than 'n' (case-insensitive) sorted ascending
        System.out.printf("Strings less than n sorted ascending: %s%n",
                Arrays.stream(strings)
                        .filter(s -> s.compareToIgnoreCase("n") < 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER)
                        .toList());

        //strings less than 'n' (case-insensitive) sorted descending
        System.out.printf("Strings less than n sorted descending: %s%n",
                Arrays.stream(strings)
                        .filter(s -> s.compareToIgnoreCase("n") < 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                        .toList());
    }





    static void main(String[] args) {
        //classicLoop();
        //rangeClosedStream();
        //streamsOperations();
        //randomIntegers();
        //intStreamOperations();
        //arraysAndStreams();
        arraysAndStreams2();

    }
}

