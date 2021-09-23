package nl.belastingdienst.fundamentals.h10;

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
        if (e instanceof PermanentEmployee) { // wijst e naar een PE?
            // e.getPosition(); // does not work; solution:
            PermanentEmployee pe = (PermanentEmployee) e;
            int position = pe.getPosition();
            System.out.println(position);
        }
        System.out.println(e.getSalary()); // dynamic binding = neem de meest specifieke implementatie van getSalary()
        e.doWork();
    }

}
