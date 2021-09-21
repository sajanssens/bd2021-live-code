package nl.belastingdienst.h10;

public class TemporaryEmployee extends Employee {
    private int numberOfHours = 160;

    public long getSalary() {
        return numberOfHours * 40;
    }
}
