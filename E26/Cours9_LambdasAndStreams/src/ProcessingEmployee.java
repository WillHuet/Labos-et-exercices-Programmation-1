import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProcessingEmployee {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Jason", "Red", 5000, "IT"),
                new Employee("Ashley", "Green", 7600, "IT"),
                new Employee("Matt", "Blue", 3850.5, "Sales"),
                new Employee("James", "Indigo", 4077.77, "Marketing"),
                new Employee("Robert", "Indigo", 6200, "IT"),
                new Employee("Flo", "Violet", 3200, "Sales"),
                new Employee("Wendy", "Red", 4236.4, "Marketing")
        };

        // get List view of the Employees
        List<Employee> list = Arrays.asList(employees);

        //display all employees
        System.out.println("Complete Employee List: ");
        list.stream().forEach(System.out::println);

        // predicate that returns true for salaries in the range $4000-$6000
        Predicate<Employee> fourToSixThousand =
                e -> (e.getSalary() >= 4000 && e.getSalary() <= 6000);

        //display them in ascending order with Comparator
        System.out.printf("%nEmployees earning $4000-$6000 per month in ascending order:%n");
        list.stream()
                .filter(fourToSixThousand)
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);

        //display first to earn that much
        System.out.printf("%nFirst employee earning $4000-$6000 per month :%n%s%n",
                list.stream()
                        .filter(fourToSixThousand)
                        .findFirst()
                        .get());

        // functions for getting first and last names from an employee
        Function<Employee, String> byFirstName = Employee::getFirstName;
        Function<Employee, String> byLastName = Employee::getLastName;

        // comparator for comparing Employees by first name and then last
        Comparator<Employee> lastThenFirst =
                Comparator.comparing(byLastName).thenComparing(byFirstName);

        // sort employees by last name, then first name
        System.out.printf("%nEmployees in ascending order by last name then first:%n");
        list.stream()
                .sorted(lastThenFirst)
                .forEach(System.out::println);

        // sort employees by last name, then first name
        System.out.printf("%nEmployees in descending order by last name then first:%n");
        list.stream()
                .sorted(lastThenFirst.reversed())
                .forEach(System.out::println);

        // group employees by department
        System.out.printf("%nEmplyees by department:%n");
        Map<String, List<Employee>> groupedByDepartment =
                list.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));
        groupedByDepartment.forEach(
                (department, employeesInDepartment) -> {
                    System.out.printf("%n%s%n", department);
                    employeesInDepartment.forEach(
                            employee -> System.out.printf("    %s%n", employee));
                }
        );
    }
}
