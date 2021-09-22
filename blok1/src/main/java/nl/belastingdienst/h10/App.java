package nl.belastingdienst.h10;

public class App {

    public static void main(String[] args) {
        // Employee e = new Employee(); // is abstract
        PermanentEmployee permanentEmployee = new PermanentEmployee();
        TemporaryEmployee temporaryEmployee = new TemporaryEmployee();
        InterimManager manager = new InterimManager();

        process(permanentEmployee); // polymorfisme
        process(temporaryEmployee);
        process(manager);
    }

    private static void process(Employee e) {
        System.out.println(e.getSalary()); // dynamic binding = neem de meest specifieke implementatie van getSalary()
        e.doWork();
    }

}
