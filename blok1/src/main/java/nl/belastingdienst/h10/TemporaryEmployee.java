package nl.belastingdienst.h10;

public class TemporaryEmployee extends Employee {

    private int numberOfHours;
    private String nameOfExternalCompany;

    public long getSalary() {
        return numberOfHours * 40;
    }

    public TemporaryEmployee() {
        this(80); // roep eerst de ctor met numberOfHours=80 aan
        System.out.println("Done with no arg constructor"); // doe dan nog wat andere dingen...
    }

    public TemporaryEmployee(int numberOfHours) {
        this(numberOfHours, "UNKNOWN");
        System.out.println("Creating TemporaryEmployee...");
        System.out.println("Almost done... ");
    }

    public TemporaryEmployee(String nameOfExternalCompany) {
        this(80, nameOfExternalCompany);
    }

    public TemporaryEmployee(int numberOfHours, String nameOfExternalCompany) {
        this.numberOfHours = numberOfHours;
        this.nameOfExternalCompany = nameOfExternalCompany;
    }

}
