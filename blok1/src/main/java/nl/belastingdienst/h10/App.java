package nl.belastingdienst.h10;

public class App {
    public static void main(String[] args) {
        printSalary(new PermanentEmployee());
        printSalary(new TemporaryEmployee());
        printSalary(new Manager());
    }

    private static void printSalary(Employee e) {
        System.out.println(e.getSalary()); // dynamic binding = neem de meest specifieke implementatie van getSalary()
    }

}
