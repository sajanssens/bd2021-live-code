package nl.belastingdienst.fundamentals.h10;

public abstract class Employee implements Raisable {

    private long id;
    protected String name;

    public void doWork() {
        System.out.println("Working my ass off...");
    }

    public void raise() {
        System.out.println("Raising salary");
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public abstract long getSalary();
}
