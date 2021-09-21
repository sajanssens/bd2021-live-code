package nl.belastingdienst.h10;

public class PermanentEmployee extends Employee {
    private int position = 2;

    public long getSalary() {
        return 2500 * position;
    }

    public int getPosition() {
        return position;
    }
}
