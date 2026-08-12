import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutor {
    public static void main(String[] args) {
        PrintTask task1 = new PrintTask("task1");
        PrintTask task2 = new PrintTask("task2");
        PrintTask task3 = new PrintTask("task3");

        System.out.println("Starting Executor");

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(task1);
        executor.execute(task2);
        executor.execute(task3);

        executor.shutdown();
        System.out.printf("Tasks started, main ends.%n%n");
    }
}
