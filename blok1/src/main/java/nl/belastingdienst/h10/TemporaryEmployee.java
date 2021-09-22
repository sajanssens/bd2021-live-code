package nl.belastingdienst.h10;

public class TemporaryEmployee extends Employee {

    private int numberOfHours = 160;
    private String nameOfExternalCompany;

    public TemporaryEmployee() {

    }

    public TemporaryEmployee(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public long getSalary() {
        return numberOfHours * 40L;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

}
